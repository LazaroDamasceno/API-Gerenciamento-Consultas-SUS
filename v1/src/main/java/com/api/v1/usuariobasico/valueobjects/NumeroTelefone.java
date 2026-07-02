package com.api.v1.usuariobasico.valueobjects;

import java.util.Objects;
import java.util.regex.Pattern;

public record NumeroTelefone(String numeroTelefone) {
	
	private static final Pattern PADRAO_NUM_TELEFONE = Pattern.compile("^\\d{11}$");

	public NumeroTelefone {
		Objects.requireNonNull(numeroTelefone, "Número de telefone é obrigatório.");
		
		String numFoneLimpo = numeroTelefone.replace("(", "")
				.replace(")", "")
				.replace("-", "");
		
		if (numFoneLimpo.isBlank()) {
			throw new IllegalArgumentException("Número de telefone é obrigatório.");
		}
		
		if (!PADRAO_NUM_TELEFONE.matcher(numFoneLimpo).matches()) {
			throw new IllegalArgumentException("Formato errado de número de telefone. Deve conter 11 dígitos.");
		}
	}
}
