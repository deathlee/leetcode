package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
		public static void main(String args[]){
			Queue<Integer> queue=new LinkedList<Integer>();
			queue.add(1);
	        int size=queue.size();
	        for(int i=0;i<size;i++){
	            if(i!=queue.size()-1){
	                queue.add(queue.poll());
	            }
	        }
	        System.out.println(queue.isEmpty());
		}
}
