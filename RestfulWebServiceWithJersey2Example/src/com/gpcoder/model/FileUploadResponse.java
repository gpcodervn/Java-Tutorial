package com.gpcoder.model;

import java.util.Date;

import lombok.Data;

@Data
public class FileUploadResponse {

	private String fileName;
	private Date createdDate;
	private long fileSizeInByte;
}
