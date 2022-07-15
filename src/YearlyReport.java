import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class YearlyReport {
    private final ArrayList<YRecord> rows = new ArrayList<>();

    public void getYearlyReport(String path){
        String content = readFileContentsOrNull(path);
        String[] lines = content.split("\r?\n");
        for(int i=1; i<lines.length; i++ ){
            String line = lines[i];
            String[] parts = line.split(",");
            int month = Integer.parseInt(parts[0]);
            int amount = Integer.parseInt(parts[1]);
            boolean isExpense = Boolean.parseBoolean(parts[2]);
            rows.add(new YRecord(month,amount,isExpense));
        }
    }

    private String readFileContentsOrNull(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }

    // проверка на то, что годовой отчет пустой
    public boolean yearIsNull(){
        return rows.isEmpty();
    }

    // расходы за год
    public int expensesYear(){
        int expenses = 0;
        for(YRecord row : rows){
            if(row.getIsExpense()){
                expenses += row.getAmount();
            }
        }
        return expenses;
    }

    // расходы за первый месяц в годовом отчете
    public int expensesYearMonth1(){
        int expensesMonth1 = 0;
        for (YRecord row : rows){
            if(row.getIsExpense()) {
                if (row.getMonth() == 01) {
                    expensesMonth1 += row.getAmount();
                }
            }
        }
        return expensesMonth1;
    }

    // расходы за второй месяц в годовом отчете
    public int expensesYearMonth2(){
        int expensesMonth2 = 0;
        for (YRecord row : rows){
            if(row.getIsExpense()) {
                if (row.getMonth() == 02) {
                    expensesMonth2 += row.getAmount();
                }
            }
        }
        return expensesMonth2;
    }

    // расходы за третий месяц в годовом отчете
    public int expensesYearMonth3(){
        int expensesMonth3 = 0;
        for (YRecord row : rows){
            if(row.getIsExpense()) {
                if (row.getMonth() == 03) {
                    expensesMonth3 += row.getAmount();
                }
            }
        }
        return expensesMonth3;
    }

    // доход за год
    public int incomesYear(){
        int incomes = 0;
        for(YRecord row : rows){
            if(!row.getIsExpense()){
                incomes += row.getAmount();
            }
        }
        return incomes;
    }

    // доход за 1 месяц согласно годовому отчету
    public int incomesYearMonth1(){
        int incomesMonth1 = 0;
        for(YRecord row : rows){
            if(!row.getIsExpense()){
                if(row.getMonth() == 03) {
                    incomesMonth1 += row.getAmount();
                }
            }
        }
        return incomesMonth1;
    }

    // доход за 2 месяц согласно годовому отчету
    public int incomesYearMonth2(){
        int incomesMonth2 = 0;
        for(YRecord row : rows){
            if(!row.getIsExpense()){
                if(row.getMonth() == 03) {
                    incomesMonth2 += row.getAmount();
                }
            }
        }
        return incomesMonth2;
    }
    // доход за 3 месяц согласно годовому отчету
    public int incomesYearMonth3(){
        int incomesMonth3 = 0;
        for(YRecord row : rows){
            if(!row.getIsExpense()){
                if(row.getMonth() == 03) {
                    incomesMonth3 += row.getAmount();
                }
            }
        }
        return incomesMonth3;
    }

    public int maxExpense(){
        int max = 0;
        for(YRecord row : rows){
            if(row.getIsExpense()){
                if(row.getAmount() > max){
                    max = row.getAmount();
                }
            }
        }
        return max;
    }

    public int minExpense(){
        int min = 0;
        for(YRecord row : rows){
            if(row.getIsExpense()){
                if(row.getAmount() > min){
                    min = row.getAmount();
                }
            }
        }
        return min;
    }

    public int overageExpense(){
        int overage = 0;
        for(int i=0; i<rows.size(); i++){
            for(YRecord row : rows){
                if(row.getIsExpense()){
                    overage = overage + row.getAmount();
                }
            }
            overage = overage/i;
        }
        return overage;
    }

    public void printYear(int year) {
        System.out.println("Информация о годовом отчёте: ");
        System.out.println("Год: "+year);

        int expenses = 0;
        for (YRecord yearExpRow : rows) {
            if (yearExpRow.getIsExpense()) {
                expenses +=  yearExpRow.getAmount();
            }
        }
        int averageExpenses = expenses / 3;
        System.out.println("");

        int income = 0;
        for (YRecord yearIncRow : rows) {
            if (!yearIncRow.getIsExpense()) {
                income +=  yearIncRow.getAmount();
            }
        }
        int averageIncome = income / 3;

        System.out.println("Средний расход за все месяцы в году: "+averageExpenses);
        System.out.println("Средний доход за все месяцы в году: "+averageIncome);
    }

}
