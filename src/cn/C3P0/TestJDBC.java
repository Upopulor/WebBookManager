package cn.C3P0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;


public class TestJDBC {
	@Test
	public void test1() {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = C3P0Util.getConnection();
			System.out.println(conn.getClass().getName());
			ps = conn.prepareStatement("insert into users(id,name,password,email,birthday)values(222,'c3p0','sss','1234@qq.com','2018-12-21')");
			/**
			 * ÔöÉ¾¸Ä²é
			 */
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			C3P0Util.closeAll(null, ps, conn);
		}
	}

}
