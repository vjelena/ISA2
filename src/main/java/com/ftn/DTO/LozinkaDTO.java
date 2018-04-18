package com.ftn.DTO;

public class LozinkaDTO {
	
	private String lozinka;
	
	public LozinkaDTO(){
		
	}

	
	public LozinkaDTO(String lozinka) {
		super();
		this.lozinka = lozinka;
	}


	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	
	
}
