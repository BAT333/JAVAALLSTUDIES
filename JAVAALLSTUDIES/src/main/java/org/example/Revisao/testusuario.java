package org.example.Revisao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class testusuario {
    public static void main(String[] args) {
        Enderec enderec = new Enderec("JOAQUIM");
        Usuario usuario = new Usuario("RAFAEL",19,enderec);
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("endereco");
        EntityManager manager = managerFactory.createEntityManager();

        manager.getTransaction().begin();
        manager.persist(usuario);
        manager.getTransaction().commit();
        manager.close();
    }
}
