package com.gagoo.faq.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gagoo.faq.vo.FaqVO;

public class FaqDAO {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";

	String uid = "java00";
	String upw = "java00";

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public List<FaqVO> list() throws Exception {

		List<FaqVO> list = null;

		try {
			// 외부 연결 예외 처리
			Class.forName(driver);
			System.out.println("드라이버 연결완료");

			con = DriverManager.getConnection(url, uid, upw);
			System.out.println("db연결");

			String sql = "select no, title, writer, writeDate, hit from board ORDER BY no DESC";
			System.out.println("sql 실행 쿼리");

			pstmt = con.prepareStatement(sql);
			System.out.println("실행 객체 생성 완료");

			rs = pstmt.executeQuery();
			System.out.println("db쿼리 실행 완료");

			if (rs != null) {

				while (rs.next()) {

					if (list == null) {
						list = new ArrayList<FaqVO>();
					}
					FaqVO vo = new FaqVO();

					vo.setNo(rs.getLong("no"));
					vo.setTitle(rs.getString("title"));
					vo.setWriter(rs.getString("writer"));
					vo.setWriteDate(rs.getString("writeDate"));
					vo.setHit(rs.getLong("hit"));

					list.add(vo);
				}//end of while
			}//end of if
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

			throw new Exception("게시판 리스트 데이터를 가져오는 중 오류 발생." + e.getMessage());
		}finally {
			try {
			
			if(con != null) con.close();
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
		
			}catch (Exception e) {
				// TODO: handle exception
				throw new Exception("게시판 리스트 데이터 처리 객체 받는 중 오류 발생" + e.getMessage());
			}
		}
		System.out.println("리스트 데이터 확인 : " + list);
			return list;
		
	}
	
	
	//글 보기
	// 번호 입력하면 글 1개 나옴 
	//
	public FaqVO view(long no) throws Exception {
		
		FaqVO vo = null; 
		try {
		Class.forName(driver);
		
		con = DriverManager.getConnection(url, uid, upw);
		
		String sql = "SELECT no, title, content, writer, writeDate, hit FROM board WHERE no = ?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setLong(1, no);
		
		rs = pstmt.executeQuery();
		
		System.out.println("출력완료");
		
		if(rs != null && rs.next()) {
			vo = new FaqVO();
			vo.setNo(rs.getLong("no"));
			vo.setTitle(rs.getString("title"));
			vo.setContent(rs.getString("content"));
			vo.setWriter(rs.getString("writer"));
			vo.setWriteDate(rs.getString("writeDate"));
			vo.setHit(rs.getLong("hit"));
			
		}
		
		}catch (Exception e) {
		
			e.printStackTrace();
			
			throw new Exception("글 보기 db 연결중 에러발생" +e.getMessage());
			// TODO: handle exception
		}finally {
			
		
			try {
				if(con != null)con.close();
				if(pstmt != null)pstmt.close();
				if(rs != null)rs.close();
				
				
			} catch (Exception e) {
				// TODO: handle exception

				throw new Exception("글 보기 리소스 닫는중 에러발생" +e.getMessage());
			}
		
		}
		
		System.out.println(vo);
		return vo;
	}

	//글쓰기
	//no, title, content, writer
	//출력은 글보기에서 하니 입력이 되었는지만 확인
	//입력 결과 숫자로 출력
	public Integer write(FaqVO vo) throws Exception {
		Integer result = 0;
		try {
			Class.forName(driver);

			con = DriverManager.getConnection(url, uid, upw);

			String sql = "INSERT INTO board(no, title, content, writer) VALUES (board_seq.NEXTVAL, ?, ?, ?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getWriter());

			result = pstmt.executeUpdate();

			System.out.println("db 등록 완료");

		} catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();

			throw new Exception("글쓰기 db 처리중 에러발생" + e.getMessage());

		} finally {

			try {
				if (con != null)
					con.close();
				if (pstmt != null)
					pstmt.close();

			} catch (Exception e) {
				// TODO: handle exception
				throw new Exception("글쓰기 리소스 닫는중 에러발생" + e.getMessage());
			}
		}
		System.out.println(result);
		return result;
	}


	//자바 의 수정된 vo 값이 들어올예정
	// 어떤 글번호에 넣는지 - no 
	// title, content, writer, 
	public Integer update(FaqVO vo) throws Exception {

		Integer result = 0;

		try {
			
			Class.forName(driver);
			
			con = DriverManager.getConnection(url, uid, upw);
			
			String sql = "UPDATE board SET title = ?, content = ?, writer = ? WHERE no = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getWriter());
			pstmt.setLong(4, vo.getNo());

			result = pstmt.executeUpdate();
			
			if(result >= 1) {
				System.out.println("수정 DB 처리 완료");
			}else {
				System.out.println("수정 DB 처리가 되지 않았습니다. 글번호를 확인해 주세요");
			}
		}

		catch (Exception e) {
			// TODO: handle exception

			throw new Exception("FAQ 수정 db 처리중 에러발생 " + e.getMessage());
		
		} finally {

			try {

				if (con != null)con.close();
				if (pstmt != null) pstmt.close();
				
			} catch (Exception e) {
				// TODO: handle exception
				
				throw new Exception("FAQ 수정 리소스 닫는중 에러발생 " + e.getMessage());
			}

		}

		return result;
	}

	
	public Integer delete(long no) throws Exception {
		
		Integer result = 0;
		
		try {
			
			Class.forName(driver);
			
			con = DriverManager.getConnection(url, uid, upw);
			
			String sql = "DELETE FROM board WHERE no = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, no);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			
			throw new Exception("삭제 db 처리중 예외 발생" + e.getMessage());

		}finally {
			
			try {
				
				if (con != null)con.close();
				if (pstmt != null)con.close();
				
			} catch (Exception e) {
				throw new Exception("삭제 db 리소스 닫는중 예외 발생" + e.getMessage());
				// TODO: handle exception
			}
		}
		
		return result;
	}
	
	
}// end of Class
