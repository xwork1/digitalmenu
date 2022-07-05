package Odemeyontemi;

import java.util.ArrayList;
import java.util.List;

class ShoppingCart {
    private List<Sepet> urunler;
    private IPayment payment;

    public ShoppingCart() {
        urunler = new ArrayList<Sepet>();
    }

    public void setPaymentMethod(IPayment payment) {
        this.payment = payment;
    }

    public void addItem(Sepet item) {
        this.urunler.add(item);
    }

    public int calculateTotal() {
        int sum = 0;
        for (Sepet urunler : this.urunler) {
            sum += urunler.getSepet_fiyati();
        }
        return sum;
    }

    public void Pay() {
        int amount = calculateTotal();
        this.payment.pay(amount);
    }
}