
public class test04 {
    public static long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        boolean[] check = new boolean[(int)k+1];
        for (int i = 0; i < room_number.length; i++) {
			if(!check[(int)room_number[i]]) {
				answer[i] = room_number[i];
				check[(int) room_number[i]] = true;
				continue;
			}else {
				int s = (int) room_number[i];
				
				for (int j = s; j <= k; j++) {
					if(!check[j]) {
						answer[i] = j;
						check[j] = true;
						break;
					}
				}
			}
		}
        for (int i = 0; i < answer.length; i++) {
			System.out.print(answer[i]+ " ");
		}
        return answer;
    }
    public static void main(String[] args) {
		int k = 10;
		long[] room_number = {1, 3, 4, 1, 3, 1};
		solution(k, room_number);
	}
}
