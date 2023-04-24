package kr.co.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.todo.service.AppService;
import kr.co.todo.vo.TodoVO;

@RestController
public class AppController {

	@Autowired
	private AppService appService;
	
	@GetMapping("todo")
	public List<TodoVO> list() {
		return appService.selectTodos();
	}
	
	@PostMapping("todo")
	public TodoVO todo(@RequestBody TodoVO vo) {
		//log.info("vo : " + vo);
		appService.insertTodo(vo);
		//log.info("no : " + vo.getNo());
		return appService.selectTodo(vo.getNo());
	}
	
	@DeleteMapping("todo/{no}")
	public void deleteTodo(@PathVariable int no) {
		appService.deleteTodo(no);
	}
	
	@DeleteMapping("todo")
	public void clear() {
		appService.deleteTodoAll();
	}
	
}
