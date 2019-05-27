package com.gpcoder.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface UserService {

	@WebMethod
	int insert(User user);

	@WebMethod
	boolean update(User user);

	@WebMethod
	boolean delete(int id);

	@WebMethod
	User get(int id);

	@WebMethod
	User[] getAll();
}
