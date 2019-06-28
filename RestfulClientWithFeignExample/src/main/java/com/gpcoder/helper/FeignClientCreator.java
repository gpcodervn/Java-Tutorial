package com.gpcoder.helper;

import com.gpcoder.handler.MyErrorDecoder;
import com.gpcoder.interceptor.AuthInterceptor;
import com.gpcoder.interceptor.LoggingInterceptor;
import com.gpcoder.service.OrderService;

import feign.Feign;
import feign.Logger;
import feign.form.FormEncoder;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;

public class FeignClientCreator {

	public static final String BASE_URL = "http://localhost:8080/RestfulWebServiceExample/rest/";
    
	public static <T> T getOrderService(Class<T> clazz) {	
		okhttp3.OkHttpClient okHttpClient = new okhttp3.OkHttpClient.Builder()
				.addInterceptor(new LoggingInterceptor())
			    .addInterceptor(new AuthInterceptor())
			    .addNetworkInterceptor(new LoggingInterceptor())
			    .build();
		
		OkHttpClient feignOkHttp = new OkHttpClient(okHttpClient);
		
		return Feign.builder()
				  .client(feignOkHttp)
				  .encoder(new FormEncoder(new GsonEncoder()))
				  .decoder(new GsonDecoder())
				  .logger(new Slf4jLogger(OrderService.class))
				  .errorDecoder(new MyErrorDecoder())
				  .logLevel(Logger.Level.FULL)
				  .target(clazz, BASE_URL);
    }
}
