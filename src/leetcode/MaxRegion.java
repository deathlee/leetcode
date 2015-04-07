package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
class Point{
    int x;
    int y;
    Point(int x,int y){
        this.x=x;
        this.y=y;
    }
}
public class MaxRegion {
	public static void main(String args[]){
		MaxRegion maxRegion=new MaxRegion();
		String a="OXOOOOOOO";
		char tmpa[]=a.toCharArray();
		String b="OOOXOOOOX";
		char tmpb[]=b.toCharArray();
		String c="OXOXOOOOX";
		char tmpc[]=c.toCharArray();
		String d="OOOOXOOOO";
		char tmpd[]=d.toCharArray();
		String e="XOOOOOOOX";
		char tmpe[]=e.toCharArray();
		String f="XXOOXOXOX";
		char tmpf[]=f.toCharArray();
		String g="OOOXOOOOO";
		char tmpg[]=g.toCharArray();
		String h="OOOXOOOOO";
		char tmph[]=h.toCharArray();
		String i="OOOOOXXOO";
		char tmpi[]=i.toCharArray();
		char board[][]={tmpa,tmpb,tmpc,tmpd,tmpe,tmpf,tmpg,tmph,tmpi};
		maxRegion.solve(board);
		System.out.println("test");
	}
    public void solve(char[][] board) {
        if(board.length==0)return;
       boolean visited[][]=new boolean[board.length][board[0].length];
        for(int i=1;i<board.length-1;i++){
            for(int j=1;j<board[0].length-1;j++){
                 
                if(board[i][j]=='O'&&visited[i][j]==false){
                List<Point> record=new ArrayList<>();
                Queue<Point> queue=new LinkedList<>();
                queue.add(new Point(i,j));
                //record.add(new Point(i,j));
                visited[i][j]=true;
                flip(queue,board,visited,record);
                }
            }
        }
    }
    void flip(Queue<Point> queue,char[][] board,boolean visited[][],List<Point> record){
    	boolean flag=true;
        while(queue.peek()!=null){
        Point node=queue.remove();
        
        if(board[node.x][node.y]=='O'&&(node.x==0||node.x==board.length-1||node.y==0||node.y==board[0].length-1)){
        	flag=false;
            continue;
        }
        
        record.add(node);
            if(visited[node.x-1][node.y]==false&&board[node.x-1][node.y]=='O'){
                queue.add(new Point(node.x-1,node.y));
                //record.add(new Point(node.x-1,node.y));
                visited[node.x-1][node.y]=true;
                if(node.x-1==4&&node.y==3){
                	System.out.print("test");
                }
                
            }
            if(visited[node.x][node.y-1]==false&&board[node.x][node.y-1]=='O'){
                queue.add(new Point(node.x,node.y-1));
                //record.add(new Point(node.x,node.y-1));
                visited[node.x][node.y-1]=true;
                if(node.x==4&&node.y-1==3){
                	System.out.print("test");
                }
            }
            if(visited[node.x+1][node.y]==false&&board[node.x+1][node.y]=='O'){
                queue.add(new Point(node.x+1,node.y));
                //record.add(new Point(node.x+1,node.y));
                visited[node.x+1][node.y]=true;
                if(node.x+1==4&&node.y==3){
                	System.out.print("test");
                }
            }
            if(visited[node.x][node.y+1]==false&&board[node.x][node.y+1]=='O'){
                queue.add(new Point(node.x,node.y+1));
                //record.add(new Point(node.x,node.y+1));
                visited[node.x][node.y+1]=true;
                if(node.x==4&&node.y+1==3){
                	System.out.print("test");
                }
            }
        }
        if(flag){
        for(Point node:record){
            board[node.x][node.y]='X';
        }
        }
    }

}
