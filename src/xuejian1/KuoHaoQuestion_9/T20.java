package xuejian1.KuoHaoQuestion_9;

import java.util.Stack;

/**
 * @author CXWWH
 * @create 2022-05-13-16:03
 * @
 **/
public class T20 {

    public boolean isValid(String s) {

        Stack<Character> left = new Stack<>();

        for(int i = 0; i < s.length(); i++){

            char c = s.charAt(i);
            if( c == '(' || c == '[' || c == '{'){

                left.push(c);
            }else{


                if( !left.isEmpty() && left.peek().equals(getLeft(c))){

                    left.pop();
                }else{

                    return false;
                }
            }
        }

        return left.isEmpty();
    }

    public char getLeft( char c){

        if( c == ')'){

            return '(';
        }else if( c == ']'){

            return '[';
        }

        return '{';
    }
}
