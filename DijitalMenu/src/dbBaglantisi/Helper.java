package dbBaglantisi;

import javax.swing.JOptionPane;

public class Helper {
	
	public static void showMsg(String str) {
		
		String msg;
		int sepet_fiyati = 0;
		switch(str) {
		case "fill":
			msg = "L�tfen t�m alanlar� doldurunuz. Varsay�lan kullan�c� ad�: admin varsay�lan �ifre:0000";
			break;
		case "fill2":
			msg = "Sat�n alma i�lemi ba�ar�yla ger�ekle�mi�tir";
			break;
		case "fill3":
			msg = "Kullan�c� ad� veya �ifre yanl��";
			break;
		case "fill4":
			msg = "�r�nler eklendi.";
			break;
		default:
			msg = str;
			
		}
		
		JOptionPane.showMessageDialog(null, msg,"Mesaj", JOptionPane.INFORMATION_MESSAGE);
	}

}
