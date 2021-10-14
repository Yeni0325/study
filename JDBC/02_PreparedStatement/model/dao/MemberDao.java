package com.kh.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.model.vo.Member;

// DAO (Data Access Object) : DB에 직접적으로 접근해서 사용자의 요청에 맞는 sql문 실행 후 결과받기(JDBC)
//                            결과를 Controller로 다시 리턴
public class MemberDao {
	
	/*
	 * * Statement와 PreparedStatement의 특징
	 * - 둘 다 sql문을 실행하고 결과를 받아내는 객체는 동일
	 * - Statement가 PreparedStatement의 부모 (상속구조)
	 * 
	 * * Statement와 PreparedStatement의 차이점
	 * - Statement 같은 경우 sql문을 바로 전달하면서 실행시키는 객체 
	 *   (즉, sql문을 완성형태로 만들어 둬야됨!! == 사용자가 입력한값이 다 채워진형태로!!)
	 * 	
	 * 		> 기존의 Statement 방식
	 * 		1) Connection 객체를 통해 Statement 객체 생성 :     stmt = conn.createStatement();
	 * 		2) Statement 객체를 통해 "완성된 sql문" 실행 및 결과받기 : 결과 = stmt.executeXXX(완성된sql);
	 * 														 DML - executeUpdate();
	 * 													  SELECT - executequery();
	 * 
	 * 
	 * - PreparedStatement 같은 경우 "미완성된 sql문"을 잠시 보관해둘 수 있는 객체 
	 *   (즉, 사용자가 입력한 값들을 채워두지 않고 각각 들어갈 공간 확보만 미리 해놔야됨!!)
	 *   단, 해당 sql문을 본격적으로 실행하기 전에는 빈 공간을 사용자가 입력한 값으로 채워서 실행하긴 해야됨
	 *   	
	 *   	> PreparedStatement 방식
	 *		1) Connection 객체를 통해 PreparedStatement 객체 생성 :   pstmt = conn.preparedStatement([미완성된]sql문);   
	 *		2) pstmt에 담긴 sql문이 미완성된 상태일 경우 우선은 완성시켜야됨 :    pstmt.setXXX(1, "대체할값");
	 *                                                        pstmt.setXXX(2, "대체할값");
	 *     													  ...
	 *      3) 해당 완성된 sql문 실행 및 결과받기                                             :   결과 = pstmt.executeXXX();  
	 *   													       DML - executeUpdate();
	 *                                                          SELECT - executequery();
	 *        기존 Statement는 executeXXX();안에 sql문을 넣었지만  PreparedStatement는 이미 preparedStatement에 sql문이 담겨있기 떄문에 실행만 해주면 된다!                                              
	 */
	
