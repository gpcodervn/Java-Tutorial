package com.gpcoder.xml.jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class XMLToObject {

	public static void main(String[] args) {

		try {
			File file = new File("department.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Department.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Department dept = (Department) jaxbUnmarshaller.unmarshal(file);
			System.out.println(dept);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
