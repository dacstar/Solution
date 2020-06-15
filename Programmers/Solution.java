package Programmers;
class Solution {
    public int solution(String s) {
       StringBuilder sb = new StringBuilder(s);
        int answer = sb.length();
        for(int i=1; i <sb.length(); i++ ) {
           int length = sb.length();
           int front = 0;
           int rear = i;
           StringBuilder tempString1 = new StringBuilder(sb.substring(front, rear));
           front += i;
           int count = 1;
           while(front < sb.length()) {
              rear = front +i <= sb.length() ? front+i : sb.length();
               StringBuilder tempString2 = new StringBuilder(sb.substring(front, rear));
               
               if(tempString1.toString().equals(tempString2.toString())) {
                  count++;                  
               }else if(count != 1) {
                  length -= (count-1) * i;
                  length += ("" + count).length();
                  count =1;
               }
              tempString1 = new StringBuilder(tempString2.toString());
               front += i;
           }
            if(count != 1) {
               length -= (count-1)*i;
               length += (""+count).length();
            }
           answer = answer < length ? answer : length;
        }
        
        return answer;
    }
}