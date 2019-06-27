package com.gpcoder.service;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface AuthService {

	@Headers("Accept: application/json; charset=utf-8")
	@FormUrlEncoded
	@POST("auth")
	Call<ResponseBody> getToken(@Field("username") String username, @Field("password") String password);
}
