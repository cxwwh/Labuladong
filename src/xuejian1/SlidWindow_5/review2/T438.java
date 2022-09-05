package xuejian1.SlidWindow_5.review2;

import org.junit.Test;

import java.util.*;

/**
 * @author CXWWH
 * @create 2022-06-26-18:27
 * @
 **/
public class T438 {

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> res = new ArrayList<>();

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        int left = 0;
        int right = 0;
        int valid = 0;

        for(int i = 0; i < p.length(); i++){

            need.put(p.charAt(i),need.getOrDefault(p.charAt(i), 0)+1);
        }

        while( right < s.length()){

            char r = s.charAt(right);
            right++;

            if( need.containsKey(r)){

                window.put( r, window.getOrDefault(r,0)+1);

                if( need.get(r).equals( window.get(r))){

                    valid++;
                }
            }

            while( valid == need.size()){

                if( (right - left) == p.length()){

                    res.add(left);
                    break;
                }

                char l = s.charAt( left);
                left++;

                if( need.containsKey(l)){

                    if( need.get(l).equals(window.get(l))){

                        valid--;
                    }

                    window.put(l,window.get(l)-1);
                }
            }
        }

        return res;
    }

    @Test
    public void test(){

        String s = "abab";
        String p = "ab";

        List<Integer> list = findAnagrams(s, p);
        System.out.println(list);
    }
}
