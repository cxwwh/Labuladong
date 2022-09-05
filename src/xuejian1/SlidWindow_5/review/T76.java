package xuejian1.SlidWindow_5.review;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CXWWH
 * @create 2022-05-08-10:45
 * @
 **/
public class T76 {

    public String minWindow(String s, String t) {

        int i = 0;
        int j = 0;
        int valid = 0;
        int start = 0;
        int end = Integer.MAX_VALUE;
        Map<Character,Integer> need = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();

        for(int n = 0; n < t.length(); n++){

            need.put(t.charAt(n),need.getOrDefault(t.charAt(n),0)+1);
        }

        while( j < s.length()){

            char c1 = s.charAt(j);
            j++;

            if( need.containsKey(c1)){

                window.put(c1,window.getOrDefault(c1,0)+1);

                if( need.get(c1).equals(window.get(c1))){

                    valid++;
                }
            }

            while( valid == need.size()){

                if( (j-i) < (end - start)){

                    start = i;
                    end = j;
                }

                char c2 = s.charAt(i);
                i++;

                if( need.containsKey(c2)){

                    if( need.get(c2).equals(window.get(c2))){

                        valid--;
                    }

                    window.put(c2,window.getOrDefault(c2,0)-1);
                }
            }
        }

        return end == Integer.MAX_VALUE? "" : s.substring(start,end);
    }
}
