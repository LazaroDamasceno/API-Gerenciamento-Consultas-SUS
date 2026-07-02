package com.api.v1.usuariobasico.domain.repositorios;

import java.util.Optional;

import com.api.v1.geral.OperacoesBasicasRepositorio;
import com.api.v1.usuariobasico.UsuarioBasico;

public interface UsuarioBasicoRepositorio extends OperacoesBasicasRepositorio<UsuarioBasico> {
	Optional<UsuarioBasico> acharPorCpf(String cpf);
	Optional<UsuarioBasico> acharPorEmail(String email);
}
