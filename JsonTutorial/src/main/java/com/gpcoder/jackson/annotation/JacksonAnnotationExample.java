package com.gpcoder.jackson.annotation;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gpcoder.jackson.object.Account;

public class JacksonAnnotationExample {

	public static final String JSON_FILE = "data/result.json";

	public static void main(String args[]) throws JsonParseException, JsonMappingException, IOException {
		Account account = getAccount();

		// Convert Object to JSON string
		ObjectMapper mapper = new ObjectMapper();
		mapper.writerWithDefaultPrettyPrinter().writeValue(new File(JSON_FILE), account);

		// Convert a JSON to a Object
		String jsonString = "{" + 
				"\"address\" : \"Can Tho, Viet Nam\"," + 
				"\"createdDate\" : \"28/01/2018\"," + 
				"\"expiredDate\" : \"28/01/2018\"," + 
				"\"notAnnotationWithSetter\" : null," + 
				"\"services\" : [ \"Internet Banking\", \"Mobile Banking\" ]," + 
				"\"number\" : \"A123 4567 8909\"," + 
				"\"20180128\" : \"Change password\"," + 
				"\"20180101\" : \"Withdraw 100$\"," + 
				"\"add_1\" : \"Add unknown key 1\"," + 
				"\"add_2\" : \"Add unknown key 2\"" + 
				"}";
		// Account account2 = mapper.readValue(new File(JSON_FILE), Account.class);
		Account account2 = mapper.readValue(jsonString, Account.class);
		System.out.println(account2);

	}

	private static Account getAccount() {
		Account account = new Account();
		account.setAccountNumber("A123 4567 8909");
		account.setIban("IB 11 22 33 44");
		account.setOwner("GP Coder");
		account.setPin("123456");
		account.setAddress("Can Tho, Viet Nam");
		account.setCreatedDate(Calendar.getInstance().getTime());
		account.setExpiredDate(Calendar.getInstance().getTime());

		String[] services = { "Internet Banking", "Mobile Banking" };
		account.setServices(Arrays.asList(services));

		Map<String, Object> history = new HashMap<>();
		history.put("20180101", "Withdraw 100$");
		history.put("20180128", "Change password");
		account.setHistory(history);

		return account;
	}
}
