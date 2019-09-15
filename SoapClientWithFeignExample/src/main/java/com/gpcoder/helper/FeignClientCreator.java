package com.gpcoder.helper;

import feign.Feign;
import feign.jaxb.JAXBContextFactory;
import feign.soap.SOAPDecoder;
import feign.soap.SOAPEncoder;
import feign.soap.SOAPErrorDecoder;

public class FeignClientCreator {

	public static final String BASE_URL = "http://localhost:8080/ws/users";
    
	public static <T> T getService(Class<T> clazz) {
		
		JAXBContextFactory jaxbFactory = new JAXBContextFactory.Builder()
			     .withMarshallerJAXBEncoding("UTF-8")
			     .withMarshallerSchemaLocation("http://apihost http://apihost/schema.xsd")
			     .build();

		return Feign.builder()
			     .encoder(new SOAPEncoder(jaxbFactory))
			     .decoder(new SOAPDecoder(jaxbFactory))
			     .errorDecoder(new SOAPErrorDecoder())
			     .target(clazz, BASE_URL);
    }
}
