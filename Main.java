package seminar03;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Worker[] workers = {
                new HeadWorker("Ivanov", "Ivan", "Ivanovich",
                        "backend-developer", "+7-999-888-77-66", 1000,
                        LocalDate.of(1940, 10, 17)),
                new Worker("Petrov", "Ivan", "Pavlovich", "manager",
                        "+7-999-111-22-66", 500,
                        LocalDate.of(1969, 11, 17)),
                new Worker("Pavlov", "Ivan", "Pavlovich", "manager",
                        "+7-999-111-22-66", 500,
                        LocalDate.of(1980, 11, 17)),
                new Worker("Denisov", "Ivan", "Pavlovich", "manager",
                        "+7-999-111-22-66", 500,
                        LocalDate.of(1962, 11, 17)),
                new Worker("Nosov", "Oleg", "Pavlovich", "manager",
                        "+7-999-111-22-66", 500,
                        LocalDate.of(1970, 11, 17))
        };

        //System.out.println("Average age: " + getAverageAge(workers));
        //System.out.println("Average salary: " + getAverageSalary(workers));

        //Worker.addSalary(workers, 45, 50);
        //System.out.println(Arrays.toString(workers));

        List<Worker> workerList = Arrays.asList(workers);

        System.out.println("---");
        //System.out.println("Collections.sort(workerList)");
        //Collections.sort(workerList);
        System.out.println(workerList);
        System.out.println("---");
        HeadWorker.addSalary(workers,18,50);
        //System.out.println("new WorkerSalaryComparator()");
        //workerList.sort(new WorkerSalaryComparator());
        //System.out.println(workerList);

        System.out.println("new WorkerNameComparator()");
        workerList.sort(new WorkerNameComparator());
        System.out.println(workerList);

        System.out.println("---");

        //workerList.sort((o1, o2) -> o1.getAge() - o2.getAge());
        //System.out.println(workerList);
    }

    public static double getAverageAge(Worker[] array) {
        int sumAge = 0;
        for (Worker worker : array) {
            sumAge += worker.getAge();
        }
        return sumAge / (double) array.length;
    }

    public static double getAverageSalary(Worker[] array) {
        int sumSalary = 0;
        for (Worker worker : array) {
            sumSalary += worker.getSalary();
        }
        return sumSalary / (double) array.length;
    }
}
