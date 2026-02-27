package TaskCode;

public class SubTask implements MoneyTag
{
    public String title;
    protected int money=20;
    protected int status = TaskStatuses.New;
    public String getTitle() {return title;}
    protected SubTask(String title)
    {
        this.title = title;
    }
    public  int getStatus()
    {
        return status;
    }
    protected void setStatus(int status)
    {
        this.status = status;
    }
    protected void show() {System.out.println(this.title+", status: "+this.status+";");}
    public void showStatus()
    {
        switch (status){
            case TaskStatuses.Done -> System.out.println("Sub task "+title+" is done!");
            case TaskStatuses.InProgress -> System.out.println("Sub task "+title+" is in progress.");
            case TaskStatuses.New -> System.out.println("Sub task "+title+" is anew.");
        }
    }

    @Override
    public boolean equals(Object o)
    {
        SubTask sub = (SubTask) o;
        return hashCode()==sub.hashCode();
    }

    @Override
    public int hashCode()
    {
        int result = title == null ? 0 : title.hashCode();
        result = result + status;
        return result;
    }

    @Override
    public String toString() {
        return (this.title+", status: "+this.status+";");
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
        return this.money;
    }


}

interface MoneyTag{
    public int getMoney();
    public int getPrice();
}