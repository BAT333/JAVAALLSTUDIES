package org.example.DataBase.Connection;

import org.example.HttpStudies.Class.Address;
import org.example.HttpStudies.Class.AddressRecord;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
            con.setAutoCommit(false);
            statement.setInt(1,address.getZipCod());
            // aqui excuta as instrução
            statement.execute();
            con.commit();
            //aqui fecha a conexão
            statement.close();
            con.close();
        }catch (SQLException ex){
            try {
                con.rollback();
            }catch (SQLException e){

                throw new RuntimeException(e);

            }

            throw new RuntimeException(ex);

        }



    }

    public List<Address> ReturnAddress() {
        List<Address> addresses = new ArrayList<>();
        String sql = "select * from address";
        try {
            PreparedStatement statement =  con.prepareStatement(sql);
            //executeQuery que pega infos do banco de dados
            //aqui excuteQuery diferente do exculte, ele pega informação
            ResultSet resultSet =  statement.executeQuery();
            //aqui vai fazer while rodar enquanto na coluna tiver linha
            while (resultSet.next()) {
                //aqui vc declara uma variavel e pega ela pela coluna que ela esta começando do
                // 1
                Integer cep = resultSet.getInt(1);
                String logradouro  = resultSet.getNString(6);
                String complemento  = resultSet.getNString(4);
                String bairro  = resultSet.getNString(2);
                String localidade  = resultSet.getNString(3);
                String uf  = resultSet.getNString(5);
                Integer number = resultSet.getInt(7);
//aqui passa as infos e add na list
                AddressRecord addressRecord = new AddressRecord(String.valueOf(cep),logradouro,complemento,bairro,localidade,uf);
                Address address = new Address(addressRecord,number);
                addresses.add(address);
            }
            resultSet.close();
            statement.close();
            con.close();
        }catch (SQLException ex){
            throw new RuntimeException(ex);

        }
        return addresses;

    }

    public void update(int number, int zipCod){
        //aqui para fazer update bem simples passa comando do update
        String sql = "update address set Number = ? where Zip_cod = ?";
        try {
            //o number e cod dele e modifica no banco
            con.setAutoCommit(false);
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, number);
            preparedStatement.setInt(2, zipCod);
            preparedStatement.execute();
            con.commit();
            preparedStatement.close();
            con.close();
        }catch (SQLException ex){
            try {
                con.rollback();
            }catch (SQLException e){

                throw new RuntimeException(e);

            }
            throw  new RuntimeException(ex);

        }


    }




}
