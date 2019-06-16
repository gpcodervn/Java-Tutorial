package com.gpcoder.model;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@XmlRootElement
@Data
public class ErrorResponse {

	private Integer status;
	private String errorMessage;
}
