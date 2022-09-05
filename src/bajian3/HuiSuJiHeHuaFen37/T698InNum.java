package bajian3.HuiSuJiHeHuaFen37;

import java.util.Arrays;

/**
 * @author CXWWH
 * @create 2022-07-28-12:11
 * @
 **/
public class T698InNum {

    int[] bucket;
    public boolean canPartitionKSubsets(int[] nums, int k) {

        bucket = new int[k];
        int sum = 0;
        for(int i = 0; i < nums.length; i++){

            sum += nums[i];
        }

        if( sum % k != 0){

            return false;
        }

        int target = sum / k;

        // 将nums升序排序
        Arrays.sort(nums);
        for(int i = 0; i < nums.length / 2; i++){

            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }

        return backTrace(nums,target,0,k);
    }

    public boolean backTrace(int[] nums, int target, int index, int k){

        if( index == nums.length){

            for(int i = 0; i < k; i++){

                if( bucket[i] != target){

                    return false;
                }
            }

            return true;
        }

        // 遍历每一个桶，看看nums[index]应该装进哪个桶里面
        for(int i = 0; i < k; i++){

            if(bucket[i] + nums[index] > target){

                continue;
            }

            bucket[i] += nums[index];

            // 递归穷举下一个数字
            // 如果这条路走得通，那么就不需要从桶中取出nums[index]这个数字，直接返回true即可
            if( backTrace(nums,target,index+1, k)){

                return true;
            }
            bucket[i] -= nums[index];
        }

        // nums[index]不能放入任何一个桶
        return false;
    }
}
