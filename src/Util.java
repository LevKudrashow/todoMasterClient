import TaskCode.Client;
import TaskCode.Master;
import TaskCode.Task;
import TaskCode.TaskStatuses;

import java.util.ArrayList;
import java.util.Scanner;

public class Util{
    public static <T> void ChangeTaskStatus(ArrayList<Task> tasks, ArrayList<Task> archive, Scanner scanner) {
        System.out.print("Choose task: ");
        int TaskId = scanner.nextInt();
        if (tasks.get(TaskId).getStatus() == TaskStatuses.Done) {
            System.out.print(tasks.get(TaskId).title + " task is fully done, send it to archive? 0-No, 1-Yes: ");
            if (scanner.nextInt() == 1) {
                MoveToArchive(tasks, archive, TaskId);
            }
        } else {
            ChangeSubTaskStatus(tasks.get(TaskId), scanner);
        }
    }

    public static <T> void MoveToArchive(ArrayList<Task> tasks, ArrayList<Task> archive, int TaskId) {
        archive.add(tasks.get(TaskId));
        tasks.remove(TaskId);
        System.out.println("Task moved to archive.");
    }

    public static <T> void ChangeSubTaskStatus(Task t1, Scanner scanner) {
        t1.Show();
        System.out.print("Which subtask to change: ");
        int Id = scanner.nextInt();
        System.out.print("Choose new status (0 - Not touched, 1 - InProgress, 2 - Done): ");
        t1.setStatus(scanner.nextInt(), Id);
    }

    public static <T> void ExecuteOrder(Client c1, Master m1)
    {
        m1.assignTasks(c1);
        int p1=c1.payment(m1.DoingTaskFor(c1));
        if(m1.payment(p1)==-1)
        {
            System.out.println(c1.getName()+" has to pay "+p1+" but only has "+c1.getMoney() + " for "+m1.getName()+".");
        }
    }


}
