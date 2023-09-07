package com.example.demo_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo_project.entity.Company;
import com.example.demo_project.entity.Org_Company_id;

@Repository													//�U�ު��D��
public interface CompanyDao extends JpaRepository<Company, Org_Company_id> {

}
