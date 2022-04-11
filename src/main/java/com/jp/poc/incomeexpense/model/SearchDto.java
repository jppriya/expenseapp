package com.jp.poc.incomeexpense.model;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class SearchDto {
	
	
    private String villageName;
    
    private String firstPersonName;
    
    private String wifeName;
    
    
    
    

}
