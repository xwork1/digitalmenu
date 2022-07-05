package Odemeyontemi;

import javax.swing.JOptionPane;

class KrediKarti implements IPayment {
    private String name;
    private String cardNumber;
    private String cvv;
    private String dateOfExpiry;

    public KrediKarti(String name, String ccNum, String cvv, String expiryDate) {
        this.name = name;
        this.cardNumber = ccNum;
        this.cvv = cvv;
        this.dateOfExpiry = expiryDate;
    }
    
    
    
    public void pay(int sepet_fiyati) {
        JOptionPane.showMessageDialog(null, sepet_fiyati+ " TL Kredi Kartý ile ödeme yapýldý.","ÖDEME BAÞARILI", JOptionPane.INFORMATION_MESSAGE);
    }
}