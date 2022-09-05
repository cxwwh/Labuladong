package xuejian1.ArrayShuangZhiZhen_4;

/**
 * @author CXWWH
 * @create 2022-05-05-15:14
 * @
 **/
public class T26 {

    public int removeDuplicates(int[] nums) {

        int len = nums.length;
        if( len <= 1){

            return len;
        }

        int slow = 0;
        int fast = 0;
        while( fast < len){

            if( nums[fast] != nums[slow]){

                slow++;
                nums[slow] = nums[fast];
            }

            fast++;
        }

        return slow+1;
    }
}
