package seminar03;

import java.util.Comparator;

public class WorkerNameComparator implements Comparator<Worker> {

    @Override
    public int compare(Worker o1, Worker o2) {
        String first_surname = o1.getSurname();
        String second_surname = o2.getSurname();
        return first_surname.toLowerCase().compareTo(
                second_surname.toLowerCase());
    }
}
