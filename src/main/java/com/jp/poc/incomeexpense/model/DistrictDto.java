package com.jp.poc.incomeexpense.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DistrictDto {

	private Long id;

	private String districtName;
	private Long stateId;

	private StateDto state;
}
