package com.gpcoder.filter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;

public class CheckClientResponseFilter implements ClientResponseFilter {

	@Override
	public void filter(ClientRequestContext requestContext, ClientResponseContext responseContext) {
		System.out.println("CheckClientResponseFilter running ... ");
		responseContext.getHeaders().add("X-Test-Client", "gpcoder client filter");
		System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss")));
	}
}
