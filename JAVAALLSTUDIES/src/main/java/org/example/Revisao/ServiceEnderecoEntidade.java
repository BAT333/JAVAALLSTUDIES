package org.example.Revisao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ServiceEnderecoEntidade {
    private final static EntityManagerFactory CONECTE = Persistence.createEntityManagerFactory("endereco");
    private final static EntityManager MANAGER = CONECTE.createEntityManager();
    public void AbrirConex(){
        MANAGER.getTransaction().begin();
    }
    public void cadastra(Endereco endereco){
        EnderecoEntidadeDAO dao = new EnderecoEntidadeDAO(MANAGER);

        dao.cadastra(endereco);
        MANAGER.flush();
        MANAGER.clear();


    }
    public void update(int id,String cep,String bairro){
        EnderecoEntidadeDAO dao = new EnderecoEntidadeDAO(MANAGER);
        dao.update(id,cep,bairro);
        MANAGER.flush();
        MANAGER.clear();
    }
    public void delete(int id){
        EnderecoEntidadeDAO dao = new EnderecoEntidadeDAO(MANAGER);
        dao.delete(id);

        MANAGER.flush();
        MANAGER.clear();

    }
    public List<Endereco> enderecoList(){
        EnderecoEntidadeDAO dao = new EnderecoEntidadeDAO(MANAGER);
        return dao.enderecoList();

    }
    public void fechar(){
        MANAGER.getTransaction().commit();
        MANAGER.close();

    }
}
