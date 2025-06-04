
package book.file;

public interface FileBookDB {
	String DATA_FILE = "./data/book";
	void saveBooks();
	void loadBooks();
}
