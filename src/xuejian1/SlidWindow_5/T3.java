package xuejian1.SlidWindow_5;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CXWWH
 * @create 2022-05-06-17:34
 * @
 **/
public class T3 {

    public int lengthOfLongestSubstring(String s) {

        int left = 0;
        int right = 0;
        int len = 0;

        Map<Character,Integer> window = new HashMap<>();

        while( right < s.length()){

            char c = s.charAt(right);
            right++;

            window.put(c,window.getOrDefault(c,0)+1);

            while( window.get(c) > 1){

                char d = s.charAt(left);
                left++;

                window.put(d,window.getOrDefault(d,0 )-1);
            }

            len = Math.max(len,right - left);

        }

        return len;
    }

    @Test
    public void test(){

        String s = "abcbacbb";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);

    }
}
