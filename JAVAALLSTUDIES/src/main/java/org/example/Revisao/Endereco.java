package org.example.Revisao;

import com.google.gson.annotations.SerializedName;

import javax.persistence.*;

@Entity
@Table(name = "endereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @SerializedName("cep")
    private String cep;
    @Column(name = "bairro")
    private String bairro;
    public Endereco(){

    }
    public Endereco(String cep, String bairro){
        this.cep = cep;
        this.bairro = bairro;
    }
    public String getCep(){
        return cep;
    }
    public void setCep(String cep){
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "id=" + id +
                ", cep='" + cep + '\'' +
                ", bairro='" + bairro + '\'' +
                '}';
    }
}
