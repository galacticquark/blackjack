import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class Tablero extends JPanel implements ActionListener {
	private JButton stand;
	private JButton hit;
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
		this.carta = new ImageIcon("1.png").getImage();
		this.add(this.stand, BorderLayout.SOUTH);
		this.add(this.hit,BorderLayout.SOUTH);
		this.setPreferredSize(new Dimension(800,600));
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(myColor3);
		g.fillRect(0, 0, 800, 600);	
		g.setColor(myColor4);
		g.fillOval(-50, 230, 900, 380);
		g.setColor(myColor1);
		g.fillRect(0, 0, 800, 450);
		g.fillOval(-50, 200, 900, 380);
		g.setColor(myColor2);
		g.fillRect(10, 350, 100, 123);
		g.fillRect(10, 350, 100, 123);
		g.fillRect(210, 350, 100, 123);
		g.fillRect(410, 350, 100, 123);
		g.fillRect(610, 350, 100, 123);
		g.drawRect(50, 100, 700, 130);
		g.drawImage(this.carta, 10, 350,85,108, this);
	
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
