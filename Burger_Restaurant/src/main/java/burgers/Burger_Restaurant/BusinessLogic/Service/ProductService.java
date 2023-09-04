package burgers.Burger_Restaurant.BusinessLogic.Service;

import burgers.Burger_Restaurant.BusinessLogic.ProductDAO;
import burgers.Burger_Restaurant.Food.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductDAO productDAO;

    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public List<Product> getAllProducts(){
        return productDAO.selectAllProducts();
    }

    public Product getProduct(Integer id){
        return productDAO.selectProductById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "product with id [%s] not found".formatted(id)));
    }
}
