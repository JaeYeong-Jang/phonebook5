package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class PhoneDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//전체 리스트 가져오기
	public List<PersonVo> getPersonList() {
		
		List<PersonVo>personList = sqlSession.selectList("phonebook.selectList");
		System.out.println("DAO");
		System.out.println(personList);
		
		return personList;
	}
	
	public int personInsert(PersonVo personVo) {
		
		System.out.println(personVo);
		
		sqlSession.insert("phonebook.personInsert",personVo);
		
		return 1;
	}
	
}
