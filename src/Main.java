
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String text = "The Rostóvs knew everybody in Moscow." +
                "The old count had money enough that year, as all his estates had been remortgaged, and so Nicholas," +
                " acquiring a trotter of his own, very stylish riding breeches of the latest cut, such as no one else yet" +
                " had in Moscow, and boots of the latest fashion, with extremely pointed toes and small silver spurs," +
                " passed his time very gaily. After a short period of adapting himself to the old conditions of life," +
                "Nicholas found it very pleasant to be at home again. He felt that he had grown up and matured very much." +
                " His despair at failing in a Scripture examination, his borrowing money from Gavríl to pay a sleigh" +
                "driver, his kissing Sónya on the sly—he now recalled all this as childishness he had left immeasurably" +
                " behind. Now he was a lieutenant of hussars, in a jacket laced with silver, and wearing the Cross of" +
                " St. George, awarded to soldiers for bravery in action, and in the company of well-known, elderly, and" +
                " respected racing men was training a trotter of his own for a race. He knew a lady on one of the" +
                " boulevards whom he visited of an evening. He led the mazurka at the Arkhárovs’ ball, talked about the" +
                " war with Field Marshal Kámenski, visited the English Club, and was on intimate terms with a colonel of" +
                " forty to whom Denísov had introduced him.";
        File file1 =new File("src/Text.txt");
        File file2 = new File("D:/javalessons/prac/Kurs/HomeWork15/src/concText.txt");
        System.out.println("Записание текста в файл и прочтение его и вывод в консоль через относительный путь");
        writeAndReadOtnosPytFail(text,file1);
        System.out.println("\nЗаписание текста в файл и прочтение его и вывод в консоль через конкретный путь");
        writeAndReadConcretPytKFail(text,file2);

        System.out.println("Задание с машиной");
        String file = "src/CarInfo.txt";
        Car car = new Car("BMV", 10);
        System.out.println(car.toString());
        car.go();
        System.out.println(car.toString());
        serialize(car, file);
        System.out.println("десериализация файла");
        deserialize(file);
    }

    public static void writeAndReadOtnosPytFail(String text,File file) {
        try(FileWriter fileWriter=new FileWriter(file)){
            fileWriter.write(text);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

        try(FileReader fileReader = new FileReader(file)){
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String text1=  bufferedReader.readLine();
            System.out.println(text1);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }





    public static void writeAndReadConcretPytKFail(String text,File file) {
        try(FileWriter fileWriter=new FileWriter(file)){
            fileWriter.write(text);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        try(FileReader fileReader = new FileReader(file)){
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String text1=  bufferedReader.readLine();
            System.out.println(text1);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void serialize(Car car, String file) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(car);
        } catch (Throwable e) {
            e.printStackTrace();
        }

    }
    public static void deserialize(String file) {
        try (ObjectInputStream objectInputputStream = new ObjectInputStream(new FileInputStream(file))) {
            Car car1=(Car) objectInputputStream.readObject();
            System.out.println(car1);
        } catch (Throwable e) {
            e.printStackTrace();
        }

    }
}
