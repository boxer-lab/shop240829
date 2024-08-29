package shop.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import shop.infra.AbstractEvent;

@Data
public class OrderPlaced extends AbstractEvent {

    private String customerId;
    private String customerName;
    private Long productId;
    private Integer qty;
    private Long id;
    private String address;
}
