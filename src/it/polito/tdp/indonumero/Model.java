package it.polito.tdp.indonumero;

import java.security.InvalidParameterException;

public class Model {
	private int NMAX = 100;
	private int TMAX = 7;
	
	private int segreto;
	private int tentativi;
	
	private boolean inGame = false;
	
	public Model() {
		this.inGame=false;
	}
	
	public void newGame() {
		this.segreto= (int)(Math.random()*NMAX)+1;
    	
		tentativi = 0;
    	inGame = true; 
	}
	/*
	 * fai un nuovo tentativo di indovinare un numero segreto
	 * @param t valore numerico del tentativo
	 * @return 0 se indovinato, 1 se troppo alto,-1 se troppo basso
	 */
	public int tentativo(int t) {
		
		if(!inGame) {
			throw new IllegalStateException("Partita non attiva");
		}
		
		if(!valoreValido(t)) {
			throw new InvalidParameterException("Tentativo fuori range");
		}
		
		this.tentativi++;
		if(this.tentativi==this.TMAX) {
			this.inGame = false;
		}
		
		if(t==segreto) {
		this.inGame=false;
		return 0;
		
		}
		else {
		if(t>segreto)
			return 1;
		else return -1;
		}
		
		
		 
		
	}

	public boolean valoreValido(int tentativo)
	{
		return tentativo>=1 && tentativo <= this.NMAX;
	}
	public boolean isInGame() {
		return inGame;
	}

	public int getTentativi() {
		return this.tentativi;
	}

	public int getNMAX() {
		return NMAX;
	}

	public int getTMAX() {
		return TMAX;
	}

	public int getSegreto() {
		return segreto;
	}
	
	
	
	
	
	
}
