import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class InventoryServiceTest {

    private InventoryService inventoryService;

    @Before
    public void setUp() {
        inventoryService = new InventoryService();
    }

    @After
    public void tearDown() {
        inventoryService.clear();
        inventoryService = null;
    }

    @Test
    public void testAddItemIncreasesCount() {
        String item = "Laptop";

        inventoryService.addItem(item);

        int result = inventoryService.getItemCount();
        assertEquals(1, result);
    }
}