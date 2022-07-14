public class MRecord {
    private String itemName;
    private boolean isExpense;
    private int quantity;
    private int sumOfOne;

    MRecord(String itemName, boolean isExpense, int quantity, int sumOfOne){
        this.itemName = itemName;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.sumOfOne = sumOfOne;
    }
}
