/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6.lab6;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Artur
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CustomJPAAnnotationProcessor annotationProcessor=new CustomJPAAnnotationProcessor("lab7.Entities");
        String str=annotationProcessor.builtMetaClasses().toString();
        str=str.substring(2, str.length()-1);
        System.out.println(str);
        writeToFile(str);
    }
    
    public static void writeToFile(String str){
        File file =new File("C:\\Users\\Acer\\Desktop\\ГитХаб\\myoodb\\src\\main\\java\\lab7\\metaClasses.txt");
        if (!file.exists())
            try {
                file.createNewFile();
        } catch (IOException ex) {
                System.err.println("Can not create file cause:"+ex );
        }
        try(FileWriter writer=new FileWriter(file,false)){
            writer.write(str);
        } catch (IOException ex) {
            System.err.println("Can not write file cause:"+ex );
        }
    }
    
}
