package com.gpcoder.lombok;

import java.util.Date;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

	private Long id;

	private String username;

	@Getter(AccessLevel.NONE)
	private String password;

	@Getter(AccessLevel.PROTECTED)
	@Setter(AccessLevel.PROTECTED)
	private String email;

	private Date birthday;

	private String avatar;

	private String address;

}
