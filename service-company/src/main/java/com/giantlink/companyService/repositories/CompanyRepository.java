package com.giantlink.companyService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.giantlink.companyService.entities.Company;

@RepositoryRestResource
public interface CompanyRepository extends JpaRepository<Company, Long> {

}
