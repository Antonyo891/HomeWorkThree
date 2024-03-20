package seminar03;

import java.time.LocalDate;

public class HeadWorker extends Worker{
    public HeadWorker(String surname, String name, String middleName, String position, String phoneNumber, int salary, LocalDate birthDate) {
        super(surname, name, middleName, position, phoneNumber, salary, birthDate);
    }

    public HeadWorker(String surname, String name, String middleName) {
        super(surname, name, middleName);
    }

    public static void addSalary(Worker[] workers, int age, int addAmount) {
        for (Worker worker : workers) {
            if ((worker.getAge() >= age)&&(worker.getClass()!= HeadWorker.class)) {
                worker.setSalary(worker.getSalary() + addAmount);
            }
        }
        System.out.println("Зарплата повышена успешно!!!");
    }

    public void takeTask(Task task,Worker worker) {
        System.out.println(this.getSurname() + " issued a task to " + worker.getSurname());
        worker.takeTask(task);
    }

    @Override
    public String toString() {
        return "HeadWorker{" +
                "surname='" + this.getSurname() + '\'' +
                ", salary=" + this.getSalary() +
                ", age=" + this.getAge() +
                "}";
    }
}
