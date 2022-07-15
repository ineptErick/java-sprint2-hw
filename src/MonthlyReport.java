import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MonthlyReport {
    private final ArrayList<MRecord> rows = new ArrayList<>();
    // считывание входящего файла и добавление его данных в список
    public void getMonthlyReport(String path){
        String content = readFileContentsOrNull(path);
        String[] lines = content.split("\r?\n");
        for(int i=1; i< lines.length; i++){
            String line = lines[i];
            String[] parts = line.split(",");
            String itemName = parts[0];
            boolean isExpense = Boolean.parseBoolean(parts[1]);
            int quantity = Integer.parseInt(parts[2]);
            int sumOfOne = Integer.parseInt(parts[3]);
            rows.add(new MRecord(itemName,isExpense,quantity,sumOfOne));
        }
    }

    // чтение файла
    private String readFileContentsOrNull(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }

    // проверка, что месячный пустой
    public boolean monthIsNull() {
        return rows.isEmpty();
    }

    // расходы за месяц
    public int expensesMonth() {
        int expensesMonth = 0;
        for (MRecord row : rows) {
                if (row.getIsExpense()) {
                    expensesMonth += (row.getSumOfOne()*row.getQuantity());
                }
        }
        return expensesMonth;
    }

    // доходы за месяц
    public int incomesMonth(){
        int incomesMonth = 0;
            for(MRecord row : rows){
                if(!row.getIsExpense()){
                    incomesMonth += (row.getSumOfOne()*row.getQuantity());
                }
            }
            return incomesMonth;
    }

    // Расходы и доходы за все месяцы
    public int expensesAllMonths(MonthlyReport monthlyReport1, MonthlyReport monthlyReport2, MonthlyReport monthlyReport3){
        int expensesAllMonths = 0;
        expensesAllMonths = monthlyReport1.expensesMonth() + monthlyReport2.expensesMonth() + monthlyReport3.expensesMonth();

        return expensesAllMonths;
    }

    // доход за все месяцы
    public int incomesAllMonths(MonthlyReport monthlyReport1, MonthlyReport monthlyReport2, MonthlyReport monthlyReport3) {
        int incomesAllMonths = 0;
        incomesAllMonths = monthlyReport1.incomesMonth()+monthlyReport2.incomesMonth()+monthlyReport3.incomesMonth();

        return incomesAllMonths;
    }

    // Максимальная трата
    public String maxExpense(){
        int max = 0;
        String maxName = "";
        for(MRecord row : rows){
            if(row.getIsExpense()){
                if((row.getSumOfOne()*row.getQuantity())>max){
                    max = (row.getSumOfOne()*row.getQuantity());
                    maxName = row.getItemName();
                }
            }
        }
        return maxName;
    }

    // Минимальная трата
    public String minExpense(){
        int min = 0;
        String minName = "";
        for(MRecord row : rows){
            if(row.getIsExpense()){
                if((row.getSumOfOne()*row.getQuantity())<min){
                    min = (row.getSumOfOne()*row.getQuantity());
                    minName = row.getItemName();
                }
            }
        }
        return minName;
    }

    // Средняя трата
    public int overageExpense(){
        int overage = 0;
        int div = 0;

        for(int i=0; i<rows.size(); i++){
            for(MRecord row : rows){
                if(row.getIsExpense()){
                    overage = overage + (row.getSumOfOne()*row.getQuantity());
                    div++;
                }
            }
        }
        overage = overage/div;
        return overage;
    }

    // вывести всю информацию о месяце
    public void printMonth() {

        int income = 0;
        String incProduct = "";

        for (MRecord rowInc : rows) {
            if (!rowInc.getIsExpense()) {
                if (rowInc.getQuantity() * rowInc.getSumOfOne() > income) {
                    income = rowInc.getQuantity() * rowInc.getSumOfOne();
                    incProduct = rowInc.getItemName();
                }
            }
        }

        int expense = 0;
        String expProduct = "";

        for (MRecord rowExp : rows) {
            if (rowExp.getIsExpense()) {
                if (rowExp.getQuantity() * rowExp.getSumOfOne() > expense) {
                    expense = rowExp.getQuantity() * rowExp.getSumOfOne();
                    expProduct = rowExp.getItemName();
                }
            }

            System.out.println("Самый прибыльный товар: " + incProduct + ". Стоимость: " + income);
            System.out.println("Самая большая трата: " + expProduct + ". Стоимость: " + expense);

        }

    }
}
