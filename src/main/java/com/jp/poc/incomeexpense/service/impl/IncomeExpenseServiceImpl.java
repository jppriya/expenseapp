package com.jp.poc.incomeexpense.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jp.poc.incomeexpense.dao.IIncomeExpenseDao;
import com.jp.poc.incomeexpense.entity.IncomeExpense;
import com.jp.poc.incomeexpense.model.IncomeExpenseDto;
import com.jp.poc.incomeexpense.model.MasterDetail;
import com.jp.poc.incomeexpense.service.IIncomeExpenseService;
import com.jp.poc.incomeexpense.transformer.IncomeExpenseTransformer;

@Service
@Transactional
public class IncomeExpenseServiceImpl implements IIncomeExpenseService {
	
	@Autowired
	private IIncomeExpenseDao incomeExpenseDao;
	
	@Autowired
	private IncomeExpenseTransformer incomeExpenseTransformer;
	
    @Override
    public List<IncomeExpenseDto> uploadIncomeAndExpense(MultipartFile multipartFile) {
        XSSFWorkbook workbook = null;
        List<IncomeExpenseDto> incomeExpenses = new ArrayList<>();
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
        incomeExpenses = incomeExpenses.stream().sorted(Comparator.comparing((IncomeExpenseDto e) -> e.getVillageName()).thenComparing(Comparator.comparing((IncomeExpenseDto ex ) -> ex.getFirstPersonName()))).collect(Collectors.toList());
        
        List<IncomeExpense> incomeExpenseEntityList = incomeExpenseTransformer.convertDTOListToEntityList(incomeExpenses);
       return incomeExpenseTransformer.convertEntityToDtoList(incomeExpenseDao.updateBulkIncomeExpense(incomeExpenseEntityList));
    }
    
    
    private List<IncomeExpenseDto> readIncomeExpenseRequests(XSSFSheet sheet, List<IncomeExpenseDto> incomeExpenses) {
        int dataRows = sheet.getPhysicalNumberOfRows();
        for (int rowNum = 4; rowNum < dataRows - 1; rowNum++) {
            Row dataColumn = sheet.getRow(rowNum);
            if(dataColumn==null) {
            	continue;
            }
            IncomeExpenseDto incomeExpenseWrapper = new IncomeExpenseDto();
            incomeExpenseWrapper.setVillageName(String.valueOf(dataColumn.getCell(0)));
            incomeExpenseWrapper.setFirstPersonName(String.valueOf(dataColumn.getCell(1)));
            incomeExpenseWrapper.setWifeName(String.valueOf(dataColumn.getCell(2)));
            incomeExpenseWrapper.setFunctionName(String.valueOf(dataColumn.getCell(4)));
            if (StringUtils.isNotEmpty(String.valueOf(dataColumn.getCell(6)))) {
                incomeExpenseWrapper.setIncomeAmount(BigDecimal.valueOf(Double.parseDouble(String.valueOf(dataColumn.getCell(6)))));
            }
            System.out.println("EXPENSE AMOUNTS OUT"+ dataColumn.getCell(7));
            if (StringUtils.isNotEmpty(String.valueOf(dataColumn.getCell(7)))) {
            	System.out.println("EXPENSE AMOUNTS"+ dataColumn.getCell(7));
                incomeExpenseWrapper.setExpenseAmount(BigDecimal.valueOf(Double.parseDouble(String.valueOf(dataColumn.getCell(7)))));
            }
            incomeExpenses.add(incomeExpenseWrapper);
        }
        return incomeExpenses;
    }

	@Override
	public MasterDetail getMasterDetails() {
		return incomeExpenseDao.getMasterDetails();
	}
	
	@Override
	public String saveMasterDetails(MasterDetail masterDetail) {
		return incomeExpenseDao.saveMasterDetail(masterDetail);
	}

	@Override
	public List<IncomeExpense> saveIncomeExpenseDetails(List<IncomeExpenseDto> incomeExpenseDtos) {
		return incomeExpenseDao.saveIncomeExpenseDetails(incomeExpenseTransformer.convertDTOListToEntityList(incomeExpenseDtos));
	}

}
