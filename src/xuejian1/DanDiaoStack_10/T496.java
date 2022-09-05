package xuejian1.DanDiaoStack_10;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author CXWWH
 * @create 2022-05-15-16:29
 * @
 **/
public class T496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int len1 = nums1.length;
        int len2 = nums2.length;

        int[] res = new int[len1];

        Map<Integer, Integer> map = new HashMap<>();
        boolean isChanged = false;

        for(int i = 0; i < len2; i++){

            map.put(nums2[i], i);
        }

        for(int i = 0; i < len1; i++){

            isChanged = false;

            for(int j = map.get( nums1[i] )+1; j < len2; j++){

                if( nums2[j] > nums1[i]){

                    res[i] = nums2[j];
                    isChanged = true;
                    break;
                }
            }

            if( !isChanged){

                res[i] = -1;
            }
        }

        return res;
    }

    @Test
    public void test() {

        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};

        int[] res = nextGreaterElement(nums1, nums2);

        System.out.println(Arrays.toString(res));
    }
}
