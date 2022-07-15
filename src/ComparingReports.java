public class ComparingReports {

    public void compareReports(MonthlyReport monthlyReport1, MonthlyReport monthlyReport2, MonthlyReport monthlyReport3, YearlyReport yearlyReport){

        if(!(monthlyReport1.monthIsNull()) && !(monthlyReport2.monthIsNull()) &&
                !(monthlyReport3.monthIsNull()) && !(yearlyReport.yearIsNull())){

            if((monthlyReport1.expensesMonth() == yearlyReport.expensesYearMonth1())
                    && (monthlyReport1.incomesMonth() == yearlyReport.incomesYearMonth1())){

            }else{
                System.out.println("Обнаружено несоответствие в Январе. Проверьте исходные данные!");
            }

            if((monthlyReport2.expensesMonth() == yearlyReport.expensesYearMonth2())
                    && (monthlyReport2.incomesMonth() == yearlyReport.incomesYearMonth2())){

            }else{
                System.out.println("Обнаружено несоответствие в Феврале. Проверьте исходные данные!");
            }

            if((monthlyReport2.expensesMonth() == yearlyReport.expensesYearMonth3())
                    && (monthlyReport2.incomesMonth() == yearlyReport.incomesYearMonth3())){

            }else{
                System.out.println("Обнаружено несоответствие в Марте. Проверьте исходные данные!");
            }
        }else {
            System.out.println("Нет информации об отчетах.");
        }
    }
}

// Этот метод принимает установленное заранее количество отчетов
// Изначально пыталась извратиться, чтобы написать универсальный метод, но не получилось
// Интересно как обстоят дела в реальных приложениях, когда метод заранее не знает сколько отчетов нужно сверять
