package com.example.model.beans;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DepartmentBean {
	
	@ApiModelProperty(notes = "The unique id of the employee")
	private long id;
	
	@ApiModelProperty(notes = "The name of the employee")
	private String city;
	
	@ApiModelProperty(notes = "Id of the company he/she works")
	private String address;
	
	@ApiModelProperty(notes = "Id of the company it belongs")
	private long companyId;
	
}

