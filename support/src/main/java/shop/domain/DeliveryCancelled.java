package shop.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import shop.domain.*;
import shop.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class DeliveryCancelled extends AbstractEvent {

    private Long id;
    private Long productId;
    private Integer qty;
    private String address;
    private Long orderId;
    private String status;

    public DeliveryCancelled(Delivery aggregate) {
        super(aggregate);
    }

    public DeliveryCancelled() {
        super();
    }
}
//>>> DDD / Domain Event
