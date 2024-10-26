package entities;

public enum Category {
    ELECTRONICS,
    FURNITURE,
    CLOTHING,
    TOYS,
    SALES,
    BOOKS,
    PETS;


    public static boolean contains(String name) {
        for (Category category : values()) {
            if (category.name().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }
}