package com.jp.poc.incomeexpense.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@Entity
@Table(name = "districts", schema="master")
public class District implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="district", sequenceName="master.districts_id_sq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator="district")
	private Long id;

	@Column(name = "district_name")
	private String districtName;

	@ManyToOne(cascade= {CascadeType.ALL})
    @JoinColumn(name = "state_id")
    private State state;

}
