package com.jp.poc.incomeexpense.controller;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IncomeExpenseServiceImpl implements IIncomeExpenseService {
    @Override
    public List<IncomeExpenseWrapper> uploadIncomeAndExpense(MultipartFile multipartFile) {
        XSSFWorkbook workbook = null;
        List<IncomeExpenseWrapper> incomeExpenses = new ArrayList<>();
        try {
            InputStream inputStream = multipartFile.getInputStream();
            if (null == workbook) {
                workbook = new XSSFWorkbook(inputStream);
            }
            XSSFSheet sheet = workbook.getSheetAt(0);
            if (null != workbook) {
               incomeExpenses=  readIncomeExpenseRequests(sheet, incomeExpenses);
                workbook.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        incomeExpenses = incomeExpenses.stream().sorted(Comparator.comparing((IncomeExpenseWrapper e) -> e.getVillageName()).thenComparing(Comparator.comparing((IncomeExpenseWrapper ex ) -> ex.getFirstPersonName()))).collect(Collectors.toList());
        return incomeExpenses;
    }

    private List<IncomeExpenseWrapper> readIncomeExpenseRequests(XSSFSheet sheet, List<IncomeExpenseWrapper> incomeExpenses) {
        int dataRows = sheet.getPhysicalNumberOfRows();
        for (int rowNum = 4; rowNum < dataRows - 1; rowNum++) {
            Row dataColumn = sheet.getRow(rowNum);
            IncomeExpenseWrapper incomeExpenseWrapper = new IncomeExpenseWrapper();
            incomeExpenseWrapper.setVillageName(String.valueOf(dataColumn.getCell(0)));
            incomeExpenseWrapper.setFirstPersonName(String.valueOf(dataColumn.getCell(1)));
            incomeExpenseWrapper.setWifeName(String.valueOf(dataColumn.getCell(2)));
            incomeExpenseWrapper.setFunctionName(String.valueOf(dataColumn.getCell(4)));
            if (StringUtils.isNotEmpty(String.valueOf(dataColumn.getCell(6)))) {
                incomeExpenseWrapper.setIncomeAmount(BigDecimal.valueOf(Double.parseDouble(String.valueOf(dataColumn.getCell(6)))));
            }
            incomeExpenses.add(incomeExpenseWrapper);
        }
        return incomeExpenses;
    }

}
