package bajian3.HuiSuSiLu36;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CXWWH
 * @create 2022-07-26-10:18
 * @
 **/
public class T46 {

    List<List<Integer>> res  = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        ArrayList<Integer> track  = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        backTrack(nums, track, used);
        return res;
    }

    public void backTrack(int[] nums, ArrayList<Integer> track, boolean[] used){

        //如果路径track中包含了全部数字
        if( nums.length == track.size()){

            //res.add(track);
            res.add(new ArrayList(track));
            return;
        }

        for(int i = 0; i < nums.length; i++){

            // 说明此时nums[i]已经在track中
            if( used[i]){

                continue;
            }

            // 做选择
            track.add(nums[i]);
            used[i] = true;

            // 进入下一层决策树
            backTrack(nums,track,used);

            // 撤销选择
            track.remove(nums[i]);
            used[i] = false;
        }
    }
}
