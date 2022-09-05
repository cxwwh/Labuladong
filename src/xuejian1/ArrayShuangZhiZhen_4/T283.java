package xuejian1.ArrayShuangZhiZhen_4;

/**
 * @author CXWWH
 * @create 2022-05-05-15:41
 * @
 **/
public class T283 {

    public void moveZeroes(int[] nums) {

        int slow = 0;
        int fast = 0;

        while( fast < nums.length){

            if( nums[fast] != 0){

                nums[slow] = nums[fast];
                slow++;
            }

            fast++;
        }

        for(int i = slow; i < nums.length; i++){

            nums[i] = 0;
        }
    }
}
