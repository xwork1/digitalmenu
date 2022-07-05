package Odemeyontemi;

import javax.swing.JOptionPane;

import dbBaglantisi.Helper;

class Papara implements IPayment {
    private String email;
    private String password;

    public Papara(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public void pay(int sepet_fiyati) {
    	JOptionPane.showMessageDialog(null, sepet_fiyati+ " TL - Papara ile Ödendi.","ÖDEME BAÞARILI", JOptionPane.INFORMATION_MESSAGE);
    }
}