package org.example.Revisao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDAO {
    private Connection connection;
    public EnderecoDAO(Connection connection){
        this.connection = connection;
    }

    public void cadastro(Endereco endereco){
        try {
            connection.setAutoCommit(false);
            String sql  = "insert into endereco(cep,bairro) value(?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, endereco.getCep());
            statement.setString(2, endereco.getBairro());
            statement.execute();
            connection.commit();
            statement.close();
            connection.close();

        }catch (SQLException ex){
            try {
                connection.rollback();
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
            throw new RuntimeException(ex);

        }
    }
    public void update(int id,String bairro){
        try {
            connection.setAutoCommit(false);
            String sql  = "update endereco set bairro = ? where id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,bairro);
            statement.setInt(2,id);
            statement.execute();
            connection.commit();
            statement.close();
            connection.close();


        }catch (SQLException ex){
            try {
                connection.rollback();
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
            throw new RuntimeException(ex);

        }
    }
    public void delete(int id){
        try {
            connection.setAutoCommit(false);
            String sql  = "delete from endereco where id =?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            statement.execute();
            connection.commit();
            statement.close();
            connection.close();



        }catch (SQLException ex){
            try {
                connection.rollback();
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
            throw new RuntimeException(ex);

        }
    }
    public List<Endereco> lista(){
        List<Endereco> enderecos = new ArrayList<>();
        try {
            String sql  = "select * from endereco order by bairro asc;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet set = statement.executeQuery();
            while (set.next()){
                String cep = set.getNString(2);
                String bairro = set.getNString(3);
                Endereco endereco = new Endereco(cep,bairro);
                enderecos.add(endereco);
            }


        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return enderecos;
    }


}
