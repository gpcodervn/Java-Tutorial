package com.gpcoder.helper;

import com.gpcoder.interceptor.AuthInterceptor;
import com.gpcoder.interceptor.LoggingInterceptor;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitClientCreator {

	public static final String BASE_URL = "http://localhost:8080/RestfulWebServiceExample/rest/";
    
	public static Retrofit getClient() {		
        return new Retrofit.Builder()
                .baseUrl(BASE_URL) //This is the onlt mandatory call on Builder object
                .addConverterFactory(JacksonConverterFactory.create()) // Convertor library used to convert response into POJO
                // .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    
	public static Retrofit getClientWithInterceptor() {		
		OkHttpClient okHttpClient = new OkHttpClient.Builder()
				.addInterceptor(new LoggingInterceptor())
			    .addInterceptor(new AuthInterceptor())
			    .addNetworkInterceptor(new LoggingInterceptor())
			    .build();
        
		return new Retrofit.Builder()
        		.baseUrl(BASE_URL) //This is the onlt mandatory call on Builder object.
        	    .client(okHttpClient) //The Htttp client to be used for requests
                .addConverterFactory(JacksonConverterFactory.create()) // Convertor library used to convert response into POJO
                .build();
    }
}
