package br.com.comex.factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	
	public DataSource dataSource;
	
	public ConnectionFactory() {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:oracle:thin:@172.17.0.2:1522:xe");
		//comboPooledDataSource.setJdbcUrl("jdbc:oracle:thin:0.0.0.0:@172.17.0.2:1522:xe");
		//comboPooledDataSource.setJdbcUrl("jdbc:oracle:thin:@0.0.0.0:1522:xe");
		comboPooledDataSource.setUser("system");
		comboPooledDataSource.setPassword("admin");
		
		comboPooledDataSource.setMaxPoolSize(15);
		
		this.dataSource = comboPooledDataSource;
	}
	
	public Connection getConnection() throws SQLException{
		return this.dataSource.getConnection();
	}
		
}
