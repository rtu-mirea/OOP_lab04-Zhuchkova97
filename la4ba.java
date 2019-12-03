import java.io.*;
import java.util.ArrayList;

public class la4ba {
    public static void main(String[] args) {
        ArrayList<File> files= new ArrayList<File>();
    
        try
        {
            File F=new File("C:\\Users\\Сашуленок\\Desktop\\Сашуленок\\2курс\\Java\\4Лаба\\MyFile1.txt");
            files.add(F);
            F.createNewFile();
            System.out.println("Полный путь к файлу: "+F.getAbsolutePath()+"\n");// Упражнение 2(3)
            System.out.println("Размер файла в байтах= "+F.length()+"\n");// Упражнение 2(4)
            /*
            File A=new File("C:\\MyFile2.txt");
            A.createNewFile();
            System.out.println(A.getAbsolutePath());
            */


            File S=new File("C:\\С\\MyFile3.txt");
            files.add(S);
            S.createNewFile();
            System.out.println(S.getAbsolutePath());

            File D=new File("C:\\С\\Dir1\\Dir2\\Dir3\\Dir4");
            files.add(D);
            D.mkdirs();
            System.out.println(D.getAbsolutePath());

        }
        catch ( FileNotFoundException h){
            h.printStackTrace();
        }

        catch (IOException e){
            e.printStackTrace();
        }

    
        catch ( Exception y){
            y.printStackTrace();
        }
           
        check(files);// Упражнение 2(1,2)

        if(check2())
        {
            System.out.println("Файл MyFile1.txt найден\n");
        }
        else
        {
            System.out.println("Файл не найден\n");
        }

        File P=new File("C:\\Users\\Сашуленок\\Desktop\\Сашуленок\\2курс\\Java\\4Лаба\\Papka");
            files.add(P);
            P.mkdir();
            System.out.println(P.getAbsolutePath());
        File R= new File("C:\\Users\\Сашуленок\\Desktop\\Сашуленок\\2курс\\Java\\4Лаба");
            String[] root= R.list();

            System.out.println("Упражнение 3:\n");
            for(int i=0; i<root.length;i++)
            {
                System.out.println(root[i]+"\n");

            }
            int countt=0;
            File[] roott= R.listFiles();
            for(int i=0; i<root.length;i++)
            {
                if(roott[i].isDirectory())
                {
                    countt++;
                }
                System.out.println(roott[i].getName()+"\n");
            }
            System.out.println("Количество папок= "+countt);

        

//Удаление весх файлов и папок
File S=new File("C:\\С\\MyFile3.txt");
File D=new File("C:\\С\\Dir1");
File F=new File("C:\\Users\\Сашуленок\\Desktop\\Сашуленок\\2курс\\Java\\4Лаба\\MyFile1.txt");
S.delete();
deleteDir(D);
P.delete();
F.delete();
         

    }

    public static void check(ArrayList<File> files)
    {
        for( File i: files)
        {

            if(i.isFile())
            {
                System.out.println(i.getName()+"-Файл\n"+i.getParent()+"-Родительская папка\n");
            }


            if(i.isDirectory())
            {
                System.out.println(i.getName()+"-Папка\n"+i.getParent()+"-Родительская папка\n");
            }
        }
    }

        
    public static boolean check2()
    {
        File pap = new File("C:\\Users\\Сашуленок\\Desktop\\Сашуленок\\2курс\\Java\\4Лаба");
        String[] childrens = pap.list();
        for(String i : childrens)
        {
            boolean g = i.equals("MyFile1.txt");
            if(g)
            {
                return true;
            }
        }
        return false;
    }

    public static void deleteDir(File f)
    {
        File[] childrenss = f.listFiles();
        for(int i = 0; i<childrenss.length;i++)
        {
            if(childrenss[i].isDirectory())
            {
                deleteDir(childrenss[i]);
            }
            else
            {
                childrenss[i].delete();
            }
        }
        f.delete(); 
        
    }
}