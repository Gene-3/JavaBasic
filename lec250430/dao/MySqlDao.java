package lec250430.dao;

public class MySqlDao implements DataAccessObject{

	@Override
	public void insert() {
		System.out.println("MySql DB에 삽입");
	}
	
	@Override
	public void select() {
		System.out.println("MySql DB에 검색");
	}
	
	@Override
	public void update() {
		System.out.println("MySql DB에 수정");
	}
	
	@Override
	public void delete() {
		System.out.println("MySql DB에 삭제");
	}
}
