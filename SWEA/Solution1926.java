package SWEA;

import java.util.Scanner;
import java.util.regex.*;
class Solution1926 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Pattern pattern = Pattern.compile("[369]");
        String dashes;
        Matcher matcher; 
        for(int i=1; i<=N; i++) {
            matcher = pattern.matcher( String.valueOf(i) );
            dashes = "";
            while( matcher.find() ) dashes += "-";
            if( dashes.equals("") ) System.out.format( "%d ", i );
            else System.out.format( "%s ", dashes  );
        }
    }
}