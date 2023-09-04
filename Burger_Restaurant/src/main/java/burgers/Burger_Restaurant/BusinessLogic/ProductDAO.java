package burgers.Burger_Restaurant.BusinessLogic;

import burgers.Burger_Restaurant.Food.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface ProductDAO {
    List<Product> selectAllProducts();
    Optional<Product> selectProductById(Integer id);
}
