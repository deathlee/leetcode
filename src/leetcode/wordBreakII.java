package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

public class wordBreakII {

	public static void main(String args[]) {
		wordBreakII wordBreakII=new wordBreakII();
		HashSet<String> dict=new HashSet<>();
		//add("cat");
		//dict.add("cats");
		//dict.add("and");
		//dict.add("sand");
		//dict.add("dog");
		dict.add("aaaa");
		dict.add("aaa");
		String s ="aaaaaaa";
		System.out.println(wordBreakII.wordBreak(s, dict));
		
	}
    public List<String> wordBreak(String s, Set<String> dict) {
        
        List<String> list=new ArrayList<>();
        boolean table[]=new boolean[s.length()+1];
        table[table.length-1]=true;
        int i=s.length()-1;

      // check values
      int max=0;
     for(String string:dict){
    	 if(string.length()>max){
    		 max=string.length();
    	 }
     }
        recursive(s,dict,i,list,table,max);
        return list;
    }
    boolean recursive(String s,Set<String> dict,int i,List<String> list, boolean table[],int max){
                for(int j=i;j>=0;j--){
                    if(i-j<=max){
                    if(dict.contains(s.substring(j,i+1))){
                    table[j]=true;
                    recursive(s,dict,j-1,list,table,max);
                    table[j]=false;
         
                }else{
                	continue;
                }}else{
                    break;
                }
                }
                if(table[0]==true){
                    StringBuilder builder=new StringBuilder("");
                    int record=0;
                    for(int k=0;k<table.length-1;k++){
                        if(table[k]==true){
                            builder.append(s.substring(record,k+1)+" ");
                            record=k+1;
                            //table[k]=false;
                        }
                    }
                    list.add(builder.toString().trim());
                    return true;
                }else{
                    return false;
                }
                
                
                
        
        
    }
    }
