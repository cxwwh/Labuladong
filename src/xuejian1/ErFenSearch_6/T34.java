package xuejian1.ErFenSearch_6;

import org.junit.Test;

/**
 * @author CXWWH
 * @create 2022-05-08-14:24
 * @
 **/
public class T34 {

    public int[] searchRange(int[] nums, int target) {

        int i = 0;
        int j = nums.length - 1;

        int[] result = new int[2];
        //寻找左侧边界
        while( i <= j){

            int mid = i + (j - i)/2;

            if( nums[mid] == target){

                j = mid - 1;
            }else if( nums[mid] > target){

                j = mid - 1;
            }else if( nums[mid] < target) {

                i = mid + 1;
            }
        }

        if( i >= nums.length || nums[i] != target){
            result[0] = -1;
        }else{

            result[0] = i;
        }

        i= 0;
        j = nums.length - 1;
        //寻找右侧边界
        while( i <= j){

            int mid = i + (j - i)/2;

            if( nums[mid] == target){

                i = mid + 1;
            }else if( nums[mid] > target){

                j = mid - 1;
            }else if( nums[mid] < target) {

                i = mid + 1;
            }
        }

        if( j < 0 || nums[j] != target){
            result[1] = -1;
        }else{

            result[1] = j;
        }

        return result;
    }

    @Test
    public void test(){

        int[] nums = {1,2,3,3,3,3,3,3,3,4,5,5,6,9};
        int[] res = searchRange(nums,3);

        for (int re : res) {
            System.out.println(re);
        }
    }
}
