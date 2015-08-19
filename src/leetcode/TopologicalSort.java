package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort {
	public static void main(String args[]) {
		int [][]prerequisites={{1,0}};
		canFinish(2, prerequisites);
	}
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length==0)return false;
        int degree[]=new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            degree[prerequisites[i][0]]++;
        }
        Queue<Integer> node=new LinkedList<Integer>();
        for(int i=0;i<degree.length;i++){
            if(degree[i]==0){
                node.add(i);
            }
        }
        
        while(!node.isEmpty()){
            Integer n=node.poll();
            for(int i=0;i<prerequisites.length;i++){
                int in=prerequisites[i][0];
                if(prerequisites[i][1]==n){
                    degree[in]--;
                    if(degree[in]==0){
                        node.add(in);
                    }
                }
            }
        }
        for (int i=0;i<degree.length;i++){
            if(degree[i]!=0){
                return false;
            }
        }
        return true;
    }

}
