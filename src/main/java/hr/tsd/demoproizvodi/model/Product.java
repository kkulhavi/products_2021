package hr.tsd.demoproizvodi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue
    private int id;
    private String productName;
    private double productPrice;
    private int productEnergy;
    private double productFat;
    private double productCarbohydrates;
    private double productProtein;
    private double productSalt;
    private double productFibers;

    public Product(String productName, double productPrice, int productEnergy, double productFat,
                   double productCarbohydrates, double productProtein, double productSalt, double productFibers) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productEnergy = productEnergy;
        this.productFat = productFat;
        this.productCarbohydrates = productCarbohydrates;
        this.productProtein = productProtein;
        this.productSalt = productSalt;
        this.productFibers = productFibers;
    }
}
