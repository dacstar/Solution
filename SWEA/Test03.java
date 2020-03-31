package SWEA;

public class Test03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number=20;
		int firecracker[]= {10, 7, 5, 2, 1, 6, 0, 1, 3, 1,10, 7, 5, 2, 1, 6, 0, 1, 3, 1};

		int [] flower = new int[number];
		for(int i=number-1;i>=0;i--) {
			int distance = firecracker[i]; 
			int index = i - distance;
			if(index <0) {
				distance +=index;
				index=0;
			}
			flower[index] = Math.max(flower[index], distance);
		}
		int answer=0;
		for(int i=0; i <flower.length;i++) {
			System.out.print(flower[i] +" ");
		}
		System.out.println();
		for(int i=0;i<flower.length;i++) {
			if(flower[i]==0)
				answer++;
			else {
				i +=flower[i]-1;
			}
		}
		System.out.println(answer);
	}

}
