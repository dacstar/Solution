package Programmers;

public class Programmers_스킬트리 {
	static int arr[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String skill="CBD";
		String skill_trees[]= {"BACDE", "CBADF", "AECB", "BDA"};
		int res=0;
		for(int i=0;i<skill_trees.length;i++) {
			arr = new int['Z'-'0'];
			String tree=skill_trees[i];
			if(check(skill,tree)) {
				res++;
			}
		}
		System.out.println(res);
		
	}
	
	public static boolean check(String s,String t) {
		
		for(int i=0;i<t.length();i++) {
			for(int j=0;j<s.length();j++) {
				if(s.charAt(j) == t.charAt(i)) {
					if(j-1>=0) {
						if(arr[j-1]==0)
							return false;
						else
							arr[j]++;
					}else {
						arr[j]++;
					}
					
				}
			}
		}
		
		
		return true;
	}

}
