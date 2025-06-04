package member;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TextFileHashMapMemberDAO extends HashMapMemberDAO implements FileMemberDB {
	
	private String dataFilename = DATA_FILE + ".txt";
	private final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

	@Override
	public void saveMembers() {
		try (
			FileWriter FW = new FileWriter(dataFilename);
			PrintWriter PW = new PrintWriter(FW);
		) {
			for (MemberVO member : memberDB.values()) {
				PW.println(member.getMemberNo());
				PW.println(member.getId());
				PW.println(member.getPassword());
				PW.println(member.getUsername());
				PW.println(member.getMobile());
				PW.println(member.getEmail());
				PW.println(member.getAddress());
				
				SimpleDateFormat SDF = new SimpleDateFormat(DATE_FORMAT);
				PW.println(SDF.format(member.getRegdate()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void loadMembers() {
		try (
			FileReader FR = new FileReader(dataFilename);
			BufferedReader BR = new BufferedReader(FR);
		) {
			while (BR.ready()) {
				int memberNo = Integer.parseInt(BR.readLine());
				String id = BR.readLine().strip();
				String password = BR.readLine().strip();
				String username = BR.readLine().strip();
				String mobile = BR.readLine().strip();
				String email = BR.readLine().strip();
				String address = BR.readLine().strip();
				
				SimpleDateFormat SDF = new SimpleDateFormat(DATE_FORMAT);
				Date regdate = SDF.parse(BR.readLine());

				memberDB.put(String.valueOf(memberNo), new MemberVO(
					memberNo, id, password, username, mobile, email, address, regdate
				));
				
				if (memberSeq <= memberNo) {
					memberSeq = memberNo + 1;
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("[로딩] " + dataFilename + "이 없습니다.");
		} catch (IOException | ParseException e) {  // 수정: ParseException 추가
			e.printStackTrace();
		}
	}
}
