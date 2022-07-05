package Odemeyontemi;


class Sepet {
    private String sepet_adi;
    private int sepet_id,sepet_fiyati;
    
	public Sepet(String sepet_adi, int sepet_fiyati, int sepet_id) {
		super();
		this.sepet_adi = sepet_adi;
		this.sepet_fiyati = sepet_fiyati;
		this.sepet_id = sepet_id;
	}
	
	public String getSepet_adi() {
		return sepet_adi;
	}
	public void setSepet_adi(String sepet_adi) {
		this.sepet_adi = sepet_adi;
	}
	public int getSepet_fiyati() {
		return sepet_fiyati;
	}
	public void setSepet_fiyati(int sepet_fiyati) {
		this.sepet_fiyati = sepet_fiyati;
	}
	public int getSepet_id() {
		return sepet_id;
	}
	public void setSepet_id(int sepet_id) {
		this.sepet_id = sepet_id;
	}

  
    
}
