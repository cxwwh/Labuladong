package xuejian1.SlidWindow_5.review2;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CXWWH
 * @create 2022-06-26-16:56
 * @
 **/
public class T76 {

    public String minWindow(String s, String t) {

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {

            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;
        int start = 0;
        int end = Integer.MAX_VALUE;

        while (right < s.length()) {

            char r = s.charAt(right);
            right++;

            if (need.containsKey(r)) {

                window.put(r, window.getOrDefault(r, 0) + 1);

                if (need.getOrDefault(r, 0).equals(window.getOrDefault(r, 0))) {

                    valid++;
                }
            }


            while (valid == need.size()) {

                if ((right - left) < (end - start)) {

                    start = left;
                    end = right;
                }

                char l = s.charAt(left);
                left++;

                if (need.containsKey(l)) {

                    if (need.get(l).equals(window.get(l))) {

                        valid--;
                    }
                    window.put(l, window.getOrDefault(l, 0) - 1);
                }
            }

        }
        return end == Integer.MAX_VALUE ? "" : s.substring(start, end);
    }

    @Test
    public void test(){

        String s = "ADOBECODEBANC";
        String t = "ABC";

        String s1 = minWindow(s, t);

        System.out.println(s1);

    }

}
