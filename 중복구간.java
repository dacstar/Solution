
public class 중복구간 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int play_list[] = { 1,2,3,4 };
		int listen_time = 5;
		int playtime[] = new int[play_list.length + 1];

		for (int i = 1; i < playtime.length; i++) {
			playtime[i] = play_list[i - 1] + playtime[i - 1];
		}

		int result = 0;
		for (int i = 1; i < playtime.length; i++) {
			result = Math.max(timecheck(i, (playtime[i] - 1) + listen_time, playtime, listen_time), result);
		}
		System.out.println(result);
	}

	public static int timecheck(int start, int end, int playtime[], int listen_time) {
		int count = 0;
		int time = playtime[start] - 1;

		for (int i = start; i < playtime.length; i++) {
			int playtime1=playtime[i];
			if (playtime[i] >= time && playtime[i] <= end) {
				count++;
			} else {
				if (end <= playtime[i]) {
					count++;
					break;
				} 
			}
		}

		return count;
	}

}
