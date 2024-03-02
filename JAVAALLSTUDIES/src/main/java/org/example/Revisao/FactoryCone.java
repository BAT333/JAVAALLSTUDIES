package org.example.Revisao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FactoryCone {
    public Connection  connection(){
        try {
            return dataSource().getConnection();

        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }

    }
    private HikariDataSource dataSource(){
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/cadastro");
        config.setUsername("root");
        config.setPassword("Rafael234");
        config.setMaximumPoolSize(10);

        return new HikariDataSource(config);
    }
}
