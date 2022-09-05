package xuejian1.SlidWindow_5.review2;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CXWWH
 * @create 2022-06-26-18:00
 * @
 **/
public class T567 {

    public boolean checkInclusion(String s1, String s2) {

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for(int i = 0; i < s1.length(); i++){

            need.put( s1.charAt(i), need.getOrDefault(s1.charAt(i),0)+1);
        }

        int right = 0;
        int left = 0;
        int valid = 0;

        while( right < s2.length()){

            char r = s2.charAt(right);
            right++;

            if( need.containsKey(r)){

                window.put(r,window.getOrDefault(r,0)+1);

                if( need.get(r).equals( window.get(r))){

                    valid++;
                }
            }

            while( valid == need.size()){

                if( (right - left) == s1.length()){

                    return true;
                }

                char l = s2.charAt(left);
                left++;

                if( need.containsKey(l)){

                    if( need.get(l).equals(window.get(l))){

                        valid--;
                    }

                    window.put(l,window.get(l)-1);
                }
            }
        }

        return false;
    }

    @Test
    public void test(){

        String s1 = "ab";
        String s2 = "eidboaooo";
        boolean b = checkInclusion(s1, s2);
        System.out.println(b);
    }
}
