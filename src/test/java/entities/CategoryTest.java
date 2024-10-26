package entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    @Test
    void testEnumValues() {
        assertEquals(7, Category.values().length, "Should have 7 categories");
        assertEquals(Category.ELECTRONICS, Category.valueOf("ELECTRONICS"));
        assertEquals(Category.FURNITURE, Category.valueOf("FURNITURE"));
        assertEquals(Category.CLOTHING, Category.valueOf("CLOTHING"));
        assertEquals(Category.TOYS, Category.valueOf("TOYS"));
        assertEquals(Category.SALES, Category.valueOf("SALES"));
        assertEquals(Category.BOOKS, Category.valueOf("BOOKS"));
        assertEquals(Category.PETS, Category.valueOf("PETS"));
    }

    @Test
    void testEnumOrdinal() {
        assertEquals(0, Category.ELECTRONICS.ordinal());
        assertEquals(1, Category.FURNITURE.ordinal());
        assertEquals(2, Category.CLOTHING.ordinal());
        assertEquals(3, Category.TOYS.ordinal());
        assertEquals(4, Category.SALES.ordinal());
        assertEquals(5, Category.BOOKS.ordinal());
        assertEquals(6, Category.PETS.ordinal());
    }

    @Test
    void testEnumToString() {
        assertEquals("ELECTRONICS", Category.ELECTRONICS.toString());
        assertEquals("FURNITURE", Category.FURNITURE.toString());
        assertEquals("CLOTHING", Category.CLOTHING.toString());
        assertEquals("TOYS", Category.TOYS.toString());
        assertEquals("SALES", Category.SALES.toString());
        assertEquals("BOOKS", Category.BOOKS.toString());
        assertEquals("PETS", Category.PETS.toString());
    }

    @Test
    void testEnumContainsValue() {
        assertTrue(Category.contains("ELECTRONICS"), "Should contain ELECTRONICS");
        assertTrue(Category.contains("FURNITURE"), "Should contain FURNITURE");
        assertTrue(Category.contains("CLOTHING"), "Should contain CLOTHING");
        assertTrue(Category.contains("TOYS"), "Should contain TOYS");
        assertTrue(Category.contains("SALES"), "Should contain SALES");
        assertTrue(Category.contains("BOOKS"), "Should contain BOOKS");
        assertTrue(Category.contains("PETS"), "Should contain PETS");
        assertFalse(Category.contains("FOOD"), "Should not contain FOOD");
    }
}
