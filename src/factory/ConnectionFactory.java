package factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

	public DataSource dataSource;
	
	public ConnectionFactory() {

		ComboPooledDataSource comboPDS = new ComboPooledDataSource();
		comboPDS.setJdbcUrl("jdbc:mysql://localhost/hotelalura?useTimezone=true&serverTimezone=UTC");
		comboPDS.setUser("root");
		comboPDS.setPassword("root");
		
		dataSource = comboPDS;
		
	}

	public Connection getConexion() {
		try {
			return this.dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
