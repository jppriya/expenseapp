package com.jp.poc.incomeexpense.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@Entity
@Table(name = "moi_details", schema="master")
public class IncomeExpense implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="seq", sequenceName="master.sequence_moi_id", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator="seq")
	private Long id;

	@Column(name = "village_name")
	private String villageName;

	@Column(name = "first_person_name")
	private String firstPersonName;

	@Column(name = "second_person_name")
	private String wifeName;

	@Column(name = "function_name")
	private String functionName;

	@Column(name = "function_date")
	private Date date;

	@Column(name = "money_in")
	private BigDecimal incomeAmount;

	@Column(name = "money_out")
	private BigDecimal expenseAmount;

	@Column(name = "is_deleted")
	private boolean isDeleted;
}
