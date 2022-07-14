public class YRecord {
    private int month;
    int amount;
    boolean isExpense;

    YRecord(int month, int amount, boolean isExpense) {
        this.setMonth(month);
        this.amount = amount;
        this.isExpense = isExpense;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }
}
