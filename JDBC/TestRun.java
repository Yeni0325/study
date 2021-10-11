package test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestRun {

	public static void main(String[] args) {
		
		/*
		 * * JDBC용 객체
		 * - Connection : DB의 연결정보를 담고있는 객체
		 * - [Prepared]Statement : 연결된 DB에 sql문을 전달해서 실행하고 그 결과를 받아내는 객체 ****
		 * - ResultSet : SELECT문 실행 후 조회된 결과물둘이 담겨있는 객체
		 * 
		 * * JDBC 과정 (순서중요)
		 * 1) jdbc driver 등록 : 해당 DBMS(오라클)가 제공하는 클래스 등록
		 * 2) Connection 생성 : 연결하고자 하는 DB정보를 입력해서 해당 DB와 연결하면서 생성
		 * 3) Statement 생성 : Connection 객체를 이용해서 생성 (sql문 실행 및 결과를 돌려받는 객체)
		 * 4) sql문 전달하면서 실행 : Statemenet 객체를 이용해서 sql문 실행
		 * 5) 결과받기
		 * 		> SELECT문 실행 => ResultSet객체 (조회된 데이터들이 감겨있음) => 6-1)
		 * 		>    DML문 실행 => int (처리된 행 수)                   => 6-2)
		 * (insert, update, delete)					
		 * 
		 * 6-1) ResultSet에 담겨있는 데이터들을 하나씩 하나씩 뽑아서 vo객체에 주섬주섬 옮겨 담기 [+ ArrayList에 차곡차곡 담기]
		 * 6-2) 트랜잭션 처리 (성공적으로 수행했으면 commit, 실패했으면 rollback)
		 * 
		 * 7) 다 사용한 JDBC용 객체들 반드시 자원 반납(close) => 생성된 역순으로 
		 * 		
		 */
		
		// 1. 각자 pc(localhost)에 JDBC계정에 연결 한 후 TEST테이블에 INSERT 해보기
		//    insert문 => 처리된 행 수 (int) => 트랜잭션 처리
		
		/*
		Scanner sc = new Scanner(System.in);
		
		System.out.print("번호 : ");
		int num = sc.nextInt();
		
		sc.nextLine();
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		
		// 필요한 변수들 먼저 셋팅
		int result = 0;   // 결과(처리된 행 수)를 받아줄 변수
		Connection conn = null; // DB의 연결정보를 보관할 객체 
		// 기본자료형이 아닌 참조자료형에는 주소값이 들어가고, 초기값으로 null이 들어간다. 
		Statement stmt = null; // sql문을 전달해서 실행하고 그에 해당하는 결과를 돌려받는 Statement객체
		
		// 앞으로 실행할 sql문 ("완성형태"로 만들어두기)(sql문 끝에, 맨 뒤에 세미콜론 없어야됨!!)
		// Statement객체를 가지고 sql문을 실행할 때 prepared Statement도 존재하는데 
		// Statement객체를 가지고 실행할때는 당장이라도 실행가능한 완성된 insert문을 만들어두어야 한다.
		//String sql = "INSERT INTO TEST VALUES(1, '강개순', SYSDATE)";
		String sql = "INSERT INTO TEST VALUES(" + num + ", '" + name + "', SYSDATE)";
		
		try {
			// 1) jdbc driver 등록
			Class.forName("oracle.jdbc.driver.OracleDriver"); // ojdbc6.jar 파일을 추가안했을경우 | 추가는 했는데 오타가 있을 경우 => ClassNotFoundException발생
			
			// 2) Connection 객체 생성 : DB에 연결(url, 계정명, 비밀번호)
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");  // connection타입의 객체를 돌려받음
			// jdbc:oracle:thin:@localhost:1521:xe => 내 pc에 설치되어있는 DB를 가리킴
			// DriverManager.getConnection() 메소드를 통해서 해당 DB와 접속된 Connection객체가 리턴이 되고 conn이라는 변수에 대입
			
			// 3) Statement 객체 생성
			stmt = conn.createStatement();
			
			// 4,5 ) sql문 전달하면서 실행 후 결과 받기 (돌아오는 결과는 처리된 행수로 돌아옴)
			result = stmt.executeUpdate(sql);
			// 내가 실행할 sql문이 DML문(insert, update, delete)일 경우 => stmt.executeUpdate("DML문") => 결과값으로 반환값 int형
			// 내가 실행할 sql문이 select문일 경우 => stmt.executeQuery("select문") => 결과값으로 조회된 결과문들이 담겨있는 ResultSet 객체가 돌아옴
			
			// 6) 트랜잭션 처리
			if(result > 0) { // 성공했을 경우 commit
				conn.commit();
			} else { // 실패했을 경우 rollback;
				conn.rollback();
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			// 7) 다 쓴 JDBC용 객체 자원반납(생성된 역순으로)
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(result > 0) {
			System.out.println("성공적으로 삽입되었습니다.");
		} else {
			System.out.println("삽입이 실패되었습니다.");
		}
		*/
		
		// 2. 내 PC DB상에 JDBC계정에 TEST테이블에 모든 데이터 조회해보기
		//    select문 => 결과 ResultSet(조회된 데이터들이 감겨있음) 받기 => ResultSet으로부터 데이터 뽑기
		
		// 필요한 변수들 셋팅
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null; // select문으로 실행된 조회될 결과값들이 처음에 실질적으로 담길 객체
		
		// 실행할 sql문
		String sql = "SELCT * FROM TEST";
		
		try {
			
			// 1) jdbc driver 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2) Connection 객체 생성
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			
			// 3) Statment 객체 생성
			stmt = conn.createStatement();
			
			// 4,5) sql문 전달해서 실행 후 결과 받기 (조회된 결과물 : ResultSet 객체)
			rset = stmt.executeQuery(sql);
			// 맨 처음 커서는 1행에 있는 컬럼명을 가르키고 있음
			
			// 6)
			//rset.next() : 커서를 한 행 움직였을 때 행이 있으면 true, 없으면 false 반환해주는 메소드
			while(rset.next()) { // 행 커서 움직여주는 역할, 뿐만 아니라 해당 행이 있으면 true, 없으면 false 반환
				// 현재 참조하는 rset으로부터 어떤 컬럼에 해당하는 값을 어떤 타입으로 뽑을건지 제시해야됨!!
				// db의 컬럼명 제시!! (대소문자를 가리지 않음!)
				int tno = rset.getInt("TNO");
				String tname = rset.getString("tname");
				Date tdate = rset.getDate("TDATE");
				
				System.out.println(tno + ", " + tname + ", " + tdate);
				
			}
			
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		} catch (SQLException e) {
		
			e.printStackTrace();
		} finally {
			try {
				//7) 다 쓴 JDBC용 객체 반납
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		

	}

}
