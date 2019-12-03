package emp;

import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.nio.charset.Charset;
import java.util.Scanner;

public class Employee
{
    int number;//4 байта
    String name;//30 cим
    String surname;//30
    String addres;//30
    int childrens;//4
    String sex;//30
    String birthday;//30


    Employee(int number,String name, String surname,String addres,int childrens, String sex, String birthday) throws Exception
    {
         if(number<=0) throw new Exception("Номер не может быть меньше нуля");
         this.number=number;
         if(name.equals("")) throw new Exception("Номер не может быть меньше нуля");
         this.name=name;
         this.surname=surname;
         this.addres=addres;
         this.childrens=childrens;
         this.sex=sex;
         this.birthday=birthday;



    }


}

    class Creature {


        public static void Save(String file, Employee emp) {
            try {
                DataOutputStream dos = new DataOutputStream(new FileOutputStream(file, true));
                dos.writeInt(emp.number);
                dos.writeUTF(emp.name);
                dos.writeUTF(emp.surname);
                dos.writeUTF(emp.addres);
                dos.writeInt(emp.childrens);
                dos.writeUTF(emp.sex);
                dos.writeUTF(emp.birthday);
                dos.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        public static boolean check(String name) {
            File pap = new File(".");
            String[] children = pap.list();
            for (String i : children) {
                boolean g = i.equals(name);
                if (g) {
                    return true;
                }
            }
            return false;
        }


        public static ArrayList<Employee> WritteL(String file)
        {
            ArrayList<Employee> Emps = new ArrayList<Employee>();
            try
            {
                DataInputStream dos = new DataInputStream(new FileInputStream(file));
                while (true)
                {
                    int number = dos.readInt();
                    String name = dos.readUTF();
                    String surname = dos.readUTF();
                    String addres = dos.readUTF();
                    int childrens = dos.readInt();
                    String sex = dos.readUTF();
                    String birthday = dos.readUTF();
                    Employee emp = new Employee(number, name, surname, addres, childrens, sex, birthday);
                    Emps.add(emp);

                }

            } catch (FileNotFoundException e)
            {
                e.printStackTrace();
            } catch (IOException e)
            {
//                e.printStackTrace();
                System.out.println("Чтение файла окончено");


            } catch (Exception e) {
                e.printStackTrace();
            }
            return Emps;
        }


        public static ArrayList<Employee> WritteD(String file)
        {
            ArrayList<Employee> Emps = new ArrayList<Employee>();
            try
            {
                DataInputStream dos = new DataInputStream(new FileInputStream(file));
                while (true)
                {
                    int number = dos.readInt();
                    String name = dos.readUTF();
                    String surname = dos.readUTF();
                    String addres = dos.readUTF();
                    int childrens = dos.readInt();
                    String sex = dos.readUTF();
                    String birthday = dos.readUTF();
                    if (sex.equals("male"))
                    {
                        Employee emp = new Employee(number, name, surname, addres, childrens, sex, birthday);
                        Emps.add(emp);
                    }
                    else{
                        continue;
                    }

                }

            } catch (FileNotFoundException e)
            {
                e.printStackTrace();
            } catch (IOException e)
            {
//                e.printStackTrace();
                System.out.println("Чтение файла окончено");


            } catch (Exception e) {
                e.printStackTrace();
            }
            return Emps;
        }



        public static ArrayList<Employee> WritteDD( ArrayList<Employee> Emps) {
            Emps.remove(0);
//            for (var i: Emps) {
//                System.out.println(i.number);
//            }
            System.out.println();
            Emps.add(0, Emps.get(Emps.size()-1));
//            for (var i: Emps) {
//                System.out.println(i.number);
//            }
            System.out.println();

            Emps.remove(Emps.size()-1);
//            for (var i: Emps) {
//                System.out.println(i.number);
//            }
            System.out.println();

            return Emps;

        }

//        public static void Rewrite1(String name)throws IOException
//        {
//            RandomAccessFile dos = new RandomAccessFile(name, "rw");
//            int number1= dos.readInt();
//            String name1= ceck2(dos);
//            String surname1= ceck2(dos);
//            String addres1= ceck2(dos);
//            int childrens1= dos.readInt();
//            String sex1= ceck2(dos);
//            String birthday1= ceck2(dos);
//            System.out.println("начало");
//
//            System.out.println(number1);
//            System.out.println(name1);
//            System.out.println(birthday1);
//            System.out.println("конец");
//
//            dos.close();
//        }


        public static ArrayList<Employee> Rewrite(String name, ArrayList<Employee> Emps)throws IOException,Exception
        {
            RandomAccessFile dos = new RandomAccessFile(name, "rw");
            int size=Emps.size();
            for (var i: Emps) {
                i.name = Acesss(i.name);
                i.surname = Acesss(i.surname);
                i.addres = Acesss(i.addres);
                i.sex = Acesss(i.sex);
                i.birthday = Acesss(i.birthday);
                dos.writeInt(i.number);
//                System.out.println(dos.getFilePointer());
                dos.writeUTF(i.name);
//                System.out.println(dos.getFilePointer());
                dos.writeUTF(i.surname);
//                System.out.println(dos.getFilePointer());
                dos.writeUTF(i.addres);
//                System.out.println(dos.getFilePointer());
                dos.writeInt(i.childrens);
//                System.out.println(dos.getFilePointer());
                dos.writeUTF(i.sex);
//                System.out.println(dos.getFilePointer());
                dos.writeUTF(i.birthday);
//                System.out.println(dos.getFilePointer());
//                System.out.println();
            }
            Emps.clear();
            dos.seek(0);
            for(int i=0;i<size;i++){
                dos.seek(168*i);
               Emps.add(new Employee(dos.readInt(),dos.readUTF(),dos.readUTF(),dos.readUTF(),dos.readInt(),dos.readUTF(),dos.readUTF()));
//                System.out.println(dos.getFilePointer());
//                int number1 = dos.readInt();
//                System.out.println(dos.getFilePointer());
//                String name1 = dos.readUTF();
//                System.out.println(dos.getFilePointer());
//                String surname1 = dos.readUTF();
//                System.out.println(dos.getFilePointer());
//                String addres1 = dos.readUTF();
//                System.out.println(dos.getFilePointer());
//                int childrens1 = dos.readInt();
//                System.out.println(dos.getFilePointer());
//                String sex1 = dos.readUTF();
//                System.out.println(dos.getFilePointer());
//                String birthday1 = dos.readUTF();
//                System.out.println(dos.getFilePointer());
//            Emps.add(new Employee(number1,name1,surname1,addres1,childrens1,sex1,birthday1));


            }
            Emps = WritteDD(Emps);
            dos.close();
            return Emps;
        }

//        public static String ceck2(RandomAccessFile dos)throws IOException
//        {
//            String name1="";
//            for(int i=0;i<10;i++) {
//                name1+=dos.readChar();
//            }
//            return name1;
//        }


        public static void Aces(String file, ArrayList<Employee> Emp) throws IOException{
            
            RandomAccessFile dos = new RandomAccessFile(file, "rw");
            
            for(Employee emp: Emp) {

                dos.writeInt(emp.number);
                dos.writeChars(Acesss(emp.name));
                dos.writeChars(Acesss(emp.surname));
                dos.writeChars(Acesss(emp.addres));
                dos.writeInt(emp.childrens);
                dos.writeChars(Acesss(emp.sex));
                dos.writeChars(Acesss(emp.birthday));

            }
                dos.close();

        }

        public static String Acesss(String str)
        {
            for (int i = str.length(); i < 30; i++) {
                str += " ";
            }
            return str;
        }



        public static void task3Ex1(){
            try {
                Reader reader = new InputStreamReader(new FileInputStream("T1.txt"));
                Writer writer = new OutputStreamWriter(new FileOutputStream("T2.txt"));
                int x;
                while((x = reader.read()) != -1) {
                    writer.write((char)x);
                }
                reader.close();
                writer.close();
            }
            catch (Exception e){
                System.err.println(e);
            }
        }
        public static void task3Ex2(){
            try {
                Writer writer = new OutputStreamWriter(new FileOutputStream("A.txt"));
                for (int i = 40; i < 552; i++) {
                    writer.write((char) i);
                }
                writer.close();

                BufferedReader inb = new BufferedReader(new InputStreamReader(new FileInputStream("A.txt")), 128);
                BufferedWriter outb = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("B.txt")), 128);
                char[] buf = new char[128];
                for(int i = 0; i < 4; i++){
                    inb.read(buf);
                    outb.write(buf);
                    outb.newLine();
                }
                inb.close();
                outb.close();
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
        public static void task3Ex3(){
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\Сашуленок\\Desktop\\Сашуленок\\2курс\\Java\\lab4\\src\\A.txt"), "Cp1251"));
                System.out.println(Charset.defaultCharset().name());
                String str = in.readLine();
                System.out.println(str);
                in = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\Сашуленок\\Desktop\\Сашуленок\\2курс\\Java\\lab4\\src\\B.txt"), "UTF-8"));
                str = in.readLine();
                System.out.println(str);
            }
            catch (Exception e){System.err.println(e);}
        }

        public static void task4(){
            int task = 666;
            Scanner in = new Scanner(System.in);
            while(task != 0){
                try{
                    System.out.print("[0] - Возвращение к предыдущему меню" + '\n' +
                            "[1] - проверка класса получающего данные из файла" +'\n' +
                            "[2] - проверка класса консольного ввода" +'\n' +
                            "[3] - проверка класса сериализации" +'\n' +
                            "Выбериет нужный варант: ");
                    task = in.nextInt();
                    switch (task){
                        case 0:
                            System.out.println("Возвращение к предыдущему меню");
                            break;
                        case 1:
                            in.nextLine();
                            System.out.println("Введите название файла");
                            String fileName=in.nextLine();
                            ClassTextFile obj = new ClassTextFile(fileName);
                            TextWork textObj = obj.task4();
                            System.out.println(textObj.getText());
                            break;
                        case 2:
                            ConsoleInput object = new ConsoleInput();
                            object.consoleInputData();
                            System.out.println(object.getObject().getText());
                            break;
                        case 3:
                            in.nextLine();
                            System.out.println("Введите название файла для сериализации");
                            SerilisationClass o = new SerilisationClass(in.nextLine());
                            System.out.println("Файл был создан");
                            o.makeCollection();
                            System.out.println("Коллекция была создана");
                            o.readCollection();
                            System.out.println("Коллекция была десериализирована");
                            ArrayList<TextWork> arr = o.getObjectCollection();
                            for (TextWork i:
                                    arr) {
                                System.out.println(i.getText());
                            }
                            break;
                    }
                }
                catch (Exception e){System.err.println(e);}
            }
        }
    }










































