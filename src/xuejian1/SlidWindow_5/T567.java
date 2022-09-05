package xuejian1.SlidWindow_5;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CXWWH
 * @create 2022-05-06-16:13
 * @
 **/
public class T567 {

    public boolean checkInclusion(String s1, String s2) {

        Map<Character,Integer> need = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();

        int left = 0;
        int right = 0;
        int valid = 0;

        for(int i = 0; i < s1.length(); i++){

            need.put(s1.charAt(i),need.getOrDefault(s1.charAt(i),0)+1);
        }

        while( right < s2.length()){

            char c = s2.charAt(right);
            right++;

            if( need.containsKey(c)){

                window.put(c,window.getOrDefault(c,0)+1);
                if( window.get(c).equals( need.get(c))){

                    valid++;
                }
            }

            // 这里把 (right - left) >= s1.length()
            // 改为了 (right - left) == s1.length()
            // 因为 (right - left) 肯定是 先满足 == 这个条件，然后才可能去满足 >
            // 经过思考：下面的代码，要么满足条件退出
            // 要么left++，缩小串口
            // 上面提到：首先肯定是先满足  == 这个条件，进去执行下面的代码
            // 如果不满足退出条件，那么left++,也就不再满足 (right - left) == s1.length()
            // 转而去扩大窗口。

            // 其实就是 先right++ 判断是否满足 (right - left) == s1.length()
            // 再去判断是否满足退出条件 若不满足 再left++, 不再满足 (right - left) == s1.length()
            // 开始下一轮扩大窗口 right++
            // 综上：先right++，再left++, 再right++，所以每次都是窗口长度+1，再-1
            // 所以判断 (right - left) == s1.length() 即可
            // 而且还可以把 while 改为 if

            //这里：如果窗口的长度等于字符串s1的长度
            //就要判断这时候窗口内的字符串是不是s1的一个排列
            if( (right - left) == s1.length()){

                //如果满足这个条件
                //说明[left,right)之间是s1的一个排列
                if( valid == need.size()){

                    return true;
                }

                //如果不是，就要精简子串
                c = s2.charAt(left);

                //left++以后，不再满足(right - left) == s1.length()
                //只会经过一次就不再满足条件
                //这也是为什么可以把while改为if
                left++;

                //缩小窗口
                if( need.containsKey(c)){

                    if( window.get(c) == need.get(c)){

                        valid--;
                    }

                    window.put(c,window.getOrDefault(c,0)-1);
                }
            }
        }

        return false;
    }

    @Test
    public void test(){

        String s1 = "ab";
        String s2 = "eidboaoo";

        boolean b = checkInclusion(s1, s2);
        System.out.println(b);

    }
}
