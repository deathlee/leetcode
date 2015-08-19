package leetcode;

public class SpiralMatrix {
	public static void main(String args[]) {
		SpiralMatrix spiralMatrix=new SpiralMatrix();
		spiralMatrix.generateMatrix(2);
	}
    public int[][] generateMatrix(int n) {
        if(n==0)return new int[0][0];
        if(n==1)
        {
            int res[][]=new int[1][1];
            res[0][0]=1;
            return res;
        }
        int num=1;
        int len=n*n;
        int res[][]=new int[n][n];
        int up=1;
        int down=n;
        int left=0;
        int right=n;
        int i=0;
        int j=0;
        while(num<=len){
            while(j<right&&num<=len){
                res[i][j]=num;
                num++;
                j++;
            }
            right=right-1;
            j=j-1;
            i++;
            while(i<down&&num<=len){
                res[i][j]=num;
                num++;
                i++;
            }
            i=i-1;
            j--;
            while(j>=left&&num<=len){
                res[i][j]=num;
                num++;
                j--;
            }
            left=left+1;
            j=j+1;
            i--;
            while(i>=up&&num<=len){
                res[i][j]=num;
                num++;
                i--;
            
            }
       
            up=up+1;
            i=i+1;
            j++;
        }
        return res;
    }

}
