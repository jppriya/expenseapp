package com.jp.poc.incomeexpense.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jp.poc.incomeexpense.entity.State;

@Repository
public interface StateRepository extends JpaRepository<State, Long>{
}
