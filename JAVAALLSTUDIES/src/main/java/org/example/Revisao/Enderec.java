package org.example.Revisao;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

@Embeddable
public class Enderec {
    @Column(name = "endereco")
    public String ender;

    public Enderec(){

    }
    public Enderec(String ender){
        this.ender = ender;
    }

}
