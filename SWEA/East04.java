package SWEA;

import java.util.ArrayList;

public class East04 {
	static ArrayList<String> list;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S="John Doe; Peter Benjamin Parker; Mary Jane Watson-Parker; John Elvis Doe; John Evan Doe; Jane Doe; Peter Brian Parker";
		String C="Example";
		list = new ArrayList<String>();
		String email="";
		String answer="";
		String str[]=S.split("; ");
		for(int i=0;i<str.length;i++) {
			String str2[]=str[i].split(" ");
			String firstname=str2[0].trim();
			str2[str2.length-1].trim();
			String lastname=makename(str2);
			String name=lastname.toLowerCase()+"_"+firstname.toLowerCase();
			int num=namenumber(name);
			if(num==0) {
				list.add(name);
				email="<"+name+"@"+C.toLowerCase()+"."+"com"+">";
			}else {
				email="<"+name+(num+"")+"@"+C.toLowerCase()+"."+"com"+">";
			}
			String fullname=str[i];
			answer+=fullname+" "+email+";";
		}
		System.out.println(answer);
	}

	public static int namenumber(String s) {
		int number=0;
		for(int i=0;i<list.size();i++) {
			if(list.get(i).equals(s)) {
				number++;
			}
		}
		return number;
	}
	
	public static String makename(String []str) {
		String lastname=str[str.length-1];
		lastname=lastname.replace("-","");
		
		return lastname;
	}

}
