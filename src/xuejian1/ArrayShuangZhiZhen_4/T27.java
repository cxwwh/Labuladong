package xuejian1.ArrayShuangZhiZhen_4;

/**
 * @author CXWWH
 * @create 2022-05-05-15:37
 * @
 **/
public class T27 {

    public int removeElement(int[] nums, int val) {

        int len = nums.length;
        if( len == 0){

            return 0;
        }

        int slow = 0;
        int fast = 0;

        while( fast < len){

            if( nums[fast] != val){

                nums[slow] = nums[fast];
                slow++;
            }

            fast++;
        }

        return slow;
    }
}
