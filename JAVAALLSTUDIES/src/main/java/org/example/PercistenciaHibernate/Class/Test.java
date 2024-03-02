package org.example.PercistenciaHibernate.Class;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Test {
    public static void main(String[] args) {
        Cadastro cadastro = new Cadastro("Renan",18);
/*
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("comex");
        EntityManager entityManager = managerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(cadastro);
        entityManager.getTransaction().commit();

 */
        CadastroServico servico =  new CadastroServico(cadastro);
        servico.salvar();

    }
}
