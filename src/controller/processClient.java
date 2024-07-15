package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.client;
import model.clientDAO;

public class processClient extends Thread implements parametrizable{
	
	private List<client> newCLients=new ArrayList();
	
	public processClient() {
		newCLients.add(new client(1,"Fernanda Lomas",1716975501,"flomas@gmail.com","0975021221"));
		newCLients.add(new client(1,"Carla Perez",1716975502,"cperez@gmail.com","0999021221"));
		newCLients.add(new client(1,"Carolina Lopez",1716975503,"clopez@gmail.com","0988021221"));
		newCLients.add(new client(1,"Marcelo Suarez",1716975504,"msuarez@gmail.com","0979021221"));
		newCLients.add(new client(1,"Fernando Gomez",1716975505,"fgomez@gmail.com","0978621221"));
		newCLients.add(new client(1,"Fernanda Lomas",1716975501,"flomas@gmail.com","0975021221"));
		newCLients.add(new client(1,"Carla Perez",1716975502,"cperez@gmail.com","0999021221"));
	}

	public void run() {
		
		for(client newClient:newCLients) {
			try {
				if(!cdao.matchClient(newClient)) {
					clientDAO cdaoR=new clientDAO(newClient);
//					cdao.setClient(newClient);
					cdaoR.registerClient();
					System.out.println(this.currentThread()+"Registro al cliente:"+newClient.getNames());
				}else {
					System.out.println("Cliente existente");
				}
				this.sleep(2000);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
