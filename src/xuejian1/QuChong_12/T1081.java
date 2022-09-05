package xuejian1.QuChong_12;

import java.util.Stack;

/**
 * @author CXWWH
 * @create 2022-05-17-20:06
 * @
 **/
public class T1081 {

    public String smallestSubsequence(String s) {

        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++){

            count[ s.charAt(i)-'a']++;
        }

        Stack<Character> stack = new Stack<>();
        boolean[] isInStack = new boolean[26];

        for( char c : s.toCharArray()){

            int index = c - 'a';
            count[index]--;

            if( isInStack[index]){

                continue;
            }else{

                while( !stack.isEmpty() && stack.peek()>c){

                    if( count[ stack.peek()-'a'] == 0){

                        break;
                    }

                    isInStack[stack.pop()-'a'] = false;
                }

                stack.push(c);
                isInStack[index] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        while( !stack.isEmpty()){

            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
