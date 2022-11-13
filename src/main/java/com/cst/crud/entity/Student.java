package com.cst.crud.entity;

import javax.persistence.*;

import lombok.*;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sid;
	
	private String sname;
	
	private String branch;

	public Student(String sname, String branch) {
		super();
		this.sname = sname;
		this.branch = branch;
	}

}
