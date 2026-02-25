package TaskCode;

import java.util.HashMap;

public class Master extends Person
{
    int money = 0;
    HashMap<Client,Task> tasks = new HashMap<>();

    public Master(String name)
    {
        super(name);
    }

    public int getMoney() {
        return this.money;
    }

    public void Show()
    {
        System.out.println(this.name+", money: "+this.money);
    }

    public void assignTasks(Client c1)
    {
        tasks.put(c1, c1.giveTask());
    }

    public int DoingTaskFor(Client c1)
    {
        for (int i=0;i<tasks.get(c1).getSize();i++)
        {
            tasks.get(c1).setStatus(TaskStatuses.Done,i);
        }
        return tasks.get(c1).getMoney();
    }

    @Override
    public int payment(int money) {
        this.money+=money;
        if(!(money>0))
        {
            System.out.println("- Where's my pay?");
            return -1;
        }
        return money;
    }
}
