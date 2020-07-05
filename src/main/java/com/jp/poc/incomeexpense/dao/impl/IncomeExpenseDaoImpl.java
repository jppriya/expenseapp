package com.jp.poc.incomeexpense.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jp.poc.incomeexpense.dao.IIncomeExpenseDao;
import com.jp.poc.incomeexpense.entity.IncomeExpenseEntity;
import com.jp.poc.incomeexpense.repository.IncomeExpenseRepository;

@Component
@Transactional
public class IncomeExpenseDaoImpl implements IIncomeExpenseDao {

	@Autowired
	private IncomeExpenseRepository incomeExpenseRepositry;

	@Override
	public List<IncomeExpenseEntity> updateBulkIncomeExpense(List<IncomeExpenseEntity> incomeExpenses) {
		List<IncomeExpenseEntity> savedEntity = incomeExpenseRepositry.saveAll(incomeExpenses);
		return savedEntity;
	}

}
