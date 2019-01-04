package cn.C3P0;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Util {
	//�õ�ÿһ������Դ
	private static DataSource dataSource = new ComboPooledDataSource();
	
	public static DataSource getDataSource() {
		return dataSource;
	}
	//��һ�֣��ڳ���������
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
	//�ڶ��֣�ʹ��XML
	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException("���������Ӵ���");
		}
	}
	public static void closeAll(ResultSet rs,Statement stmt,Connection connection) {
		//6 �ر���Դ ȡ���������������û���㹻�����ӣ��Ͳ���رգ����ǷŻ�ȥ
		//  ������ӳ��㹻���ͻ�رգ�Apache�Ѿ��ڵײ������ˣ�����ֱ�ӵ���close��ok
		if(rs!=null) {
			try { //�����˿��ܻ����쳣�����Լ�trycatch
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
