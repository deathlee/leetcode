package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinWin {
	public static void main(String args[]) {
		MinWin minWin=new MinWin();
		System.out.println(minWin.minWindow("adobecodebanc", "abcda"));
	}

    public String minWindow(String S, String T) {
        if(T.length()>S.length())return "";
        HashMap<Character,Integer> set=new HashMap<>();
        int cc=0;
        int xx=0;
        for(int i=0;i<T.length();i++){
            if(!set.containsKey(T.charAt(i)))
                {
                    set.put(T.charAt(i),1);
                }else{
                    set.put(T.charAt(i),set.get(T.charAt(i))+1);
                    cc++;
                }
        }
        HashMap<Character,Integer> record=new HashMap<>();
        List<Integer> str=new ArrayList<>();
        int count=Integer.MAX_VALUE;
        int min=0;
        int max=0;
        for(int i=0;i<S.length();i++){
            if(set.containsKey(S.charAt(i))){
                if(!record.containsKey(S.charAt(i))){
                    
                    record.put(S.charAt(i),1);
                    str.add(i);
                    if(record.size()==set.size()){
                     if((i+1-str.get(0))<count){
                         min=str.get(0);
                         max=i+1;
                         count=i+1-str.get(0);
                     }   
                    }
                }else{
                	 record.put(S.charAt(i),record.get(S.charAt(i))+1);
                	 str.add(i);
                    if(record.get(S.charAt(i))>=set.get(S.charAt(i))){
                    xx++;
                    if(S.charAt(str.get(0))==S.charAt(i))
                    {
                        int c=0;
                    	while(record.get(S.charAt(str.get(c)))>set.get(S.charAt(str.get(c))))
                    	{
                    	
                    	record.put(S.charAt(str.get(c)),record.get(S.charAt(str.get(c)))-1);
                    	str.remove(c);
                    	
                    	}
                    	
                    }
                    if(xx==cc&&str.size()>=T.length()){
                        if((i+1-str.get(0))<count){
                            min=str.get(0);
                            max=i+1;
                            count=i+1-str.get(0);
                        }   
                       }
                    
                    
                    }
                }
            }
        }
        if(str.size()>=T.length()){
            if((str.get(str.size()-1)-str.get(0))<count){
                min=str.get(0);
                max=str.get(str.size()-1)+1;
            }   
           }
        return S.substring(min,max);
    }

}
