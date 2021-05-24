package hr.tsd.demoproizvodi.controller;


import hr.tsd.demoproizvodi.model.Product;
import hr.tsd.demoproizvodi.repository.ProductsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Comparator;
import java.util.stream.Collectors;

@Controller
public class ProductController {

    @Autowired
    ProductsRepo productsRepo;

    @GetMapping("/")
    public ModelAndView getProducts(){
        ModelAndView mv=new ModelAndView("index");
        mv.addObject("products",productsRepo.findAll());
        mv.addObject("arrowPro"," ");
        mv.addObject("arrowPri"," ");
        mv.addObject("arrowEne"," ");
        mv.addObject("arrowFat"," ");
        mv.addObject("arrowCar"," ");
        mv.addObject("arrowProt"," ");
        mv.addObject("arrowSal"," ");
        mv.addObject("arrowFib"," ");
        return mv;
    }
    @PostMapping("/")      //defaultni post mapping s kojim mozemo dodati podatke u bazu
    //vućemo potrebne parametre za upisivanje u bazu
    public ModelAndView editProduct(@RequestParam int id,@RequestParam String productName,@RequestParam double productPrice,@RequestParam int productEnergy,
                                    @RequestParam double productFat,@RequestParam double productCarbohydrates,@RequestParam double productProtein,
                                    @RequestParam double productSalt,@RequestParam double productFibers){
        //kreiramo objekt u koji spremamo podatke
        Product p1=new Product(id, productName, productPrice, productEnergy, productFat,
                productCarbohydrates, productProtein, productSalt, productFibers);

        productsRepo.save(p1);  //spremamo objekt u bazu
        ModelAndView mv=new ModelAndView("index");
        mv.addObject("products",productsRepo.findAll());



        return mv;
    }

    @PostMapping("/addproduct")
    //post bez id svojstva koji se sada automatski generira
    public ModelAndView addProduct(@RequestParam String productName,@RequestParam double productPrice,
                                   @RequestParam int productEnergy, @RequestParam double productFat,
                                   @RequestParam double productCarbohydrates, @RequestParam double productProtein,
                                   @RequestParam double productSalt,@RequestParam double productFibers){
        //ubacujemo podatke u objekt koristeći konstruktor bez id
        Product p1=new Product(productName, productPrice, productEnergy, productFat,
                productCarbohydrates, productProtein, productSalt, productFibers);

        productsRepo.save(p1);  //spremamo objekt u bazu
        ModelAndView mv=new ModelAndView("index");
        mv.addObject("products",productsRepo.findAll());
        return mv;
    }
    @GetMapping("/toaddproductpage")
    public ModelAndView addProductPage(){
        ModelAndView mv=new ModelAndView("addproduct.html");
        return mv;
    }
    boolean nameClicked=false;
    @GetMapping("/sortproductasc")
    public ModelAndView sortProductsByNameAsc(){
        //unutar index view
        ModelAndView mv=new ModelAndView("index");
        //sortiramo sve objekte u bazi po imenu
        if (nameClicked==false){
            mv.addObject("products",productsRepo.findAll().stream()
                .sorted(Comparator.comparing(Product::getProductName))
                .collect(Collectors.toList()));
                mv.addObject("arrowPro","▼");
                mv.addObject("arrowPri"," ");
                mv.addObject("arrowEne"," ");
                mv.addObject("arrowFat"," ");
                mv.addObject("arrowCar"," ");
                mv.addObject("arrowProt"," ");
                mv.addObject("arrowSal"," ");
                mv.addObject("arrowFib"," ");
            falseFunction();
            nameClicked=true;
        }
        else{
            mv.addObject("products",productsRepo.findAll().stream()
                .sorted(Comparator.comparing(Product::getProductName).reversed())
                .collect(Collectors.toList()));
            mv.addObject("arrowPro","▲");
            mv.addObject("arrowPri"," ");
            mv.addObject("arrowEne"," ");
            mv.addObject("arrowFat"," ");
            mv.addObject("arrowCar"," ");
            mv.addObject("arrowProt"," ");
            mv.addObject("arrowSal"," ");
            mv.addObject("arrowFib"," ");
            nameClicked=false;
        }
        return mv;
    }
    boolean PriceClicked=false;
    @GetMapping("/sortproductprice")
    public ModelAndView sortProductsByPrice(){
        //unutar index view
        ModelAndView mv=new ModelAndView("index");
        //sortiramo sve objekte u bazi po imenu
        if (PriceClicked==false){
            mv.addObject("products",productsRepo.findAll().stream()
                    .sorted(Comparator.comparing(Product::getProductPrice).reversed())
                    .collect(Collectors.toList()));
            mv.addObject("arrowPri","▼");
            mv.addObject("arrowPro"," ");
            mv.addObject("arrowEne"," ");
            mv.addObject("arrowFat"," ");
            mv.addObject("arrowCar"," ");
            mv.addObject("arrowProt"," ");
            mv.addObject("arrowSal"," ");
            mv.addObject("arrowFib"," ");
            falseFunction();
            PriceClicked=true;
        }
        else{
            mv.addObject("products",productsRepo.findAll().stream()
                    .sorted(Comparator.comparing(Product::getProductPrice))
                    .collect(Collectors.toList()));
            mv.addObject("arrowPri","▲");
            mv.addObject("arrowPro"," ");
            mv.addObject("arrowEne"," ");
            mv.addObject("arrowFat"," ");
            mv.addObject("arrowCar"," ");
            mv.addObject("arrowProt"," ");
            mv.addObject("arrowSal"," ");
            mv.addObject("arrowFib"," ");
            PriceClicked=false;
        }
        return mv;
    }

