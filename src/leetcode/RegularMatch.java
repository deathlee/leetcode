package leetcode;

import java.io.PrintWriter;

public class RegularMatch {
	public static void main(String args[]) {
		RegularMatch regularMatch=new RegularMatch();
		System.out.println(regularMatch.isMatch("aaaaaaaaaaaaab", "a*c"));
	}
    public boolean isMatch(String s, String p) {
        if(s=="")return false;
        if(p=="")return false;
        int idxs=0;
        int idxp=0;
        if(p.charAt(0)=='*')return false;
        char tmp='#';
        return checkMatch(s,p,idxs,idxp,tmp);
    }
    boolean checkMatch(String s, String p,int idxs,int idxp,char last){
        boolean flag=true;
        if(idxs==s.length())return true;
        if(idxp==p.length()&&idxs!=s.length())return false;
        if(p.charAt(idxp)=='*'){
            if(s.charAt(idxs)==last){
            	System.out.println("test1");
                return checkMatch(s,p,idxs+1,idxp,last)||checkMatch(s,p,idxs+1,idxp+1,last);
            }else{
                System.out.println("test2");
                return checkMatch(s,p,idxs,idxp+1,s.charAt(idxs));
            }
        }else{
        if(s.charAt(idxs)==p.charAt(idxp)||p.charAt(idxp)=='.'){
         idxs++;
         idxp++;
         System.out.println("test3");
            return checkMatch(s,p,idxs,idxp,s.charAt(idxs-1));
        }else{
            idxs=0;
            idxp++;
            System.out.println("test4");
            return checkMatch(s,p,idxs,idxp,s.charAt(idxs));
        }
        }
        
        
    }

}
