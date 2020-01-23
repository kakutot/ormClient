package com.example.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "company")
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Details about the company")
public class Company {
	
	@Id
	@Column
	@ApiModelProperty(notes = "The unique id of the company")
	private long id;
	
	
	@ApiModelProperty(notes = "The name of the company")
	private String name;
	
	@ApiModelProperty(notes = "The date of foundation")
	private Date createdAt;
	
	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	private Set<Employee> employees;
	
	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	private Set<Department> departments;
	
}
