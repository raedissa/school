package com.swan.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.swan.model.DocumentVerify;

@Repository
@EnableJpaRepositories
public interface DocumentVerifyRepository extends JpaRepository<DocumentVerify, Long> {

	boolean existsStudentIdByVerifyId(String verifyId);

	DocumentVerify findAllByVerifyId(String verifyId);

	DocumentVerify findByVerifyIdAndDeletedNull(String verifyId);

	DocumentVerify findByVerifyId(String verifyId);
	
	
	DocumentVerify findFirst1ByOrderByUpdatedDateDesc();

}
