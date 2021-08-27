package com.swan.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.swan.model.Student;

@Repository
@EnableJpaRepositories
public interface StudentRepository extends JpaRepository<Student, Long> {

	Student findByFirstNameAndLastName(String firstName, String lastName);

	Student findByUuid(String studentId);
}
