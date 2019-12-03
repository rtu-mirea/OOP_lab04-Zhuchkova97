package emp;

public class Employee
{
    int number;
    String name;
    String surname;
    String addres;
    int childrens;
    String sex;
    String birthday;


    Employee(int number,String name, String surname,String addres,int childrens, String sex, String birthday)
    {
        // if(number<=0)
        // throw Exception("Номер не может быть меньше нуля");
        // this.number=numder;
        // if(name.equals(""))
        // throw Exception("Номер не может быть меньше нуля");
        this.name=name;
        this.surname=surname;
        this.addres=addres;
        this.childrens=childrens;
        this.sex=sex;
        this.birthday=birthday;

    }
    
     
}

public class Creature
{

}