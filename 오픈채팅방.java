import java.util.ArrayList;
import java.util.TreeMap;

public class 오픈채팅방 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String record[] = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
				"Change uid4567 Ryan" };
		TreeMap<String, String> map = new TreeMap<String, String>();
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> re = new ArrayList<String>();

		for (int i = 0; i < record.length; i++) {
			String str[] = record[i].split(" ");
			if (str[0].equals("Enter")) {
				if (map.containsKey(str[1])) {
					map.put(str[1], str[2]);
					list.add(str[1] + "님이" + " " + "들어왔습니다.");

				} else {
					map.put(str[1], str[2]);
					list.add(str[1] + "님이" + " " + "들어왔습니다.");
				}
			} else if (str[0].equals("Change")) {
				if (map.containsKey(str[1])) {
					map.put(str[1], str[2]);
				}

			} else {
				
				list.add(str[1] + "님이" + " " + "나갔습니다.");
			}
		}

		for (int i = 0; i < list.size(); i++) {
			String str=list.get(i);
			int index=str.indexOf("님");
			String name=str.substring(0, index);
			String full=map.get(name)+str.substring(index,str.length());
			re.add(full);
		}
		for(int i=0;i<re.size();i++) {
			System.out.println(re.get(i));
		}

	}

}
