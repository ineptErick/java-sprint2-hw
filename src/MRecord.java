public class MRecord {
    String itemName;
    boolean isExpense;
    int quantity;
    int sumOfOne;

    MRecord(String itemName, boolean isExpense, int quantity, int sumOfOne){
        this.itemName = itemName;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.sumOfOne = sumOfOne;
    }
}
