package com.swan.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.swan.model.IpCountry;

@Repository
@EnableJpaRepositories
public interface IpCountryRepository extends JpaRepository<IpCountry, Long> {

}
