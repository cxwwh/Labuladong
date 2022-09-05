package xuejian1.SlidWindow_5.review2;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CXWWH
 * @create 2022-06-26-19:20
 * @
 **/
public class T3 {

    public int lengthOfLongestSubstring(String s) {

        Map<Character,Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;

        int res = 0;

        while( right < s.length()){

            char r = s.charAt(right);
            right++;
            window.put( r, window.getOrDefault(r,0)+1);

            while( window.get(r) > 1){

                char l = s.charAt( left);
                left++;

                window.put(l,window.get(l)-1);
            }

            res = Math.max(res,(right-left));
        }

        return res;
    }

    @Test
    public void test(){

        String s = "abcabcbb";

        System.out.println(lengthOfLongestSubstring(s));
    }
}
