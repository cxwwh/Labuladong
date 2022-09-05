package xuejian1.ArrayShuangZhiZhen_4;

/**
 * @author CXWWH
 * @create 2022-05-07-15:44
 * @
 **/
public class T344 {

    public void reverseString(char[] s) {

        int left = 0;
        int right = s.length-1;

        while( left < right){

            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }
}
