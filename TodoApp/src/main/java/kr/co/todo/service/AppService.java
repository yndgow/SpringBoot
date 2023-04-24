package kr.co.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.todo.dao.AppDAO;
import kr.co.todo.vo.TodoVO;

@Service
public class AppService {
	
	@Autowired
	private AppDAO appDAO;

	public void insertTodo(TodoVO vo) {
		appDAO.insertTodo(vo);
	};
	public TodoVO selectTodo(int no) {
		return appDAO.selectTodo(no);
	};
	public List<TodoVO> selectTodos(){
		return appDAO.selectTodos();
	};
	public void updateTodo(TodoVO vo) {
		appDAO.updateTodo(vo);
	};
	public void deleteTodo(int no) {
		appDAO.deleteTodo(no);
	};
	public void deleteTodoAll() {
		appDAO.deleteTodoAll();
	};
}
