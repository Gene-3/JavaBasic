package snack;

import java.io.Serializable;
import java.util.Date;

public class SnackVO implements Serializable {
    private int snackNo;
    private String snackName;
    private String country;
    private String category;
    private int price;
    private int instock;
    private Date regdate;

    public SnackVO(int snackNo, String snackName, String country, String category, int price, int instock, Date regdate) {
        this.snackNo = snackNo;
        this.snackName = snackName;
        this.country = country;
        this.category = category;
        this.price = price;
        this.instock = instock;
        this.regdate = regdate;
    }

    public SnackVO(String snackName, String country, String category, int price, int instock) {
        this(-1, snackName, country, category, price, instock, null);
    }

    public int getSnackNo() {
        return snackNo;
    }

    public void setSnackNo(int snackNo) {
        this.snackNo = snackNo;
    }

    public String getSnackName() {
        return snackName;
    }

    public void setSnackName(String snackName) {
        this.snackName = snackName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    @Override
    public String toString() {
        return "[" + snackNo + ", " + snackName + " , " + country + " , " + category + " , " + price + ", " + instock + "]";
    }
}
