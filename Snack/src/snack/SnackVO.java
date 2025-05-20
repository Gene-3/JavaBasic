package snack;

public class SnackVO {
	private int snackNo;
	private String name;
	private String company;
	private int price;
	private int instock;
	
	public SnackVO(int snackNo, String name, String company, int price, int instock) {
		this.snackNo = snackNo;
		this.name = name;
		this.company = company;
		this.price = price;
		this.instock = instock;
	}
	
	public SnackVO(String name, String company, int price, int instock) {
		this(-1, name, company, price, instock);
	}
	
	
	public String toString() {
		return "[" + snackNo + ", " + name + ", " + company + ", " + price + instock +  "]";
	}

	public int getSnackNo() {
		return snackNo;
	}

	public void setSnackNo(int snackNo) {
		this.snackNo = snackNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getInstock() {
		return instock;
	}

	public void setInstock(int instock) {
		this.instock = instock;
	}
	
	
}