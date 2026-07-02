package com.api.v1.usuariobasico.valueobjects;

import java.util.Objects;
import java.util.regex.Pattern;

public record Endereco(
		String rua, 
		String bairro, 
		String numero, 
		String cep,
		String cidade,
		String uf
) {
	
	private static final Pattern PADRAO_DIGITOS_CEP = Pattern.compile("^\\d{8}$");

	public Endereco {
		Objects.requireNonNull(rua, "Rua é obrigatório.");
		Objects.requireNonNull(bairro, "Bairro é obrigatório.");
		Objects.requireNonNull(numero, "Número da residência é obrigatório.");
		Objects.requireNonNull(cep, "CEP é obrigatório.");
		Objects.requireNonNull(cidade, "Cidade é obrigatório.");
		Objects.requireNonNull(uf, "UF é obrigatório.");
		
		String cepLimpo = cep.replace("-", "").trim(); 
		String ufTratada = uf.trim().toUpperCase();
		
		if (rua.isBlank() || bairro.isBlank() || numero.isBlank() 
				|| cepLimpo.isBlank() || cidade.isBlank() || ufTratada.isBlank()
		) {
			throw new IllegalArgumentException("Todos os componentes do endereço são obrigatórios.");
		}
		
		if (ufTratada.length() != 2) {
			throw new IllegalArgumentException("UF deve conter exatamente 2 caracteres.");
		}
		
		if (!PADRAO_DIGITOS_CEP.matcher(cepLimpo).matches()) {
			throw new IllegalArgumentException("Formato inválido de CEP. Deve conter 8 dígitos.");
		}
		
		cep = cepLimpo;
		uf = ufTratada;
	}
}