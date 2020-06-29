package generator.config;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

    private  FileInputStream fileInputStream;
    private  Properties property;


    public Config() {

        try {
            property = new Properties();
            fileInputStream = new FileInputStream("src/main/resources/application.properties");

            property.load(fileInputStream);

        } catch (IOException e) {
            System.err.println("Error: application.properties not found" );
        }
    }

    public Properties getProperty() {
        return property;
    }



}
