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

    public String getItemName(){
        return itemName;
    }
    public void setItemName(String itemName){
        this.itemName=itemName;
    }
    public boolean getIsExpense(){
        return isExpense;
    }
    public void setIsExpense(boolean isExpense){
        this.isExpense=isExpense;
    }
    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int quantity){
        this.quantity=quantity;
    }
    public int getSumOfOne(){
        return sumOfOne;
    }
    public void setSumOfOne(int sumOfOne){
        this.sumOfOne=sumOfOne;
    }
}
