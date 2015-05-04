

public class Jugador{
	private int saldo;
	private String Name;
	private int puntos;
	private boolean perdio;
	private int counterCarta = 0;
	private Naipe[] juego = new Naipe[11];//numeor maximo de cartas que puede tener sin subirse de 21
	//puede cambiarse a 5 para poner regla de 5 cartas sin subir de 21 xD

	public void setNaipe(Naipe carta){
		this.juego[this.counterCarta++] = carta;
	}
	public Naipe getNaipe(int carta){
		return this.juego[carta];		
	}
	public int getPuntos(){
		this.puntos=0;
		for (int carta = 0;carta < this.counterCarta; carta++){
			if (this.juego[carta].getValor() == 1){
				if (this.puntos + 11 > 21){
					this.puntos += 1;
				}else{
					this.puntos += 11;
				}								
			}else if(this.juego[carta].getValor() > 10){
				this.puntos += 10;				
			}else{
				this.puntos += this.juego[carta].getValor();
			}
		}
		return this.puntos;
	}
	public void printnaipes(){
		
		System.out.println(counterCarta+": "+ juego[this.counterCarta-1].getValor());
	}
	public int getSaldo() {
		return saldo;
	}
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	public void aumentaSaldo(int aumento){
		this.saldo += aumento;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
}