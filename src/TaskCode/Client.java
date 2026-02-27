package TaskCode;
import java.util.HashMap;
import java.util.Map;

public class Client extends Person
{
    int money = 100;
    Task task;

    public Client(String name, Task task)
    {
        super(name);
        this.task=task;
    }

    public String getTaskTitle()
    {
        return this.task.getTitle();
    }

    public int getTaskPrice()
    {
        return this.task.getPrice();
    }

    public int getMoney() {
        return this.money;
    }

    public void Show()
    {
        System.out.println(this.name+", money: "+this.money);
    }

    public Task giveTask()
    {
        Task t1=this.task;
        this.task = null;
        return t1;
    }

    @Override
    public int payment(int money) {
        if (this.money-money>=0)
        {
            this.money-=money;
            return money;
        }
        else
        {
            System.out.println("- I don't have enough to pay.");
            return -money;
        }
    }
}
