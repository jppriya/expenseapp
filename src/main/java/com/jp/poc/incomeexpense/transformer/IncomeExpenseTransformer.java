package com.jp.poc.incomeexpense.transformer;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.jp.poc.incomeexpense.entity.IncomeExpenseEntity;
import com.jp.poc.incomeexpense.model.IncomeExpenseDto;

@Component
public class IncomeExpenseTransformer {

	public List<IncomeExpenseEntity> convertDTOListToEntityList(List<IncomeExpenseDto> incomeExpenses) {
		List<IncomeExpenseEntity> incomeExpenseList = incomeExpenses.stream().map(incomeExpense -> convertDtoTOEntity(incomeExpense))
				.collect(Collectors.toList());
		return incomeExpenseList;
	}

	public IncomeExpenseEntity convertDtoTOEntity(IncomeExpenseDto incomeExpenses) {
		IncomeExpenseEntity entity = new IncomeExpenseEntity();
		entity.setId(incomeExpenses.getId());
		entity.setDate(null);
		entity.setExpenseAmount(incomeExpenses.getExpenseAmount());
		entity.setFirstPersonName(incomeExpenses.getFirstPersonName());
		entity.setFunctionName(incomeExpenses.getFunctionName());
		entity.setIncomeAmount(incomeExpenses.getIncomeAmount());
		entity.setDeleted(false);
		entity.setVillageName(incomeExpenses.getVillageName());
		entity.setWifeName(incomeExpenses.getWifeName());
		return entity;
	}
	
	public List<IncomeExpenseDto> convertEntityToDtoList(List<IncomeExpenseEntity> incomeExpenses) {
		List<IncomeExpenseDto> incomeExpenseList = incomeExpenses.stream().map(incomeExpense -> convertEntityTODto(incomeExpense))
				.collect(Collectors.toList());
		return incomeExpenseList;
	}
	
	public IncomeExpenseDto convertEntityTODto(IncomeExpenseEntity incomeExpenseEntity) {
		IncomeExpenseDto incomeExpenseDto = new IncomeExpenseDto();
		incomeExpenseDto.setId(incomeExpenseEntity.getId());
		incomeExpenseDto.setDate(null);
		incomeExpenseDto.setExpenseAmount(incomeExpenseEntity.getExpenseAmount());
		incomeExpenseDto.setFirstPersonName(incomeExpenseEntity.getFirstPersonName());
		incomeExpenseDto.setFunctionName(incomeExpenseEntity.getFunctionName());
		incomeExpenseDto.setIncomeAmount(incomeExpenseEntity.getIncomeAmount());
		incomeExpenseDto.setVillageName(incomeExpenseEntity.getVillageName());
		incomeExpenseDto.setWifeName(incomeExpenseEntity.getWifeName());
		return incomeExpenseDto;
	}

}
