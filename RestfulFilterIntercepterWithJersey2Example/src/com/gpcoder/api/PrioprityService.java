package com.gpcoder.api;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

//URI:
//http(s)://<domain>:(port)/<YourApplicationName>/<UrlPattern in web.xml>/<path>
//http://localhost:8080/RestfulWebServiceExample/rest/priorities
@Path("/priorities")
public class PrioprityService {

	@POST
	public String create(String data) {
		return "Created " + data;
	}
}
