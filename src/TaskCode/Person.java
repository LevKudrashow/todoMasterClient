package TaskCode;

//Мастер, клиент, персон ооп, персон(имя, id, money)->мастер(несколько задач),клиент(одна задача/несколько, )
//UTILS HashSetMap
//abstract class, class, methods

abstract class Person implements Finansable {
    String name;
    int money;

    public String getName() {
        return this.name;
    }

    public Person(String name)
    {
        this.name=name;
    }
}

interface Finansable
{
    public int payment(int money);

}