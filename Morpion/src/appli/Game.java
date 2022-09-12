package appli;

import java.util.Scanner;

import grille.Grille;
import joueur.Joueur;
import symbole.Case;
import symbole.FabriqueSymbole;
import symbole.Symbole;

public class Game {
private Grille morpion;
private Joueur playerOne;
private Joueur playerTwo;
private FabriqueSymbole factory;
private static boolean TOUR;
private static Symbole S;
Scanner scP1 = new Scanner(System.in);
Scanner scP2 = new Scanner(System.in);

public Game()
{
	this.morpion = new Grille();
	this.playerOne = new Joueur(null);
	this.playerTwo = new Joueur(null);	
	this.factory = new FabriqueSymbole();
}
public void start()
{
	System.out.println("Joueur 1 choisissez votre nom");
	String playerOneName = scP1.nextLine();
	playerOne.setNom(playerOneName);
	System.out.println("Joueur 2 choisissez votre nom");
	String playerTwoName = scP2.nextLine();
	playerOne.setNom(playerTwoName);
	morpion.print();	
	int coup = 9;
	while(true) 
	{
			TOUR = false;
			System.out.println("Tour de "+playerOneName);
			S = factory.fabriquerSymbole(TOUR);
			System.out.println("Jouez votre coup : ");
			int number = scP1.nextInt(); 
			chosePlay(S, number);coup--;
	    	checkWinPlayer(playerOneName, coup);
	     	morpion.print();	
			TOUR = true;
			System.out.println("Tour de "+playerTwoName);
			S = factory.fabriquerSymbole(TOUR);
			System.out.print("Jouez votre coup : ");
			number = scP2.nextInt();
			chosePlay(S, number);coup--;
	     	checkWinPlayer(playerTwoName, coup);
	     	morpion.print();	 
		}	
 }

private void checkWinPlayer(String playerName, int count) {
	if(!checkEndGame(count)) {
		morpion.print();
		System.out.print(playerName+" a gagné la partie !");
		System.exit(0);
	}
}

private void chosePlay(Symbole S, int number) {
	switch(number)
	  { 
		case 1:{
			morpion.toPlay(0,0, S);
			break;
		}
		case 2:{
			morpion.toPlay(0,1, S);
			break;
		}
		case 3:{
			morpion.toPlay(0,2, S);
			break;
		}
		case 4:{
			morpion.toPlay(1,0, S);
			break;
		}
		case 5:{
			morpion.toPlay(1,1, S);
			break;
		}
		case 6:{
			morpion.toPlay(1,2, S);
			break;
		}
		case 7:{
			morpion.toPlay(2,0, S);
			break;
		}
		case 8:{
			morpion.toPlay(2,1, S);
			break;
		}
		case 9:{
			morpion.toPlay(2,2, S);
			break;
		}default:{
			System.out.println("Choisir un chiffre entre 1 et 9");
		}
   }
}
	  
public boolean checkEndGame(int count) 
{
   if(checkCroix()) {
		return false;
		
} else if(checkRond()) {
	       return false; 
	}else if(count == 0) {
		System.out.println("égalité ! ");
		morpion.print();
		System.exit(0);
		return false;
	}else {
		return true;
	}

}

private boolean checkRond() {
	return morpion.getSymbole(0,0).toString().equals("O")&&morpion.getSymbole(0,1).toString().equals("O")&&morpion.getSymbole(0,2).toString().equals("O")
				||morpion.getSymbole(1,0).toString().equals("O")&&morpion.getSymbole(1,1).toString().equals("O")&&morpion.getSymbole(1,2).toString().equals("O")
				||morpion.getSymbole(2,0).toString().equals("O")&&morpion.getSymbole(2,1).toString().equals("O")&&morpion.getSymbole(2,2).toString().equals("O")
				
				||morpion.getSymbole(0,0).toString().equals("O")&&morpion.getSymbole(1,0).toString().equals("O")&&morpion.getSymbole(2,0).toString().equals("O")
				||morpion.getSymbole(0,1).toString().equals("O")&&morpion.getSymbole(1,1).toString().equals("O")&&morpion.getSymbole(2,1).toString().equals("O")
				||morpion.getSymbole(0,2).toString().equals("O")&&morpion.getSymbole(1,2).toString().equals("O")&&morpion.getSymbole(2,2).toString().equals("O")
				
				||morpion.getSymbole(0,0).toString().equals("O")&&morpion.getSymbole(1,1).toString().equals("O")&&morpion.getSymbole(2,2).toString().equals("O")
				||morpion.getSymbole(2,0).toString().equals("O")&&morpion.getSymbole(1,1).toString().equals("O")&&morpion.getSymbole(0,2).toString().equals("O");
}
private boolean checkCroix() {
	return morpion.getSymbole(0,0).toString().equals("X")&&morpion.getSymbole(0,1).toString().equals("X")&&morpion.getSymbole(0,2).toString().equals("X")
		||morpion.getSymbole(1,0).toString().equals("X")&&morpion.getSymbole(1,1).toString().equals("X")&&morpion.getSymbole(1,2).toString().equals("X")
		||morpion.getSymbole(2,0).toString().equals("X")&&morpion.getSymbole(2,1).toString().equals("X")&&morpion.getSymbole(2,2).toString().equals("X")
		
		||morpion.getSymbole(0,0).toString().equals("X")&&morpion.getSymbole(1,0).toString().equals("X")&&morpion.getSymbole(2,0).toString().equals("X")
		||morpion.getSymbole(0,1).toString().equals("X")&&morpion.getSymbole(1,1).toString().equals("X")&&morpion.getSymbole(2,1).toString().equals("X")
		||morpion.getSymbole(0,2).toString().equals("X")&&morpion.getSymbole(1,2).toString().equals("X")&&morpion.getSymbole(2,2).toString().equals("X")
		
		||morpion.getSymbole(0,0).toString().equals("X")&&morpion.getSymbole(1,1).toString().equals("X")&&morpion.getSymbole(2,2).toString().equals("X")
		||morpion.getSymbole(2,0).toString().equals("X")&&morpion.getSymbole(1,1).toString().equals("X")&&morpion.getSymbole(0,2).toString().equals("X");
}
}


















