package sdu.edu.Algorithm;

import java.util.Hashtable;

/**
 * Java实现LRU算法
 */
public class LRUCache {

    private Hashtable<Integer, DLinkedNode> cache = new Hashtable<>();

    private int count;

    private int capacity;

    private DLinkedNode head, tail;

    public LRUCache(int capacity){

        this.capacity = capacity;

        head = new DLinkedNode();
        head.pre = null;

        tail = new DLinkedNode();
        tail.next = null;

        head.next = tail;
        tail.pre = head;

    }

    public int get(String key){
        DLinkedNode node = cache.get(key);
        if(key == null){
            return -1;
        }
        this.moveToHead(node);
        return node.value;
    }

    public void add(String key, int value){
        DLinkedNode node = cache.get(key);
        if(node == null){
            DLinkedNode newNode = new DLinkedNode();

            newNode.key = key;
            newNode.value = value;

            this.addNode(newNode);
            count++;
            if(count > capacity){
                DLinkedNode tail = this.popTail();
                this.cache.remove(tail);
                count--;
            }
        }else{
            node.value = value;
            this.moveToHead(node);
        }
    }

    public void moveToHead(DLinkedNode node){
        this.removeNode(node);
        this.addNode(node);
    }

    public void removeNode(DLinkedNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void addNode(DLinkedNode node){
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    public DLinkedNode popTail(){
        DLinkedNode node = tail.pre;
        this.removeNode(node);
        return node;
    }

}

class DLinkedNode{
    String key;
    int value;
    DLinkedNode pre;
    DLinkedNode next;
}