package xuejian1.JiSuanaQi_17;

import org.junit.Test;

import java.util.Stack;

/**
 * @author CXWWH
 * @create 2022-05-22-19:45
 * @
 **/
//该解同样适用于T227 T772
public class T224 {

    public int calculate(String s) {

        return getResuslt(s, 0)[0];
    }

    public int[] getResuslt(String s, int index){

        Stack<Integer> nums = new Stack<>();
        char sign = '+';
        int num = 0;

        int i = index;
        for(i = index; i < s.length(); i++) {

            char c = s.charAt(i);

            if (c >= '0' && c <= '9') {

                //加上括号(c - '0')是为了防止当字符串表示的数字很大的时候出现溢出
                num = num * 10 + (c - '0');
            }

            //左括号之前的字符一定不可能是数字
            //一定是符号
            //所以之前肯定已经已经把num push到了栈中，nums也进行了归零
            if (c == '(') {

                int[] result = getResuslt(s, i + 1);
                num = result[0];

                //这里要更新一下索引i
                //返回的i指向的是右括号)
                //经过for循环的i++后指向下面的字符
                i = result[1];
            }

            if ((!Character.isDigit(c) && c != ' ') || i == (s.length() - 1)) {

                switch (sign) {

                    case '+':
                        nums.push(num);
                        break;
                    case '-':
                        nums.push(-num);
                        break;
                    case '*':
                        int pre1 = nums.pop();
                        nums.push(pre1 * num);
                        break;
                    case '/':
                        int pre2 = nums.pop();
                        nums.push(pre2 / num);
                        break;
                }


                //更新符号
                sign = c;
                //将num归零
                num = 0;

                //如果遇到了右括号，那么就跳出当前的for循环
                //返回计算结果和当前索引
                if (c == ')') {

                    break;
                }
            }
        }

        int res = 0;
        while( !nums.isEmpty()){

            res += nums.pop();
        }

        return new int[]{res,i};
    }

    @Test
    public void test(){

        String s = "(1+4+5*2-3)+6+8";
        int res = calculate(s);

        System.out.println(res);
    }
}
