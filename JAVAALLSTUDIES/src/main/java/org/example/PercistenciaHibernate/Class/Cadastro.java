package org.example.PercistenciaHibernate.Class;

import javax.persistence.*;

@Entity
@Table(name = "Usuario")
public class Cadastro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nome")
    private String name;
    private int idade;

    public Cadastro(String name ,int idade){
        this.name = name;
        this.idade = idade;

    }



}
