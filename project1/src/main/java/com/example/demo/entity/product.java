package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="product")
public class product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idx;

	@Column(nullable = true)
	private String title;

	@Column(nullable = true)
	private String contents;

	@Column(nullable = true)
	private String writer;

	@Column(nullable = true)
	private String price;

	@Column(nullable = true)
	private String fileurl;

	@Column(nullable = true)
	private String filename;

	@Column(nullable = true)
	private String fileOriName;

	@Column(nullable = true)
	private String reg_dt;
}
