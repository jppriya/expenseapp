package com.jp.poc.incomeexpense.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jp.poc.incomeexpense.entity.District;

@Repository
public interface DistrictRepository extends JpaRepository<District, Long>{
}
