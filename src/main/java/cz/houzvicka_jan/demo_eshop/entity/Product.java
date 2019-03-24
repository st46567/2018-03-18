package cz.houzvicka_jan.demo_eshop.entity;

import lombok.Data;
import javax.persistence.Entity;

@Entity
@Data
public class Product extends BaseEntity
{
    private String name;

    private String slugName;

    private Double price;

    private String description;

    private boolean isActive;

    public Double getPrice() {
        return price;
    }
}
