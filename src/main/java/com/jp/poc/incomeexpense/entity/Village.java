package com.jp.poc.incomeexpense.entity;

import java.io.Serializable;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@Entity
@Table(name = "villages", schema="master")
public class Village implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="village", sequenceName="master.villages_id_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator="village")
	private Long id;

	@Column(name = "village_name")
	private String villageName;


}
