package com.jp.poc.incomeexpense.entity;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

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
