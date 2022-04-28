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

			String sql = "select no, title, writer, writeDate, hit from board";
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
}//end of Class
	
