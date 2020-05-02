package Programmers;

public class Ä«Æê {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int brown=10;
		int red=2;
		int cal=0;
		int row=0;
		int n=0;
		int m=0;
		int width=brown+red;
		for(int i=2;i<=width;i++) {
			if(width%i==0) {
				cal=i;
				row=width/i;
				if(cal >=row) {
					m=cal;
					n=row;
				}
			}
		}
		System.out.println(m+" "+n);
	}

}
