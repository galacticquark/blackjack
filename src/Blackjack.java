import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Blackjack extends JFrame {
	int numJug;
	private Tablero tab;
	public Blackjack(){
		super("Blackjack");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.tab = new Tablero();
		this.add(this.tab);
		this.setResizable(false);
		
		this.pack();
		
		
	}
	
	public void numberOfPlayers(){//en estte metodo solo se setean el numero de jugadores  se reparte la primer ronda d cartas
		numJug=Integer.parseInt(JOptionPane.showInputDialog("How many players?"));
		this.tab.setJugadores(numJug);
		//this.tab.reparteCAJ(0);          este se tiene que llamar desde el boton de repartir crta
		for (int i = 0; i < numJug + 1; i++){
			this.tab.reparteCAJ(i);
			this.tab.reparteCAJ(i);
		}
	}
	
	
	
	
	
	public static void main(String[] args){
		Blackjack ventana = new Blackjack();
		ventana.numberOfPlayers();
		ventana.setVisible(true);
		
		
		
		
		
		
	}
}
