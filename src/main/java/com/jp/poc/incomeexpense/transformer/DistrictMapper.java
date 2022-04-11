package com.jp.poc.incomeexpense.transformer;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.jp.poc.incomeexpense.entity.District;
import com.jp.poc.incomeexpense.model.DistrictDto;

@Mapper(componentModel = "spring",uses = { StateMapper.class })
public interface DistrictMapper {

	@Mapping(target = "state", source = "districtDto.state")
	District convertDistrictDtoTODistrict(DistrictDto districtDto);

	@Mapping(target = "state", source = "district.state")
	DistrictDto convertDistrictTODistrictDto(District district);

	List<DistrictDto> convertDistrictListTODistrictDtoList(List<District> districts);
	
	List<District> convertDistrictDtoListTODistrictList(List<DistrictDto> districtDtos);
}
