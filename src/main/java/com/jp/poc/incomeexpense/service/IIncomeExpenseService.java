package com.jp.poc.incomeexpense.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.jp.poc.incomeexpense.entity.IncomeExpense;
import com.jp.poc.incomeexpense.model.IncomeExpenseDto;
import com.jp.poc.incomeexpense.model.MasterDetail;

public interface IIncomeExpenseService {
    List<IncomeExpenseDto> uploadIncomeAndExpense(MultipartFile multipartFile);

	MasterDetail getMasterDetails();

	String saveMasterDetails(MasterDetail masterDetail);

	List<IncomeExpense> saveIncomeExpenseDetails(List<IncomeExpenseDto> incomeExpenseDtos);
}
