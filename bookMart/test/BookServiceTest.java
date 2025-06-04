package test;

import book.BookDAO;

import book.BookService;
import book.BookVO;
import book.HashMapBookDAO;
import book.KJBookService;
import book.ListBookDAO;
import book.file.TextFileHashMapBookDAO;
import book.file.FileBookDB;

public class BookServiceTest {
	
	static BookDAO bookDAO = new TextFileHashMapBookDAO();
	static BookService bs = new KJBookService(bookDAO);
	
	public static void main(String[] args) {
		
		
		// 책 등록
		//bs.registBook(new BookVO("test", "hyejeong", "kopo", 10000, 10));
		//bs.registBook(new BookVO("test2", "curi", "home", 1000, 5));
		//bs.registBook(new BookVO("test3", "hye", "home", 3000, 15));
		
		((FileBookDB)bookDAO).loadBooks();
		
		// 책목록 
		System.out.println(bs.listBooks());
		
		((FileBookDB)bookDAO).saveBooks();
		
		// 책상세정보
		System.out.println(bs.detailBookInfo(112));
		
		// 책정보 수정
		bs.updateBookInstock(111, 15);
		bs.updateBookPrice(112, 30000);
		
		System.out.println(bs.listBooks());
		
		//책 삭제
		
		bs.removeBook(113);
		
		System.out.println(bs.listBooks());
		
		System.out.println();
		
		BookService bs1 = new KJBookService(new HashMapBookDAO());
		// 책 등록
		bs1.registBook(new BookVO("test", "hyejeong", "kopo", 10000, 10));
		bs1.registBook(new BookVO("test2", "curi", "home", 1000, 5));
		bs1.registBook(new BookVO("test3", "hye", "home", 3000, 15));
		
		// 책목록 
		System.out.println(bs1.listBooks());
		
		// 책상세정보
		System.out.println(bs1.detailBookInfo(112));
		
		// 책정보 수정
		bs1.updateBookInstock(111, 15);
		bs1.updateBookPrice(112, 30000);
		
		System.out.println(bs1.listBooks());
		
		//책 삭제
		
		bs1.removeBook(113);
		
		System.out.println(bs1.listBooks());

	}
	
	static void DAOTest() {
BookDAO bookDAO = new ListBookDAO();
		
		
		// 책 등록
		bookDAO.insertBook(new BookVO("test", "hyejeong", "kopo", 10000, 10));
		bookDAO.insertBook(new BookVO("test2", "curi", "home", 1000, 5));
		bookDAO.insertBook(new BookVO("test3", "hye", "home", 3000, 15));
		// 책 정보
		System.out.println(bookDAO.selectAllBooks());
		System.out.println(bookDAO.selectBook(112));
		// 책 정보 수정
		BookVO book = bookDAO.selectBook(111);
		book.setInstock(15);
		bookDAO.updateBook(book);
		
		BookVO book1 = bookDAO.selectBook(112);
		book1.setPrice(30000);
		bookDAO.updateBook(book1);
		
		System.out.println(bookDAO.selectAllBooks());
		
		// 책 삭제
		bookDAO.deleteBook(113);
		System.out.println(bookDAO.selectAllBooks());
	}
}
