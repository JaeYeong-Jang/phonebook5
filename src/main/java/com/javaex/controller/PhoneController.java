package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

@Controller
public class PhoneController {

	// fields
	@Autowired
	private PhoneDao phoneDao;
	// constructors

	// g/s

	// method

	// 리스트
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		System.out.println("[PhoneController.list]");
		
		//Dao사용
		//PhoneDao phoneDao = new PhoneDao();
		
		//Dao의 메소드로 데이터 가져오기
		List<PersonVo> personList = phoneDao.getPersonList();
		
		//Model에 담기(택배박스에 담기) --> DispatcherServlet에 전달된다. --> request의 attribute 영역에 넣는다.
		model.addAttribute("personList",personList);
		

		return "/WEB-INF/views/list.jsp"; // --> DispatcherServlet 야 (/WEB-INF/views/list.jsp) 에 포워드 해줘잉
	}

	// 쓰기폼
	@RequestMapping(value = "/writeForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String writeForm() {
		System.out.println("[PhoneController.writeForm]");

		return "/WEB-INF/views/writeForm.jsp"; // --> DispatcherServlet 야 (/WEB-INF/views/writeForm.jsp) 에 포워드 해줘잉

	}
	
	// @ModelAttribute 일 때 // 쓰기
	@RequestMapping(value="/write",method={RequestMethod.GET,RequestMethod.POST})
	public String write(@ModelAttribute PersonVo personVo) {
		System.out.println("[PhoneController.write]");

		// @ModelAttribute --> new PersonVo() // --> 기본생성자 + setter 로 값 대입

		System.out.println(personVo);
		
		//Dao사용
		//PhoneDao phoneDao = new PhoneDao();
		//Dao의 personInsert() 이용해서 데이터 저장
		phoneDao.personInsert(personVo);
		
		return "redirect:/list";

	}
	
	//PathVariable 테스트
	@RequestMapping(value="/board/read/{no}", method = {RequestMethod.GET, RequestMethod.POST})
	public String read(@PathVariable("no") int boardNo) {
		System.out.println("PathVariable[read]");
		
		//localhost:8088/phonebook5/board/read/1
		//localhost:8088/phonebook5/board/read/2
		//localhost:8088/phonebook5/board/read/100 --> 이렇게 표현 가능
		
		System.out.println(boardNo);
		
		return "";
	}
	
	//삭제
	@RequestMapping(value="/delete", method = {RequestMethod.GET, RequestMethod.POST})
	public String delete(@RequestParam("personId")int personId) {
		System.out.println("[PhoneController.delete]");
		
		PhoneDao phoneDao = new PhoneDao();
		//phoneDao.personDelete(personId);
		
		return "redirect:/list";
	}
	//수정폼
	@RequestMapping(value="updateForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String updateForm(Model model,@RequestParam("personId")int personId) {
		System.out.println("[PhoneController.updateForm]");
		
		PhoneDao phoneDao = new PhoneDao();
		//PersonVo personVo = phoneDao.getPerson(personId);
		
		//model.addAttribute("personVo",personVo);
		
		return "/WEB-INF/views/updateForm.jsp";
	}
	//수정
	@RequestMapping(value="update", method = {RequestMethod.GET, RequestMethod.POST})
	public String update(@ModelAttribute PersonVo personVo) {
		System.out.println("[PhoneController.update]");
		
		PhoneDao phoneDao = new PhoneDao();
		//phoneDao.personUpdate(personVo);
		
		return "redirect:/list";
		
	}
	
	

	@RequestMapping(value = "/test")
	public String test() {
		System.out.println("test");

		return "/WEB-INF/views/test.jsp"; // --> DispatcherServlet 야 (/WEB-INF/views/test.jsp) 에 포워드 해줘잉
	}

}
