package leetcode;

public class RotateMatrix {
	public static void main(String args[]){
		RotateMatrix rotateMatrix=new RotateMatrix();
		int matrix[][]={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		rotateMatrix.rotate(matrix);
	}
    public void rotate(int[][] matrix) {
        int len=matrix.length;
        int col=len;
        for(int i=0;i<len/2;i++){
            
            for(int j=i;j<col-1;j++){
                //int tmp4=matrix[leftRow][leftCol];
                int leftRow=col-1-(j-i);
                int leftCol=i;
                int tmp=matrix[i][j];
                matrix[i][j]=matrix[leftRow][leftCol];
                int rightRow=j;
                int rightCol=col-1;
                int tmp1=matrix[rightRow][rightCol];
                matrix[rightRow][rightCol]=tmp;
                int downRow=len-1-i;
                int downCol=len-1-j;
                int tmp2=matrix[downRow][downCol];
                matrix[downRow][downCol]=tmp1;
                matrix[leftRow][leftCol]=tmp2;
            }
            col--;
        }
        
    }
   

}
