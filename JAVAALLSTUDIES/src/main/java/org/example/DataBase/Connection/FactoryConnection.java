package org.example.DataBase.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FactoryConnection {
//Aqui faz conexao com banco de dados retorna Connection
    //DriverManager = todos bancos de dados disponiveis
    //getConnection = qual banco vc quer conectar
    public Connection RecoveryConnection(){
        try {
          return   DriverManager.getConnection("jdbc:mysql://localhost:3306/comex?user=root&password=Rafael234");
        }catch (SQLException ex){
            throw new RuntimeException(ex);

        }


    }


}
