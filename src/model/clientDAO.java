package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class clientDAO implements settings{
	
	private client c;
	
	public clientDAO() {
		c=new client();
	}
	public clientDAO(client c_) {
		this.c=c_;
	}
	public boolean registerClient() {
		boolean flag= conn.setQuery(
				String.format("INSERT INTO empresa1.client VALUES(null,%d,'%s','%s','%s');", 
																c.getDNI(),
																c.getNames(),
																c.getEmail(),
																c.getPhone())
				);
		conn.closeConn();
		return flag;
		
	}
	public synchronized List<client> loadAllClient() throws SQLException{
		List<client>clients=new ArrayList();
		ResultSet res=conn.getQuery("SELECT * FROM empresa1.client;");
		while(res.next()) {
			client c=new client();
			c.setId(res.getInt(1));
			c.setDNI(res.getLong(2));
			c.setNames(res.getString(3));
			c.setEmail(res.getString(4));
			c.setPhone(res.getString(5));
			clients.add(c);
		}
		res=null;
		conn.closeConn();
		
		return clients;
	}
	public synchronized boolean matchClient(client newClient) throws SQLException {
		List<client>clients=loadAllClient();
		boolean flag=false;
		
		for(client bbddClient:clients) {
			if(bbddClient.getDNI()==newClient.getDNI()) {
				flag=true;
				
			}
		
		}
		
		
		return flag;
	}

	public void setClient(client c) {
		this.c=c;
	}
}
