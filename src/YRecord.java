public class YRecord {
    private int month;
    private int amount;
    private boolean isExpense;

    YRecord(int month, int amount, boolean isExpense) {
        this.setMonth(month);
        this.setAmount(amount);
        this.setIsExpense(isExpense);
    }

    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public int getAmount(){
        return amount;
    }
    public void setAmount(int amount){
        this.amount = amount;
    }
    public boolean getIsExpense(){
        return isExpense;
    }
    public void setIsExpense(boolean isExpense){
        this.isExpense = isExpense;
    }
}
