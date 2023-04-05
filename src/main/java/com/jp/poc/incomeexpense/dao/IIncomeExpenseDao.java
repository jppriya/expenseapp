package com.jp.poc.incomeexpense.dao;

import java.util.List;

import com.jp.poc.incomeexpense.entity.IncomeExpense;
import com.jp.poc.incomeexpense.model.MasterDetail;
import com.jp.poc.incomeexpense.model.MoiDetailsDTO;

public interface IIncomeExpenseDao {

	public List<IncomeExpense> updateBulkIncomeExpense(List<IncomeExpense> incomeExpenses);

	public MasterDetail getMasterDetails();

	String saveMasterDetail(MasterDetail masterDetail);

	public List<IncomeExpense> saveIncomeExpenseDetails(List<IncomeExpense> list);

	public List<MoiDetailsDTO> getMoiDetails(String search);
	
}
