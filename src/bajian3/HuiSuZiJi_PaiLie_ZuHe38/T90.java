package bajian3.HuiSuZiJi_PaiLie_ZuHe38;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author CXWWH
 * @create 2022-08-24-13:41
 * @
 **/
public class T90 {

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        backTrack(nums, 0);
        return res;
    }

    public void backTrack(int[] nums, int start){

        res.add(new LinkedList<>(track));

        for(int i = start; i < nums.length; i++){

            // 剪枝
            // [1 2 2]
            // 比如当执行backTrack(nums, 1)时，执行完backTrack(nums, 2)回溯到这里
            // 下一轮for循环，i=2,发现满足if条件，那么就不用去执行了
            if( i > start && nums[i] == nums[i-1]){

                continue;
            }

            track.addLast( nums[i]);
            backTrack(nums,i+1);
            track.removeLast();
        }
    }
}
