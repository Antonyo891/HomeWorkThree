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
        Task task = new Task("Prepare a report");
        ArrayList<Task> tasks= new ArrayList<>();
        List<Worker> workerList = Arrays.asList(workers);
        HeadWorker headWorker = null;
        tasks.add(task);
        tasks.add(new Task("Impose order"));
        tasks.add(new Task("Fixing the lights"));

        System.out.println("---");
        System.out.println(workerList);
        System.out.println("---");
        HeadWorker.addSalary(workers,18,50);

        System.out.println("new WorkerNameComparator()");
        workerList.sort(new WorkerNameComparator());
        System.out.println(workerList);

        System.out.println("---");
        System.out.println(Worker.getTasks());
        System.out.println("----");
        workerList.get(2).takeTask(task);
        for (Worker temp: workerList) {
            if (temp.getClass()== HeadWorker.class) headWorker=(HeadWorker) temp;
        }
        headWorker.takeTask(tasks.get(1));
        headWorker.takeTask(tasks.get(2),workerList.get(3));
        for (Map.Entry<Task,Worker> item: Worker.getTasks().entrySet()
             ) {
            System.out.println("Task " + item.getKey().getContent_of_the_task() +
                    " is perfomed by " + item.getValue().getSurname());
        }
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
