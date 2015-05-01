package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutate {
	public static void main(String args[]) {
		Permutate permutate=new Permutate();
		int num[]={0,1};
		permutate.permute(num);
	}
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> list=new ArrayList<>();
        int count=0;
        count++;
        for(int i=0;i<num.length;i++){
            
            boolean used[]=new boolean[num.length];
            used[i]=true;
            ArrayList<Integer> sublist=new ArrayList<>();
            sublist.add(num[i]);
            permutation(list,num,used,sublist,count);
            used[i]=false;
        }
        return list;
    }
    
    void permutation(List<List<Integer>> list,int[] num,boolean used[],ArrayList<Integer> sublist,int count){
        if(count==num.length)
        {
            list.add(sublist);
            return;
            
        }
        count++;
        for(int i=0;i<num.length;i++){
            if(used[i]==true){
                continue;
            }else{
                
                used[i]=true;
                ArrayList<Integer> cloneList = (ArrayList<Integer>)sublist.clone();
                cloneList.add(num[i]);
                permutation(list,num,used,cloneList,count);
                used[i]=false;
            }
        }
    }
        

}
