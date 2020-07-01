package com.jp.poc.incomeexpense.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class IncomeExpenseWrapper {

    private String villageName;
    private String firstPersonName;
    private String wifeName;
    private String functionName;
    private Date date;
    private BigDecimal incomeAmount;
    private BigDecimal expenseAmount;
}
