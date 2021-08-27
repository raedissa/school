package com.swan.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.swan.model.SearchVerify;

@Repository
@EnableJpaRepositories
public interface SearchVerifyRepository extends JpaRepository<SearchVerify, Long> {

}
