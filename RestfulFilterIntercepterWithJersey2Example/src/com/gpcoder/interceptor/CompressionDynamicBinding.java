package com.gpcoder.interceptor;

import javax.ws.rs.container.DynamicFeature;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Provider;

import com.gpcoder.api.HeavyService;

//This dynamic binding provider registers GZIPWriterInterceptor
//only for HelloWorldResource and methods that contain
//"VeryLongString" in their name. It will be executed during
//application initialization phase.
@Provider
public class CompressionDynamicBinding implements DynamicFeature {

	@Override
	public void configure(ResourceInfo resourceInfo, FeatureContext context) {
		if (HeavyService.class.equals(resourceInfo.getResourceClass())
				&& resourceInfo.getResourceMethod().getName().contains("DynamicData")) {
			context.register(GZIPWriterInterceptor.class);
		}
	}
}