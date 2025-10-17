package com.elkabani.firstspringboot;

import com.elkabani.firstspringboot.entities.Address;
import com.elkabani.firstspringboot.entities.Category;
import com.elkabani.firstspringboot.entities.Product;
import com.elkabani.firstspringboot.entities.User;
import com.elkabani.firstspringboot.repositories.CategoryRepository;
import com.elkabani.firstspringboot.repositories.ProductRepository;
import com.elkabani.firstspringboot.repositories.UserRepository;
import com.elkabani.firstspringboot.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;

@SpringBootApplication
public class FirstSpringBootApplication {

    public static void main(String[] args)
    {
        ApplicationContext context =  SpringApplication.run(FirstSpringBootApplication.class, args);

        ProductRepository productRepo = context.getBean(ProductRepository.class);
        CategoryRepository categoryRepo = context.getBean(CategoryRepository.class);

        //Starting Data
        System.out.println(" ");
        System.out.println("----------------------------------------------------");
        System.out.println("All categories starting data: " + categoryRepo.findAll());
        System.out.println("All products starting data: " + productRepo.findAll());
        System.out.println("----------------------------------------------------");
        System.out.println(" ");

        //A) Create a Product with a New Category
        Category electronics = new Category();
        electronics.setName("Electronics");
        categoryRepo.save(electronics);

        Product camera = new Product();
        camera.setName("Camera");
        camera.setPrice(new BigDecimal("299.99"));
        camera.setCategory(electronics);
        productRepo.save(camera);

        System.out.println(" ");
        System.out.println("---TABLE DATA AFTER ADDING ELECTRONICS AND CAMERA---");
        categoryRepo.findAll().forEach(System.out::println);
        productRepo.findAll().forEach(System.out::println);
        System.out.println("----------------------------------------------------");
        System.out.println(" ");

        //B) Create a Product for an Existing Category
        Category existing = categoryRepo.findById(electronics.getId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Product headphones = new Product();
        headphones.setName("Headphones");
        headphones.setPrice(new BigDecimal("89.99"));
        headphones.setCategory(existing);
        productRepo.save(headphones);

        System.out.println(" ");
        System.out.println("---TABLE DATA AFTER ADDING HEADPHONES---");
        productRepo.findAll().forEach(System.out::println);
        System.out.println("----------------------------------------------------");
        System.out.println(" ");

        //C) Delete a Product
        System.out.println(" ");
        System.out.println("---TABLE DATA BEFORE DELETING HEADPHONES---");
        productRepo.findAll().forEach(System.out::println);
        System.out.println("----------------------------------------------------");
        System.out.println(" ");

        productRepo.deleteById(headphones.getId());

        System.out.println(" ");
        System.out.println("---TABLE DATA AFTER DELETING HEADPHONES---");
        productRepo.findAll().forEach(System.out::println);
        System.out.println("----------------------------------------------------");
        System.out.println(" ");




        //  var userRepository = context.getBean(UserRepository.class);
   //     var userService = context.getBean(UserService.class);
   //     userService.showEntityState();
   //     userService.showRelatedEntities();

     //   userService.persistRelated();
    //      userService.deleteRelated();

   //     var orderService = context.getBean(OrderService.class);
       // var orderservice2 = context.getBean(OrderService.class);
      //var  orderService = new OrderService(new StripePaymentService());
   //     orderService.placeOrder();
       // orderservice2.placeOrder();
     //   var user1 = new User(1L, "John Doe", "jDoe@email.com", "1234");

/*        var user1 = User.builder()
                .name("Jane Smith")
                .email("jSmith@emial.com")
                .password("abcd")
                .build();

       // userRepository.save(user1);
        var user2 = userRepository.findById(2L).orElseThrow();
        System.out.println(user2.getEmail());

        userRepository.deleteById(1L);

        var users = userRepository.findAll();
      users.forEach(u -> System.out.println(u.getName()));

        var address1 = Address.builder()
                .street("123 Main St")
                .city("Springfield")
                .state("IL")
                .zipCode("62701")
                .build();

        user1.addAddress(address1);

        System.out.println(user1); */



    }

}
