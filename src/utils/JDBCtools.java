package utils;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Vector;

public class JDBCtools {


	//释放连接资源
	public static void relese(ResultSet rs,Statement statement,Connection con) throws SQLException{
		try {}
		catch (Exception e) {
		}finally{
			if(rs != null)
			rs.close();
			if(statement != null)
			statement.close();
			if(con != null)
			con.close();
		}
	}
	//获取数据库一行的数据  
	public static Vector<String> getNextRow(ResultSet rs, ResultSetMetaData rsmd) throws SQLException {
		Vector<String> currentRow = new Vector<String>();
		for (int i = 1; i <= rsmd.getColumnCount(); i++) {
			currentRow.addElement(rs.getString(i));

		}
		return currentRow;
	}

	//动态获取数据库连接方法
	public Connection getconnection() throws IOException, ClassNotFoundException, SQLException {
		String driverClass = null;
		String jdbcUrl = null;
		String user = null;
		String password = null;
		InputStream in = getClass().getClassLoader().getResourceAsStream("jdbc.properties");
		Properties properties = new Properties();
		properties.load(in);
		driverClass = properties.getProperty("driver");
		jdbcUrl = properties.getProperty("jdbcUrl");
		user = properties.getProperty("user");
		password = properties.getProperty("password");
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(jdbcUrl, user, password);
		return con;
	}

	

	
}
