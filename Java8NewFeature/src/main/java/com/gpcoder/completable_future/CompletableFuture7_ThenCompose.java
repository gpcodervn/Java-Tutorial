package com.gpcoder.completable_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

class User {
	String userId;

	public User(String userId) {
		this.userId = userId;
	}
}

class UserService {
	public static User getUserDetails(String userId) {
		return new User(userId);
	}
}

class CreditRatingService {
	public static Double getCreditRating(User user) {
		return Double.parseDouble(user.userId);
	}
}

class ApiUtil {
	public static CompletableFuture<User> getUsersDetail(String userId) {
		return CompletableFuture.supplyAsync(() -> {
			return UserService.getUserDetails(userId);
		});
	}

	public static CompletableFuture<Double> getCreditRating(User user) {
		return CompletableFuture.supplyAsync(() -> {
			return CreditRatingService.getCreditRating(user);
		});
	}
}

public class CompletableFuture7_ThenCompose {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// Usign thenApply()
		CompletableFuture<CompletableFuture<Double>> nested = ApiUtil.getUsersDetail("1")
				.thenApply(user -> ApiUtil.getCreditRating(user));

		// Using thenCompose()
		CompletableFuture<Double> flattened = ApiUtil.getUsersDetail("1")
				.thenCompose(user -> ApiUtil.getCreditRating(user));
		System.out.println(flattened.get()); // 1.0
	}
}
