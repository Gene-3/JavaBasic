package snack;

import java.io.*;
import java.util.Map;

public class ObjFileHashMapSnackDAO extends HashMapSnackDAO implements FileSnackDB {

    private final String dataFilename = DATA_FILE + ".obj";

    public ObjFileHashMapSnackDAO() {
        loadSnacks();
    }

    @Override
    public void saveSnacks() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dataFilename))) {
            oos.writeObject(snackDB);
        } catch (IOException e) {
            System.err.println("[저장 실패] 스낵 데이터 저장 중 오류 발생");
            e.printStackTrace();
        }
    }

    @Override
    public void loadSnacks() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dataFilename))) {
            snackDB = (Map<Integer, SnackVO>) ois.readObject();
            for (int no : snackDB.keySet()) {
                if (no >= snackSeq) snackSeq = no + 1;
            }
        } catch (FileNotFoundException e) {
            System.out.println("[DB 로딩] " + dataFilename + " 파일 없음 - 새로 시작합니다.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("[로드 실패] 스낵 정보 불러오기 중 오류 발생");
            e.printStackTrace();
        }
    }

    @Override
    public boolean insertSnack(SnackVO snack) {
        boolean result = super.insertSnack(snack);
        if (result) saveSnacks();
        return result;
    }

    @Override
    public boolean updateSnack(SnackVO newSnack) {
        boolean result = super.updateSnack(newSnack);
        if (result) saveSnacks();
        return result;
    }

    @Override
    public boolean deleteSnack(int snackNo) {
        boolean result = super.deleteSnack(snackNo);
        if (result) saveSnacks();
        return result;
    }
}
