package com.api.v1.usuariobasico.domain.valueobjects;

import java.util.Objects;
import java.util.regex.Pattern;

public record Email(String email) {
	
	private static final Pattern EMAIL_PATTERN = 
	        Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");

	public Email {
		Objects.requireNonNull(email, "Email é obrigatório.");
		
		if (email.isBlank()) {
			throw new IllegalArgumentException("Email é obrigatório.");
		}
		
		if (!EMAIL_PATTERN.matcher(email).matches()) {
            throw new IllegalArgumentException("Formato de email inválido.");
        }
	}
}
