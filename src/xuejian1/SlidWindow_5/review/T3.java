package xuejian1.SlidWindow_5.review;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CXWWH
 * @create 2022-05-08-11:32
 * @
 **/
public class T3 {

    public int lengthOfLongestSubstring(String s) {

        int i = 0;
        int j = 0;
        int res = 0;
        Map<Character,Integer> window = new HashMap<>();

        while( j < s.length()){

            char c = s.charAt(j);
            j++;

            window.put(c,window.getOrDefault(c,0)+1);

            while( window.get(c) > 1){

                char c2 = s.charAt(i);
                i++;

                window.put(c2,window.getOrDefault(c2,0)-1);
            }

            res = Math.max(res,j-i);
        }

        return res;
    }
}
