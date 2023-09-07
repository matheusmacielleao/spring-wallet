package mml.wallet.domain.entities;

import java.util.Date;

public class Transfer {
    private final  Integer id;
    private final User sender;
    private final User receiver;
    private final Date date;
    private final Double value;

    public Transfer(User sender, User receiver, Date date, Double value) {
        this.id = 1;
        this.sender = sender;
        this.receiver = receiver;
        this.date = date;
        this.value = value;
    }
}
