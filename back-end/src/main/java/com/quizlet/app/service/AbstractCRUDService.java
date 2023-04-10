package com.quizlet.app.service;

import com.quizlet.app.api.AbstractCRUDApi;
import com.quizlet.app.converter.AbstractDTOConverter;
import com.quizlet.app.dto.GeneralDTO;
import com.quizlet.app.model.GeneralEntity;
import com.quizlet.app.repository.GeneralRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.GenericTypeResolver;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;


public abstract class AbstractCRUDService<ENTITY extends GeneralEntity, DTO extends GeneralDTO>
        implements AbstractCRUDApi<ENTITY, DTO> {

    //region Member
    private static final Logger LOG = LoggerFactory.getLogger(AbstractCRUDService.class);
    private GeneralRepository<ENTITY> repository;
    private AbstractDTOConverter<ENTITY, DTO> converter;
    private Class<ENTITY> entityClass;
    //endregion

    //region Constructor
    public AbstractCRUDService(final GeneralRepository<ENTITY> repository,AbstractDTOConverter<ENTITY,DTO> converter) {
        this.repository = repository;
        this.converter = converter;
        final Class<?>[] params = GenericTypeResolver.resolveTypeArguments(getClass(), AbstractCRUDService.class);
        this.entityClass = (Class<ENTITY>) params[0];
    }
    //endregion


    //region Implementation
    public abstract ENTITY updateEntity(final ENTITY entity, final DTO dto);

    @Override
    public DTO save(DTO dto) {
        ENTITY entity;
        if (dto.isNew()) {
            entity = initEntity();
        } else {
            entity = findByEntityById(dto.getId());
        }
        if(entity == null) {
            LOG.error("Failed to save entity of class '{}'", entityClass.getSimpleName());
            return null;
        }
        // Save this entity
        final ENTITY savedEntity = repository.save(updateEntity(entity,dto));
        return this.converter.convertDetail(savedEntity);

    }

    @Override
    public DTO getById(Integer id) {
        final ENTITY entity = findByEntityById(id);
        if (entity == null) {
            LOG.error("Failed to find entity with ID '{}'", id);
            return null;
        }
        return this.converter.convertDetail(entity);
    }

    @Override
    public Page<DTO> list(Integer index) {
        return repository.findAll(PageRequest.of(index,3)).map(entity -> converter.convertDetail(entity));
    }

    @Override
    public boolean delete(Integer id) {
        final ENTITY entity = findByEntityById(id);
        if (entity == null) {
                LOG.error("Failed to delete entity with ID '{}' as it does not exist", id);
            return false;
        }
        try {
            repository.delete(entity);
            return true;
        } catch (final Exception e) {
            LOG.error(e.getMessage(), e);
            return false;
        }
    }

    //endregion

    //region Helper
    private ENTITY findByEntityById(final Integer id) {
        return repository.findById(id).orElse(null);
    }



    private ENTITY initEntity() {
        try {
            final ENTITY entity = entityClass.newInstance();
            return entity;
        } catch (final Exception e) {
            LOG.error(e.getMessage(), e);
            return null;
        }
    }




}
