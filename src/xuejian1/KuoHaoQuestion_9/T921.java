package xuejian1.KuoHaoQuestion_9;

import org.junit.Test;

import java.util.Stack;

/**
 * @author CXWWH
 * @create 2022-05-13-16:37
 * @
 **/
public class T921 {

    //自己想的，比较慢
    public int minAddToMakeValid(String s) {

        int count = 0;
        Stack<Character> left = new Stack<>();

        for(int i = 0; i < s.length(); i++){

            char c = s.charAt(i);
            if( c == '('){

                left.push(c);
            }else{

                //这里 c 是右括号
                if( !left.isEmpty()){

                    left.pop();
                }else{

                    //需要插入的左括号的数量
                    count++;
                }
            }
        }

        //left.size()为需要的右括号的数量
        return count + left.size();
    }

    public int minAddToMakeValid2(String s) {

        int need = 0;//需要的右括号的数量
        int insert = 0;//需要的左括号的数量
        for(int i = 0; i < s.length(); i++){

            char c = s.charAt(i);
            if( c == '('){

                need++;
            }else{

                if( need != 0){

                    need--;
                }else{
                    //如果不需要右括号了
                    //说明这个右括号是多出来的
                    //那么需要左括号
                    need = 0;
                    insert++;
                }
            }
        }

        return insert + need;
    }

    @Test
    public void test(){

        String s = "())(";
        String s1 = "(((";
        String s2 = ")))";
        String s4 = ")()(";

        int i = minAddToMakeValid(s4);
        System.out.println(i);
    }
}
