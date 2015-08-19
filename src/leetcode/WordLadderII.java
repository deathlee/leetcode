package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadderII {
		public static void main(String args[]) {
			WordLadderII wordLadderII=new WordLadderII();
			String beginWord="hot";
			String endWord="dog";
			Set<String> wordDict=new HashSet<>();
			wordDict.add("hot");
			wordDict.add("dot");
			wordDict.add("dog");
			wordDict.add("cog");
			wordDict.add("tot");
			wordDict.add("hog");
			wordDict.add("hop");
			wordDict.add("pot");
			System.out.println(wordLadderII.findLadders(beginWord, endWord, wordDict));
		}

	    int min=Integer.MAX_VALUE;
	    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
	         List<List<String>> res=new ArrayList<List<String>>();
	         List<String> tmp=new ArrayList<String>();
	         tmp.add(start);
	         backTracking(res,tmp,start,end,dict,0);
	         return res;
	    }
	    void backTracking(List<List<String>> res,List<String> tmp,String start,String end,Set<String> dict,int level){
	            if(level>=min){
	                return;
	            }
	            char[] t = start.toCharArray();
	            for (int i = 0; i < start.length(); i++) {
	            	StringBuilder builder = new StringBuilder(start); 
	            for(char c='a';c<='z';c++){
	            	 //char temp = t[i];
	                 //t[i] = c;
	                 //String s = String.copyValueOf(t);
	                 //t[i] = temp;
	                 builder.setCharAt(i,c);
	                    String s=builder.toString();   
	                 System.out.println(level);
	                 if(s.equals(end)){
	                     List<String> newtmp=new ArrayList<String>(tmp);
	                     newtmp.add(s);
	                     int newl=level+1;
	                     if(min>=newl){
	                         min=newl;
	                        while(res.size()-1>=0&&res.get(res.size()-1).size()>newtmp.size())
	                         {
	                         res.remove(res.size()-1);
	                         }
	                             res.add(newtmp);
	                     }
	                     return;
	                 }
	                 if(dict.contains(s)){
	                	 dict.remove(s);
	                     int newl=level+1;
	                     tmp.add(s);
	                     backTracking(res,tmp,s,end,dict,newl);
	                     tmp.remove(s);
	                     dict.add(s);
	                 }
	            }
	            }
	        
	    }

}
