package com.jp.poc.incomeexpense.transformer;

import java.util.List;

import org.mapstruct.Mapper;

import com.jp.poc.incomeexpense.entity.State;
import com.jp.poc.incomeexpense.model.StateDto;

@Mapper(componentModel ="spring")
public interface StateMapper {
	
	State convertStateDtoTOState(StateDto stateDto);
	
	StateDto convertStateTOStateDto(State state);
	
	List<StateDto> convertStateListTOStateDtoList(List<State> state);
	
	List<State> convertStateDtoListTOStateList(List<StateDto> stateDtos);	

}
