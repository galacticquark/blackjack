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
	private int figura;//(0,3) 
	private int valor;//(0,12) puede ser (0,10)
	//0C 1D 2P 3T 
	public Naipe(int figura, int valor){
		this.valor = valor;
		this.figura = figura;		
		
	}
	
	public int getFigura(){
		return this.figura;
	}
	
	public int getValor(){
		if (this.valor < 13){
			return this.valor + 1;	
		}else{
			return 1;
		}
	}
	
	public Naipe getNaipe(){
		return this;
	}
	

}
