package org.example.DataBase.Connection;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FactoryConnection {
    //Aqui faz conexao com banco de dados retorna Connection
    //DriverManager = todos bancos de dados disponiveis
    //getConnection = qual banco vc quer conectar
    public Connection RecoveryConnection(){
        try {
            return this.CreateDataSource().getConnection();
        }catch (SQLException ex){
            throw new RuntimeException(ex);

        }


    }

    private HikariDataSource CreateDataSource(){
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/comex");
        config.setUsername("root");
        config.setPassword("Rafael234");
        config.setMaximumPoolSize(10);

        return new HikariDataSource(config);


    }


}
