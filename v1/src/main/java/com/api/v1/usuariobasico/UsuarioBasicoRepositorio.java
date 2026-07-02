package com.api.v1.usuariobasico;

import java.util.Optional;

import com.api.v1.geral.OperacoesBasicasRepositorio;

public interface UsuarioBasicoRepositorio extends OperacoesBasicasRepositorio<UsuarioBasico> {
	Optional<UsuarioBasico> acharPorCpf(String cpf);
	Optional<UsuarioBasico> acharPorEmail(String email);
}
