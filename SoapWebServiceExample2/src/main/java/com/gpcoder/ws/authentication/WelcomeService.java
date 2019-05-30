package com.gpcoder.ws.authentication;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface WelcomeService {

	@WebMethod
	String getWelcomeMsg(String name);
}
