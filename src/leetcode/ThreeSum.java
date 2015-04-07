package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {
	public static void main(String args[]) {
		ThreeSum ThreeSum=new ThreeSum();
		int num[]={-2,0,1,1,2};
		System.out.print(ThreeSum.threeSum(num));
	}

    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> record=new ArrayList<List<Integer>>();
        HashSet<Integer> dupIndex=new HashSet<>();
        for(int i=0;i<num.length-1;i++){
            int low=1;
            int high=num.length-1;
            if(dupIndex.contains(i))continue;
            if(i!=0&&(i+1)<num.length-1&&num[i]==num[i+1])continue;
            if(i==low&&i==high)continue;
            while(low<high){
                if(num[low]+num[high]==-num[i]){
                    
                    List<Integer> tmp=new ArrayList<Integer>();
                    tmp.add(num[i]);
                    tmp.add(num[low]);
                    tmp.add(num[high]);
                    record.add(tmp);
                    dupIndex.add(i);
                    while(num[low]==num[low+1]&&low+1<high){
                        low++;
                    }
                    while(num[high]==num[high-1]&&high-1>low){
                        high--;
                    }
                    low++;
                }else if(num[low]+num[high]>-num[i]){
                    high--;
                }else{
                    low++;
                }
            }
            
        }
        return record;
    }

}
