package com.gpcoder.ws;

import java.util.HashMap;
import java.util.Map;

import javax.jws.WebService;

@WebService(endpointInterface = "com.gpcoder.ws.UserService")
public class UserServiceImpl implements UserService {

	private static final Map<Integer, User> USERS = new HashMap<>();

	@Override
	public int insert(User user) {
		Integer id = generateUniqueId();
		user.setId(id);
		USERS.put(id, user);
		return id;
	}

	private int generateUniqueId() {
		return USERS.keySet().stream().max((x1, x2) -> x1 - x2).orElse(0) + 1;
	}

	@Override
	public boolean update(User user) {
		return USERS.put(user.getId(), user) != null;
	}

	@Override
	public boolean delete(int id) {
		return USERS.remove(id) != null;
	}

	@Override
	public User get(int id) {
		return USERS.getOrDefault(id, new User());
	}

	@Override
	public User[] getAll() {
		return USERS.values().toArray(new User[0]);
	}
}
