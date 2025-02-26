package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "test_tb")
@Data
@NoArgsConstructor
public class TestTbVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "test_pk")
	private Long testPk;
	
	@Column(name = "test_col1")
	private Integer testCol1;
	
	@Column(name = "test_col2")
	private String testCol2;
	
}
