package com.api.v1.usuariobasico.domain.valueobjects;

import java.util.Objects;

public record NomeCompleto(String primeiroNome, String nomeMeio, String sobrenome) {

	public NomeCompleto {
		Objects.requireNonNull(primeiroNome, "Primeiro nome é obrigatório.");
		Objects.requireNonNull(sobrenome, "Sobrenome é obrigatório.");
		
		if (primeiroNome.isBlank() || sobrenome.isBlank()) {
			throw new IllegalArgumentException("Tanto o primeiro nome e o sobrenome são obrigatórios.");
		}
	}
}
 