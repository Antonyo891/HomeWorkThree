# Урок 3. Классы и объекты <br>
### *1. Написать [компоратор по фамилии](https://github.com/Antonyo891/HomeWorkThree/blob/master/WorkerSalaryComparator.java)*
```    import java.util.Comparator;

public class WorkerNameComparator implements Comparator<Worker> {

    @Override
    public int compare(Worker o1, Worker o2) {
        String first_surname = o1.getSurname();
        String second_surname = o2.getSurname();
        return first_surname.toLowerCase().compareTo(
                second_surname.toLowerCase());
    }
}
```
### *2. Опишите класс руководителя [Manager](https://github.com/Antonyo891/HomeWorkThree/blob/master/HeadWorker.java), наследник от сотрудника.*
```
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
     @Override
    public String toString() {
        return "HeadWorker{" +
                "surname='" + this.getSurname() + '\'' +
                ", salary=" + this.getSalary() +
                ", age=" + this.getAge() +
                "}";
    }
    
}
```
### *Перенесите статический метод повышения зарплаты в класс руководителя, модифицируйте метод таким образом, чтобы он мог поднять заработную плату всем, кроме руководителей.* 
```
    public static void addSalary(Worker[] workers, int age, int addAmount) {
        for (Worker worker : workers) {
            if ((worker.getAge() >= age)&&(worker.getClass()!= HeadWorker.class)) {
                worker.setSalary(worker.getSalary() + addAmount);
            }
        }
        System.out.println("Зарплата повышена успешно!!!");
    }
}
```
### *В основной программе создайте руководителя и поместите его в общий массив сотрудников. Повысьте зарплату всем сотрудникам и проследите, чтобы зарплата руководителя не повысилась ![picture](https://github.com/Antonyo891/HomeWorkThree/blob/master/SemThreeHW/TaskTwoTesting.png?raw=true).*

### *3. Добавить возможность сотрудникам брать на себя задачу (реализовать либо как String, либо как объект [класса Task](https://github.com/Antonyo891/HomeWorkThree/blob/master/Task.java)) - например, метод assign(Task task).* <br>
добавил поле **protected static Map<Task,Worker> tasks** для хранения задач в привязке к исполнителю метод **takeTask(Task task)** добавляет задачу воркеру
```
public void takeTask(Task task){
        if (tasks==null) tasks=new HashMap<>();
        tasks.put(task,this);
        System.out.println(this.getSurname() + " take a task " + task.getContent_of_the_task());
    }
```
### *У руководителя должна быть возможность ставить задачу сотруднику, используя перегрузку метода assign(...) и брать задачу себе.* <br>
перегругрузка метода **takeTask(Task task)** для руководителя: 
```
public void takeTask(Task task,Worker worker) {
        System.out.println(this.getSurname() + " issued a task to " + worker.getSurname());
        worker.takeTask(task);
    }
```
В Main создал 3 задачи. Одну взял себе Worker, одну взял себе HeadWorker, одну HeadWorker поручил Workery.![test](https://github.com/Antonyo891/HomeWorkThree/blob/master/SemThreeHW/TaskThreeTesting.png?raw=true)

