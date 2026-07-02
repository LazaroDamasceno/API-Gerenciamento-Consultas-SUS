package com.api.v1.geral;

import java.util.Optional;

public interface OperacoesBasicasRepositorio<T> {
	T salvar(T entidade);
	void deletar(T entidadeT);
	Optional<T> findById(String id);
}
