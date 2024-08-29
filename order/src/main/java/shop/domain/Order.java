package shop.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import shop.OrderApplication;
import shop.domain.OrderCancelled;
import shop.domain.OrderPlaced;

@Entity
@Table(name = "Order_table")
@Data
//<<< DDD / Aggregate Root
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String customerId;

    private String customerName;

    private Long productId;

    private Integer qty;

    private String status;

    @PostPersist
    public void onPostPersist() {
        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();
    }

    @PreRemove
    public void onPreRemove(){
        OrderCancelled orderCancelled = new OrderCancelled(this);
        orderCancelled.publishAfterCommit();
    }
    
    public static OrderRepository repository() {
        OrderRepository orderRepository = OrderApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }
    
   
    


}
//>>> DDD / Aggregate Root
