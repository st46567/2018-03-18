package cz.houzvicka_jan.demo_eshop.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Data
public class OrderForm extends BaseEntity
{
    @OneToMany(mappedBy = "id")
    private Set<OrderedProduct> orderedProductSet;

    @Enumerated(EnumType.STRING)
    private OrderState orderState;

    public void setOrderState(OrderState state){
        orderState = state;
    }
}
