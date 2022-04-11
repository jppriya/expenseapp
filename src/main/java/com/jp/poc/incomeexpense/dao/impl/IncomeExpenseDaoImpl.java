package com.jp.poc.incomeexpense.dao.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jp.poc.incomeexpense.dao.IIncomeExpenseDao;
import com.jp.poc.incomeexpense.entity.IncomeExpense;
import com.jp.poc.incomeexpense.entity.State;
import com.jp.poc.incomeexpense.model.DistrictDto;
import com.jp.poc.incomeexpense.model.MasterDetail;
import com.jp.poc.incomeexpense.model.StateDto;
import com.jp.poc.incomeexpense.model.VillageDto;
import com.jp.poc.incomeexpense.repository.DistrictRepository;
import com.jp.poc.incomeexpense.repository.IncomeExpenseRepository;
import com.jp.poc.incomeexpense.repository.StateRepository;
import com.jp.poc.incomeexpense.repository.VillageRepository;
import com.jp.poc.incomeexpense.transformer.DistrictMapper;
import com.jp.poc.incomeexpense.transformer.StateMapper;
import com.jp.poc.incomeexpense.transformer.VilageMapper;

@Component
@Transactional
public class IncomeExpenseDaoImpl implements IIncomeExpenseDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(IncomeExpenseDaoImpl.class);

	@Autowired
	private IncomeExpenseRepository incomeExpenseRepositry;

	@Autowired
	private StateRepository stateRepository;

	@Autowired
	private DistrictRepository districtRepository;

	@Autowired
	private VillageRepository villageRepository;

	@Autowired
	private StateMapper stateMapper;

	@Autowired
	private DistrictMapper districtMapper;

	@Autowired
	private VilageMapper villageMapper;

	@Override
	public List<IncomeExpense> updateBulkIncomeExpense(List<IncomeExpense> incomeExpenses) {
		List<IncomeExpense> savedEntity = incomeExpenseRepositry.saveAll(incomeExpenses);
		return savedEntity;
	}

	@Override
	public MasterDetail getMasterDetails() {
		MasterDetail masterDetail = new MasterDetail();
		List<StateDto> states = stateMapper.convertStateListTOStateDtoList(stateRepository.findAll());
		List<DistrictDto> districts = districtMapper.convertDistrictListTODistrictDtoList(districtRepository.findAll());
		List<VillageDto> villages = villageMapper.convertVillageListTOVillageDtoList(villageRepository.findAll());
		masterDetail.setDistricts(districts);
		masterDetail.setStates(states);
		masterDetail.setVillages(villages);
		return masterDetail;
	}

	@Override
	public String saveMasterDetail(MasterDetail masterDetail) {
		String type = "";
		try {
			if (CollectionUtils.isNotEmpty(masterDetail.getStates())) {
				type = "STATES";

				stateRepository.saveAll(stateMapper.convertStateDtoListTOStateList(masterDetail.getStates()));
			}
			if (CollectionUtils.isNotEmpty(masterDetail.getDistricts())) {
				type = "DISTRICTS";
				List<DistrictDto> districts = masterDetail.getDistricts().stream().map(district -> {
					 district.setState(stateMapper.convertStateTOStateDto(stateRepository.findById(district.getStateId()).get()));
					 return district;
				}).collect(Collectors.toList());

				districtRepository
						.saveAll(districtMapper.convertDistrictDtoListTODistrictList(districts));
			}
			if (CollectionUtils.isNotEmpty(masterDetail.getVillages())) {
				type = "VILLAGES";
				villageRepository.saveAll(villageMapper.convertVillageDtoListTOVillageList(masterDetail.getVillages()));
			}
		} catch (Exception e) {
			LOGGER.error("Exception occured while saving {}", type);
			return "FAILURE";
		}
		return "SUCCESS";
	}

	@Override
	public List<IncomeExpense> saveIncomeExpenseDetails(List<IncomeExpense> incomeExpenses) {
		List<IncomeExpense> savedEntity = incomeExpenseRepositry.saveAll(incomeExpenses);
		return savedEntity;
	}

}
