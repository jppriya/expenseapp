package com.jp.poc.incomeexpense.service;

import org.springframework.web.multipart.MultipartFile;

import com.jp.poc.incomeexpense.model.IncomeExpenseDto;

import java.util.List;

public interface IIncomeExpenseService {
    List<IncomeExpenseDto> uploadIncomeAndExpense(MultipartFile multipartFile);
}
