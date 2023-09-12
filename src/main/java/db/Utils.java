package db;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class Utils {
    public static Object getDbProperty(String nameProperty){
        Properties properties = new Properties();
        try(InputStream is = Files.newInputStream(Paths.get("src/test/db.properties"))){
            properties.load(is);
        } catch (IOException e){
            throw new RuntimeException(e);
        }
        return properties.getProperty(nameProperty);
    }
}
