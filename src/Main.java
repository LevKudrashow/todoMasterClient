import TaskCode.*;

import java.util.*;

public class Main {
    static ArrayList<Task> archive = new ArrayList<Task>();
    static ArrayList<Task> tasks = new ArrayList<Task>();
    static Task[] tasks1 = new Task[10];
    static Scanner scanner = new Scanner(System.in);
    static Comparator<Task> comparatorTasks = new Comparator<Task>() {
        @Override
        public int compare(Task o1, Task o2) {
            return o1.title.compareTo(o2.title);
        }
    };
    static Comparator<SubTask> comparatorSubTasks = new Comparator<SubTask>() {
        @Override
        public int compare(SubTask o1, SubTask o2) {
            return o1.title.compareTo(o2.title);
        }
    };

//Мастер, клиент, персон ооп, персон(имя, id, money)->мастер(несколько задач),клиент(одна задача/несколько, )
//UTILS HashSetMap
//abstract class, class, methods


    public static void main(String[] args) {
        /*while (true) {
            CreateTask();
            System.out.print("Add one more task? 0-No, 1-Yes: ");
            if (scanner.nextInt() == 0) {
                Collections.sort(tasks, comparatorTasks);
                Arrays.sort(tasks1, Comparator.comparing(Task::getTitle)); //Не работает т.к. tasks это ArrayList<Task> а не Task[]
                break;
            }
            ;
        }
        while (true) {
            Show();
            if (!tasks.isEmpty()) {
                Util.ChangeTaskStatus(tasks, archive, scanner);
            } else {
                System.out.println("All tasks are done.");
                break;
            }
        }*/

        Master m1 = new Master("Maestro");
        Client c1 = new Client("Clint", new Task("Project",6));
        Util.ExecuteOrder(c1,m1);
    }

    static void CreateSubTask(Task t1, int ID) {
        System.out.print("Write title of sub task " + ID + " : ");
        t1.addSubTask(scanner.next());
    }

    static void CreateTask() {
        System.out.print("Write title of main task: ");
        String title = scanner.next();
        System.out.print("Write size of main task: ");
        int size = scanner.nextInt();
        Task maintask = new Task(title);
        for (int i = 0; i < size; i++) {
            CreateSubTask(maintask, i);
        }
        Collections.sort(maintask.subTasks, comparatorSubTasks);
        tasks.add(maintask);
    }

    static void Show() {
        if (!archive.isEmpty()) {
            System.out.println("Archive:");
            for (int i = 0; i < archive.size(); i++) {
                archive.get(i).Show();
            }
        }
        if (!tasks.isEmpty()) {
            System.out.println("Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                tasks.get(i).Show();
            }
        }
    }
}
