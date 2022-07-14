import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MonthlyReport {
    private final ArrayList<MRecord> rows = new ArrayList<>();

    public MonthlyReport(String path){

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

    // Расходы и доходы за каждый месяц
    // Здесь неверная ссылка на значения month у экз. класса
    public static void expensesMonth(YRecord yRecord, ArrayList<MRecord> rows) {
        int expensesMonth = 0;
        for (int m : yRecord.get(month)) {
            for (MRecord row : rows) {
                if (row.isExpense) {
                    expensesMonth = (row.sumOfOne * row.quantity);
                    System.out.println("Расходы за " + m + " месяц составили: " + expensesMonth);
                }
            }
        }
    }

    public static void incomesMonth(YRecord yRecord, ArrayList<MRecord> rows){
        int incomesMonth = 0;
        for(int m : yRecord.get(month)){
            for(MRecord row : rows){
                if(!row.isExpense){
                    incomesMonth = (row.sumOfOne*row.quantity);
                    System.out.println("Доходы за "+m+" месяц составили: "+incomesMonth);
                }
            }
        }
    }

    // Расходы и доходы за все месяцы
    public static void expensesAllMonths(ArrayList<MRecord> rows){
        int expensesAllMonths = 0;
        for(MRecord row : rows){
            if(row.isExpense){
                expensesAllMonths += (row.sumOfOne*row.quantity);
            }
        }
        System.out.println("Расходы за все месяцы составили: "+expensesAllMonths);
    }

    public static void incomesAllMonths(ArrayList<MRecord> rows) {
        int incomesAllMonths = 0;
        for (MRecord row : rows) {
            if (!row.isExpense) {
                incomesAllMonths += (row.sumOfOne * row.quantity);
            }
        }
        System.out.println("Доходы за все месяцы составили: " + incomesAllMonths);
    }

    // Максимальная трата
    public String maxExpense(){
        int max = 0;
        String maxName = "";
        for(MRecord row : rows){
            if(row.isExpense){
                if((row.sumOfOne*row.quantity)>max){
                    max = (row.sumOfOne*row.quantity);
                    maxName = row.itemName;
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
            if(row.isExpense){
                if((row.sumOfOne*row.quantity)<min){
                    min = (row.sumOfOne*row.quantity);
                    minName = row.itemName;
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
                if(row.isExpense){
                    overage = overage + (row.sumOfOne*row.quantity);
                    div++;
                }
            }
        }
        overage = overage/div;
        return overage;
    }

    // вывести всю информацию о месяце
    public static void printMonth(ArrayList<MRecord> rows) {
        System.out.println("Информация о всех месячных отчётах:");

        int income = 0;
        String product = "";

        for (MRecord m : rows) {
            if (!m.isExpense) {
                if (m.quantity * m.sumOfOne > income) {
                    income = m.quantity * m.sumOfOne;
                    product = m.itemName;
                }
            }
        }

        int expense = 0;
        String expProduct = "";

        for (MRecord m : rows) {
            if (m.isExpense) {
                if (m.quantity * m.sumOfOne > expense) {
                    expense = m.quantity * m.sumOfOne;
                    expProduct = m.itemName;
                }
            }

            System.out.println("Самый прибыльный товар: " + product + ". Стоимость: " + income);
            System.out.println("Самая большая трата: " + expProduct + ". Стоимость: " + expense);

        }

    }
}
