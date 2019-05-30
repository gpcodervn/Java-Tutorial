package com.gpcoder.ws.document;

import javax.activation.DataHandler;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface DocumentService {

	@WebMethod
	DataHandler download(String name);

	@WebMethod
	String upload(DataHandler data);
}
