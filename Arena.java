
import java.util.Arrays;
public class Arena {
    private char[][]board;

     public int ukur=0;

    public Arena(int ukur){
        this.ukur=ukur-1;
        board=new char[ukur][ukur];
        for(char[]row:board){
            Arrays.fill(row,'-');
        }

    }
    public void tampilanArena(){
        System.out.print("  ");
        for(int colm=0;colm<= ukur;colm++){
            System.out.print(colm+" ");
        }
        System.out.println();
        for(int bars=0;bars<= ukur;bars++){
            System.out.print(bars+" ");
            for(int col=0;col<= ukur;col++){
                System.out.print(board[bars][col]+" ");
            }
            System.out.println();
        }
    }



    public void arenaPerahu(int row, int col){
        board[row][col]='S';
    }
    public void terbom(int row, int col){
        board[row][col]='X';
    }
    public void tandaiMeleset(int row,int col){
        board[row][col]='O';
    }
    public boolean ditempati(int row, int col){
         return board[row][col]=='S';
    }
    public boolean kena(int row,int col){
        return board[row][col]=='X';
    }
    public boolean meleset(int row,int col){
        return board[row][col]=='O';
    }
    
}
