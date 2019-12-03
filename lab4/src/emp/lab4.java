package emp;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.RandomAccessFile;



public class lab4 {
    public static void main(String[] args) throws Exception
    {

        Employee Sasha= new Employee(56, "Sasha", "Zhuchkova", "Moscow", 0, "female", "18.07.2000");

        Employee Masha= new Employee(42, "Masha", "Smirnova", "Moscow", 1, "female", "19.04.2000");


        System.out.println("Введите имя файла с консоли");
        Scanner in= new Scanner(System.in);
        String name = in.nextLine();
        System.out.println(name);
        Creature.Save(name,Sasha);
        Creature.Save(name,Masha);


        if(Creature.check(name))
        {
            System.out.println("Файл "+name+ " найден");
        }
        else
        {
            System.out.println("Файл "+name +" не найден");
        }
        System.out.println("Введите количество человек:");
        int n = Integer.parseInt(in.nextLine());
        for(int i =0;i<n;i++) {
            System.out.println("Введите Табельный номер:");
            int number1 = Integer.parseInt(in.nextLine());
            System.out.println("Введите имя:");
            String name1 = in.nextLine();
            System.out.println("Введите фамилию:");
            String surname1 = in.nextLine();
            System.out.println("Введите адрес:");
            String addres1 = in.nextLine();
            System.out.println("Введите количество детей:");
            int childrens1 = Integer.parseInt(in.nextLine());
            System.out.println("Введите пол:");
            String sex1 = in.nextLine();
            System.out.println("Введите дату рождения:");
            String birthday1 = in.nextLine();
            Employee Pasha = new Employee(number1, name1, surname1, addres1, childrens1, sex1, birthday1);
            Creature.Save(name, Pasha);
        }

        ArrayList<Employee> Emn= Creature.WritteL(name);
        System.out.print(Emn);

        ArrayList<Employee> Em2= Creature.WritteD(name);
        System.out.print(Em2);

        Creature.Aces("AcesRan",Emn);
//        Creature.Rewrite1("AcesRan");
        System.out.println("до изменения");
        for(var i: Em2){//Emn

            System.out.println(i.number);
            System.out.println(i.name);
            System.out.println(i.surname);
            System.out.println(i.addres);
            System.out.println(i.childrens);
            System.out.println(i.sex);
            System.out.println(i.birthday);
            System.out.println();

        }
        Emn=Creature.Rewrite("AcesRan",Emn);
        System.out.println("после изменения");

        for(var i: Emn){

            System.out.println(i.number);
            System.out.println(i.name);
            System.out.println(i.surname);
            System.out.println(i.addres);
            System.out.println(i.childrens);
            System.out.println(i.sex);
            System.out.println(i.birthday);
            System.out.println();

        }
//        Creature.Rewrite1("AcesRan");

        Creature.task3Ex1();
        Creature.task3Ex2();
        Creature.task3Ex3();
        Creature.task4();

        in.close();
    }
}


