package com.swan.model.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.swan.model.Document;

@Repository
@EnableJpaRepositories
public interface DocumentRepository extends JpaRepository<Document, Long> {

	@Query(value = "SELECT name FROM document;", nativeQuery = true)
	List<String> findAllNames();

	Document findAllByName(String name);

	Document findAllByUuid(String uuid);

}
