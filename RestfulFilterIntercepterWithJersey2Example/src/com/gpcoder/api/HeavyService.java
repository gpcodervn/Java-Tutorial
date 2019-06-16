package com.gpcoder.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.gpcoder.annotation.Compress;

//URI:
//http(s)://<domain>:(port)/<YourApplicationName>/<UrlPattern in web.xml>/<path>
//http://localhost:8080/RestfulWebServiceExample/rest/compresses
@Path("/compresses")
public class HeavyService {

	@GET
	@Path("normal-data")
	public String getNormalData() {
		return "Normal data";
	}

	@GET
	@Path("big-data")
	@Compress
	public String getBigData() {
		return "Big data";
	}

	@GET
	@Path("dynamic-data")
	public String getDynamicData() {
		return "Dynamic data";
	}
}
