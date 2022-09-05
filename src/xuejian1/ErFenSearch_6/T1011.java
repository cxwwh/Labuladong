package xuejian1.ErFenSearch_6;

import org.junit.Test;

/**
 * @author CXWWH
 * @create 2022-05-09-15:29
 * @
 **/
public class T1011 {

    public int shipWithinDays(int[] weights, int days) {

        int left = 0;
        int right = 1;

        for (int w : weights) {

            left = Math.max(left,w);
            right += w;
        }

        while( left < right){

            int mid = left + (right - left)/2;
            int d = fx(weights,mid);

            if(d == days){

                right = mid;
            }else if( d < days){

                right = mid;
            }else if( d >days){

                left = left + 1;
            }
        }

        return left;
    }

    public int fx(int[] nums, int k){

        int result = 0;
        for(int i = 0; i < nums.length;){

            //每天初始化船的装载量
            int cap = k;

            //如果现在剩余的装载量大于当前货物的重量
            //那么就装上这件货物，更新装载量 cap -= nums[i];
            //然后i++，判断还能不能装下下一件货物
            //如果不能，那么就说明今天已经装不下了，退出，然后天数+1
            while(i < nums.length){

                if( cap >= nums[i]){

                    cap -= nums[i];
                    i++;//注意在这里更新货物，for循环中就不要写i++了
                }else{

                    break;//这时，船已经装不下 下一件货物了
                }
            }

            result++;//更新天数
        }
        return result;
    }

    @Test
    public void test(){

        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        int[] nums2 = {3,2,2,4,1,4};
        int[] nums3 = {1,2,3,1,1};

        int days = 3;
        int k = 3;
        int fx = fx(nums3, k);
        System.out.println(fx);

//        int days1 = shipWithinDays(nums3, days);
//        System.out.println(days1);
    }
}
