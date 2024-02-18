package org.example.DataBase.Connection;

import org.example.HttpStudies.Class.Address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddressDAO {
    //Dao onde fica tudo que tem banco de dados
    //nada de regra de negocios so coisa do banco
    private Connection con;
//aqui precisa add connection mas comum conexão que vc fez com seu banco
    public AddressDAO(Connection con){
        this.con = con;

    }

    public void AddressDataBase(Address address){
        //aqui oq vc vai fazer no banco exemplo inserir infos
        String sql = "INSERT INTO Address (Zip_cod, Neighborhood, City, Complement, State ,Street, Number)" +
                      "VALUES (?, ?, ?, ?, ?, ?, ?);";
        try {
            //aqui vc passa oq vc quer fazer no banco tipo inserir infos
            PreparedStatement statement = con.prepareStatement(sql);
            //passa parametro a ser add e oq vai ser add
            statement.setInt(1,address.getZipCod());
            statement.setString(2,address.getNeighborhood());
            statement.setString(3,address.getLocality());
            statement.setString(4,address.getComplement());
            statement.setString(5, address.getState());
            statement.setString(6,address.getPublicPlace());
            statement.setInt(7,address.getNumber());
            statement.execute();
            statement.close();
            con.close();
        }catch (SQLException ex){

            throw  new RuntimeException(ex);
        }

    }
    public void DeletingAddress(Address address){
        //aqui mesma coisa so que com excluir
        String Sql = "Delete from comex.address where Zip_cod = ?";
        try {
           PreparedStatement statement =  con.prepareStatement(Sql);
           statement.setInt(1,address.getZipCod());
           // aqui excuta as instrução
           statement.execute();
           //aqui fecha a conexão
           statement.close();
           con.close();
        }catch (SQLException ex){
            throw new RuntimeException(ex);

        }



    }


}
