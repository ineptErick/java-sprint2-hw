import java.util.Scanner;
public class Main {

    public void main(String[] args) {
        Scanner user = new Scanner(System.in);
        final int exit = 666;
        int year = 2021;

        MonthlyReport mreport1 = new MonthlyReport();
        MonthlyReport mreport2 = new MonthlyReport();
        MonthlyReport mreport3 = new MonthlyReport();
        YearlyReport yreport = new YearlyReport();
        ComparingReports comparing = new ComparingReports();

        while(true) {
            System.out.println("Что вы хотите сделать?");
            menu();
            int userInput = user.nextInt();

            if (userInput == 1) { // Считать все месячные отчёты
                mreport1.getMonthlyReport("src/m.202101.csv");
                if(true){
                    System.out.println("Отчет за Январь считан.");
                }else{
                    System.out.println("Ошибка! Не удалось считать отчет. Попробуйте еще раз.");
                    menu();
                }

                mreport2.getMonthlyReport("src/m.202102.csv");
                if(true){
                    System.out.println("Отчет за Февраль считан.");
                }else{
                    System.out.println("Ошибка! Не удалось считать отчет. Попробуйте еще раз.");
                    menu();
                }

                mreport3.getMonthlyReport("src/m.202103.csv");
                if(true){
                    System.out.println("Отчет за Март считан.");
                }else{
                    System.out.println("Ошибка! Не удалось считать отчет. Попробуйте еще раз.");
                    menu();
                }

                if(true){
                    System.out.println("Месячные отчеты считаны.");
                }


            } else if (userInput == 2) { // Считать годовой отчёт
                yreport.getYearlyReport("src/y.2021.csv");
                if(true){
                    System.out.println("Годовой отчет считан.");
                }else{
                    System.out.println("Не удалось загрузить годовой отчет. Попробуйте еще раз.");
                    menu();
                }

            } else if (userInput == 3) { // Сверить отчёты
                comparing.compareReports(mreport1, mreport2, mreport3, yreport);

            } else if (userInput == 4) { // Вывести информацию о всех месячных отчётах
                System.out.println("Информация о всех месячных отчётах:");
                System.out.println("Информация о Январе:");
                mreport1.printMonth();
                System.out.println("Информация о Феврале:");
                mreport2.printMonth();
                System.out.println("Информация о Марте:");
                mreport3.printMonth();

            } else if (userInput == 5) { // Вывести информацию о годовом отчёте
                yreport.printYear(year);

            } else if (userInput == 666) { // Программа должна завершаться только при вводе оператором специальной последовательности символов.
                System.out.println("До встречи.");
            } else {
                System.out.println("Нет такого пункта меню.");
                menu();
            }
        }

    }

    public void menu() {
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию о всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
    }



}

