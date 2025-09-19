package com.terry.authorization.dto;

import java.util.Set;

public record UserResponse(
		String username,
		Set<String> roles
		) {

}
