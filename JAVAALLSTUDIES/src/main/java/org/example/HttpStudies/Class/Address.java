package org.example.HttpStudies.Class;

import com.google.gson.annotations.SerializedName;
import org.example.DataBase.Connection.AddressDAO;
import org.example.DataBase.Connection.FactoryConnection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class Address {

    @SerializedName("cep")
    private int zipCod;
    private String publicPlace;
    private String complement;
    private  String neighborhood;
    private String locality;
    private String state;
    private int number;

    private FactoryConnection connection;

    public Address(AddressRecord ar){
        this.zipCod = Integer.valueOf(ar.cep().replace("-",""));
        this.publicPlace = ar.logradouro();
        this.complement = ar.complemento();
        this.neighborhood = ar.bairro();
        this.locality = ar.localidade();
        this.state = ar.uf();
        this.connection = new FactoryConnection();

    }
    public Address(AddressRecord ar,int number){
        this.zipCod = Integer.valueOf(ar.cep().replace("-",""));
        this.publicPlace = ar.logradouro();
        this.complement = ar.complemento();
        this.neighborhood = ar.bairro();
        this.locality = ar.localidade();
        this.state = ar.uf();
        this.number = number;
        this.connection = new FactoryConnection();

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
    public void AddDataBase(){
        new AddressDAO(connection.RecoveryConnection()).AddressDataBase(this);
    }
    public void Deleting(){

        new AddressDAO(connection.RecoveryConnection()).DeletingAddress(this);
    }

    public List<Address> addressList(){
        Connection con = connection.RecoveryConnection();
        AddressDAO addressDAO = new AddressDAO(con);

        return addressDAO.ReturnAddress();

    }
    public void update(int number,int zipCod){
        Connection connections = connection.RecoveryConnection();
        AddressDAO addressDAO = new AddressDAO(connections);
        addressDAO.update(number,zipCod);

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
