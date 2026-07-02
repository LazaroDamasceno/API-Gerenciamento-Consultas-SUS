package com.api.v1.geral;

import java.util.Optional;

public interface OperacoesBasicasRepositorio<T> {
	T salvar(T entidade);
	long deletar(T entidade);
	Optional<T> acharPorId(String id);
}
