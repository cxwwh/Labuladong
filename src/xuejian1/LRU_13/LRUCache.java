package xuejian1.LRU_13;


import java.util.HashMap;
import java.util.Map;

/**
 * @author CXWWH
 * @create 2022-05-18-21:16
 * @
 **/
// T146
public class LRUCache {

        private int capacity;
        private Map<Integer,Node> map;
        private DoubleList cache;

        public LRUCache(int capacity) {

                this.capacity = capacity;
                map = new HashMap<>();
                cache = new DoubleList();
        }

        public int get(int key) {

                if( !map.containsKey(key)){

                        return -1;
                }

                makeRencentlyUsed(key);
                return map.get(key).val;
        }

        public void put(int key, int value) {

                if( map.containsKey(key)){

                        //将其删除
                        deleteKey(key);
                        //在添加进去
                        addRecently(key,value);
                        return;
                }

                if( cache.getSize() == capacity){

                        removeLastRecently();
                }

                addRecently(key,value);
        }

        //将最近使用的放到最后位置
        public void makeRencentlyUsed(int key){

                Node node = map.get(key);

                cache.remove(node);

                cache.addLast(node);
        }

        //添加最近使用的元素
        public void addRecently(int key, int val){

                Node node = new Node(key,val);

                map.put(key,node);

                cache.addLast(node);
        }

        //删除某一个key
        public void deleteKey(int key){

                Node node = map.get(key);
                map.remove(key);

                cache.remove(node);
        }

        //删除最久未使用的元素
        public void removeLastRecently(){

                Node first = cache.removeFirst();
                map.remove(first.key);
        }
}
