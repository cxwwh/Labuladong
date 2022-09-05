package xuejian1.QuChong_12;

import org.junit.Test;

import java.util.Stack;

/**
 * @author CXWWH
 * @create 2022-05-17-19:19
 * @
 **/
public class T316 {

    //目标1:给s去重
    public String removeDuplicateLetters1(String s) {

        Stack<Character> stack = new Stack<>();

        //用这个数组来表示字符串s中各个字符是否存在于stack中
        boolean[] isInStack = new boolean[26];

        for(int i = 0; i < s.length(); i++){

            char c = s.charAt(i);
            //元素对应的索引
            int index = c - 'a';

            //如果栈中有这个元素，直接跳过
            if( isInStack[index]){

                continue;
            }else{

                //如果栈中没有这个元素
                //将其入栈，然后修改标记
                stack.push(c);
                isInStack[index] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        while( !stack.isEmpty()){

            sb.append( stack.pop() );
        }

        //栈是先进先出的，我们按照s的顺序将字符加入栈
        //出栈的时候也是按s中的顺序出栈，所以sb的顺序和s相反
        return sb.reverse().toString();
    }

    //目标2：保证去重后，结果保持字典序
    //假设s = "bcac"，最后得到的结果却是"ac",没有了b
    //这是因为我们在将a入栈的时候，将里面的b弹出了，而a后面没有b了
    public String removeDuplicateLetters2(String s) {

        Stack<Character> stack = new Stack<>();

        //用这个数组来表示字符串s中各个字符是否存在于stack中
        boolean[] isInStack = new boolean[26];

        for(int i = 0; i < s.length(); i++){

            char c = s.charAt(i);
            //元素对应的索引
            int index = c - 'a';

            //如果栈中有这个元素，直接跳过
            if( isInStack[index]){

                continue;
            }else{

                //如果栈中没有这个元素
                //将其入栈，然后修改标记

                //如果栈中之前的字符的字典序比当前字符大
                //那么就pop()出之前的字符
                while( !stack.isEmpty() && stack.peek()>c){

                    //将字符弹出，并且修改标记
                    isInStack[stack.pop()-'a'] = false;
                }

                stack.push(c);
                isInStack[index] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        while( !stack.isEmpty()){

            sb.append( stack.pop() );
        }

        //栈是先进先出的，我们按照s的顺序将字符加入栈
        //出栈的时候也是按s中的顺序出栈，所以sb的顺序和s相反
        return sb.reverse().toString();
    }

    //目标3：实现整体需求
    public String removeDuplicateLetters3(String s) {

        //统计s中每个字符出现的次数
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++){

            count[ s.charAt(i)-'a']++;
        }

        Stack<Character> stack = new Stack<>();

        //用这个数组来表示字符串s中各个字符是否存在于stack中
        boolean[] isInStack = new boolean[26];

        for(int i = 0; i < s.length(); i++){

            char c = s.charAt(i);
            //元素对应的索引
            int index = c - 'a';
            count[index]--;//当前字符在剩余s中出现的次数-1

            //如果栈中有这个元素，直接跳过
            if( isInStack[index]){

                continue;
            }else{

                //如果栈中没有这个元素

                //如果栈中之前的字符的字典序比当前字符大
                //那么就pop()出之前的字符
                while( !stack.isEmpty() && stack.peek()>c){

                    //stack.peek()这个元素的字典序比当前字符大

                    //如果后面没有该元素了，那么就不要弹出去了
                    if( count[stack.peek()-'a'] == 0){
                        break;
                    }

                    //如果后面还有该字符
                    //将字符弹出，后面该字符还会加进来，不会影响结果
                    //并且修改标记
                    isInStack[stack.pop()-'a'] = false;
                }

                stack.push(c);
                isInStack[index] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        while( !stack.isEmpty()){

            sb.append( stack.pop() );
        }

        //栈是先进先出的，我们按照s的顺序将字符加入栈
        //出栈的时候也是按s中的顺序出栈，所以sb的顺序和s相反
        return sb.reverse().toString();
    }


    @Test
    public void test(){

        String s = "bcabc";

        String s1 = removeDuplicateLetters3(s);
        System.out.println(s1);
    }
}
