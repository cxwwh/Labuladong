package bajian3.HuiSuZiJi_PaiLie_ZuHe38;

import java.util.LinkedList;
import java.util.List;

/**
 * @author CXWWH
 * @create 2022-08-25-10:52
 * @
 **/
public class T39 {

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    int trackSum = 0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        backTrack(candidates,0,target);
        return res;
    }

    public void backTrack(int[] nums, int start, int target){

        if( trackSum == target){

            res.add(new LinkedList<>(track));
            return;
        }

        if( trackSum > target){

            return;
        }
        for(int i = start; i < nums.length; i++){


            track.addLast(nums[i]);
            trackSum += nums[i];

            backTrack(nums, i, target);

            track.removeLast();
            trackSum -= nums[i];
        }
    }
}
