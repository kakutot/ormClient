package com.example.model.beans;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class EmployeeBean {
	
	@ApiModelProperty(notes = "The unique id of the employee")
	private long id;
	
	@ApiModelProperty(notes = "The name of the employee")
	private String name;
	
	@ApiModelProperty(notes = "Id of the company he/she works")
	private long companyId;
	
}
