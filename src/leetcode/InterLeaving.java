package leetcode;

public class InterLeaving {
	public static void main(String args[]) {
		InterLeaving interLeaving=new InterLeaving();
		String s1="a";
		String s2="b";
		String s3="ab";
		System.out.println(interLeaving.isInterleave(s1, s2, s3));
	}
    public boolean isInterleave(String s1, String s2, String s3) {
        
        int m=s1.length();
        int n=s2.length();
        if((m+n)!=s3.length())return false;
        boolean table[][]=new boolean[n+1][m+1];
        table[0][0]=true;
        for(int i=1;i<m+1;i++){
            table[0][i]=table[0][i-1]&&((s3.charAt(i-1)==s1.charAt(i-1))?true:false);
        }
        for(int i=1;i<n+1;i++){
            table[i][0]=table[i-1][0]&&(s3.charAt(i-1)==s2.charAt(i-1)?true:false);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(table[i][j+1]&&(s3.charAt(i+j+1)==s2.charAt(i))||table[i+1][j]&&(s3.charAt(i+j+1)==s1.charAt(j))){
                    table[i+1][j+1]=true;
                }
                else{
                    table[i+1][j+1]=false;
                }
            }
        }
        return table[n][m];
    }

}
