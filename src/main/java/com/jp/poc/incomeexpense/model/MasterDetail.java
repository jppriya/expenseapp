package com.jp.poc.incomeexpense.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MasterDetail {

	private List<StateDto> states;
	
	private List<DistrictDto> districts;
	
	private List<VillageDto> villages;

}

