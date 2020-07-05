package com.jp.poc.incomeexpense.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jp.poc.incomeexpense.model.IncomeExpenseDto;
import com.jp.poc.incomeexpense.service.IIncomeExpenseService;

import java.util.List;

@RestController
public class IncomeExpenseController {

    @Autowired
    private IIncomeExpenseService incomeExpenseService;

    @PostMapping(value = "/upload", headers = "content-type=multipart/form-data", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public List<IncomeExpenseDto> uploadEmployee(@RequestPart MultipartFile multipartFile) {
       return  incomeExpenseService.uploadIncomeAndExpense(multipartFile);
    }
}
