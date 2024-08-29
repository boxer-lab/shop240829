package shop.domain;

import java.util.*;
import lombok.*;
import shop.domain.*;
import shop.infra.AbstractEvent;

@Data
@ToString
public class OrderPlaced extends AbstractEvent {

    private String customerId;
    private String customerName;
    private Long productId;
    private Integer qty;
    private Long id;
    private String address;
}
