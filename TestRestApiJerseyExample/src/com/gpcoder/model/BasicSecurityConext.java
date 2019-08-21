package com.gpcoder.model;

import java.security.Principal;

import javax.ws.rs.core.SecurityContext;

/**
 * The SecurityContext interface provides access to security related
 * information. An instance of SecurityContext can be injected into a JAX-RS
 * resource class field or method parameter using the @Context annotation.
 * 
 * @see https://jersey.github.io/documentation/latest/security.html
 * @see https://docs.oracle.com/javaee/7/api/javax/ws/rs/core/SecurityContext.html
 */
public class BasicSecurityConext implements SecurityContext {

	private User user;
	private boolean secure;

	public BasicSecurityConext(User user, boolean secure) {
		this.user = user;
		this.secure = secure;
	}

	@Override
	public Principal getUserPrincipal() {
		return () -> user.getUsername();
	}

	@Override
	public boolean isUserInRole(String role) {
		return user.getRoles().contains(role);
	}

	@Override
	public boolean isSecure() {
		return secure;
	}

	@Override
	public String getAuthenticationScheme() {
		return SecurityContext.BASIC_AUTH;
	}
}
