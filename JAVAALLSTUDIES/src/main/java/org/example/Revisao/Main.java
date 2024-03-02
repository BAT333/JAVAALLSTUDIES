package org.example.Revisao;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create();

        Endereco endereco = gson.fromJson(PesquisaCep.Endereco("69312-265"), Endereco.class);
        ServiceEnderecoEntidade serviceEnderecoEntidade = new ServiceEnderecoEntidade();
        serviceEnderecoEntidade.AbrirConex();
        serviceEnderecoEntidade.cadastra(endereco);
       // serviceEnderecoEntidade.delete(64);
       serviceEnderecoEntidade.update(62,"4","bairro dos coração");
        for (Endereco mostra:serviceEnderecoEntidade.enderecoList()){
            System.out.println(mostra);

        }
        serviceEnderecoEntidade.fechar();
        /*
        ServiceEndereco serviceEndereco = new ServiceEndereco(endereco);
        serviceEndereco.cadastra();
        serviceEndereco.delete(40);
        serviceEndereco.update(21,"Rua Do Amor");
        for (Endereco mostra:serviceEndereco.listaEndereco()){
            System.out.println(mostra);
        }

        System.out.println(endereco);


        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create();
        Endereco endereco = gson.fromJson(PesquisaCep.Endereco("72410-206"),Endereco.class);


        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("endereco");

        EntityManager entityManager = managerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(endereco);
        entityManager.flush();
        //upadate
       Endereco endereco1= entityManager.find(Endereco.class,43);
       endereco1.setCep("72410-206");
       endereco1.setBairro("FUSCA ROSA E OCULOS DE CORAÇÃO");
        entityManager.flush();
        //delete

        Endereco endereco2 = entityManager.find(Endereco.class,46);
        entityManager.remove(endereco2);
        entityManager.flush();
        entityManager.clear();


       //lista de endereco

        String jdpt = "SELECT e.bairro FROM Endereco e WHERE e.id = ?1";

        //String jdpt = "SELECT e FROM Endereco e WHERE e.id = ?1";
      //  List<Endereco> enderecoList = entityManager.createQuery(jdpt,Endereco.class).setParameter(1,42).getResultList();
      String  enderecoList = entityManager.createQuery(jdpt,String.class).setParameter(1,43).getSingleResult();
      System.out.println(enderecoList);

        List<Endereco> enderecoList = entityManager.createQuery(jdpt,Endereco.class).getResultList();
        for (Endereco mostra: enderecoList){
            System.out.println(mostra);
        }


        entityManager.getTransaction().commit();
        entityManager.close();

    }

         */
    }
}


