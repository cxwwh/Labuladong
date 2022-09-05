package xuejian1.ErFenSearch_6;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CXWWH
 * @create 2022-05-10-16:32
 * @
 **/
public class T392 {

    public boolean isSubsequence(String s, String t) {

        //处理特殊情况
        if( s.length() == 0){

            return  true;
        }

        int i = 0;
        for(int j = 0; j < t.length(); j++){

            //如果此时匹配，那么就让i++
            if( t.charAt(j)== s.charAt(i)){

                i++;
                //这时候就说明判断完了
                if( i == s.length()){

                    return true;
                }
            }
        }
        return false;
    }

    //二分查找做法：
    public boolean isSubsequence2(String s, String t) {

        //处理特殊情况
        if (s.length() == 0) {

            return true;
        }

        //把t中各个字符出现的索引放到ArrayList中
        //最终构成一个ArrayList数组
        //ascii码的最大值为255
        //在这里，ascii是作为索引出现的
        ArrayList<Integer>[] index = new ArrayList[256];
        for(int i = 0; i < t.length(); i++){

            char c = t.charAt( i );
            if( index[c] == null){

                index[c] = new ArrayList<>();
            }

            index[c].add(i);
        }

        //开始从t中的起始索引开始查找
        int j = 0;
        for(int i = 0; i < s.length(); i++){

            char c = s.charAt(i);

            //说明t中没有字符c
            if( index[c] == null){

                return false;
            }

            // 从字符c在t中出现的索引数组中查找j的左侧边界
            //如果目标值j在数组中，那么返回的是j的左侧边界
            //如果目标值j比数组中的所有元素都小，那么会返回0
            //如果目标值j比数组中的所有元素都大，那么会返回arr.size
            //也就代表着数组中小于目标值的元素的个数
            int pos = leftBound(index[c], j);
            //说明j比字符c在t中出现的位置都要大
            //那么就不能构成子序列了
            if( pos == index[c].size()){

                return false;
            }

            //更新要在t中开始查找的索引位置
            j = index[c].get(pos) + 1;
        }

        return true;
    }

    //arr为待查找的字符在t中出现的索引集合，按从小到大的顺序排列
    //tar为即将要扫描的t的索引
    //如果该字符在t中出现的索引都比tar小，那么说明不能构成子序列
    //此时，返回的式arr中小于tar的元素的个数，即arr.size

    //寻找左侧边界的二分查找算法的返回值含义：
    //如果目标值在数组中，那么返回的是他的左侧边界
    //如果目标值比数组中的所有元素都小，那么会返回0
    //如果目标值比数组中的所有元素都大，那么会返回arr.size
    //也就代表着数组中小于目标值的元素的个数
    public int leftBound(ArrayList<Integer> arr, int tar){

        int left = 0;
        int right = arr.size();

        while( left < right){

            int mid = left + (right - left)/2;

            if( arr.get(mid) == tar){

                right = mid;
            }else if( arr.get(mid) < tar){

                left = mid + 1;
            }else if( arr.get(mid) > tar){

                right = mid;
            }
        }

        return left;
    }


    //5.11日复习
    public boolean isSubsequence3(String s, String t) {

        if( s.length() == 0){

            return true;
        }

        int j = 0;
        for(int i = 0; i < t.length(); i++){

            if( t.charAt(i) == s.charAt(j)){

                j++;
                if(j == s.length()){

                    return true;
                }
            }
        }

        return false;
    }


    public boolean isSubsequence4(String s, String t) {

        ArrayList<Integer>[] index = new ArrayList[256];
        for(int i = 0; i < t.length(); i++){

            char c = t.charAt(i);

            if( index[c] == null){

                index[c] = new ArrayList<>();
            }

            index[c].add(i);
        }

        int j = 0;
        for(int i = 0; i < s.length(); i++){

            char c = s.charAt(i);

            if( index[c] == null){

                return false;
            }

            int pos = leftBound2(index[c], j);
            if( pos == index[c].size()){

                return false;
            }

            j = index[c].get(pos) + 1;
        }

        return true;
    }

    public int leftBound2(List<Integer> list, int tar){

        int left = 0;
        int right = list.size();

        while( left < right){

            int mid = left + (right - left)/2;

            if( list.get(mid) == tar){

                right = mid;
            }else if( list.get(mid) > tar){

                right = mid;
            }else if( list.get(mid) < tar){

                left = mid + 1;
            }
        }

        return left;
    }
    @Test
    public void test(){

//        String s = "abc", t = "ahbgdc";

        String s = "axc", t = "ahbgdc";
        boolean subsequence = isSubsequence(s, t);
        System.out.println(subsequence);

    }
}
