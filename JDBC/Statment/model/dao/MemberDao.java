package com.kh.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kh.model.vo.Member;

// DAO (Data Access Object) : DB에 직접적으로 접근해서 사용자의 요청에 맞는 sql문 실행 후 결과받기(JDBC)
//                            결과를 Controller로 다시 리턴
public class MemberDao {
	
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
	
	
	/**
	 * 사용자가 입력한 정보들을 추가시켜주는 메소드
	 * @param m  : 사용자가 입력한 값들이 주섬주섬 담겨있는 Member 객체
	 * @return   : insert문 실행 후 처리된 행 수 
	 */
	public int insertMember(Member m) { 
		// insert문 => 처리된 행수(int) => 트랜잭션 처리
		
		// 필요한 변수들 먼저 셋팅
		int result = 0; // 처리된 결과(처리된 행수)를 받아줄 변수
		Connection conn = null; // 연결된 DB의 연결정보를 담는 객체
		Statement stmt = null;  // "완성된 sql문(실제값이 다 채워진 상태로)" 을 전달해서 곧바로 실행 후 결과를 받는 객체 
		// prepared Statement와 Statement의 차이 : 전달되는 sql문의 완성유무 차이
		
		// 실행할 sql문 (완성된 형태로 만들어두기!!)
		// INSERT INTO MEMBER VALUES(SEQ_USERNO.NEXTVAL, 'XXX', 'XXXX', 'XXX', 'XXX', 'XXXX', 'XX', 'XXX', 'XXXX', 'XXX', SYSDATE);
		String sql = "INSERT INTO MEMBER VALUES(SEQ_USERNO.NEXTVAL, "
									+ "'" + m.getUserId()   + "', "
									+ "'" + m.getUserPwd()  + "', "
									+ "'" + m.getUserName() + "', "
									+ "'" + m.getGender()   + "', "
									      + m.getAge()      + ", "
									+ "'" + m.getEmail()    + "', "
									+ "'" + m.getPhone()    + "', "
									+ "'" + m.getAddress()  + "', "
									+ "'" + m.getHobby()    + "', SYSDATE)"; 
		
 		//System.out.println(sql);							
		
		
		try {
			// 1) jdbc driver 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2) Connection 객체 생성 == DB에 연결 (url, 계정명, 비밀번호)
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			
			// 3) Statement 객체 생성
			stmt = conn.createStatement();
			
			// 4, 5) sql문을 전달하면서 실행 후 결과(처리된 행수 : int)받기
			result = stmt.executeUpdate(sql);
			
			// 6) 트랜잭션 처리 
			if(result > 0) { // 성공 => commit
				conn.commit();
				
			} else { // 실패 => rollback
				conn.rollback();
				
			}
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			
			try {
				// 7) 다 쓴 JDBC용 객체 반납
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		
		return result; // 1아니면 0
	}
	
	
	/**
	 * 2. 사용자가 요청한 회원 전체 조회를 처리해주는 메소드
	 * @return : 조회된 결과가 있었으면 조회된 결과들이 담겨있는 list | 조회된 결과가 없었으면 텅 빈 list 반환
	 */
	public ArrayList<Member> selectList() {
		// select문(여러행조회) => 조회된 결과물이 ResultSet객체에 담겨있음 => ArrayList에 차곡차곡 담기
 		
		//필요한 변수들 셋팅
		ArrayList<Member> list = new ArrayList<>(); // 현재 상태는 텅 비어있는 상태
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null; // select문 실행 시 조회된 결과값들이 최초로 담기는 객체
		
		// 실행할 sql문
		String sql = "SELECT * FROM MEMBER";
		
		try {
			// 1) jdbc driver 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2) Connection 등록
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			
			// 3) Statement 등록
			stmt = conn.createStatement();
			
			// 4,5) sql문 실행 및 결과받기(ResultSet)받기
			rset = stmt.executeQuery(sql);
			
			// 6) ResultSet으로부터 데이터 하나씩 뽑아서 vo 객체에 주섬주섬 담고 + list에 vo객체 추가
			while(rset.next()) {
				
				// 현재 rset의 커서가 가리키고 있는 한 행의 데이터들을 싹 다 뽑아서 Member 객체에 담기
				Member m = new Member();
				
				m.setUserNo(rset.getInt("USERNO"));
				m.setUserId(rset.getString("USERID"));
				m.setUserPwd(rset.getString("userpwd")); // db에서의 컬럼명은 대소문자 중요하지 않음
				m.setUserName(rset.getString("username"));
				m.setGender(rset.getString("gender"));
				m.setAge(rset.getInt("age"));
				m.setEmail(rset.getString("email"));
				m.setPhone(rset.getString("phone"));
				m.setAddress(rset.getString("address"));
				m.setHobby(rset.getString("hobby"));
				m.setEnrollDate(rset.getDate("emrolldate"));
				// 현재 참고하고 있는 행에 대한 모든 컬럼에 대한 데이터들을 한 Member 객체에 담기 끝!
				
				list.add(m); // 리스트에 해당 회원 객체 차곡차곡 담기
				
			}
			
			// 반복문이 다 끝난 시점에
			// 만약에 조회된 데이터가 없었다면 list가 텅 빈 상태!
			// 만약에 조회된 데이터가 있었다면 list에 뭐라도 담겨있을것!
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			
			try {
				// 7) 다 쓴 자원반납
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		return list; // 텅빈리스트 | 뭐라도 담겨있는 리스트
		
		
	}
	
	
	/**
	 * 3. 사용자의 아이디로 회원 검색 요청을 처리해주는 메소드
	 * @param userId : 사용자가 입력한 검색하고자하느 회원 아이디값
	 * @return : 검색된 결과가 있었으면 생성된 Member객체 | 검색된 결과가 없었으면 null
	 */
	public Member selectByUserId(String userId) {
		// select문(무조건 한행만 조회) : 검색한 아이디가 하나 나오기 때문
		// 조회된 한 행은 Member객체에 담을 수 있음
		// select(한행) => ResultSet객체 => Member 객체
		
		Member m = null;
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		// 실행할 sql문 (완성된 형태로)
		// SELECT * FROM MEMBER WHERE USERID = 'XXX';
		String sql = "SELECT * FROM MEMBER WHERE USERID = '" + userId + "'";
		
	
		try {
			// 1) jdbc.driver 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
			// 2) Connection 등록
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC"); 
		
			// 3) Statement 등록
			stmt = conn.createStatement();
			
			// 4,5) sql문 실행 및 결과받기(ResultSet)받기
			rset = stmt.executeQuery(sql);
			
			// 6) ResultSet으로부터 조회결과를 뽑아서 Member객체에 담기
			
			if(rset.next()) {
				//조회됐다면 해당 조회된 컬럼 값들을 쏙쏙 뽑아서 한 Member 객체의 각 필드에 담기
				m = new Member(rset.getInt("userno"), 
						       rset.getString("userid"),
						       rset.getString("userpwd"),
						       rset.getString("username"),
						       rset.getString("gender"),
						       rset.getInt("age"),
						       rset.getString("email"),
						       rset.getString("phone"),
						       rset.getString("address"),
						       rset.getString("hobby"),
						       rset.getDate("emrolldate"));
			}
			
			// 위의 조건문 다 끝난 시점에
			// 만약에 조회된 데이터가 없었을 경우 => m은 null 상태
			// 만약에 조회된 데이터가 있었을 경우 => m은 생성된 객체
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			
			try {
				// 7) 다 쓴 자원반납
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		return m;
	}
	
	
	public ArrayList<Member> selectByUserName(String keyword) {
		// select문(여러행조회) => 조회된 결과물이 ResultSet객체에 담겨있음 => ArrayList에 차곡차곡 담기
		
		ArrayList<Member> list = new ArrayList<>();  // 텅 빈 리스트
		
		// 필요한 변수들 셋팅
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null; // select문 실행 시 조회된 결과값들이 최초로 담기는 객체
		
		// 실행할 sql문
		// SELECT * FROM MEMBER WHERE USERNAME LIKE '%XXX%';
		String sql = "SELECT * FROM MEMBER WHERE USERNAME LIKE '%" + keyword + "%'";
		
		try {
			// 1) jdbc driver 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2) Connection 등록
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			
			// 3) Statement 등록
			stmt = conn.createStatement();
			
			// 4,5) sql문 실행 및 결과받기(ResultSet)받기
			rset = stmt.executeQuery(sql);
					
			// 6) ResultSet으로부터 데이터 하나씩 뽑아서 vo 객체에 주섬주섬 담고 + list에 vo객체 추가
			
			while(rset.next()) {
				// 현재 rset이 참조하고 있는 한 행 데이터들을 뽑아서 => 한 Member객체에 주섬주섬.. => list에 차곡차곡 추가
				list.add(new Member(rset.getInt("userno"),
						            rset.getString("userid"),
						            rset.getString("userpwd"),
						            rset.getString("username"),
						            rset.getString("gender"),
						            rset.getInt("age"),
						            rset.getString("email"),
						            rset.getString("phone"),
						            rset.getString("address"),
						            rset.getString("hobby"),
						            rset.getDate("emrolldate")));
				
				
				
			}
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			
			try {
				
				// 7) 다 쓴 객체 반납
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		return list; // 텅 빈 리스트 | 뭐라도 담겨있는 리스트
	}
	
	
	
	public int updateMember(Member m) {
		// update문 => 처리된 행수가 돌아옴 (int) => 트랜잭션 처리 
		int result = 0;
		
		Connection conn = null;
		Statement stmt = null;
		
		// 실행할 sql문 (완성된 형태)
		/*
		 * UPDATE MEMBER 
   			  SET USERPWD = 'XXXX'      
                , EMAIL = 'XXXXXXX'
                , PHONE = 'XXXXXXXXXXX'
                , ADDRESS = 'XXXXXX'
             WHERE USERID = 'XXXX';
		 */
		String sql = "UPDATE MEMBER " 
		           +  "SET USERPWD = '" + m.getUserPwd() + "' "
		           +      ", EMAIL = '" + m.getEmail()   + "' "
		           +      ", PHONE = '" + m.getPhone()   + "' "
		           +    ", ADDRESS = '" + m.getAddress() + "' "
		           + "WHERE USERID = '" + m.getUserId()  + "'";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","JDBC","JDBC");
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
			
			if(result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
		
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		           
		return result;
	}
	
	
	/**
	 * 6. 사용자가 입력한 아이디값을 전달 받아서 회원 탈퇴 시켜주는 케소드
	 * @param userId : 사용자가 입력한 아이디값
	 * @return : delete문 실행 후 처리된 행 수 반환
	 */
	public int deleteMember(String userId) {
		/* DELETE FROM MEMBER WHERE USERID = '사용자가입력한아이디값' */
		// DELETE문 => 결과값으로 처리된 행수 돌려받음 => 트랜잭션 처리 
		
		int result = 0;
		Connection conn = null;
		Statement stmt = null;
		
		String sql = "DELETE FROM MEMBER WHERE USERID = '" + userId + "'";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);  // sql문 실행하는 코드로, 결과값인 처리된 행수가 result에 담겨있음
			
			if(result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
		
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
		
				e.printStackTrace();
			}
		}
		
		return result;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
