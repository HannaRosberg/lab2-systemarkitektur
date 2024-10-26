package entities;

import jakarta.validation.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    private Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testValidProduct() {
        Product product = new Product("1", "Smartphone", Category.ELECTRONICS, 5, LocalDate.now(), LocalDate.now());

        Set<ConstraintViolation<Product>> violations = validator.validate(product);
        assertTrue(violations.isEmpty(), "Should not have any validation errors");
    }

    @Test
    void testProductWithNullId() {
        Product product = new Product(null, "Smartphone", Category.ELECTRONICS, 5, LocalDate.now(), LocalDate.now());

        Set<ConstraintViolation<Product>> violations = validator.validate(product);
        assertEquals(1, violations.size());
        assertEquals("must not be null", violations.iterator().next().getMessage());
    }

    @Test
    void testProductWithEmptyName() {
        Product product = new Product("5", "", Category.TOYS, 5, LocalDate.now(), LocalDate.now());

        Set<ConstraintViolation<Product>> violations = validator.validate(product);
        assertEquals(1, violations.size());
        assertEquals("Empty names not allowed", violations.iterator().next().getMessage());
    }

    @Test
    void testProductWithNullCategory() {
        Product product = new Product("2", "Table", null, 5, LocalDate.now(), LocalDate.now());

        Set<ConstraintViolation<Product>> violations = validator.validate(product);
        assertEquals(1, violations.size());
        assertEquals("must not be null", violations.iterator().next().getMessage());
    }

    @Test
    void testProductWithInvalidRatingTooLow() {
        Product product = new Product("4", "Chew toys", Category.TOYS, -1, LocalDate.now(), LocalDate.now());

        Set<ConstraintViolation<Product>> violations = validator.validate(product);
        assertEquals(1, violations.size());
        assertEquals("Rating should be between 1-5", violations.iterator().next().getMessage());
    }

    @Test
    void testProductWithInvalidRatingTooHigh() {
        Product product = new Product("4", "Jeans", Category.CLOTHING, 6, LocalDate.now(), LocalDate.now());

        Set<ConstraintViolation<Product>> violations = validator.validate(product);
        assertEquals(1, violations.size());
        assertEquals("Rating should be between 1-5", violations.iterator().next().getMessage());
    }

    @Test
    void testProductWithPastCreatedDate() {
        Product product = new Product("7", "Scratching post", Category.SALES, 5, LocalDate.of(2022, 1, 1), LocalDate.now());

        Set<ConstraintViolation<Product>> violations = validator.validate(product);
        assertTrue(violations.isEmpty(), "Should not have any validation errors");
    }

    @Test
    void testProductWithNullModifiedDate() {
        Product product = new Product("1", "Smartphone", Category.ELECTRONICS, 5, LocalDate.now(), null);

        Set<ConstraintViolation<Product>> violations = validator.validate(product);
        assertTrue(violations.isEmpty(), "Should not have any validation errors");
    }

    @Test
    void testProductModifiedDateDefaultsToCreatedDate() {
        LocalDate now = LocalDate.now();
        Product product = new Product("1", "Elsewhere by Gabrielle Zevin", Category.BOOKS, 5, now, null);

        assertEquals(now, product.modifiedDate());
    }
}
