package xuejian1.qianZhuiHe_1;

/**
 * @author CXWWH
 * @create 2022-04-27-22:08
 * @
 **/
public class T303 {

    class Numarray{

        int[] sumNums;

        public Numarray(int[] nums){

            sumNums = new int[nums.length+1];
            for(int i = 1; i < sumNums.length; i++){

                sumNums[i] = sumNums[i-1] + nums[i-1];
            }
        }

        public int sumRange(int left, int right){

            return sumNums[right+1] - sumNums[left];
        }
    }
}
