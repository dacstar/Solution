package Programmers;

import java.util.HashMap;

public class 카카오_호텔방배정 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k=10;
		long room_number[] = {1,1,1,3,2,1};
		long answer[]= new long[room_number.length];
		HashMap<Long,Long> hash = new HashMap<Long, Long>();
		for(int i=0;i<room_number.length;i++) {
			if(hash.containsKey(room_number[i])) {
				continue;
			}else {
				answer[i]=room_number[i];
				hash.put(room_number[i],room_number[i]+1);
			}
		}
		for(int i=0;i<room_number.length;i++) {
			if(hash.containsKey(room_number[i])) {
				long key=hash.get(room_number[i]);
				while(true) {
					if(hash.containsKey(key)) {
						key=hash.get(key);
					}else {
						break;
					}
				}
				answer[i]=key;
				hash.put(key, key+1);
				hash.put(room_number[i], key+1);
			}else {
				answer[i]=room_number[i];
				hash.put(room_number[i],room_number[i]+1);
			}
		}


		for(int i=0;i<answer.length;i++) {
			System.out.print(answer[i]+" ");
		}

	}

}
