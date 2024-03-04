package org.example.Revisao;

import javax.persistence.*;

@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nome")
    private String name;
    @Column(name = "idade")
    private int age;
    @Embedded
    private Enderec endereco;


    public Usuario(){}
    public Usuario(String name,int age,Enderec endereco){
        this.name= name;
        this.age =age;
        this.endereco =endereco;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}
