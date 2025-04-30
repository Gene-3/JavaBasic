package lec250430.dao;

public class OracleDao implements DataAccessObject{

	@Override
	public void insert() {
		System.out.println("Oracle DB에 삽입");
	}
	
	@Override
	public void select() {
		System.out.println("Oracle DB에 검색");
	}
	
	@Override
	public void update() {
		System.out.println("Oracle DB에 삽입");
	}
	
	@Override
	public void delete() {
		System.out.println("Oracle DB에 삭제");
	}
}
