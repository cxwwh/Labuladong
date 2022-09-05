package xuejian1.ErFenSearch_6;

import org.junit.Test;

/**
 * @author CXWWH
 * @create 2022-05-08-13:55
 * @
 **/
public class Search {

    public int searchNum(int[] nums, int target){

        int i = 0;
        int j = nums.length-1;

        while(i <= j){

            int mid = i + (j-i)/2;

            if( nums[mid] == target){

                return mid;
            }else if(nums[mid] > target){

                j = mid - 1;
            }else if(nums[mid] < target){

                i = mid + 1;
            }
        }

        return -1;
    }

    public int leftBound(int[] nums, int target) {

        int i = 0;
        int j = nums.length - 1;

        while( i <= j){

            int mid = i + (j-i)/2;

            if( nums[mid] == target){

                j =  mid - 1;
            }else if(nums[mid] > target){

                j = mid - 1;
            }else if(nums[mid] < target){

                i = mid + 1;
            }
        }

        if( i >= nums.length || nums[i] != target){

            return -1;
        }
        return i;
    }

    public int leftBound2(int[] nums, int target){

        int left = 0;
        int right = nums.length;

        while( left < right){

            int mid = left + (right - left)/2;

            if( nums[mid] == target){

                right = mid;
            }else if( nums[mid] < target){

                left = mid + 1;
            }else if( nums[mid] > target){

                right = mid;
            }
        }

        System.out.println("left:" + left + "  right:" + right);
        if( left == nums.length){

            return -1;
        }
        return nums[left]==target? left : -1;
    }

    public int rightBound(int[] nums, int target){

        int i = 0;
        int j = nums.length - 1;

        while( i <= j){

            int mid = i + (j - i)/2;

            if( nums[mid] == target){

                i = mid + 1;
            }else if( nums[mid] > target){

                j = mid - 1;
            }else if( nums[mid] < target){

                i = mid + 1;
            }
        }

        if( j < 0 || nums[j] != target){

            return -1;
        }

        return j;
    }

    public int rightBound2(int[] nums, int target){

        int left = 0;
        int right = nums.length;

        while( left < right){

            int mid = left + (right - left)/2;

            int num = nums[mid];
            if( num == target){

                left = mid + 1;
            }else if( num < target){

                left = mid + 1;
            }else if( num > target){

                right = mid;
            }
        }

        System.out.println("left:" + left + "  right:" + right);
        if( right == 0){

            return -1;
        }
        return nums[right-1] == target? right-1 : -1;
    }
    @Test
    public void test(){

//        int[] nums = {1,2,3,3,3,3,3,3,3,4,5,5,6,9};
        int[] nums = {1,2,3,5,5,5,7,7,7};

        int i = rightBound2(nums, 5);
        System.out.println(i);
//        int index = searchNum(nums, 3);
//        int left = leftBound(nums,3);
//        int right = rightBound(nums,3);
//
//        System.out.println("search:" + index);
//        System.out.println("leftBound:" + left);
//        System.out.println("rightBound:" + right);
    }
}
