package com.example.springAPI;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Employee {

	//data
	@Id
	@Column
	private Long empId;
	@Column
	private String name;
	@Column
	private String department;
	@Column
	private double salary;
}

