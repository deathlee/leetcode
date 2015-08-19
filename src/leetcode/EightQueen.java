package leetcode;

import java.util.ArrayList;
import java.util.List;

public class EightQueen {
	public static void main(String args[]) {
		EightQueen eightQueen=new EightQueen();
		System.out.println(eightQueen.solveNQueens(9).size());
		
	}
    public List<String[]> solveNQueens(int n) {
        List<String[]> result=new ArrayList<>();
    	for (int i = 0; i < n; i++) {
				int count=1;
				int board[][]=new int[n][n];
		        int visited[][]=new int[n][n];
				board[0][i]=1;
				visited[0][i]=1;
				backTracking(visited,board,count,result,1);
				//count--;
				//board[0][i]=0;
				//visited[0][i]=0;
				
			}
        
        return result;
    }
    boolean backTracking(int[][] visited,int[][] board,int count,List<String[]> result,int x){
    	if (count==board.length) {
			String tmp[] =new String[board.length];
			for (int k = 0; k < board.length; k++) {
	        tmp[k]="";
	        }
			for (int k = 0; k < board.length; k++) {
				for (int k2 = 0; k2 < board.length; k2++) {
					if (board[k][k2]==1) {
						tmp[k]+='Q';
					}else{
					    tmp[k]+='.';
					}
				}
			}
			result.add(tmp);
			return true;
		}
    	for (int i = 0; i < board.length; i++) {
				if (ifStatisfied(board, x, i)) {
					board[x][i]=1;
					//visited[i][j]=1;
					count++;
					backTracking(visited,board,count,result,x+1);
					count--;
					board[x][i]=0;
				
				
			}
		}
    	return false;
    }
    boolean ifStatisfied(int[][] board,int x,int y){
    	for (int i = 0; i < board.length; i++) {
    		if (board[x][i]==1) {
				return false;
			}
			if (board[i][y]==1) {
				return false;
			}

            if (x-i >=0 && y-i >= 0  &&  board[x-i][y-i] == 1)
            {
               return false;
            }
            if (x+i < board.length && y+i < board.length && board[x+i][y+i] == 1)
            {
                return false;
            }
            if (x+i < board.length && y-i >= 0  &&  board[x+i][y-i] == 1)
            {
               return false;
            }
            if (x-i >=0 && y+i < board.length && board[x-i][y+i] == 1)
            {
                return false;
            }
        
    	}
    	
    	return true;
    }

}
