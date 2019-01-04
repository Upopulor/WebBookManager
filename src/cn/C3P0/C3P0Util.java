package cn.C3P0;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Util {
	//得到每一个数据源
	private static DataSource dataSource = new ComboPooledDataSource();
	
	public static DataSource getDataSource() {
		return dataSource;
	}
	//第一种：在程序中配置
	/*private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	 * static {
		try {
			dataSource.setDriverClass("com.mysql.jdbc.Driver");//load the jdbc driver
			dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/day06");
			dataSource.setUser("root");
			dataSource.setPassword("root");
			dataSource.setInitialPoolSize(10);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	//第二种：使用XML
	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException("服务器连接错误");
		}
	}
	public static void closeAll(ResultSet rs,Statement stmt,Connection connection) {
		//6 关闭资源 取决于条件，如果是没有足够的连接，就不会关闭，而是放回去
		//  如果连接池足够，就会关闭，Apache已经在底层做好了，这里直接调用close就ok
		if(rs!=null) {
			try { //里面了可能还有异常，所以加trycatch
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			rs=null;
		}
		if(stmt!=null) {
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			stmt = null;
		}
		if(connection!=null) {
			try {
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			connection = null;
		}
	}
}
