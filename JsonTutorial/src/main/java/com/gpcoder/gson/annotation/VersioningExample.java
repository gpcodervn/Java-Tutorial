package com.gpcoder.gson.annotation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.gpcoder.gson.object.MemberInfo;

public class VersioningExample {
	public static void main(final String[] args) throws Exception {

		final GsonBuilder builder = new GsonBuilder();
		builder.setVersion(2.0);

		final Gson gson = builder.create();

		final MemberInfo member = new MemberInfo();
		member.setId(1);
		member.setName("GP Coder");
		member.setYahooAccount("gpcoder@yahoo.com"); // Until version 1.7
		member.setFacebookAccount("facebook.com/GPCoder/"); // Since version 2.0

		final String json = gson.toJson(member);
		System.out.println("Json: " + json);

		// Parse JSON to Java
		String json2 = "{\"id\":1,\"name\":\"GP Coder\",\"yahooAccount\":\"gpcoder@yahoo.com\",\"facebookAccount\":\"facebook.com/GPCoder/\"}";
		final MemberInfo otherMember = gson.fromJson(json2, MemberInfo.class);
		System.out.println("Deserialised (version 1.0)");
		System.out.printf("  + Id:              %s%n", otherMember.getId());
		System.out.printf("  + Name:            %s%n", otherMember.getName());
		System.out.printf("  + YahooAccount:    %s Until(1.7)%n", otherMember.getYahooAccount());
		System.out.printf("  + FacebookAccount: %s Since(2.3)%n", otherMember.getFacebookAccount());
	}
}
