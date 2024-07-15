package controller;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread hilo1=new processClient();
		Thread hilo2=new processClient();
		Thread hilo3=new processClient();
		
		hilo1.start();
		hilo2.start();
		hilo3.start();

	}

}
