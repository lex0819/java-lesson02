// Напишите программу, которая
// 1) по указанной строке URL скачивает файл и возвращает строковое содержимое файла
// 2) изменяет строковое содержимое файла подставляя по маске "%s" ваше имя
// 3) сохраняет файл локально
// 4) читает сохраненный файл и выводит содержимое в логгер
// 5) удаляет сохраненный файл

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class task3_file {
    public static void saveOnLocal(String localFilename, String fileContent) {
        try{
            File file = new File(localFilename);
            //create the file.
            if (file.createNewFile()){
                System.out.println("File was created!");
            }
            else{
                System.out.println("File already exists.");
            }
            //write content
            PrintWriter writer = new PrintWriter(file);
            writer.write(fileContent);
            writer.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public static String download(String url, String localFilename) {
        String res = "";
        try {
            URL remote_file = new URL(url);
            Scanner scan = new Scanner(remote_file.openStream(), StandardCharsets.UTF_8);
            // read from your scanner
            while (scan.hasNextLine()) {
                res += scan.nextLine();
            }
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }

        saveOnLocal(localFilename, res);
        return res;
    }
    public static String read(String localFilename) {

        Logger logger = Logger.getLogger(task3_file.class.getName());
        FileHandler file_log;

        String res = "";
        try{
            file_log = new FileHandler("Task_3_LogFile.log");
            logger.addHandler(file_log);
            SimpleFormatter formatter = new SimpleFormatter();
            file_log.setFormatter(formatter);

            // the following statement is used to log any messages
            logger.info("log start");

            FileReader file= new FileReader(localFilename);
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                res += scan.nextLine();
            }
            file.close();

        }catch ( Exception e){
            logger.warning(e.getMessage());
        }
        logger.info(res);
        logger.info("log stop");

        return res;
    }

    public static String change(String localFilename, String fileContent) {

        String from_file = read(localFilename);
        String res = from_file.replace("%s",fileContent);

        saveOnLocal(localFilename, res);
        return res;
    }

    public static boolean removeFromLocale(String localFilename) {
        try{
            File file= new File(localFilename);
            if (file.isFile()) {
                file.delete();
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) throws URISyntaxException {
        String fileUrl = "https://raw.githubusercontent.com/aksodar/JSeminar_2/master/src/main/resources/example.txt";
        String localFilename = "example.txt";
        String MyPath = task3_file.class.getProtectionDomain().getCodeSource().getLocation().getPath() + localFilename;
        System.out.println(MyPath);
        System.out.println(download(fileUrl, MyPath));
        System.out.println(change(MyPath, "Anna"));
        if(removeFromLocale(MyPath)){
            System.out.printf("File %s was removed\n", MyPath);
        }else {
            System.out.println("Something was wrong");
        }
    }
}