package com.api.v1.usuariobasico.domain.valueobjects;

import java.util.Objects;
import java.util.regex.Pattern;

public record CPF(String cpf) {
	
	private static final Pattern PADRAO_DIGITOS_CPF = Pattern.compile("^\\d{11}$"); 

	public CPF {
		Objects.requireNonNull(cpf, "CPF não pode ser nulo.");
		
		String cpfLimpo = cpf.replace(".", "").replace("-", "");
		
		if (cpfLimpo.isBlank()) {
			throw new IllegalArgumentException("CPF é obrigatório.");
		}
		
		if (!PADRAO_DIGITOS_CPF.matcher(cpfLimpo).matches()) {
			throw new IllegalArgumentException("Formato inválido de CPF. Deve conter 11 dígitos.");
		}
	}
}