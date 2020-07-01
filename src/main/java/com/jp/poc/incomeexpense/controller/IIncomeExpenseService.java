package com.jp.poc.incomeexpense.controller;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IIncomeExpenseService {
    List<IncomeExpenseWrapper> uploadIncomeAndExpense(MultipartFile multipartFile);
}
