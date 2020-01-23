package com.example.model.beans;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CompanyBean {
	
	@ApiModelProperty(notes = "The unique id of the company")
	private long id;
	
	@ApiModelProperty(notes = "The name of the company")
	private String name;
	
	@ApiModelProperty(notes = "The date of foundation")
	private Date createdAt;
	
}
