package com.jp.poc.incomeexpense.dao;

import java.util.List;

import com.jp.poc.incomeexpense.entity.IncomeExpense;
import com.jp.poc.incomeexpense.model.MasterDetail;

public interface IIncomeExpenseDao {

	public List<IncomeExpense> updateBulkIncomeExpense(List<IncomeExpense> incomeExpenses);

	public MasterDetail getMasterDetails();

	String saveMasterDetail(MasterDetail masterDetail);

	public List<IncomeExpense> saveIncomeExpenseDetails(List<IncomeExpense> list);
	
}
