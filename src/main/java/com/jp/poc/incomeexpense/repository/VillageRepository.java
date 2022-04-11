package com.jp.poc.incomeexpense.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jp.poc.incomeexpense.entity.Village;

@Repository
public interface VillageRepository extends JpaRepository<Village, Long>{
}
