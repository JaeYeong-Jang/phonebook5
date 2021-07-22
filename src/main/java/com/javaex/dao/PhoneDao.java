package com.javaex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.javaex.vo.PersonVo;

public class PhoneDao {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "phonedb";
	private String pw = "phonedb";

	// 데이터베이스 연결
	private void getconnection() {
		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName(driver);
			// 2. Connection 얻어오기
			conn = DriverManager.getConnection(url, id, pw);
			// 3. SQL문 준비 / 바인딩 / 실행

			// 4.결과처리

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

	}

	// 자원 정리
	private void Close() {

		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

	}

	// Delete
	public int personDelete(int personId) {

		int count = 0;

		this.getconnection();

		try {
			// 3. SQL문 준비 / 바인딩 / 실행
			String query = "";

			query += "delete from phonebook ";
			query += "where person_id = ? ";

			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, personId);

			count = pstmt.executeUpdate();

			// 4.결과처리

			System.out.println(count + "건 삭제되었습니다.");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.Close();

		return count;
	}

	// Insert
	public int personInsert(PersonVo personVo) {

		int count = 0;

		this.getconnection();

		try {
			// 3. SQL문 준비 / 바인딩 / 실행
			String query = "";

			query += "insert into phonebook ";
			query += "values (seq_person_id.nextval, ?, ?, ?)";

			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, personVo.getName());
			pstmt.setString(2, personVo.getHp());
			pstmt.setString(3, personVo.getCompany());

			count = pstmt.executeUpdate();

			// 4.결과처리

			System.out.println(count + "건 등록되었습니다.");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.Close();

		return count;
	}

	// Update
	public int personUpdate(PersonVo personVo) {
		int count = 0;

		this.getconnection();

		try {
			// 3. SQL문 준비 / 바인딩 / 실행
			String query = "";

			query += "update phonebook ";
			query += "set name = ?, ";
			query += "    hp = ?, ";
			query += "    company = ? ";
			query += "where person_id = ?";

			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, personVo.getName());
			pstmt.setString(2, personVo.getHp());
			pstmt.setString(3, personVo.getCompany());
			pstmt.setLong(4, personVo.getPersonId());

			count = pstmt.executeUpdate();

			// 4.결과처리

			System.out.println(count + "건 수정되었습니다.");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.Close();

		return count;
	}

	// List
	public List<PersonVo> getPersonList() {

		List<PersonVo> personList = new ArrayList<PersonVo>();

		this.getconnection();

		try {
			// 3. SQL문 준비 / 바인딩 / 실행
			String query = "";

			query += "select person_id, ";
			query += "       name, ";
			query += "       hp, ";
			query += "       company ";
			query += "from phonebook ";
			query += "order by person_id asc ";

			pstmt = conn.prepareStatement(query);

			rs = pstmt.executeQuery();

			// 4.결과처리
			while (rs.next()) {
				int personId = rs.getInt("person_id");
				String name = rs.getString("name");
				String hp = rs.getString("hp");
				String company = rs.getString("company");

				PersonVo personVo = new PersonVo(personId, name, hp, company);

				personList.add(personVo);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.Close();

		return personList;

	}

	public PersonVo getPerson(int personId) {
		
		PersonVo personVo = null;
		
		this.getconnection();

		try {
			// 3. SQL문 준비 / 바인딩 / 실행
			String query = "";

			query += "select person_id, ";
			query += "	     name, ";
			query += "		 hp, ";
			query += "	     company ";
			query += "from phonebook ";
			query += "where person_id =? ";

			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, personId );
			
			rs = pstmt.executeQuery();
			
			
			
			// 4.결과처리
			
			while(rs.next()) {
				
				int pid = rs.getInt("person_id");
				String name= rs.getString("name");
				String hp = rs.getString("hp");
				String company = rs.getString("company");
				
				personVo = new PersonVo(pid,name,hp,company);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.Close();
		
		return personVo;
		
	}

}
