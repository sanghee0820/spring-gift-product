package gift.controller;


import gift.model.Product;
import gift.model.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository){
        this.productRepository = productRepository;

    }

    @GetMapping("/api/products")
    public List<Product> getAllProducts(){

        return productRepository.findAll();
    }

    @GetMapping("/api/products/{id}")
    public Product getProduct(@PathVariable("id") Long id){

        return productRepository.find(id);
    }
}