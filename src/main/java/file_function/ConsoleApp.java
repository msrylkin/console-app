package file_function;

import java.io.*;

/**
 * Created by Maksim Rylkin on 08.10.2015.
 *
 */
public class ConsoleApp {
    /**
     *
     * @param args - путь к файлу. Результирующий файл сохраняется в той же директории
     *  Работа программы не зависит от количества строк и аргументов для каждой строки
     *  Список функций можно расширить добавив еще одно условие в метод main и саму функцию в этот класс
     */
    public static void main(String[] args){
        if (args.length<1){
            System.out.println("Enter filepath in args!");
            return;
        }
        File file = new File(args[0]);
        try (
                BufferedReader reader = new BufferedReader(new FileReader(file));
                BufferedWriter writer = new BufferedWriter(new FileWriter(file.getParent()+"/result.txt"))
        )
        {
            String line;
            int counter = 0;
            while ((line = reader.readLine())!=null){
                String[] strings = line.split(" ");
                int[] arguments = new int[strings.length-1];
                for (int i=1;i<strings.length;i++){
                    arguments[i-1] = Integer.parseInt(strings[i]);
                }
                writer.write(++counter+" ");
                if (strings[0].equals("ACK")){
                    for (int i=0;i<arguments.length;i+=2){
                        if (i!=arguments.length-1)
                            writer.write(ackermann(arguments[i],arguments[i+1])+" ");
                    }
                }
                if (strings[0].equals("F")){
                    for (int i=0;i<arguments.length;i++)
                        writer.write(fact(arguments[i])+" ");
                }
                if (strings[0].equals("FIB")){
                    for (int i=0;i<arguments.length;i++)
                        writer.write(fibonacci(arguments[i])+" ");
                }
                writer.newLine();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static int ackermann(int m, int n) {
        if (m == 0)
            return n + 1;
        if (n == 0)
            return ackermann(m - 1, 1);
        return ackermann(m - 1, ackermann(m, n - 1));
    }

    public static int fact(int num){
        if (num == 0)
            return 1;
        return num*fact(num-1);
    }

    public static int fibonacci(int num){
        int fib = 0,last = 1;
        for (int i=1;i<=num;i++){
            fib += last;
            last = fib - last;
        }
        return fib;
    }
}
