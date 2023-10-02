package day29.dbOracle.quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DBOracle {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String user = "mytest";
		String password = "mytest";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("연동성공");
			String sql = "insert into Persons(firstName,lastName,age,city)"
					+ "values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, "Chris");
			pstmt.setNString(2, "Lee");
			pstmt.setInt(3, 20);
			pstmt.setNString(4, "Sanjose");
			
			int result = pstmt.executeUpdate();
			if(result != 0) {
				System.out.println("레코드 추가 성공");
			} else {
				System.out.println("레코드 추가 실패");
			}
			
			String sql2 = "select * from Persons";
			pstmt = conn.prepareStatement(sql2);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				
				System.out.printf("이름: %s%s, 나이: %d, 사는 도시: %s", rs.getString("firstName"),rs.getNString("lastName"),
						rs.getInt("age"), rs.getString("city"));
			}
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패");
		} catch (SQLException sqle) {
			System.out.println("연동 실패");
			System.out.println(sqle.getMessage());
		}
		
	}

}
