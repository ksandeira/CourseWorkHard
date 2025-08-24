public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook(15);
        employeeBook.addEmployee(new Employee("Журавлев Игорь Александрович", 1, 42000));
        employeeBook.addEmployee(new Employee("Боброва Евгения Викторовна", 2, 43500));
        employeeBook.addEmployee(new Employee("Мыслин Ярослав Владимирович", 3, 40000));
        employeeBook.addEmployee(new Employee("Гордеева Марина Петровна", 4, 39000));
        employeeBook.addEmployee(new Employee("Афонин Сергей Валерьевич", 5, 65000));
        employeeBook.addEmployee(new Employee("Морозова Татьяна Игоревна", 1, 62000));
        employeeBook.addEmployee(new Employee("Козырева Ирина Васильевна", 2, 59000));
        employeeBook.addEmployee(new Employee("Дуброва Елена Вячеславовна", 3, 55000));
        employeeBook.addEmployee(new Employee("Рыкова Мария Витальевна", 4, 53000));
        employeeBook.addEmployee(new Employee("Ислентьева Дарья Вадимовна", 5, 57000));

        System.out.println("Все сотрудники: ");
        employeeBook.printAllEmployees();

        System.out.println("Сумма затрат на ЗП в рублях: " + employeeBook.calculateTotalSalary());

        System.out.println("Сотрудник с минимальной ЗП в рублях: " + employeeBook.findEmployeeWithMinSalary());

        System.out.println("Сотрудник с максимальной ЗП в рублях: " + employeeBook.findEmployeeWithMaxSalary());

        System.out.println("Средняя ЗП в рублях: " + employeeBook.calculateAverageSalary());

        System.out.println("ФИО всех сотрудников:");
        employeeBook.printAllEmployeesNames();

        System.out.println("Индексация зарплат всех сотрудников на 10%");
        employeeBook.indexAllSalaries(10);
        employeeBook.printAllEmployees();

        for (int department = 1; department <= 5; department++) {
            System.out.println("Отдел: " + department);
            Employee minEmployee = employeeBook.findEmployeeWithMinSalaryInDepartment(department);
            Employee maxEmployee = employeeBook.findEmployeeWithMaxSalaryInDepartment(department);
            int totalSalary = employeeBook.calculateTotalSalaryInDepartment(department);
            double averageSalary = employeeBook.calculateAverageSalaryInDepartment(department);

            System.out.println("Минимальная ЗП: " + (minEmployee != null ? minEmployee : "нет сотрудников"));
            System.out.println("Максимальная ЗП: " + (maxEmployee != null ? maxEmployee : "нет сотрудников"));
            System.out.println("Сумма затрат на ЗП: " + totalSalary + " руб.");
            System.out.println("Средняя ЗП: " + averageSalary + " руб.");
        }

        employeeBook.employeesWithSalaryLow(60000);
        employeeBook.employeesWithSalaryHigh(60000);

        boolean added = employeeBook.addEmployee(new Employee("Ширшова Маргарита Олеговна", 3, 50000));
        System.out.println("Новый сотрудник добавлен: " + added);

        Employee employee = employeeBook.getEmployeeById(11);
        if (employee != null) {
            System.out.println("Найден сотрудник: " + employee);
        }

        employeeBook.removeEmployee(3);
        System.out.println("Сотрудник с ID 3 удален");

        System.out.println("Итоговая сумма затрат на ЗП: " + employeeBook.calculateTotalSalary() + " руб.");
        System.out.println("Итоговая средняя ЗП: " + employeeBook.calculateAverageSalary() + " руб.");

        employeeBook.printEmployeeById(12);

    }
}