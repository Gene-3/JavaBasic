package snack;

public interface FileSnackDB {
    String DATA_FILE = "./data/snackDB";
    void saveSnacks();
    void loadSnacks();
}
