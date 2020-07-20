import java.util.TreeMap;

public class 문제1 {
/*
 * 1. 엄지손가락은 상하좌우 4가지 방향으로만 이동할 수 있으며 키패드 이동 한 칸은 거리로 1에 해당합니다.
2. 왼쪽 열의 3개의 숫자 `1`, `4`, `7`을 입력할 때는 왼손 엄지손가락을 사용합니다.
3. 오른쪽 열의 3개의 숫자 `3`, `6`, `9`를 입력할 때는 오른손 엄지손가락을 사용합니다.
4. 가운데 열의 4개의 숫자 `2`, `5`, `8`, `0`을 입력할 때는 두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락을 사용합니다.
   4-1. 만약 두 엄지손가락의 거리가 같다면, 오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손가락을 사용합니다.
   | [1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5] | `"right"` | `"LRLLLRLLRRL"` |
| [7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2] | `"left"`  | `"LRLLRRLLLRR"` |
| [1, 2, 3, 4, 5, 6, 7, 8, 9, 0]    | `"right"` | `"LLRLLRLLRL"`  |
 * 
 * LRLLLRLLRRL
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeMap<Integer,XY> map = new TreeMap<>();
		int num=1;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				map.put(num++,new XY(i,j));
			}
		}
		map.put(10, new XY(3,0));
		map.put(0, new XY(3,1));
		map.put(11, new XY(3,2));
		int left=10;
		int right=11;
		String hand="right";
		int numbers[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
		String answer="";
		for(int i=0;i<numbers.length;i++) {
			if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7 ) {
				answer+="L";
				left=numbers[i];
			}else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
				answer+="R";
				right=numbers[i];
			}else {
				double l=getDistance(map.get(left),map.get(numbers[i]));
				double r=getDistance(map.get(right),map.get(numbers[i]));
				if(l > r) {
					answer+="R";
					right=numbers[i];
				}else if(l < r) {
					answer+="L";
					left=numbers[i];
				}else {
					if(hand.equals("right")) {
						answer+="R";
						right=numbers[i];
					}else {
						answer+="L";
						left=numbers[i];
					}
				}
				
			}
		}
		System.out.println(answer);
	}
	
	public static double getDistance(XY p1, XY p2){

        double d = Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));

        return d;

    }
	
	public static class XY{
		int y;
		int x;
				XY(int y,int x){
					this.y=y;
					this.x=x;
				}
	}

}
