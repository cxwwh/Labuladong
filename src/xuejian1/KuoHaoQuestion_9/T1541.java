package xuejian1.KuoHaoQuestion_9;

import org.junit.Test;

/**
 * @author CXWWH
 * @create 2022-05-13-16:59
 * @
 **/
public class T1541 {

    public int minInsertions(String s) {

        int need = 0;
        int insert = 0;

        for(int i = 0; i < s.length(); i++){

            char c = s.charAt(i);
            if( c == '('){

                need+=2;

                if( need %2 == 1){

                    insert++;
                    need--;
                }
            }else{

                need--;

                if( need == -1){

                    insert++;
                    need++;
                }
            }
        }

        return need + insert;
    }

    @Test
    public void test(){

        String s = ")))))))";
        int i = minInsertions(s);
        System.out.println(i);
    }
}
