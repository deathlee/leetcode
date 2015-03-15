package leetcode;

public class WordSearch {
	public static void main(String args[]) {
		WordSearch wordSearch=new WordSearch();
		char board[][]={{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
		String word="ABCESEEEFS";
		System.out.println(wordSearch.exist(board, word));
	}

    public boolean exist(char[][] board, String word) {
        if(word.length()>(board.length*board[0].length))return false;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                boolean visited[][]=new boolean[board.length][board[0].length];
                if(checkWords(word,word.charAt(0),i,j,0,visited,board)==true)return true;
            }
        }
        return false;
    }
    boolean checkWords(String word,char letter,int i,int j,int index,boolean visited[][],char board[][]){
        if(visited[i][j]==true)return false; 
        
        
            if(index==word.length()-1){
                if(letter==board[i][j]){
                    return true;
                }else{
                    return false;
                }
            }else{
                if(letter!=board[i][j]){
                    return false;
                }else{
                visited[i][j]=true;
                index=index+1;
                boolean flag=false;
                flag=flag||((i+1)==board.length?false:checkWords(word,word.charAt(index),(i+1),j,index,visited,board));
                flag=flag||((j+1)==board[0].length?false:checkWords(word,word.charAt(index),(i),j+1,index,visited,board));
                flag=flag||((i-1)==-1?false:checkWords(word,word.charAt(index),(i-1),j,index,visited,board));
                flag=flag||((j-1)==-1?false:checkWords(word,word.charAt(index),(i),j-1,index,visited,board));
                if(flag==false)visited[i][j]=false;
                return flag;
                }
            }
            
    }

}
