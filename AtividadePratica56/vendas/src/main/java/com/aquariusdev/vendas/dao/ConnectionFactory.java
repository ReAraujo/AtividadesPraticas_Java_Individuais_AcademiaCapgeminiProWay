package com.aquariusdev.vendas.dao;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
    private DataSource dataSource;  

    public ConnectionFactory() {
        ComboPooledDataSource poolConexoes = new ComboPooledDataSource();
        this.dataSource = poolConexoes; 
    }

    public Connection getConnection() throws SQLException{
        return this.dataSource.getConnection();
    }
}
