package ma.enset.productsapp;
import ma.enset.productsapp.entities.Product;
import ma.enset.productsapp.entities.Supplier;
import ma.enset.productsapp.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
//import java.util.function.Supplier;


@SpringBootApplication
public class ProductsAppApplication {

    public static void main(String[] args) {

        SpringApplication.run(ProductsAppApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository, RepositoryRestConfiguration repositoryRestConfiguration){
        return args -> {
            repositoryRestConfiguration.exposeIdsFor(Supplier.class);
            productRepository.save(new Product(null,"Computer",7600,34));
            productRepository.save(new Product(null,"Printer",1600,134));
            productRepository.save(new Product(null,"Smartphone",1600,34));
        };
    }

}
