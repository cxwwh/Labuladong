package xuejian1.SlidWindow_5;

import org.junit.Test;

/**
 * @author CXWWH
 * @create 2022-05-07-15:48
 * @
 **/
public class T5 {

    public String longestPalindrome(String s) {

       String res = "";

       for(int i = 0; i < s.length(); i++){

           String s1 = palindrome(s,i,i);
           String s2 = palindrome(s,i,i+1);

           res = res.length() > s1.length()? res : s1;
           res = res.length() > s2.length()? res : s2;
       }

       return res;
    }

    public String palindrome(String s, int l, int r){

        while( l >= 0 && r < s.length() && s.charAt(l)==s.charAt(r)){

            l--;
            r++;
        }

        return s.substring(l+1,r);
    }

    @Test
    public void test(){

        String s = "babad";
        String s1 = longestPalindrome(s);


    }
}
