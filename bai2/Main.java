package bai2;
interface EmailSender {
    void sendEmail(String to, String content);
}

interface Programmer {
    void code(String task);
}

interface Salesperson {
    void sell(String product, int quantity);
}

// ===== Lớp cơ sở chứa thông tin chung =====
abstract class Employee {
    protected String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class OfficeEmployee extends Employee implements EmailSender {
    public OfficeEmployee(String name) {
        super(name);
    }

    @Override
    public void sendEmail(String to, String content) {
        System.out.println("[Văn phòng] " + name + " gửi email tới " + to + ": " + content);
    }
}

class TechnicalEmployee extends Employee implements Programmer, EmailSender {
    public TechnicalEmployee(String name) {
        super(name);
    }

    @Override
    public void code(String task) {
        System.out.println("[Kỹ thuật] " + name + " đang lập trình: " + task);
    }

    @Override
    public void sendEmail(String to, String content) {
        System.out.println("[Kỹ thuật] " + name + " gửi email tới " + to + ": " + content);
    }
}
class SalesEmployee extends Employee implements Salesperson, EmailSender {
    public SalesEmployee(String name) {
        super(name);
    }

    @Override
    public void sell(String product, int quantity) {
        System.out.println("[Bán hàng] " + name + " bán " + quantity + " " + product);
    }

    @Override
    public void sendEmail(String to, String content) {
        System.out.println("[Bán hàng] " + name + " gửi email tới " + to + ": " + content);
    }
}
public class Main {
    public static void main(String[] args) {
        OfficeEmployee office = new OfficeEmployee("An");
        TechnicalEmployee tech = new TechnicalEmployee("Bình");
        SalesEmployee sales = new SalesEmployee("Chi");

        office.sendEmail("boss@company.com", "Báo cáo tuần");
        tech.code("Module đăng nhập");
        tech.sendEmail("team@company.com", "Đã xong module");
        sales.sell("Laptop", 5);
        sales.sendEmail("client@company.com", "Báo giá sản phẩm");

        System.out.println("\n--- Gửi email hàng loạt qua interface ---");
        EmailSender[] senders = { office, tech, sales };
        for (EmailSender s : senders) {
            s.sendEmail("all@company.com", "Họp lúc 9h sáng mai");
        }
    }
}
