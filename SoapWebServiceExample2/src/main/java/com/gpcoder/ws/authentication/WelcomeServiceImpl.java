package com.gpcoder.ws.authentication;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

@WebService(endpointInterface = "com.gpcoder.ws.authentication.WelcomeService")
public class WelcomeServiceImpl implements WelcomeService {

	@Resource
	private WebServiceContext wsctx;

	@Override
	public String getWelcomeMsg(String name) {
		MessageContext mctx = wsctx.getMessageContext();

		// get detail from request headers
		Map<String, Object> headers = (Map<String, Object>) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
		List<String> users = (List<String>) headers.get("username");
		List<String> pwds = (List<String>) headers.get("password");

		if (users != null && pwds != null) {
			if ("gpcoder".equals(users.get(0)) && "jax-ws-by-gpcoder".equals(pwds.get(0))) {
				return "Welcome " + name;
			} else {
				return "Authentication failed!";
			}
		}

		return "Username and password are not provided!";
	}
}
