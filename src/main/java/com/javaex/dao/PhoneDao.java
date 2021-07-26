package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class PhoneDao {

	@Autowired
	private SqlSession sqlSession;

	// 전체 리스트 가져오기
	public List<PersonVo> getPersonList() {

		List<PersonVo> personList = sqlSession.selectList("phonebook.selectList");
		System.out.println("DAO");
		System.out.println(personList);

		return personList;
	}

	public int personInsert(PersonVo personVo) {

		System.out.println(personVo);

		sqlSession.insert("phonebook.personInsert", personVo);

		return 1;
	}

	// 쓰기2 예
	public int personInsert2(String name, String hp, String company) {
		System.out.println("[PhoneDao.personInsert2]");

		// Map을 사용해서 파라미터들을 하나로 묶는다.
		Map<String, Object> personMap = new HashMap<String, Object>();
		personMap.put("name", name);
		personMap.put("hp", hp);
		personMap.put("company", company);

		System.out.println(personMap);
		int count = sqlSession.insert("phonebook.personInsert2", personMap);

		System.out.println("dao.personInsert2 결과 : " + count);

		return count;

	}

	public void personDelete(int personId) {

		System.out.println(personId);

		sqlSession.delete("phonebook.personDelete", personId);

	}

	public PersonVo getPerson(int personId) {

		PersonVo personVo = sqlSession.selectOne("phonebook.selectPerson", personId);

		System.out.println(personVo);

		return personVo;
	}
	
	//수정폼2 전화번호 가져오기
	public Map<String, Object> getPerson2(int personId) {
		
		System.out.println("[PhoneDao.getPerson2]");
		
		Map<String, Object> personMap = sqlSession.selectOne("phonebook.selectPerson2", personId);
		System.out.println(personMap);
		
		return personMap;
	}

	public void personUpdate(PersonVo personVo) {

		sqlSession.update("phonebook.personUpdate", personVo);

	}

}
