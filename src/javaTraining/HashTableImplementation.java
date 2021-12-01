package javaTraining;

import java.util.ArrayList;
import java.util.Objects;

class HashNode{
	Integer key;
	String value;
	HashNode next;
	HashNode(Integer key,String value){
		this.key=key;
		this.value=value;
	}
}
public class HashTableImplementation {
	
	private ArrayList<HashNode> buckets;
	private int capacity;
	private int size;
	private double loadFactor = 0.75;
	public HashTableImplementation(int m,double lf) {
		buckets = new ArrayList<>();
		capacity = m;
		size=0;
		loadFactor=lf;
		for(int i=0;i<capacity;i++) buckets.add(null);
		
	}
	 //generate index using hashFuction
	private int getIndex(Integer key) {
		int hashCode = Objects.hashCode(key);
		
		return hashCode % capacity;
	}
	//add pair (key,value)
	public void add(Integer key,String value) {
		int index = getIndex(key);
		HashNode head = buckets.get(index);
		while(head!=null ) {
			if(head.key.equals(key)) {
				head.value=value;
				return;
			}
			head=head.next;
		}
		size++;
		HashNode node = new HashNode(key, value);
		node.next=head;
		buckets.set(index, node);
		
		 if (size / capacity >= loadFactor) {
	            ArrayList<HashNode> temp = buckets;
	            buckets = new ArrayList<>();
	            capacity = 2 * capacity;
	            size = 0;
	            for (int i = 0; i < capacity; i++)
	                buckets.add(null);
	 
	            for (HashNode headNode : temp) {
	                while (headNode != null) {
	                    add(headNode.key, headNode.value);
	                    headNode = headNode.next;
	                }
	            }}
		 
		
	}
	public String get(Integer key) {
		int index = Objects.hashCode(key);
		HashNode head = buckets.get(index);
		while(head!=null) {
			if(head.key.equals(key)) return head.value;
			head=head.next;
		}
		return null;
		
	}
	public String remove(Integer key) {
		int index = Objects.hashCode(key);
		HashNode head = buckets.get(index);
		HashNode prev =null;
		while(head!=null) {
			if(head.key.equals(key)) break;
			prev =head;
			head=head.next;
		}
		if (head == null)
            return null;
        size--;
        if(prev !=null) 
        	 prev.next = head.next;
             else
            	 buckets.set(index, head.next);
      
             return head.value;
        }
	
	public static void main(String[] args) {
		HashTableImplementation map = new HashTableImplementation(20,0.75);
        map.add(1,"nouha");
        map.add(2,"NOUHAA");
        map.add(4,"this");
        map.add(5,"hi");
        System.out.println(map.remove(4));
        System.out.println(map.remove(1));
	}

}
