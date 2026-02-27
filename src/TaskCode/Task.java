package TaskCode;
import java.util.ArrayList;
//TODO switch Task and SubTask as child and parent classes if beneficial

public final class Task extends SubTask{
    protected int money=0;
    public ArrayList<SubTask> subTasks = new ArrayList<SubTask>();
    public Task(String title)
    {
        super(title);
    }
    public Task(String title, int num)
    {
        super(title);
        for (int i=0;i<num;i++) {
            this.addSubTask("SubTask"+i);
        }
    }
    public int getSize()
    {
        return subTasks.size();
    }
    public void addSubTask(String title)
    {
        this.subTasks.add(new SubTask(title));
    }
    public void setStatus(int status, int subtaskID)
    {
        this.subTasks.get(subtaskID).setStatus(status);
        money+=this.subTasks.get(subtaskID).getMoney();
        this.status=CheckAllSubs();
    }
    
    public int CheckAllSubs()
    {
        int inProg = 0;
        int isDone = 0;
        for (int i=0;i<this.subTasks.size();i++)
        {
            if(this.subTasks.get(i).getStatus()==TaskStatuses.InProgress)
            {
                inProg++;
            }
            else if (this.subTasks.get(i).getStatus()==TaskStatuses.Done)
            {
                isDone++;
            }
        }
        if (isDone==this.subTasks.size())
        {
            return TaskStatuses.Done;
        }
        else if ((isDone+inProg)>0)
        {
            return TaskStatuses.InProgress;
        }
        return TaskStatuses.New;
    }
    
    public void Show()
    {
        System.out.println("Main task "+this.title+", status: "+this.status+", subtasks:");
        for (int i = 0; i < this.subTasks.size(); i++) {
            if(i==this.subTasks.size()-1)
            {
                System.out.print("∟");
            }
            else {System.out.print("⊢");}
            System.out.print("Subtask, ID: " +i+" ");
            subTasks.get(i).show();
        }
    }

    public void showStatus()
    {
        switch (status){
            case TaskStatuses.Done -> System.out.println("Main task "+title+" is done!");
            case TaskStatuses.InProgress -> System.out.println("Main task "+title+" is in progress.");
            case TaskStatuses.New -> System.out.println("Main task "+title+" is anew.");
        }
    }

    @Override
    public boolean equals(Object o)
    {
        Task tk = (Task) o;
        return hashCode()==tk.hashCode();
    }

    @Override
    public int hashCode()
    {
        int result = title == null ? 0 : title.hashCode();
        result += status + subTasks.size();
        return result;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int getMoney() {
        if (status!=TaskStatuses.Done)
        {
            return 0;
        }
        else {
            int a = this.money;
            this.money = 0;
            return a;
        }
    }

    @Override
    public int getPrice() {
        int overallPrice=0;
        for (int i=0;i<this.subTasks.size();i++)
        {
            overallPrice+=this.subTasks.get(i).getPrice();
        }
        return overallPrice;
    }
}

