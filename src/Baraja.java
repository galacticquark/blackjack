import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;



public class Baraja {
	private int posicion; //?
	private Random lastCard = new Random();
	private Naipe lastNaipe;
	private ArrayList<Naipe> baraja = new ArrayList<Naipe>();
	public Baraja(){
		int figura = 0;		
		for (int valor = 0; valor < 52; valor++){			 
			this.baraja.add(new Naipe(figura, ((valor%13) + 1)));//FV
			if (((valor%13) + 1) == 13){//termino Figura
				figura++;
			}
		}
		mezclar();
	}
	public void mezclar(){
		 Collections.shuffle(this.baraja);		 
	}
	public Naipe next(){
		lastNaipe = this.baraja.get(0);
		this.baraja.remove(0);
		return lastNaipe;		
	}
}
