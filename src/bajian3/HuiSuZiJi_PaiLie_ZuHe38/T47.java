package bajian3.HuiSuZiJi_PaiLie_ZuHe38;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author CXWWH
 * @create 2022-08-25-10:27
 * @
 **/
public class T47 {

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);
        used = new boolean[nums.length];
        backTrack(nums);
        return res;
    }

    public void backTrack(int[] nums){

        if( track.size() == nums.length){

            res.add(new LinkedList<>(track));
            return;
        }

        for(int i = 0; i < nums.length; i++){

            if( used[i]){

                continue;
            }

            // 保证重复元素在排列中的相对位置是一致的
            if( i > 0 && (nums[i] == nums[i-1]) && !used[i-1]){

                continue;
            }

            track.addLast(nums[i]);
            used[i] = true;

            backTrack(nums);

            track.removeLast();
            used[i] = false;
        }
    }
}
