package xuejian1.SlidWindow_5.review;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CXWWH
 * @create 2022-05-08-11:06
 * @
 **/
public class T567 {

    public boolean checkInclusion(String s1, String s2) {

        int i = 0;
        int j = 0;
        int valid = 0;
        int start = 0;
        int end = Integer.MAX_VALUE;
        Map<Character,Integer> need = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();

        for(int n = 0; n < s1.length(); n++){

            need.put(s1.charAt(n),need.getOrDefault(s1.charAt(n),0)+1);
        }

        while( j < s2.length()){

            char c1 = s1.charAt( j );
            j++;

            if( need.containsKey(c1)){

                window.put(c1, window.getOrDefault(c1,0)+1);

                if( window.get(c1).equals(need.get(c1))){

                    valid++;
                }
            }

            while( j-i == s1.length()){

                if( valid == need.size()){

                    return true;
                }

                char c2 = s2.charAt(i);
                i++;

                if( need.containsKey(c2)){

                    if( window.get(c2).equals(need.get(c2))){

                        valid--;
                    }
                    window.put(c2, window.getOrDefault(c2,0)-1);
                }
            }
        }

        return false;
    }
}
