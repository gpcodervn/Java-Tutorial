package com.gpcoder.model;

import javax.ws.rs.core.Link;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class Article {

	private Integer id;
	private String content;
	private String publishedDate;
	private Integer authorId;
	 private Link self;
}
