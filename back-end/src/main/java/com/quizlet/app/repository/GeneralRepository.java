package com.quizlet.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GeneralRepository<E> extends JpaRepository<E,Integer> {
}
