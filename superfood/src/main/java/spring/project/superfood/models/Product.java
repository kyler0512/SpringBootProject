package spring.project.superfood.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String productName;
    private double price;
    private String foodType;
    private String info;
    private boolean sold = false;
    @ManyToOne
    @JoinColumn(name = "userId", insertable = false, updatable = false, referencedColumnName = "id")
    private User user;

}
