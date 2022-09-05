package xuejian1.DanDiaoStack_10;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author CXWWH
 * @create 2022-05-15-15:41
 * @
 **/
public class T739 {

    public int[] dailyTemperatures(int[] temperatures) {

        int len = temperatures.length;
        int[] res = new int[len];
        Stack<Integer> s = new Stack<>();


        for(int i = len-1; i >= 0; i--){

            while( !s.isEmpty() && temperatures[s.peek()] <= temperatures[i]){

                s.pop();
            }

            res[i] = s.isEmpty()? 0 : (s.peek() - i);
            s.push(i);
        }

        return res;
    }

    @Test
    public void test(){

        int[] nums = {30,40,50,60};
        int[] ints = dailyTemperatures(nums);

        System.out.println(Arrays.toString(ints));
    }
}
