package com.api.v1.geral;

import java.util.Optional;

public interface OperacoesBasicasRepositorio<T> {
	T salvar(T entidade);
	void deletar(T entidade);
	Optional<T> findById(String id);
}
