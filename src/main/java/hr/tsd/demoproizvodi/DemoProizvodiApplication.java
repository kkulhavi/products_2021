package hr.tsd.demoproizvodi;

import hr.tsd.demoproizvodi.model.Product;
import hr.tsd.demoproizvodi.repository.ProductsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoProizvodiApplication implements CommandLineRunner{

    @Autowired
    ProductsRepo productsRepo;

    public static void main(String[] args) {
        SpringApplication.run(DemoProizvodiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Product p1=new Product("nutella",25, 539,
                30.9, 57.5, 6.3, 0.107, 0);
        productsRepo.save(p1);
        Product p2=new Product("linolada",22, 540,
                31, 57, 7, 0.2,0);
        productsRepo.save(p2);
        Product p3=new Product("peanut butter",18, 633,
                54.2, 16, 26, 2.9,8.11);
        productsRepo.save(p3);
        Product p4=new Product("maslac",12, 744,
                82, 0.7, 0.7, 0.01,0);
        productsRepo.save(p4);
        Product p5=new Product( "zagrebački sir",15, 101,
                5, 3, 11, 0.2,0);
        productsRepo.save(p5);
        Product p6=new Product("pekmez od šljiva",30, 240,
                0, 60, 0, 0,0);
        productsRepo.save(p6);
        Product p7=new Product("milka čokolada",8, 552,
                34, 53, 7.6, 0.32,2.9);
        productsRepo.save(p7);
        Product p8=new Product("čipi čips",10, 558,
                37.3, 45.2, 5.7, 1.9,0);
        productsRepo.save(p8);
        Product p9=new Product("smoki",9, 521,
                29, 50, 13, 2.2,4);
        productsRepo.save(p9);
    }
}
