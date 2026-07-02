package com.api.v1.usuariobasico.infra;

import java.util.Optional;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.api.v1.usuariobasico.UsuarioBasico;
import com.api.v1.usuariobasico.domain.repositorios.UsuarioBasicoRepositorio;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class UsuarioBasicoRepositorioImpl implements UsuarioBasicoRepositorio {

    private final MongoTemplate mongoTemplate;

    @Override
    public UsuarioBasico salvar(UsuarioBasico entidade) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'salvar'");
    }

    @Override
    public void deletar(UsuarioBasico entidade) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletar'");
    }

    @Override
    public Optional<UsuarioBasico> findById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Optional<UsuarioBasico> acharPorCpf(String cpf) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'acharPorCpf'");
    }

    @Override
    public Optional<UsuarioBasico> acharPorEmail(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'acharPorEmail'");
    }
    
}
