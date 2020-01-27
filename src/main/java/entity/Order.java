package entity;

import org.springframework.data.annotation.Id;

public class Order {

    @Id
    String id;

    String customerid;
    float moneypaid;

    public Order() {
    }

    public Order(String customerid, float moneypaid) {
        this.customerid = customerid;
        this.moneypaid = moneypaid;
    }
}
