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

    // проверка на то, что годовой отчет не пустой
    public boolean yearIsNotNull(){
        return !rows.isEmpty();
    }

    // здесь я сделала переменные rows package-private, get'еры и set'еры не пришлось использовать
    // потому что при попытке использовать именно их, не поняла как получить переменные в raws (isExpense, amount)
    // можно ли так делать или на меня грянет кара небесная?
    public void expensesYear(){
        int expenses = 0;
        for(YRecord row : rows){
            if(row.isExpense){
                expenses += row.amount;
            }
        }
        System.out.println("Расходы за год составили: "+expenses);
    }

    // расходы за первый месяц в годовом отчете
    public int expensesYearMonth1(){
        int expensesMonth1 = 0;
        for (YRecord row : rows){
            if(row.isExpense) {
                if (row.getMonth() == 01) {
                    expensesMonth1 += row.amount;
                }
            }
        }
        return expensesMonth1;
    }

    // расходы за второй месяц в годовом отчете
    public int expensesYearMonth2(){
        int expensesMonth2 = 0;
        for (YRecord row : rows){
            if(row.isExpense) {
                if (row.getMonth() == 02) {
                    expensesMonth2 += row.amount;
                }
            }
        }
        return expensesMonth2;
    }

    // расходы за третий месяц в годовом отчете
    public int expensesYearMonth3(){
        int expensesMonth3 = 0;
        for (YRecord row : rows){
            if(row.isExpense) {
                if (row.getMonth() == 03) {
                    expensesMonth3 += row.amount;
                }
            }
        }
        return expensesMonth3;
    }

    // доход за год
    public int incomesYear(){
        int incomes = 0;
        for(YRecord row : rows){
            if(!row.isExpense){
                incomes += row.amount;
            }
        }
        return incomes;
    }

    // доход за 1 месяц согласно годовому отчету
    public int incomesYearMonth1(){
        int incomesMonth1 = 0;
        for(YRecord row : rows){
            if(!row.isExpense){
                if(row.getMonth() == 03) {
                    incomesMonth1 += row.amount;
                }
            }
        }
        return incomesMonth1;
    }

    // доход за 2 месяц согласно годовому отчету
    public int incomesYearMonth2(){
        int incomesMonth2 = 0;
        for(YRecord row : rows){
            if(!row.isExpense){
                if(row.getMonth() == 03) {
                    incomesMonth2 += row.amount;
                }
            }
        }
        return incomesMonth2;
    }
    // доход за 3 месяц согласно годовому отчету
    public int incomesYearMonth3(){
        int incomesMonth3 = 0;
        for(YRecord row : rows){
            if(!row.isExpense){
                if(row.getMonth() == 03) {
                    incomesMonth3 += row.amount;
                }
            }
        }
        return incomesMonth3;
    }

    public int maxExpense(){
        int max = 0;
        for(YRecord row : rows){
            if(row.isExpense){
                if(row.amount > max){
                    max = row.amount;
                }
            }
        }
        return max;
    }

    public int minExpense(){
        int min = 0;
        for(YRecord row : rows){
            if(row.isExpense){
                if(row.amount > min){
                    min = row.amount;
                }
            }
        }
        return min;
    }

    public int overageExpense(){
        int overage = 0;
        for(int i=0; i<rows.size(); i++){
            for(YRecord row : rows){
                if(row.isExpense){
                    overage = overage + row.amount;
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
        for (YRecord y : rows) {
            if (y.isExpense) {
                expenses +=  y.amount;
            }
        }
        int averageExpenses = expenses / 3;
        System.out.println("");

        int income = 0;
        for (YRecord u : rows) {
            if (!u.isExpense) {
                income +=  u.amount;
            }
        }
        int averageIncome = income / 3;

        System.out.println("Средний расход за все месяцы в году: "+averageExpenses);
        System.out.println("Средний доход за все месяцы в году: "+averageIncome);
    }

}
