import java.awt.Image;


public class Naipe {
	String[] valores;//consideramos inutil e ineficiente
	String[] figuras;//consideramos inutil e ineficiente
	Image[] naipesImg;//consideramos inutil e ineficiente
	private int figura;//(0,3) 
	private int valor;//(0,12) puede ser (0,10)
	public String toString(){
		return "";//algun string xD(?)
	}
	public Image getImage(){
		return naipesImg[0];//o algo asi
	}
	public int getValor(){
		return valor;
	}
	

}