    boolean isEnergyClicked=false;
    @GetMapping("/sortproductenergy")
    public ModelAndView sortProductsByEnergy(){
        //unutar index view
        ModelAndView mv=new ModelAndView("index");
        //sortiramo sve objekte u bazi po imenu
        if (isEnergyClicked==false){
            mv.addObject("products",productsRepo.findAll().stream()
                    .sorted(Comparator.comparing(Product::getProductEnergy).reversed())
                    .collect(Collectors.toList()));
            mv.addObject("arrowEne","▼");
            mv.addObject("arrowPri"," ");
            mv.addObject("arrowPro"," ");
            mv.addObject("arrowFat"," ");
            mv.addObject("arrowCar"," ");
            mv.addObject("arrowProt"," ");
            mv.addObject("arrowSal"," ");
            mv.addObject("arrowFib"," ");
            falseFunction();
            isEnergyClicked=true;
        }
        else{
            mv.addObject("products",productsRepo.findAll().stream()
                    .sorted(Comparator.comparing(Product::getProductEnergy))
                    .collect(Collectors.toList()));
            mv.addObject("arrowEne","▲");
            mv.addObject("arrowPri"," ");
            mv.addObject("arrowPro"," ");
            mv.addObject("arrowFat"," ");
            mv.addObject("arrowCar"," ");
            mv.addObject("arrowProt"," ");
            mv.addObject("arrowSal"," ");
            mv.addObject("arrowFib"," ");
            isEnergyClicked=false;
        }
        return mv;
    }
    boolean isFatClicked=false;
    @GetMapping("/sortproductfat")
    public ModelAndView sortProductsByFat(){
        //unutar index view
        ModelAndView mv=new ModelAndView("index");
        //sortiramo sve objekte u bazi po imenu
        if (isFatClicked==false){
            mv.addObject("products",productsRepo.findAll().stream()
                    .sorted(Comparator.comparing(Product::getProductFat).reversed())
                    .collect(Collectors.toList()));
            mv.addObject("arrowFat","▼");
            mv.addObject("arrowEne"," ");
            mv.addObject("arrowPri"," ");
            mv.addObject("arrowPro"," ");
            mv.addObject("arrowCar"," ");
            mv.addObject("arrowProt"," ");
            mv.addObject("arrowSal"," ");
            mv.addObject("arrowFib"," ");
            falseFunction();
            isFatClicked=true;
        }
        else{
            mv.addObject("products",productsRepo.findAll().stream()
                    .sorted(Comparator.comparing(Product::getProductFat))
                    .collect(Collectors.toList()));
            mv.addObject("arrowEne"," ");
            mv.addObject("arrowPri"," ");
            mv.addObject("arrowPro"," ");
            mv.addObject("arrowCar"," ");
            mv.addObject("arrowProt"," ");
            mv.addObject("arrowSal"," ");
            mv.addObject("arrowFib"," ");
            mv.addObject("arrowFat","▲");
            isFatClicked=false;
        }
        return mv;
    }
    boolean carbohydratesClicked=false;
    @GetMapping("/sortproductcarbohydrates")
    public ModelAndView sortProductsByCarbohydrates(){
        //unutar index view
        ModelAndView mv=new ModelAndView("index");
        //sortiramo sve objekte u bazi po imenu
        if (carbohydratesClicked==false){
            mv.addObject("products",productsRepo.findAll().stream()
                    .sorted(Comparator.comparing(Product::getProductCarbohydrates).reversed())
                    .collect(Collectors.toList()));
            mv.addObject("arrowCar","▼");
            mv.addObject("arrowEne"," ");
            mv.addObject("arrowPri"," ");
            mv.addObject("arrowPro"," ");
            mv.addObject("arrowProt"," ");
            mv.addObject("arrowSal"," ");
            mv.addObject("arrowFib"," ");
            mv.addObject("arrowFat"," ");
            falseFunction();
            carbohydratesClicked=true;
        }
        else{
            mv.addObject("products",productsRepo.findAll().stream()
                    .sorted(Comparator.comparing(Product::getProductCarbohydrates))
                    .collect(Collectors.toList()));
            mv.addObject("arrowCar","▲");
            mv.addObject("arrowCar","");
            mv.addObject("arrowEne"," ");
            mv.addObject("arrowPri"," ");
            mv.addObject("arrowPro"," ");
            mv.addObject("arrowProt"," ");
            mv.addObject("arrowSal"," ");
            mv.addObject("arrowFib"," ");
            mv.addObject("arrowFat"," ");
            carbohydratesClicked=false;
        }
        return mv;
    }
    boolean proteinClicked=false;
    @GetMapping("/sortproductprotein")
    public ModelAndView sortProductsByProtein(){
        //unutar index view
        ModelAndView mv=new ModelAndView("index");
        //sortiramo sve objekte u bazi po imenu
        if (proteinClicked==false){
            mv.addObject("products",productsRepo.findAll().stream()
                    .sorted(Comparator.comparing(Product::getProductProtein).reversed())
                    .collect(Collectors.toList()));
            mv.addObject("arrowProt","▼");
            mv.addObject("arrowCar"," ");
            mv.addObject("arrowCar","");
            mv.addObject("arrowEne"," ");
            mv.addObject("arrowPri"," ");
            mv.addObject("arrowPro"," ");
            mv.addObject("arrowSal"," ");
            mv.addObject("arrowFib"," ");
            mv.addObject("arrowFat"," ");
            falseFunction();
            proteinClicked=true;
        }
        else{
            mv.addObject("products",productsRepo.findAll().stream()
                    .sorted(Comparator.comparing(Product::getProductProtein))
                    .collect(Collectors.toList()));
            mv.addObject("arrowProt","▲");
            mv.addObject("arrowCar"," ");
            mv.addObject("arrowCar","");
            mv.addObject("arrowEne"," ");
            mv.addObject("arrowPri"," ");
            mv.addObject("arrowPro"," ");
            mv.addObject("arrowSal"," ");
            mv.addObject("arrowFib"," ");
            mv.addObject("arrowFat"," ");
            proteinClicked=false;
        }
        return mv;
    }
    boolean saltClicked=false;
    @GetMapping("/sortproductsalt")
    public ModelAndView sortProductsBySalt(){
        //unutar index view
        ModelAndView mv=new ModelAndView("index");
        //sortiramo sve objekte u bazi po imenu
        if (saltClicked==false){
            mv.addObject("products",productsRepo.findAll().stream()
                    .sorted(Comparator.comparing(Product::getProductSalt).reversed())
                    .collect(Collectors.toList()));
            mv.addObject("arrowSal","▼");
            mv.addObject("arrowPro"," ");
            mv.addObject("arrowCar"," ");
            mv.addObject("arrowCar","");
            mv.addObject("arrowEne"," ");
            mv.addObject("arrowPri"," ");
            mv.addObject("arrowProt"," ");
            mv.addObject("arrowFib"," ");
            mv.addObject("arrowFat"," ");
            falseFunction();
            saltClicked=true;
        }
        else{
            mv.addObject("products",productsRepo.findAll().stream()
                    .sorted(Comparator.comparing(Product::getProductSalt))
                    .collect(Collectors.toList()));
            mv.addObject("arrowSal","▲");
            mv.addObject("arrowPro"," ");
            mv.addObject("arrowCar"," ");
            mv.addObject("arrowCar","");
            mv.addObject("arrowEne"," ");
            mv.addObject("arrowPri"," ");
            mv.addObject("arrowProt"," ");
            mv.addObject("arrowFib"," ");
            mv.addObject("arrowFat"," ");
            saltClicked=false;
        }
        return mv;
    }
    boolean fibersClicked=false;
    @GetMapping("/sortproductfibers")
    public ModelAndView sortProductsByFibers(){
        //unutar index view
        ModelAndView mv=new ModelAndView("index");
        //sortiramo sve objekte u bazi po imenu
        if (fibersClicked==false){
            mv.addObject("products",productsRepo.findAll().stream()
                    .sorted(Comparator.comparing(Product::getProductFibers).reversed())
                    .collect(Collectors.toList()));
            mv.addObject("arrowFib","▼");
            mv.addObject("arrowSal"," ");
            mv.addObject("arrowPro"," ");
            mv.addObject("arrowCar"," ");
            mv.addObject("arrowCar","");
            mv.addObject("arrowEne"," ");
            mv.addObject("arrowPri"," ");
            mv.addObject("arrowProt"," ");
            mv.addObject("arrowFat"," ");
            falseFunction();
            fibersClicked=true;
        }
        else{
            mv.addObject("products",productsRepo.findAll().stream()
                    .sorted(Comparator.comparing(Product::getProductFibers))
                    .collect(Collectors.toList()));
            mv.addObject("arrowFib","▲");
            mv.addObject("arrowSal"," ");
            mv.addObject("arrowPro"," ");
            mv.addObject("arrowCar"," ");
            mv.addObject("arrowCar","");
            mv.addObject("arrowEne"," ");
            mv.addObject("arrowPri"," ");
            mv.addObject("arrowProt"," ");
            mv.addObject("arrowFat"," ");
            fibersClicked=false;
        }
        return mv;
    }
    void falseFunction(){
        fibersClicked=false;
        saltClicked=false;
        proteinClicked=false;
        carbohydratesClicked=false;
        isFatClicked=false;
        isEnergyClicked=false;
        PriceClicked=false;
        nameClicked=false;
    }
}
