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
@Table(name="payComplete")
public class payComplete {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idx; //기본키

	@Column(nullable = true)
	private String title;	//결제한 책 이름

	@Column(nullable = true)
	private String price; //결제 금액


	@Column(nullable = true)
	private String reg_dt; //결제 날짜

}
