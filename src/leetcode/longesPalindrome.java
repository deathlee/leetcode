package leetcode;

public class longesPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		longesPalindrome longesPalindrome=new longesPalindrome();
		System.out.println(longesPalindrome.longestPalindrome("ccc"));
	}


    public String longestPalindrome(String s) {
        char newstr[]=addNoise(s.toCharArray());
        int len=newstr.length;
        int radius[]=new int[len];
        int idx=0;
        int mx=0;
        radius[0]=1;
        for(int i=1;i<len;i++){
            if(mx-i>0){
            	if((mx-i)>(radius[2*idx-i]-1)){
                radius[i]=radius[2*idx-i];
                continue;
                }else{
                	radius[i]=mx-i+1;
                }
            }else{
                radius[i]=1;
            }
            while(radius[i]<=i&&radius[i]+i<len&&newstr[i+radius[i]]==newstr[i-radius[i]]){
                radius[i]=radius[i]+1;
            }
            if(i+radius[i]-1>mx){
                idx=i;
                mx=i+radius[i]-1;
            }
        }
        int max=0;
        int index=0;
        for(int i=0;i<len;i++){
            if(radius[i]>max){
                max=radius[i];
                index=i;
            }
        }
        StringBuilder str=new StringBuilder("");
        for(int i=index-max+1;i<index+max;i++){
            str.append(newstr[i]);
        }
        String result=str.toString().replaceAll("#","");
        return result;
    }
    char[] addNoise(char array[]){
        int len=array.length*2+1;
        char[] newstr=new char[len];
        for(int i=0;i<len-1;i+=2){
            newstr[i]='#';
            newstr[i+1]=array[i/2];
        }
        newstr[len-1]='#';
        return newstr;
    }
   

}
