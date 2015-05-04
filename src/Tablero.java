import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Tablero extends JPanel implements ActionListener {
	private JButton stand;
	private JButton hit;
	private int[] cp;
	private int xPlayer = 20;
	private int turno = 1;
	private int xDot=50;
	private int yDot=305;
	private boolean draw = false;
	private Jugador[] jugadores;
	
	private boolean isD = false;
	private Naipe nuevaCarta;
	private Baraja nuevaBaraja;
	
	private int xL=40;
	Color myColor1 = new Color(06,73,16);
	Color myColor2 = new Color(33,120,13);
	Color myColor3 = new Color(80,89,62);
	Color myColor4 = new Color(89,63,40);
	private Image carta;
	
	
	public Tablero(){
		super();
		this.stand = new JButton();
		this.hit = new JButton();
		this.stand.setText("Stand");
		this.hit.setText("Hit");
		this.stand.addActionListener(this);
		this.hit.addActionListener(this);
		this.add(this.stand, BorderLayout.SOUTH);
		this.add(this.hit,BorderLayout.SOUTH);
		this.setPreferredSize(new Dimension(800,600));
		this.nuevaBaraja= new Baraja();
		
		
	}

	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		g.setColor(myColor3);
		g.fillRect(0, 0, 850, 650);	
		g.setColor(myColor4);
		g.fillOval(-50, 230, 900, 380);
		g.setColor(myColor1);
		g.fillRect(0, 0, 850, 450);
		g.fillOval(-50, 200, 900, 380);
		g.setColor(myColor2);
		g.fillRect(10, 350, 100, 123);
		//g.fillRect(10, 350, 100, 123);
		g.fillRect(210, 350, 100, 123);
		g.fillRect(410, 350, 100, 123);
		g.fillRect(610, 350, 100, 123);
		g.drawRect(50, 100, 700, 130);
		g.setColor(Color.WHITE);
		setValues(g);
		g.fillOval(this.xDot, this.yDot, 10, 10);
		
	
		//pintaCarta(g);
		
		//if (isD){
			System.out.println("Holi");
			pintaCartas(g);
			//this.carta = new ImageIcon(this.nuevaCarta.getFigura()+"/"+this.nuevaCarta.getValor()+".png").getImage();
			//g.drawImage(this.carta, xCard, yCard,85,108, this);
			//g.drawImage(this.carta, 10, 350,85,108, this);
			         
		///}                      
		                  
		                       
	}    
	public void pintaCartas(Graphics g){
		for (int j = 0; j < this.jugadores.length; j++){
			for(int c = 0; c < this.cp[j]; c++){
				
				Image carta = new ImageIcon(this.jugadores[j].getNaipe(c).getFigura()+"/"+this.jugadores[j].getNaipe(c).getValor()+".png").getImage();
				g.drawImage(carta, xPlayer+(200*(j-1))+(15*c), 351, 85, 108, this);
			}
		}		
	}
	public void setValues(Graphics g){
		this.xL=40;
		for(int i=0; i < this.jugadores.length; i++){//jugador 0 siempre es Dealer
			if(i==0){
				g.drawString(this.jugadores[i].getPuntos()+"pts", 380, 80);
			}else{
				g.drawString(this.jugadores[i].getPuntos()+"pts", xL, 340);
				this.xL+=200;
			}
		}
	}
	
	public void setJugadores(int jugadores){//0 = dealer
		this.jugadores = new Jugador[jugadores + 1];
		this.cp = new int[jugadores + 1];
		for (int j = 0; j< this.jugadores.length; j++){
			this.jugadores[j] = new Jugador();
			this.cp[j] = 2;
		}
	}
	public void reparteCAJ(int jugador){	
		//
		this.jugadores[jugador].setNaipe(this.nuevaBaraja.next().getNaipe());
		System.out.println("Player " +jugador);
		this.jugadores[jugador].printnaipes();
	}
	
	@Override
	public void actionPerformed(ActionEvent pressB) {
		if(pressB.getSource()==stand){
			JOptionPane.showMessageDialog(null, "Your points are the same");
			cambiaTurno();
			//this.turno=true;
		}
		else if(pressB.getSource()==hit){
			if(xDot==50){//player 1
				cp[1] += 1;
				reparteCAJ(1);
			}
			else if(xDot==250){//player 2 
				cp[2] += 1;				
				reparteCAJ(2);
			}
			else if(xDot==450){//player 3
				cp[3] += 1;
				reparteCAJ(3);
			}
			else if(xDot==650){//player 4
				cp[4] += 1;
				reparteCAJ(4);
			}
			this.repaint();
		}
		
	}
	
	public void decideDealer(){
			int dec=0;
			for(int i=1; i<this.jugadores.length; i++){
				if(this.jugadores[i].getPuntos()>this.jugadores[0].getPuntos()){
					dec++;
				}
			}
			if(dec==this.jugadores.length){
				reparteCAJ(0);
				this.repaint();
			}
	}
	
	public void cambiaTurno(){
		if(this.turno == 0){
			this.xDot = 50;
			this.yDot = 305;
			this.turno = 1;
		}else{
			if(this.turno < this.jugadores.length - 1){
				this.xDot += 200;
				turno += 1;
			}else{
				this.xDot=350;
				this.yDot=70;
				this.turno = 0;
			}
		}
		
		/*if(xDot<((this.jugadores.length-2)*200)+50){
			xDot+=200;
			
		}
		else{//dealer
			xDot=350;
			yDot=70;
			
		}*/
		this.repaint();
	}
	
}
