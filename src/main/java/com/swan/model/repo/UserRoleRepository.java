package com.swan.model.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swan.model.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
//	@Override
//	List<UserRole> findAll();

//	@Query(value = "SELECT role_id FROM school.user_role where user_id= :user_id", nativeQuery = true)
	List<UserRole> findByUserId(String userId);

//	List<WifiData> findByModelNumberOrderByCreatedDateDesc(String modelNumber);

}
