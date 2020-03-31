package SWEA;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="BDA";
		String str2="CBD";
		str=str.replaceAll("[^" + str2 + "]", "");
		System.out.println(str);
	}

}
