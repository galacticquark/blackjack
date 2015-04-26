import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


public class Naipe {
	String[] valores;//consideramos inutil e ineficiente
	String[] figuras;//consideramos inutil e ineficiente
	Image[] naipesImg;//consideramos inutil e ineficiente
	private Image imagenFrente;
	private int figura;//(0,3) 
	private int valor;//(0,12) puede ser (0,10)
	//0C 1D 2P 3T 
	public Naipe(int figura, int valor){
		this.valor = valor;
		this.figura = figura;		
		try {
			this.imagenFrente = ImageIO.read(getClass().getResourceAsStream(figura+"/"+valor+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String toString(){
		return "";//algun string xD(?)
	}
	
	public Image getImage(){
		return this.imagenFrente;//o algo asi
	}
	
	public int getValor(){
		switch (valor){
		case 0://A
			return 11;
		case 10://J
			return 10;
		case 11://Q
			return 10;
		case 12://K
			return 10;
		}
		return valor + 1;			
	}
	

}
