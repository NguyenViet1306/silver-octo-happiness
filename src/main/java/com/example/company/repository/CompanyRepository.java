package com.example.company.repository;

import com.example.company.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company , Long> {

    List<Company> findCompaniesByNameContaining();
}
