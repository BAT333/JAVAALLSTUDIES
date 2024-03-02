package org.example.Revisao;

import javax.persistence.EntityManager;
import java.util.List;

public class EnderecoEntidadeDAO {
    private EntityManager entityManager;
    public EnderecoEntidadeDAO(EntityManager  entityManager){
        this.entityManager = entityManager;
    }
    public void cadastra(Endereco endereco){
        this.entityManager.persist(endereco);
    }
    public void update(int id,String cep,String bairro){

        Endereco endereco1= entityManager.find(Endereco.class,id);
        entityManager.merge(endereco1);
        endereco1.setCep(cep);
        endereco1.setBairro(bairro);

    }
    public void delete(int id){
        Endereco endereco2 = entityManager.find(Endereco.class,id);
        entityManager.merge(endereco2);
        entityManager.remove(endereco2);

    }
    public List<Endereco> enderecoList(){
        String jdpt = "SELECT e FROM Endereco e ";
      return entityManager.createQuery(jdpt,Endereco.class).getResultList();

    }
}
