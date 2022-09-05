package xuejian1.ErFenSearch_6;

/**
 * @author CXWWH
 * @create 2022-05-09-16:31
 * @
 **/
public class T35 {

    public int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length ;

        while( left < right){

            int mid = left + (right - left)/2;

            if(nums[mid] == target){

                right = mid;
            }else if( nums[mid] > target){

                right = mid;
            }else if( nums[mid] < target){

                left = mid + 1;
            }
        }

       return left;
    }
}
