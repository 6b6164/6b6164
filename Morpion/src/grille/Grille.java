package grille;
import symbole.Case;
import symbole.Symbole;

public class Grille {
private static final int LINE = 3;
private static final int COLUMN = 3;
private Symbole[][] morpions;

public Grille() 
{
	this.morpions = new Symbole[LINE][COLUMN];
	for(int lin = 0;lin<LINE;lin++) {
		for(int col = 0;col<COLUMN;col++) {
			morpions[lin][col] = new Case();
		}
	}
}

public void print() 
{
	int left = 0,right = 0;
	for (int i = 0; i <=LINE-1; i++ ) {
		System.out.println("");
		System.out.println("         ----------- ");
		for(int j = 0; j <= COLUMN; j++) {
			if(j==0) {
			System.out.print("       "+" ");
			left++;
			}
			if(j == 3) {
			System.out.print("| ");
			right++;
			}else {
				System.out.print("| " + morpions[i][j]+ " ");	
			}	
		}
	}
	System.out.println("");
	System.out.println("         ----------- ");
	System.out.println("");
}

public void toPlay(int x, int y, Symbole s)
{
	if(checkPlay(x,y)) {
		morpions[x][y] = s;
	}else {
		System.out.print("Saisie incorrecte !");
	}
	
}

public boolean checkPlay(int x, int y) 
{
	if((x>=0 && x<=2) && (y>=0 && y<=2)) {
		return true;
	}else {
		return false;
	}
}

public Symbole getSymbole(int x, int y) 
{
	return morpions[x][y];
}
 /** au cas ou static void printBoard()
    {
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | "
                           + board[1] + " | " + board[2]
                           + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | "
                           + board[4] + " | " + board[5]
                           + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | "
                           + board[7] + " | " + board[8]
                           + " |");
        System.out.println("|---|---|---|");
    }
  **/
}
