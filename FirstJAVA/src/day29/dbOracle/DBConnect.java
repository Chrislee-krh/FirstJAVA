package day29.dbOracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnect {

	/* JAVA DB연동하기
	1. Driver loading
	2. DriverManager로 Connection 객체 생성
	3. SQL 작성(preparedstatement방식은 sql작성이 먼저)
	4. PreparedStatement 객체 사용(Statement 대용)
	5. SQL실행	
	6. 왜 PreparedStatement를 사용?
		- SQL에 전달하여 처리하는 값을 변환하는 것이 Statement면 까다로워서, 간결하게 하려고.
		- 값을 전달할 때 SQL에 ?로 처리하여 값 지정, 변환처리는 자동
		- ?는 인덱스 값을 사용 참조하기 때문에 여러개면 1번부터 순서대로 지정
	*/
	
	public static void main(String[] args) {
		// 오라클 DB Connect - preparedStatement
		
		// 연결 정보
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String user = "mytest";
		String password = "mytest";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// 1. 드라이버 로드
			Class.forName(driver);
			// 2. Connection객체 생성 - Drivermanager
			conn = DriverManager.getConnection(url, user, password);
			System.out.println(conn);
			System.out.println("DB연동 성공");
			// 3. sql 작성 -> insert
			String sql = "insert into Users (name,age) values(?,?)";
			// 4. preparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// 5. ?에 값을 대입
			pstmt.setString(1, "testuser");
			pstmt.setInt(2, 20);
			// 6. sql 실행
			int result = pstmt.executeUpdate(); //()안에 sql 넣지 x
			if(result !=0) {
				System.out.println("레코드 추가 성공");
			} else {
				System.out.println("레코드 추가 실패");
			}
			
			String sql2 = "select * from Users";
			pstmt = conn.prepareStatement(sql2);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.printf("이름: %s, 나이: %d", rs.getString("name"), rs.getInt("age"));
			}
			
			// 테이블 생성
			// oracle에 mytest계정에 Persons테이블을 생성
			// id, lastName, firstName, age, city를 가지는 테이블 생성
			// 각 테이블에 정보를 입력받아 데이터를 생성할 수 있게 만들기.(id는 자동 생성)
			// 모든 레코드 추가가 성공하면, Persons테이블에 있는 레코드 전체를 출력하는 코드를 작성
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 불가");
			System.out.println(e.getMessage());
		} catch (SQLException sqle) {
			System.out.println("DB연동 실패");
			System.out.println(sqle.getMessage());
		}
	}
}
