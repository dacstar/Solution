package Programmers;

public class 두문자어 {
	public static void main(String[] args) {
		String strs[] = { "a", "b", "c" };
		int res = 0;
		boolean check=false;
		for (int i = 1; i < strs[0].length(); i++) {
			String str = strs[0].substring(0, i);
			for (int j = 1; j < strs.length; j++) {
				if (str.equals(strs[j].subSequence(0, i))) {
				     continue;
				} 
				else {
					check=true;
					break;
				}
			}
			if(check) {
				res=i-1;
				break;
			}
		}
		if(res!=0) {
			System.out.println(strs[0].substring(0,res));
		}else {
			System.out.println("");
		}

	}

}
