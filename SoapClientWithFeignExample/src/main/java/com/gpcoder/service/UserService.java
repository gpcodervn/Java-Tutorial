package com.gpcoder.service;

import java.util.ArrayList;
import java.util.List;

import com.gpcoder.model.User;

import feign.Headers;
import feign.RequestLine;

@Headers({ "Content-Type: text/xml" })
public interface UserService {

	@RequestLine("POST /get")
	@Headers({ "SOAPAction: get" })
	String getUser(int id);

	@RequestLine("POST /insert")
	@Headers({ "SOAPAction: insert" })
	String createUser(User user);

	@RequestLine("POST /update")
	@Headers({ "SOAPAction: update" })
	String updateUser(User user);

	@RequestLine("POST /delete")
	@Headers({ "SOAPAction: delete" })
	String deleteUser(int id);

	default List<String> getUsers(int... ids) {
		List<String> orders = new ArrayList<>();
		for (int id : ids) {
			orders.add(this.getUser(id));
		}
		return orders;
	}
}
