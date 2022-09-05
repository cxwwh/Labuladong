package xuejian1.DanDiaoStack_10;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author CXWWH
 * @create 2022-05-15-16:01
 * @
 **/
public class T503 {

    public int[] nextGreaterElements(int[] nums) {

        int len = nums.length;
        int[] res = new int[len];
        Stack<Integer> s = new Stack<>();

        for(int i = (2*len - 1); i >= 0; i--){

            while( !s.isEmpty() && s.peek() <= nums[i%len]){

                s.pop();
            }

            res[i%len] = s.isEmpty()? -1 : s.peek();

            s.push(nums[i%len]);
        }

        return res;
    }

    @Test
    public void test(){

        int[] nums = {5,4,3,2,1};
        int[] nums1 = nextGreaterElements(nums);
        System.out.println(Arrays.toString(nums1));

    }
}
