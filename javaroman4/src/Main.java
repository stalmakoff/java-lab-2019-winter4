import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Copy from.. ");
        String dirFrom = scanner.nextLine();
        System.out.println("Copy to.. ");
        String dirTo = scanner.nextLine();
        copyDir(dirFrom, dirTo);


    }

    private static void copyDir(String sourceDirName, String targetSourceDir) throws IOException {
        File folder = new File(sourceDirName);

        File[] listOfFiles = folder.listFiles();

        FileWriter writer = new FileWriter("file.txt");

        Path destDir = Paths.get(targetSourceDir);
        if (listOfFiles != null)
            for (File file : listOfFiles)
                if (file.lastModified() > new Date().getTime() -259200000) {
                    Files.copy(file.toPath(), destDir.resolve(file.getName()), StandardCopyOption.REPLACE_EXISTING);
                    System.out.println(file.getName());
                    writer.write(file.getName());
                    writer.flush();
                }
    }
}
