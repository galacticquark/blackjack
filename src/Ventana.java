import javax.swing.JFrame;


public class Ventana extends JFrame {
	public Ventana(){
		super("Blackjack");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Tablero tab = new Tablero();
		this.add(tab);
		this.setResizable(false);
		this.pack();
	}
	public static void main(String[] args) {
		Ventana ventana = new Ventana();
		ventana.setVisible(true);
	}
}
