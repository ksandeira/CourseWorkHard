class EmployeeBook {
    private Employee[] employees;
    private int size;

    public EmployeeBook(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    public boolean addEmployee(Employee employee) {
        if (size < employees.length) {
            employees[size] = employee;
            size++;
            return true;
        }
        return false;
    }

    public void removeEmployee(int id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getId() == id) {
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[size - 1] = null;
                size--;
                return;
            }
        }
    }

    public Employee getEmployeeById(int id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getId() == id) {
                return employees[i];
            }
        }
        return null;
    }

    public void printEmployeeById(int id) {
        Employee employee = getEmployeeById(id);
        if (employee != null) {
            System.out.println("Информация о сотруднике с ID " + id + ":");
            System.out.println(employee);
        } else {
            System.out.println("Сотрудник с ID " + id + " не найден");
        }
    }

    public void printAllEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    public int calculateTotalSalary() {
        int total = 0;
        for (int i = 0; i < size; i++) {
            total += employees[i].getSalary();
        }
        return total;
    }

    public Employee findEmployeeWithMinSalary() {
        if (size == 0) return null;

        Employee minEmployee = employees[0];
        for (int i = 1; i < size; i++) {
            if (employees[i].getSalary() < minEmployee.getSalary()) {
                minEmployee = employees[i];
            }
        }
        return minEmployee;
    }

    public Employee findEmployeeWithMaxSalary() {
        if (size == 0) return null;

        Employee maxEmployee = employees[0];
        for (int i = 1; i < size; i++) {
            if (employees[i].getSalary() > maxEmployee.getSalary()) {
                maxEmployee = employees[i];
            }
        }
        return maxEmployee;
    }

    public double calculateAverageSalary() {
        if (size == 0) return 0;
        return (double) calculateTotalSalary() / size;
    }

    public void printAllEmployeesNames() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i].getFullName());
        }
    }

    public void indexAllSalaries(double percentage) {
        for (int i = 0; i < size; i++) {
            int currentSalary = employees[i].getSalary();
            int newSalary = (int) (currentSalary * (1 + percentage / 100));
            employees[i].setSalary(newSalary);
        }
    }

    public Employee findEmployeeWithMinSalaryInDepartment(int department) {
        Employee minEmployee = null;
        for (int i = 0; i < size; i++) {
            if (employees[i].getDepartment() == department) {
                if (minEmployee == null || employees[i].getSalary() < minEmployee.getSalary()) {
                    minEmployee = employees[i];
                }
            }
        }
        return minEmployee;
    }

    public Employee findEmployeeWithMaxSalaryInDepartment(int department) {
        Employee maxEmployee = null;
        for (int i = 0; i < size; i++) {
            if (employees[i].getDepartment() == department) {
                if (maxEmployee == null || employees[i].getSalary() > maxEmployee.getSalary()) {
                    maxEmployee = employees[i];
                }
            }
        }
        return maxEmployee;
    }

    public int calculateTotalSalaryInDepartment(int department) {
        int total = 0;
        for (int i = 0; i < size; i++) {
            if (employees[i].getDepartment() == department) {
                total += employees[i].getSalary();
            }
        }
        return total;
    }

    public double calculateAverageSalaryInDepartment(int department) {
        int total = 0;
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (employees[i].getDepartment() == department) {
                total += employees[i].getSalary();
                count++;
            }
        }
        return count > 0 ? (double) total / count : 0;
    }

    public void indexSalariesInDepartment(int department, double percentage) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getDepartment() == department) {
                int currentSalary = employees[i].getSalary();
                int newSalary = (int) (currentSalary * (1 + percentage / 100));
                employees[i].setSalary(newSalary);
            }
        }
    }

    public void employeesInDepartment(int department) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getDepartment() == department) {
                System.out.println("ID: " + employees[i].getId() +
                        ", ФИО:" + employees[i].getFullName() +
                        ", ЗП:" + employees[i].getSalary());
            }
        }
    }

    public void employeesWithSalaryLow(int salaryLow) {
        System.out.println("Сотрудники с ЗП меньше " + salaryLow + ":");
        for (int i = 0; i < size; i++) {
            if (employees[i].getSalary() < salaryLow) {
                System.out.println("ID: " + employees[i].getId() +
                        ", ФИО:" + employees[i].getFullName() +
                        ", ЗП:" + employees[i].getSalary());
            }
        }
    }

    public void employeesWithSalaryHigh(int salaryHigh) {
        System.out.println("Сотрудники с большей или равно ЗП " + salaryHigh + ":");
        for (int i = 0; i < size; i++) {
            if (employees[i].getSalary() >= salaryHigh) {
                System.out.println("ID: " + employees[i].getId() +
                        ", ФИО:" + employees[i].getFullName() +
                        ", ЗП:" + employees[i].getSalary());
            }
        }
    }
}