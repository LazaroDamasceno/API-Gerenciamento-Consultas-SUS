package com.api.v1.usuariobasico;

import java.time.LocalDate;
import java.util.Objects;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.api.v1.usuariobasico.valueobjects.CPF;
import com.api.v1.usuariobasico.valueobjects.Email;
import com.api.v1.usuariobasico.valueobjects.Endereco;
import com.api.v1.usuariobasico.valueobjects.Genero;
import com.api.v1.usuariobasico.valueobjects.NomeCompleto;
import com.api.v1.usuariobasico.valueobjects.NumeroTelefone;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Document(collection = "usuariosbasicos")
public class UsuarioBasico {
	
	@Id
	private ObjectId id;
	private CPF cpf;
	private Endereco endereco;
	private Genero genero;
	private NumeroTelefone numeroTelefone;
	private NomeCompleto nomeCompleto;
	private Email email;
	private LocalDate dataNascimento;
	
	private UsuarioBasico(
			CPF cpf,
			Endereco endereco,
			Genero genero,
			NumeroTelefone numeroTelefone,
			NomeCompleto nomeCompleto,
			Email email,
			LocalDate dataNascimento
	) {
		
		Objects.requireNonNull(cpf, "CPF é obrigatório.");
		Objects.requireNonNull(endereco, "Endereço é obrigatório.");
		Objects.requireNonNull(genero, "Gênero é obrigatório.");
		Objects.requireNonNull(numeroTelefone, "Número de telefone é obrigatório.");
		Objects.requireNonNull(nomeCompleto, "Nome completo é obrigatório.");
		Objects.requireNonNull(email, "Email é obrigatório.");
		Objects.requireNonNull(dataNascimento, "Data de nascimento é obrigatório.");
		
		this.id = ObjectId.get();
		this.cpf = cpf;
		this.endereco = endereco;
		this.genero = genero;
		this.numeroTelefone = numeroTelefone;
		this.nomeCompleto = nomeCompleto;
		this.email = email;
		this.dataNascimento = dataNascimento;
	}
	
	public static UsuarioBasico novo(
			CPF cpf,
			Endereco endereco,
			Genero genero,
			NumeroTelefone numeroTelefone,
			NomeCompleto nomeCompleto,
			Email email,
			LocalDate dataNascimento
	) {
		return new UsuarioBasico(
				cpf, endereco, genero, 
				numeroTelefone, nomeCompleto, email,
				dataNascimento
		);
	}
}
