package leetcode;

import java.util.HashMap;

class MyLinkedList{
    int key;
    int value;
    MyLinkedList pre;
    MyLinkedList next;
    
}
 class LRUCache {
    int capacity;
    HashMap<Integer,MyLinkedList> cache=new HashMap<>();
    MyLinkedList head;
    MyLinkedList tail;
    int count;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.count=0;
        head=new MyLinkedList();
        tail=new MyLinkedList();
        head.next=tail;
        tail.pre=head;
        
    }
    public void moveToHead(MyLinkedList node){
        MyLinkedList tmp=head.next;
        head.next=node;
        node.pre=head;
        node.next=tmp;
        tmp.pre=node;
       
    }
    public int get(int key) {
        if(cache.containsKey(key)){
            MyLinkedList node=cache.get(key);
            moveToHead(node);
            return node.value;
        }else{
            return -1;
        }
    }
    public MyLinkedList removeTail(){
        MyLinkedList tmp=tail.pre;
        tail.pre=tmp.pre;
        tmp.pre.next=tail;
        return tmp;
    }
    
    public void set(int key, int value) {
        if(cache.containsKey(key)){
            MyLinkedList node=cache.get(key);
            node.value=value;
            moveToHead(node);
        }else{
            MyLinkedList node=new MyLinkedList();
            node.value=value;
            node.key=key;
            cache.put(key,node);
            moveToHead(node);
            count++;
            if(count>capacity){
                MyLinkedList tmp=removeTail();
                cache.remove(tmp.key);
                count--;
            }
        }
    }
}
public class TestCache {
	public static void main(String args[]) {
		LRUCache lruCache =new LRUCache(2);
		lruCache.set(2, 1);
		lruCache.set(1,1);
		lruCache.get(2);
		lruCache.set(4,1);
		lruCache.get(1);
		lruCache.get(2);
	}
}
