package symbole;
public class FabriqueSymbole {
private Croix croix;
private Rond rond;
private Case caseVide;

public FabriqueSymbole() 
{
	this.croix = new Croix();
	this.rond = new Rond();
	this.caseVide = new Case();
}

public Symbole fabriquerSymbole(boolean tour) 
{
	if(tour == false) {
		return croix;
	}
	else if(tour == true) {
		return rond;
	}
	else {
		return caseVide;
	}
}

}
