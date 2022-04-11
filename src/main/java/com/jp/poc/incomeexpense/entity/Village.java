package com.jp.poc.incomeexpense.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
