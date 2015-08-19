package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permutationUnique {
	public static void main(String args[]){
		permutationUnique permutationUnique=new permutationUnique();
		int nums[]={1,1};
		permutationUnique.permuteUnique(nums);
	}
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        int count=0;
        count++;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            
            boolean used[]=new boolean[nums.length];
            used[i]=true;
            ArrayList<Integer> sublist=new ArrayList<>();
            sublist.add(nums[i]);
            permutation(list,nums,used,sublist,count,i);
            used[i]=false;
        }
        return list;
    }
    void permutation(List<List<Integer>> list,int[] num,boolean used[],ArrayList<Integer> sublist,int count,int id){
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
            	if(num[id]==num[i]&&i<id){
                    used[i]=true;
                    continue;
                }
                used[i]=true;
                ArrayList<Integer> cloneList = (ArrayList<Integer>)sublist.clone();
                cloneList.add(num[i]);
                permutation(list,num,used,cloneList,count,i);
                used[i]=false;
            }
        }
    }

}
