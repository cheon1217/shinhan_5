package team3.domain;

import lombok.Data;

@Data
public class Payment {
    private int paymentsId;
    private String name;

    public Payment() {}

    public Payment(int paymentsId, String name) {
        this.paymentsId = paymentsId;
        this.name = name;
    }

    public int getPaymentsId() { return paymentsId; }
    public void setPaymentsId(int paymentsId) { this.paymentsId = paymentsId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

}
