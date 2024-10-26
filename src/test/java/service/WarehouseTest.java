package service;

import entities.Category;
import entities.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseServiceTest {
    private WarehouseService warehouseService;

    @BeforeEach
    void setUp() {
        Warehouse warehouse = new Warehouse();
        warehouseService = new WarehouseService(warehouse);
    }

    @Test
    void testModifyProduct() {
        warehouseService.modifyProduct("1", "Updated Smartphone", Category.ELECTRONICS, 5);
        Optional<Product> updatedProduct = warehouseService.getProductById("1");

        assertTrue(updatedProduct.isPresent());
        assertEquals("Updated Smartphone", updatedProduct.get().name());
        assertEquals(5, updatedProduct.get().rating());
    }

    @Test
    void testGetAllProducts() {
        List<Product> products = warehouseService.getAllProducts(1, 10);
        assertEquals(10, products.size()); // Check that there are 10 default products
    }

    @Test
    void testGetProductById() {
        Optional<Product> product = warehouseService.getProductById("1");
        assertTrue(product.isPresent());
        assertEquals("Smartphone", product.get().name());
    }

    @Test
    void testGetProductsByCategory() {
        List<Product> clothingProducts = warehouseService.getProductsByCategory(Category.CLOTHING);
        assertEquals(3, clothingProducts.size()); // Check that there are 3 clothing products
    }

    @Test
    void testGetProductsCreatedAfter() {
        LocalDate date = LocalDate.now().minusDays(1);
        List<Product> recentProducts = warehouseService.getProductsCreatedAfter(date);
        assertEquals(12, recentProducts.size()); // Check that all default products were created today
    }

    @Test
    void testGetProductsByModified() {
        List<Product> modifiedProducts = warehouseService.getProductsByModified();
        assertEquals(0, modifiedProducts.size()); // Initially, no products are modified
    }

    @Test
    void testGetCategoriesWithProducts() {
        List<Category> categories = warehouseService.getCategoriesWithProducts();
        assertEquals(7, categories.size()); // Check the number of unique categories
    }

    @Test
    void testGetNumberOfProductsByCategory() {
        Map<Category, Long> productsByCategory = warehouseService.getNumberOfProductsByCategory();
        assertEquals(3, productsByCategory.get(Category.CLOTHING));
        assertEquals(1, productsByCategory.get(Category.ELECTRONICS));
    }

    @Test
    void testGetProductsByMaxRatingAndSortedByDate() {
        List<Product> highRatedProducts = warehouseService.getProductsByMaxRatingAndSortedByDate().toList();
        assertEquals(5, highRatedProducts.size()); // Check that there are 5 products with max rating of 5
    }
}
