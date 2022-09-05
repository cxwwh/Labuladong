package xuejian1.LRU_13;

import java.util.LinkedHashMap;

/**
 * @author CXWWH
 * @create 2022-05-18-22:42
 * @
 **/
public class T146 {

    private int capacity;
    private LinkedHashMap<Integer,Integer> cache;

    public T146(int capacity) {

        this.capacity = capacity;
        cache = new LinkedHashMap<>();
    }

    public int get(int key) {

        if( !cache.containsKey(key)){

            return -1;
        }

        makeRencently(key);
        return cache.get(key);
    }

    public void put(int key, int value) {

        if( cache.containsKey(key)){

            cache.put(key,value);
            makeRencently(key);
            return;
        }

        if( cache.size() == capacity){

            //如果cache已经满了
            //那么链表头部就是最久未使用的
            Integer oldKey = cache.keySet().iterator().next();

            cache.remove(oldKey);
        }

        //添加到链表尾部就是保持最新使用
        cache.put(key,value);
    }

    //让当前key保持最近使用
    public void makeRencently(int key){

        Integer integer = cache.get(key);
        cache.remove(key);
        //添加到链表尾部就是保持最新使用
        cache.put(key,integer);
    }
}
