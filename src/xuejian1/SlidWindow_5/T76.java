package xuejian1.SlidWindow_5;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CXWWH
 * @create 2022-05-06-15:25
 * @
 **/
public class T76 {

    public String minWindow(String s, String t) {

        //need存放t的字符
        Map<Character,Integer> need = new HashMap<>();
        //window用于存放处于窗口中且存在于t中的字符
        Map<Character,Integer> window = new HashMap<>();

        int left = 0;
        int right = 0;

        int valid = 0;//若window中的某个字符和need中的字符出现的次数一样，就让valid++

        //return s.substring( start, len)
        int start = 0;//用于最后返回子串的起点
        int end = Integer.MAX_VALUE;//用于最后返回子串的终点



        //把t中的字符都放入need中
        for(int i = 0; i < t.length(); i++){

            need.put(t.charAt(i), need.getOrDefault(t.charAt(i),0)+1);
        }

        //进行滑动窗口
        while( right < s.length()){

            char r = s.charAt(right);
            right++;//while的条件是 right<s.length,最后进来right=s.length-1,然后right++，取到了s.length

            //如果need中包含当前字符，那么就更新window
            if( need.containsKey(r)){

                window.put(r,window.getOrDefault(r,0)+1);

                //如果t中某个字符及其出现的次数和window中完全一样
                //说明这个字符判断完毕
                //valid++
                if( window.get(r).equals( need.get(r))){

                    valid++;
                }
            }

            //当window中包含字符串t的全部字符时，就要精简子串
            //移动left,让子串尽可能小
            while( valid == need.size()){

                //判断子串的长度是否更小了
                if( (right - left) < (end - start)){

                    start = left;
                    end = right;
                }

                //取出窗口中最左边的字符
                char c = s.charAt(left);
                left++;

                //如果need中包含该字符
                if( need.containsKey(c)){

                    //并且该字符在窗口window中出现的次数和在need中出现的次数一样
                    //就让valid--，此时不能再继续缩小窗口
                    if( window.getOrDefault(c,0).equals( need.get(c))){

                        valid--;
                    }

                    //改变窗口window中该字符的数量
                    window.put(c,window.getOrDefault(c,0)-1);
                }
            }
        }

        return end == Integer.MAX_VALUE? "" : s.substring(start, end);
    }
}
