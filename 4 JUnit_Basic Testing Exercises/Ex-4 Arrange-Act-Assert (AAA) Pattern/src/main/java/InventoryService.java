import java.util.ArrayList;
import java.util.List;

public class InventoryService {
    private List<String> items;

    public InventoryService() {
        this.items = new ArrayList<>();
    }

    public void addItem(String item) {
        this.items.add(item);
    }

    public int getItemCount() {
        return this.items.size();
    }

    public void clear() {
        this.items.clear();
    }
}