	/**
	 * 1. 
	 * @param m
	 * @return
	 */
	public int insertMember(Member m) {
		// insert문 => 결과값으로 처리된 행수가 돌아옴 => 트랜잭션 처리
		
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		// 실행할 sql문 (미완성된 형태로 둘 수 있음) - PreparedStatement이기 때문에
		// INSERT INTO MEMBER VALUES(SEQ_USERNO.NEXTVAL, 'XXX', 'XXXX', 'XXX', 'XXX', 'XXXX', 'XX', 'XXX', 'XXXX', 'XXX', SYSDATE);
		// 미리 사용자가 입력한값들이 들어갈 수 있게 공간 확보 (? == 홀더)만 해두면됨!
		String sql = "INSERT INTO MEMBER VALUES(SEQ_USERNO.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";
		
		try {
			// 1) jdbc driver등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2) Connection 객체 생성
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			
			// 3) PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql); // 애초에 PreparedStatment 객체 생성시 sql문을 담은채로 생성! (하필 미완성된 sql문)
			
			// > 빈 공간을 실제값(사용자가 입력한값)으로 채워준 후 실행
			// pstmt.setString(홀더순번, 대체할값);        =>  '대체할값'  (양 옆에 홑따옴표 감싸준 상태로 알아서 들어감)
			// pstmt.setInt(홀더순번, 대체할값);           =>   대체할값
			
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getGender());
			pstmt.setInt(5, m.getAge());
			pstmt.setString(6, m.getEmail());
			pstmt.setString(7, m.getPhone());
			pstmt.setString(8, m.getAddress());
			pstmt.setString(9, m.getHobby());
		
			
			// 4, 5) sql문 실행 및 결과받기
			result = pstmt.executeUpdate();
			
			// 6) 트랜잭션 처리
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
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	
	/**
	 * 2. 
	 * @return
	 */
	public ArrayList<Member> selectList() {
		// SELECT문 => 결과값으로 여러행조회 => 조회된 결과들이 ResultSet에 담겨돌아옴 => ArrayList<Member> list 객체에 담기
		
		ArrayList<Member> list = new ArrayList<>(); // 텅 빈 리스트
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM MEMBER"; // 애초에 완성된 sql문이어도 PreparedStatement 객체 사용 가능
		
		try {
			// 1)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2)
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			
			// 3)
			pstmt = conn.prepareStatement(sql); // 현재 담은 sql문이 애초에 완성된 sql문임! => 곧바로 실행
			
			// 4,5) 
			rset = pstmt.executeQuery();
		
			// 6)
			while(rset.next()) {
				// 현재 rest이 참조하고 있는 해당 행의 모든 컬럼값 뽑아서 => 하나의 Member객체에 담기 => 
				// 여러행 조회 시 , 여러개의 Member객체 생성 => 리스트에 차곡차곡 추가
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
			
			// 7)
			try {
				rset.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return list;
	}
	
	
	/**
	 * 3.
	 * @param userId
	 * @return
	 */
	public Member selectByUserId(String userId){
		// SELECT문 -> 한 행 조회 -> ResultSet객체 -> Member m 객체에 담기
		
		Member m = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		//실행할 sql문
		// SELECT * FROM MEMBER WHERE USERNAME = ?;
		String sql = "SELECT * FROM MEMBER WHERE USERID = ?";
		
		try {
			
			// 1)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2)
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
		
			// 3)
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			
			// 4,5)
			rset = pstmt.executeQuery();
			
			// 6)
			if(rset.next()) {
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
			
			// 위의 조건문이 다 끝난 시점에
			// 검색되는것이 없다면 m은 null상태
			// 검색되는것이 있으면 m은 생성된 객체
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			// 7)
			try {
				rset.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		
		return m;
		
		
	}
	
	
	/**
	 * 4.
	 * @param keyword
	 * @return
	 */
	public ArrayList<Member> selectByUserName(String keyword) {
		// select문 => 결과값으로 여러행 검색 => ResultSet객체 => ArrayList<Member> list에 담기
		
		// 변수 셋팅
		ArrayList<Member> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		// 실행할 sql문
		// String sql = "SELECT * FROM MEMBER WHERE USERNAME LIKE '%?%'";
		// 위의 sql문 제시 후 pstmt.setString(1, "강");	=> '강'
		// 이 때 완성될 sql문 : SELECT * FROM MEMBER WHERE USERNAME LIKE '%'강'%'
		
		// 해결방법1
		// String sql = "SELECT * FROM MEMBER WHERE USERNAME LIKE '%' || ? || '%'";
		
		// 해결방법2
		String sql = "SELECT * FROM MEMBER WHERE USERNAME LIKE ?";
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			pstmt = conn.prepareStatement(sql);
			
			// 해결방법1의 SQL문일 경우
			// pstmt.setString(1, keyword); // SELECT * FROM MEMBER WHERE USERNAME LIKE '%' || '강' || '%'
			
			// 해결방법2의 SQL문일경우
			pstmt.setString(1, "%" + keyword + "%"); //SELECT * FROM MEMBER WHERE USERNAME LIKE '%강%'
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
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
				rset.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
		
	}
	
	
	/**
	 * 5.
	 * @param m
	 * @return
	 */
	public int updateMember(Member m) {
		
		// update => 처리된 행수를 int로 
		
		// 필요한 변수 설정
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		// sql문
		// UPDATE MEMBER SET USERPWD = ?, EMAIL = ?,PHONE = ?, ADDRESS = ? WHERE USERID = ?;
		String sql = "UPDATE MEMBER SET USERPWD = ?, EMAIL = ?,PHONE = ?, ADDRESS = ? WHERE USERID = ?";
		
		try {
			// 1)
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
			// 2)
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
		
			// 3)
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getUserPwd());
			pstmt.setString(2, m.getEmail());
			pstmt.setString(3, m.getPhone());
			pstmt.setString(4, m.getAddress());
			pstmt.setString(5, m.getUserId());
			
			// 4,5)
			result = pstmt.executeUpdate();
			
			// 6)
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
			
			// 7)
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
		return result;
	}
	
	
	/**
	 * 6.
	 * @param userId
	 * @return
	 */
	public int deleteMember(String userId) {
		// delete문 => 처리된 행수가 int값으로 돌아옴
		
		// 변수 셋팅
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		// sql문
		// DELETE FROM MEMBER WHERE USERID = ?;
		String sql = "DELETE FROM MEMBER WHERE USERID = ?";
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
		
			result = pstmt.executeUpdate();
			
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
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
		
	}
	
	
}
