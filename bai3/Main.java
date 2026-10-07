package bai3;
abstract class PaymentMethod {
    protected String name;       
    protected boolean isCash;    

    public PaymentMethod(String name, boolean isCash) {
        this.name = name;
        this.isCash = isCash;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return isCash ? "Tiền mặt" : "Không dùng tiền mặt";
    }

    public abstract void pay(double amount);

    protected String format(double amount) {
        return String.format("%,.0f", amount).replace(',', '.');
    }
}

class CreditCardPayment extends PaymentMethod {
    public CreditCardPayment() {
        super("CreditCard", false);
    }

    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán " + format(amount) + " bằng thẻ tín dụng.");
    }
}

class PayPalPayment extends PaymentMethod {
    public PayPalPayment() {
        super("PayPal", false);
    }

    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán " + format(amount) + " qua PayPal.");
    }
}

class CashPayment extends PaymentMethod {
    public CashPayment() {
        super("Cash", true);
    }

    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán " + format(amount) + " bằng tiền mặt.");
    }
}

class MoMoPayment extends PaymentMethod {
    public MoMoPayment() {
        super("MoMo", false);
    }

    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán " + format(amount) + " qua MoMo.");
    }
}

// ===== Đơn hàng: chỉ phụ thuộc vào PaymentMethod (trừu tượng) =====
class Order {
    private String customerName;
    private double amount;
    private PaymentMethod paymentMethod;

    public Order(String customerName, double amount, PaymentMethod paymentMethod) {
        this.customerName = customerName;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }

    public void checkout() {
        System.out.println("Khách hàng: " + customerName);
        paymentMethod.pay(amount);
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Order o1 = new Order("An", 200000, new CreditCardPayment());
        Order o2 = new Order("Bình", 150000, new PayPalPayment());
        Order o3 = new Order("Chi", 100000, new CashPayment());
        Order o4 = new Order("Dũng", 300000, new MoMoPayment());

        o1.checkout();
        o2.checkout();
        o3.checkout();
        o4.checkout();
    }
}
