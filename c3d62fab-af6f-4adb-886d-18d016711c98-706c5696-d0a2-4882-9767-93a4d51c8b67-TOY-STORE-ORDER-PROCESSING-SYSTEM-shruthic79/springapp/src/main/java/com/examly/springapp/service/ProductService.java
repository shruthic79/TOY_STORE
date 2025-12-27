// package com.examly.springapp.service;

// public interface ProductService {
//     void addProduct(Object product);
// }



package com.examly.springapp.service;

import java.util.List;
import com.examly.springapp.model.Product;

public interface ProductService {

  Product addProduct(Product product);

  List<Product> getAllProducts();

  Product getProductById(Long id);

  Product updateProduct(Product product, Long id);

  void deleteProduct(Long id);
}
