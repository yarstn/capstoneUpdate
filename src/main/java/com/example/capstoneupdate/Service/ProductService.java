package com.example.capstoneupdate.Service;

import com.example.capstoneupdate.Model.Merchant;
import com.example.capstoneupdate.Model.MerchantStock;
import com.example.capstoneupdate.Model.Product;
import com.example.capstoneupdate.Model.User;
import com.example.capstoneupdate.Repository.MarchentRepositry;
import com.example.capstoneupdate.Repository.MarchentStockRepositry;
import com.example.capstoneupdate.Repository.ProductRepositry;
import com.example.capstoneupdate.Repository.UserRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class ProductService {
//    private final UserService userService;
//    private final MerchantStockService merchantStockService;
//    private final MerchantService merchantService;
private final UserRepositry userRepository;
private final MarchentRepositry marchentRepository;
private final MarchentStockRepositry marchentStockRepository;

//    ArrayList<Product> products = new ArrayList<>();
private final ProductRepositry productRepositry;

    public List<Product> getProducts() {
        return productRepositry.findAll();
    }


    public void addProduct(Product product) {
        productRepositry.save(product);
    }

    public boolean updateProduct(Integer id, Product product) {
    Product p = productRepositry.getReferenceById(id);
    if (p != null) {
        p.setName(product.getName());
        p.setPrice(product.getPrice());
        p.setCategoryId(product.getCategoryId());
        productRepositry.save(p);
        return true;
    }
    return false;
    }


    public boolean deleteProduct(Integer id) {
     Product d = productRepositry.getReferenceById(id);
     if (d != null) {
         productRepositry.delete(d);
         return true;
     }
     return false;
    }

public Product getProduct(Integer id) {
        return productRepositry.getReferenceById(id);
}

    public boolean buyProduct(Integer userId, Integer productId, Integer merchantId) {
User u = userRepository.getReferenceById(userId);
        MerchantStock merchantStock = marchentStockRepository.getReferenceById(merchantId);
        Product product = null;

    if (productId != null) {
        product = productRepositry.getReferenceById(productId);
    }

    if (u != null && product != null && merchantStock != null) {
        if (u.getRole().equals("admin")) {
            if (merchantStock.getStock() < 1) {
                return false;
            }

            if (u.getBalance() < product.getPrice()) {
                return false;
            }
            merchantStock.setStock(merchantStock.getStock() - 1);
            u.setBalance(u.getBalance() - product.getPrice());
            return true;
    }

        }
        return false;
    }

    public Map applyDiscount(Integer merchantId, Integer productId) {
        Merchant merchant = marchentRepository.getReferenceById(merchantId);
        Product product = productRepositry.getReferenceById(productId);

        if (merchant != null && product != null && merchant.getId()== merchantId) {
            if (merchant.getId()==merchantId) {
                // Apply the discount if the price is greater than 200
                if (product.getPrice() > 200) {
                    Product originalProduct = new Product(product); // Clone the original product
                    double discountedPrice = product.getPrice() * 0.90;
                    product.setPrice(discountedPrice);

                    Map<String, Product> response = new HashMap<>();
                    response.put("beforeDiscount", originalProduct);
                    response.put("afterDiscount", product);

productRepositry.save(product);

                    return response;
                }
            }
        }

        // Return null or an empty map if no discount is applied or conditions are not met
        return null;
    }

    //similar product didnt work

//    public List<Product> recommendSimilarProducts(Integer productId) {
//        Product targetProduct = productRepositry.getReferenceById(productId);
//        if (targetProduct == null) {
//            return null;
//        }
//        List<Product> similarProducts = new ArrayList<>();
//        for (Product product : products) {
//            if (!product.equals(targetProduct) && product.getCategoryId()==(targetProduct.getCategoryId())
//                    &&  (product.getPrice() - targetProduct.getPrice()) <= 50) {
//                similarProducts.add(product);
//            }
//        }
//
//        return similarProducts;
//    }
    //search
//    public List<Product> searchProductsByName(String name) {
//        List<Product> filteredProducts = new ArrayList<>();
//
//        for (Product product : getProducts()) {
//            if (name.equalsIgnoreCase("all")) {
//                return products;
//
//            }
//            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
//                filteredProducts.add(product);
//            }
//        }
//        return filteredProducts;
//    }




}
