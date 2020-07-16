import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

public class 무작위_섞기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String movie[]= {"spy","ray","spy","room","once","ray","spy","once"};
		TreeMap<String, Integer> map = new TreeMap<String, Integer>();
		for(int i=0;i<movie.length;i++) {
			if(map.containsKey(movie[i])) {
				map.put(movie[i], map.get(movie[i])+1);
			}else {
				map.put(movie[i], 1);
			}
		}
		ArrayList<XY> list = new ArrayList<>();
		for(String str : map.keySet()) {
			list.add(new XY(str,map.get(str)));
		}
		Collections.sort(list);
		String result[] = new String[movie.length];
		for(int i=0;i<list.size();i++) {
			result[i]=list.get(i).name;
		}
		
		for(int i=0;i<list.size();i++) {
			System.out.print(result[i]+" ");
		}
		
		
		
	}
	
	public static class XY implements Comparable<XY>{
		String name;
		int value;
					XY(String name,int value){
						this.name=name;
						this.value=value;
					}
		@Override
		public int compareTo(XY o) {
			// TODO Auto-generated method stub
			return this.value > o.value ? -1 : 1;
		}
	}

}
