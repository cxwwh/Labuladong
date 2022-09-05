package xuejian1.ArrayShuangZhiZhen_4;

/**
 * @author CXWWH
 * @create 2022-05-07-15:18
 * @
 **/
public class T167 {

    public int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length-1;

        while( left < right){

            int sum = numbers[left] + numbers[right];

            if( sum == target){

                return new int[]{left+1, right+1};
            }else if( sum > target){

                right--;
            }else if( sum < target){

                left++;
            }
        }

        return null;
    }
}
