package bajian3.HuiSuZiJi_PaiLie_ZuHe38;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author CXWWH
 * @create 2022-08-24-13:54
 * @
 **/
public class T40 {

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    int trackSum = 0;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        backTrack(candidates, target, 0);
        return res;
    }

    public void backTrack(int[] nums, int target, int start){

        if( trackSum == target){

            res.add(new LinkedList<>(track));
            return;
        }

        for(int i = start; i < nums.length; i++){

            if( i > start && nums[i] == nums[i-1]){

                continue;
            }

            // 如果出现这种情况，立即返回
            if( (trackSum + nums[i]) > target){

                return;
            }

            trackSum += nums[i];
            track.addLast(nums[i]);

            backTrack(nums, target, i+1);

            trackSum -= nums[i];
            track.removeLast();
        }
    }
}
