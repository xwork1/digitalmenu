package Model;

public class VisneliPasta extends PastaDecorator{

	public VisneliPasta(IPASTA p) {
		super(p);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public int getId() {
		return P.getId() + 2;
	}

	@Override
	public String getyemekAdi() {
		// TODO Auto-generated method stub
		return "Viþneli" + P.getyemekAdi();
	}

	@Override
	public int getFiyati() {
		// TODO Auto-generated method stub
		return 10 + P.getFiyati();
	}

}
