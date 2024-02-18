package org.example.HttpStudies.Class;

import com.google.gson.annotations.SerializedName;

public class Address {

    @SerializedName("cep")
    private int zipCod;
    private String publicPlace;
    private String complement;
    private  String neighborhood;
    private String locality;
    private String state;
    private int number;
    
    public Address(AddressRecord ar){
        this.zipCod = Integer.valueOf(ar.cep().replace("-",""));
        this.publicPlace = ar.logradouro();
        this.complement = ar.complemento();
        this.neighborhood = ar.bairro();
        this.locality = ar.localidade();
        this.state = ar.uf();

    }

    public int getZipCod(){
        return zipCod;

    }
    public String getPublicPlace(){
        return publicPlace;

    }
    public String getComplement(){
        return complement;

    }
    public String getNeighborhood(){
        return neighborhood;
    }
    public String getLocality(){
        return locality;

    }
    public String getState(){
        return state;
    }
    public int getNumber(){

        return number;
    }

    @Override
    public String toString() {
        return "Address{" +
                "zipCod=" + zipCod +
                ", publicPlace='" + publicPlace + '\'' +
                ", complement='" + complement + '\'' +
                ", neighborhood='" + neighborhood + '\'' +
                ", locality='" + locality + '\'' +
                ", state='" + state + '\'' +
                ", number=" + number +
                '}';
    }
}
