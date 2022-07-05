package dbBaglantisi;

import javax.swing.JOptionPane;

public class Helper {
	
	public static void showMsg(String str) {
		
		String msg;
		int sepet_fiyati = 0;
		switch(str) {
		case "fill":
			msg = "Lütfen tüm alanlarý doldurunuz. Varsayýlan kullanýcý adý: admin varsayýlan þifre:0000";
			break;
		case "fill2":
			msg = "Satýn alma iþlemi baþarýyla gerçekleþmiþtir";
			break;
		case "fill3":
			msg = "Kullanýcý adý veya þifre yanlýþ";
			break;
		case "fill4":
			msg = "Ürünler eklendi.";
			break;
		default:
			msg = str;
			
		}
		
		JOptionPane.showMessageDialog(null, msg,"Mesaj", JOptionPane.INFORMATION_MESSAGE);
	}

}
