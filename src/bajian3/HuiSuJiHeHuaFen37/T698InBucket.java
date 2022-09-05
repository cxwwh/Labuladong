package bajian3.HuiSuJiHeHuaFen37;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CXWWH
 * @create 2022-07-27-8:29
 * @
 **/
public class T698InBucket {


    // 以桶的视角
    Map<Integer, Boolean> memo = new HashMap<>();
    public boolean canPartitionKSubsets(int[] nums, int k) {

        if( k > nums.length){

            return false;
        }

        // 计算数组中所有数字之和
        int sum = 0;
        for(int i = 0; i < nums.length; i++){

            sum += nums[i];
        }

        // 判断总和能否整分到k个桶中
        if( sum % k != 0){

            return false;
        }

        // 得到每个桶的目标和
        int target = sum / k;

        int start = 0;
        int used = 0;// 使用位图技巧，记录放入桶的结果

        return backTrack(nums, target, k, 0, start, used);
    }

    public boolean backTrack(int[] nums, int target, int k, int bucket, int start, int used){

        // 所有桶都装满了
        if( k == 0){

            return true;
        }

        // 当前桶装满了
        if( bucket == target){
            // 当前桶装满了，再去装下一个桶
            // 下一个桶的start还是0，从nums[0]开始装数字
            boolean res = backTrack(nums,target,k-1, 0,0, used);
            memo.put(used,res);
            return res;
        }

        if( memo.containsKey(used)){

            return memo.get(used);
        }

        // 给当前桶装数字
        for(int i = start; i < nums.length; i++){

            // nums[i]已经在桶中
            if( ((used>>i) & 1) == 1){

                continue;
            }

            if( bucket + nums[i] > target){

                continue;
            }

            // 做选择
            used |= (1 << i);
            bucket += nums[i];

            //递归穷举下一个数字是否装入当前桶
            if( backTrack(nums,target,k,bucket,i+1, used)){

                return true;
            }
            //撤销选择
            used ^= (1 << i);
            bucket -= nums[i];
        }

        return false;
    }
}
