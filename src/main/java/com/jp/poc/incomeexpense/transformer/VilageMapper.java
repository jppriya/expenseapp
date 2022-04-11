package com.jp.poc.incomeexpense.transformer;

import java.util.List;

import org.mapstruct.Mapper;

import com.jp.poc.incomeexpense.entity.Village;
import com.jp.poc.incomeexpense.model.VillageDto;

@Mapper(componentModel ="spring")
public interface VilageMapper {
	
	Village convertVillageDtoTOVillage(VillageDto villageDto );
	
	VillageDto convertVillageTOVllageDto(Village village);
	
	List<VillageDto> convertVillageListTOVillageDtoList(List<Village> village);
	
	List<Village> convertVillageDtoListTOVillageList(List<VillageDto> villageDtos);

}
