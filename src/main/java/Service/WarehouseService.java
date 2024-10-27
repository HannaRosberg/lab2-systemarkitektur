package service;

import entities.Category;
import entities.Product;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ApplicationScoped
public class WarehouseService {
    private final Lock lock = new ReentrantLock();
    private service.Warehouse warehouse;

    public WarehouseService() {
        this.warehouse = new service.Warehouse();
        addDefaultProducts();
    }

    @Inject
    public WarehouseService(service.Warehouse warehouse) {
        this.warehouse = warehouse;
        addDefaultProducts();
    }

    private void addDefaultProducts() {
        addProduct(new Product("1", "Smartphone", Category.ELECTRONICS, 5, LocalDate.now(), LocalDate.now()));
        addProduct(new Product("2", "T-shirt", Category.CLOTHING, 4, LocalDate.now(), LocalDate.now()));
        addProduct(new Product("3", "Table", Category.FURNITURE, 3, LocalDate.now(), LocalDate.now()));
        addProduct(new Product("4", "Firetruck car", Category.TOYS, 4, LocalDate.now(), LocalDate.now()));
        addProduct(new Product("5", "Chew toy", Category.PETS, 5, LocalDate.now(), LocalDate.now()));
        addProduct(new Product("6", "Grey sofa", Category.SALES, 3, LocalDate.now(), LocalDate.now()));
        addProduct(new Product("7", "Elsewhere by Gabrielle Zevin", Category.BOOKS, 5, LocalDate.now(), LocalDate.now()));
        addProduct(new Product("8", "Jeans", Category.CLOTHING, 2, LocalDate.now(), LocalDate.now()));
        addProduct(new Product("9", "Teddy bear", Category.TOYS, 5, LocalDate.now(), LocalDate.now()));
        addProduct(new Product("10", "Cat food", Category.PETS, 3, LocalDate.now(), LocalDate.now()));
        addProduct(new Product("11", "Scratching post", Category.SALES, 5, LocalDate.now(), LocalDate.now()));
        addProduct(new Product("12", "Socks", Category.CLOTHING, 1, LocalDate.now(), LocalDate.now()));
    }

    public void addProduct(Product product) {
        lock.lock();
        try {
            warehouse.addProduct(product);
        } finally {
            lock.unlock();
        }
    }

    public void modifyProduct(String id, String name, Category category, int rating) {
        lock.lock();
        try {
            warehouse.modifyProduct(id, name, category, rating);
        } finally {
            lock.unlock();
        }
    }

    public List<Product> getAllProducts(int page, int size) {
        lock.lock();
        try {
            int start = (page - 1) * size;
            return warehouse.getAllProducts().stream()
                    .skip(start)
                    .limit(size)
                    .collect(Collectors.toList());
        } finally {
            lock.unlock();
        }
    }

    public Optional<Product> getProductById(String id) {
        lock.lock();
        try {
            return warehouse.getProductById(id);
        } finally {
            lock.unlock();
        }
    }

    public List<Product> getProductsByCategory(Category category) {
        lock.lock();
        try {
            return warehouse.getProductsByCategory(category);
        } finally {
            lock.unlock();
        }
    }

    public List<Product> getProductsCreatedAfter(LocalDate date) {
        lock.lock();
        try {
            return warehouse.getProductsCreatedAfter(date);
        } finally {
            lock.unlock();
        }
    }

    public List<Product> getProductsByModified() {
        lock.lock();
        try {
            return warehouse.getProductsByModified();
        } finally {
            lock.unlock();
        }
    }

    public List<Category> getCategoriesWithProducts() {
        lock.lock();
        try {
            return warehouse.getCategoriesWithProducts();
        } finally {
            lock.unlock();
        }
    }

    public Map<Category, Long> getNumberOfProductsByCategory() {
        lock.lock();
        try {
            return warehouse.getNumberOfProductsByCategory();
        } finally {
            lock.unlock();
        }
    }

    public Stream<Product> getProductsByMaxRatingAndSortedByDate() {
        lock.lock();
        try {
            return warehouse.getProductsByMaxRatingAndSortedByDate();
        } finally {
            lock.unlock();
        }
    }
}
