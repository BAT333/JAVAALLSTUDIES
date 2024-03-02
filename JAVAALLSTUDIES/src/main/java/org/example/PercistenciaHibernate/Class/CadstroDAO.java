package org.example.PercistenciaHibernate.Class;

import javax.persistence.EntityManager;

public class CadstroDAO {
    private EntityManager me;
    public CadstroDAO(EntityManager me){
        this.me= me;

    }
    public void cadastra(Cadastro cadastro){
        me.getTransaction().begin();
        this.me.persist(cadastro);
        me.getTransaction().commit();
        me.close();

    }
}
