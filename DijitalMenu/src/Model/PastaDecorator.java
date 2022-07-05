package Model;


public class PastaDecorator implements IPASTA {
	
	protected IPASTA P;
	
	public PastaDecorator(IPASTA p) {
		P = p;
	}

	@Override
	public int getId() {
		return P.getId();
		
	}

	@Override
	public String getyemekAdi() {
		return P.getyemekAdi();
	}

	@Override
	public int getFiyati() {
		return P.getFiyati();
	}
	
	

}
