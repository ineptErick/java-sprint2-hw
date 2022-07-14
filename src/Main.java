import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // Возможно, совсем неверно поняла задачу:
    // необходимо иметь методы для каждого из трех файлов или же общий метод для любого входного файла?

    public void main(String[] args) {
        Scanner user = new Scanner(System.in);
        final int exit = 666;

        while(true) {
            System.out.println("Что вы хотите сделать?");
            Menu();
            int userInput = user.nextInt();

            if (userInput == 1) { // Считать все месячные отчёты

                MonthlyReport mreport1 = new MonthlyReport("src/m.202101.csv");
                if(true){
                    System.out.println("Отчет за Январь считан.");
                }else{
                    System.out.println("Ошибка! Не удалось считать отчет. Попробуйте еще раз.");
                    Menu();
                }

                MonthlyReport mreport2 = new MonthlyReport("src/m.202102.csv");
                if(true){
                    System.out.println("Отчет за Февраль считан.");
                }else{
                    System.out.println("Ошибка! Не удалось считать отчет. Попробуйте еще раз.");
                    Menu();
                }

                MonthlyReport mreport3 = new MonthlyReport("src/m.202103.csv");
                if(true){
                    System.out.println("Отчет за Март считан.");
                }else{
                    System.out.println("Ошибка! Не удалось считать отчет. Попробуйте еще раз.");
                    Menu();
                }

                if(true){
                    System.out.println("Месячные отчеты считаны.");
                }


            } else if (userInput == 2) { // Считать годовой отчёт
                YearlyReport yreport = new YearlyReport("src/y.2021.csv");
                if(true){
                    System.out.println("Годовой отчет считан.");
                }else{
                    System.out.println("Не удалось загрузить готовой отчет. Попробуйте еще раз.");
                    Menu();
                }

            } else if (userInput == 3) { // Сверить отчёты

                MonthlyReport.expensesMonth(yreport, ArrayList<MRecord> rows);
                MonthlyReport.incomesMonth(yreport, ArrayList<MRecord> rows);
                MonthlyReport.expensesAllMonths(ArrayList<MRecord> rows);
                MonthlyReport.incomesAllMonths(ArrayList<MRecord> rows);
                comparing(ArrayList<MRecord> rows, YearlyReport yearlyReport);

            } else if (userInput == 4) { // Вывести информацию о всех месячных отчётах
                MonthlyReport.printMonth(yreport, ArrayList<MRecord> rows);

            } else if (userInput == 5) { // Вывести информацию о годовом отчёте
                YearlyReport.printYear(yreport, ArrayList<MRecord> rows);

            } else if (userInput == 666) { // Программа должна завершаться только при вводе оператором специальной последовательности символов.
                System.out.println("До встречи.");
            } else {
                System.out.println("Нет такого пункта меню.");
                Menu();
            }
        }

    }

    public void Menu() {
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию о всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
    }

    public void comparing(ArrayList<MRecord> rows, YearlyReport yearlyReport){
        if((rows.size()!=0) && yearlyReport.rows.size()!=0){
            if((MonthlyReport.expensesAllMonths(rows)==YearlyReport.expensesYear(rows)) && (MonthlyReport.incomesAllMonths(rows)==YearlyReport.incomesYear(rows))){

            }else{
                System.out.println("Обнаружено несоответствие. Проверьте исходные данные!");
            }
        }else {
            System.out.println("Нет информации об отчетах.");
        }
    }

}

