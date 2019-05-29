package com.gpcoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

// URI:
// http(s)://<domain>:(port)/<YourApplicationName>/<UrlPattern in web.xml>/<path>
// http://localhost:8080/RestfulWebServiceExample/rest/users
@Path("/users")
public class UserService {

	private static final Map<Integer, User> USERS = new HashMap<>();
	static {
		// Create dummy data
		for (int i = 1; i <= 10; i++) {
			USERS.put(i, new User(i, "dummy " + i));
		}
	}

	private int generateUniqueId() {
		return USERS.keySet().stream().max((x1, x2) -> x1 - x2).orElse(0) + 1;
	}

	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public User get(@PathParam("id") int id) {
		return USERS.getOrDefault(id, new User());
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<User> getAll() {
		return new ArrayList<>(USERS.values());
	}

	@PUT
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public int insert(User user) {
		Integer id = generateUniqueId();
		user.setId(id);
		USERS.put(id, user);
		return id;
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public boolean update(User user) {
		return USERS.put(user.getId(), user) != null;
	}

	@DELETE
	@Path("/{id}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public boolean delete(@PathParam("id") int id) {
		return USERS.remove(id) != null;
	}
}
