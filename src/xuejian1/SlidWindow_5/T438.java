package xuejian1.SlidWindow_5;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author CXWWH
 * @create 2022-05-06-17:01
 * @
 **/
public class T438 {

    public List<Integer> findAnagrams(String s, String p) {

        int left = 0;
        int right = 0;
        int valid = 0;

        Map<Character,Integer> need = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();
        List<Integer> list = new LinkedList<>();

        for(int i = 0; i < p.length(); i++){

            need.put(p.charAt(i),need.getOrDefault(p.charAt(i),0)+1);
        }

        while( right < s.length()){

            char c = s.charAt( right );
            right++;

            if( need.containsKey(c)){

                window.put(c,window.getOrDefault(c,0)+1);

                if(window.get(c).equals(need.get(c))){

                    valid++;
                }
            }

            while( right - left >= p.length()){

                if( valid == need.size()){

                    list.add(left);
                }

                c = s.charAt(left);
                left++;

                if( need.containsKey(c)){

                    if( need.containsKey(c)){

                        if( need.get(c).equals(window.get(c))){

                            valid--;
                        }
                        window.put(c,window.getOrDefault(c,0)-1);
                    }
                }
            }
        }

        return list;
    }
}
