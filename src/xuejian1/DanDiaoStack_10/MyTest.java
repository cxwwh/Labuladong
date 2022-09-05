package xuejian1.DanDiaoStack_10;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author CXWWH
 * @create 2022-05-15-15:19
 * @
 **/
public class MyTest {

    public int[] getNums(int[] nums){

        int len = nums.length;
        int[] res = new int[len];
        boolean isChanged = false;

        for(int i = 0; i < len; i++){

            isChanged = false;
            for(int j = i+1; j < len; j++){

                if( nums[j] > nums[i]){

                    res[i] = nums[j];
                    isChanged = true;
                    break;
                }
            }

            if( !isChanged){

                res[i] = -1;
            }
        }

        return res;
    }

    public int[] getNums2(int[] nums){

        int len = nums.length;
        int[] res = new int[len];

        Stack<Integer> stack = new Stack<>();

        for(int i = len-1; i >= 0; i--){

            while( !stack.isEmpty() && stack.peek() <= nums[i]){

                stack.pop();
            }

            res[i] = stack.isEmpty()? -1 : stack.peek();

            stack.push(nums[i]);
        }

        return res;
    }


    @Test
    public void test(){

        int[] nums = {2,1,2,4,3};
        int[] nums1 = getNums2(nums);
        System.out.println(Arrays.toString(nums1));

    }

}
