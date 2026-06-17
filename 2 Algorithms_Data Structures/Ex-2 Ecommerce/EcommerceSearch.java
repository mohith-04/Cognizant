import java.util.Arrays;

public class EcommerceSearch {

    public static Product linearSearch(Product[] products, int targetId) {
        for (Product product : products) {
            if (product.getProductId() == targetId) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, int targetId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midId = products[mid].getProductId();

            if (midId == targetId) {
                return products[mid];
            }
            if (midId < targetId) {
                left = mid + 1; 
            } else {
                right = mid - 1; 
            }
        }
        return null; 
    }

    public static void main(String[] args) {

        Product[] inventory = {
            new Product(105, "Earphones", "Electronics"),
            new Product(101, "Shoes", "Apparel"),
            new Product(108, "Coffee machine", "Home & Kitchen"),
            new Product(102, "Smartphone", "Electronics"),
            new Product(104, "Fitband", "Fitness")
        };

        int searchId = 104;

        System.out.println("Linear Search");
        Product foundLinear = linearSearch(inventory, searchId);
        System.out.println(foundLinear != null ? "Found: " + foundLinear : "Product not found.");

        System.out.println("\n Binary Search");
        Arrays.sort(inventory);
        Product foundBinary = binarySearch(inventory, searchId);
        System.out.println(foundBinary != null ? "Found: " + foundBinary : "Product not found.");
    }
}