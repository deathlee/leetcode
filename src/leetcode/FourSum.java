package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	public static void main(String args[]) {
		int nums[]={0,0,0,0};
		int target=0;
		System.out.println(fourSum(nums, target));
	}

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++){
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            for(int j=i+1;j<nums.length-2;j++){
                if(j>i+1&&nums[j]==nums[j-1]){
                    continue;
                }
                int low=j+1;
                int high=nums.length-1;
                while(low<high){
                    if(nums[i]+nums[j]+nums[low]+nums[high]==target){
                        List<Integer> tmp=new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[low]);
                        tmp.add(nums[high]);
                        result.add(tmp);
                        low=low+1;
                        high=high-1;
                        while(nums[high]==nums[high+1]&&low<high){
                        high=high-1;
                        }
                        while(nums[low]==nums[low-1]&&low<high){
                        low=low+1;
                        }
                    }else if(nums[i]+nums[j]+nums[low]+nums[high]>target){
                        high=high-1;
                    }else{
                        low=low+1;
                    }
                }
            }
        }
        return result;
    }

}
