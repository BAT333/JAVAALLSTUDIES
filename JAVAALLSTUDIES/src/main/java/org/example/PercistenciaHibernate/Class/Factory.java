package org.example.PercistenciaHibernate.Class;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Factory {
    public EntityManager Conectar(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("comex");
        return factory.createEntityManager();

    }
}
