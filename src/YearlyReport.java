import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class YearlyReport {
    private final ArrayList<YRecord> rows = new ArrayList<>();

    public YearlyReport(String path){
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

    public static void expensesYear(ArrayList<YRecord> rows){
        int expenses = 0;
        for(YRecord row : rows){
            if(row.isExpense){
                expenses += row.amount;
            }
        }
        System.out.println("Расходы за год составили: "+expenses);
    }

    public static void incomesYear(ArrayList<YRecord> rows){
        int incomes = 0;
        for(YRecord row : rows){
            if(!row.isExpense){
                incomes += row.amount;
            }
        }
        System.out.println("Расходы за год составили: "+incomes);
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

    public static void printYear(ArrayList<YRecord> rows) {
        System.out.println("Информация о годовом отчёте: ");
        System.out.println("Год: 2021");

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
