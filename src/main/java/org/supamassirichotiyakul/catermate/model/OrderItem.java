package org.supamassirichotiyakul.catermate.model;

import javax.persistence.*;

@Entity
@Table(name="ORDER_ITEMS")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public OrderItem() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}