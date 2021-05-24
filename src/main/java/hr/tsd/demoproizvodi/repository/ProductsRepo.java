package hr.tsd.demoproizvodi.repository;

import hr.tsd.demoproizvodi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepo extends JpaRepository<Product,Integer> {
}
