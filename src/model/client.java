package model;

import libreriaVersion3.generic;

public class client {

	private generic<String,Long>dt1_c;
	private generic<Integer,String>dt2_c;
	
	public client() {
		dt1_c=new generic<>();
		dt2_c=new generic<>();
	}
	public client(int id_client, String names, long cedula, String phone, String email) {
		dt1_c=new generic<>(names,phone,cedula);
		dt2_c=new generic<>(id_client,email);
	}
	public String getNames() {
		return dt1_c.getAttribute1();
	}
	public String getPhone() {
		return dt1_c.getAttribute2();
	}
	public long getDNI() {
		return dt1_c.getAttribute3();
	}
	public int getId() {
		return dt2_c.getAttribute1();
	}
	public String getEmail() {
		return dt2_c.getAttribute3();
	}
	public void setNames(String names) {
		dt1_c.setAttribute1(names);
	}
	public void setPhone(String phone) {
		dt1_c.setAttribute2(phone);
	}
	public void setDNI(long dni) {
		dt1_c.setAttribute3(dni);
	}
	public void setEmail(String email) {
		dt2_c.setAttribute3(email);
	}
	public void setId(int id) {
		dt2_c.setAttribute1(id);
	}
}
