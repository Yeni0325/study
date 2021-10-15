package com.kh.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.kh.common.JDBCTemplate.*;
import com.kh.model.vo.Member;

// DAO (Data Access Object) : DB에 직접적으로 접근해서 사용자의 요청에 맞는 sql문 실행 후 결과받기(JDBC)
//                            결과를 Controller로 다시 리턴
public class MemberDao {
	
	
	public int insertMember(Connection conn, Member m) {
		// insert문 => 처리된 행수 => 트랜잭션 처리
		
		// 필요한 변수들 셋팅
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO MEMBER VALUES(SEQ_USERNO.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";
		
		try {
			// 3) PreparedStatement 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getGender());
			pstmt.setInt(5, m.getAge());
			pstmt.setString(6, m.getEmail());
			pstmt.setString(7, m.getPhone());
			pstmt.setString(8, m.getAddress());
			pstmt.setString(9, m.getHobby());
					
			// 4,5) sql문 실행 및 결과받기
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			/*JDBCTemplate.*/close(pstmt);
			// conn은 아직 반납하면 안됨!!
		}
		
		return result;
		
	}
	
	public ArrayList<Member> selectList(Connection conn) {
		// select문 => 여러행조회되고 결과값으로 ResultSet객체 생성 => 여러개의 Member m객체  생성=> ArrayList<Member>
		ArrayList<Member>list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "SELECT * FROM MEMBER ORDER BY USERNAME";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				// 한 행 => Member 객체 => list 추가
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
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	
	public Member selectByUserId(Connection conn, String userId) {
		// select문 => 한 행 조회 => ResultSet객체 생성 => Member m객체에 담기
		
		// 필요한 변수 셋팅
		Member m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM MEMBER WHERE USERID = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
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
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return m;
		
	}
	
	
	public ArrayList<Member> selectByUserName(Connection conn, String keyword) {
		// SELECT => 여러행 검색 ResultSet => 여러행을 Member m객체에 담고 생성된 여러개의 Member객체를 ArrayList에 담기
		
		// 필요한 변수 셋팅
		ArrayList<Member> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "SELECT * FROM MEMBER WHERE USERNAME LIKE ?"; // '%?%'
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
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
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
		
	}
	
	
	public int updateMember(Connection conn, Member m) {
		// update => 처리된 행수 => 트랜잭션 처리
		
		// 필요한 변수 셋팅
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "UPDATE MEMBER SET USERPWD = ?, EMAIL = ?, PHONE = ?, ADDRESS =? WHERE USERID = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getUserPwd());
			pstmt.setString(2, m.getEmail());
			pstmt.setString(3, m.getPhone());
			pstmt.setString(4, m.getAddress());
			pstmt.setString(5, m.getUserId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			
		}
		
		return result;
	}
	
	
	
	
	
	
	public int deleteMember(Connection conn, String userId) {
		// delect문 => 처리된 행수 => 트랜잭션 처리
		
		// 필요한 변수들 셋팅
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM MEMBER WHERE USERID = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
