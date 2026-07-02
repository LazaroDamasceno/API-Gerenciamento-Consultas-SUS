package com.api.v1.usuariobasico.infra;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.api.v1.geral.Helpers;
import com.api.v1.usuariobasico.UsuarioBasico;
import com.api.v1.usuariobasico.UsuarioBasicoRepositorio;
import com.mongodb.client.result.DeleteResult;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class UsuarioBasicoRepositorioImpl implements UsuarioBasicoRepositorio {

    private final MongoTemplate mongoTemplate;

    @Override
    public UsuarioBasico salvar(UsuarioBasico entidade) {
        return mongoTemplate.save(entidade);
    }

    @Override
    public long deletar(UsuarioBasico entidade) {
        DeleteResult deleteResult = mongoTemplate.remove(entidade);
        return deleteResult.getDeletedCount();
    }

    @Override
    public Optional<UsuarioBasico> acharPorId(String id) {
        ObjectId objectId = new ObjectId(id);
        UsuarioBasico objetoPorId = mongoTemplate.findById(objectId, UsuarioBasico.class);
        return Optional.ofNullable(objetoPorId);
    }

@Override
    public Optional<UsuarioBasico> acharPorCpf(String cpf) {
        Query query = Helpers.getQuery();
        query.addCriteria(Criteria.where("cpf.cpf").is(cpf)); 
        
        UsuarioBasico usuarioPorCpf = mongoTemplate.findOne(query, UsuarioBasico.class);
        return Optional.ofNullable(usuarioPorCpf);
    }

    @Override
    public Optional<UsuarioBasico> acharPorEmail(String email) {
        Query query = Helpers.getQuery();
        query.addCriteria(Criteria.where("email.email").is(email));
        
        UsuarioBasico usuarioPorEmail  = mongoTemplate.findOne(query, UsuarioBasico.class);
        return Optional.ofNullable(usuarioPorEmail);
    }
    
}
