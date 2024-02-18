package org.example.HttpStudies.Utilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.HttpStudies.Class.Address;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileJson {
    public static File CreateFiles(String Directory, String Directories, String FileJson){
        Path folder = Paths.get(Directory);
        Path folders = Paths.get(folder.toString(),Directories);
        Path file = Paths.get(folders.toString(),FileJson);

        try {
            if(Files.notExists(folder)){Files.createDirectory(folder);}
            if(Files.notExists(folders)){Files.createDirectories(folders);}
            if(Files.notExists(file)){Files.createFile(file);}

        }catch (IOException ex){
            System.out.println(ex);

        }
File files = file.toFile();
        return files;


    }
    public static void CreateJson(File file, Address address){
        try (FileWriter fw = new FileWriter(file)){
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            //aqui faz objeto vira um arquivo json
            String whire = gson.toJson(address);
            fw.write(whire);
            fw.flush();

        }catch (IOException ex){
            System.out.println(ex);

        }

    }





}
