package com.jp.poc.incomeexpense.dao;

import java.util.List;

import com.jp.poc.incomeexpense.entity.IncomeExpenseEntity;

public interface IIncomeExpenseDao {

	public List<IncomeExpenseEntity> updateBulkIncomeExpense(List<IncomeExpenseEntity> incomeExpenses);
	
}
