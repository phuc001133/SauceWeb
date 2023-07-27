package core.configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {
    private Properties prop;
    private InputStream inputStream;
    private String filePath;

    public Configuration(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Read file .properties and get string value of property
     * @param propertyName want to get value
     * @return value of property
     * @throws IOException
     */
    public String getProperty(String propertyName) throws IOException {

        //create variable string to contain value string of property
        String result = "";

        try {
            //init a object of Properties class
            prop = new Properties();

            //init file input
            inputStream = new FileInputStream(this.filePath);

            //if file have string (not empty) prop object will load (get) value properties have in file
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                //if can not find the fife, throw a exception with below message
                throw new FileNotFoundException("property file " + filePath + " not found in the classpath");
            }

            //assign string value of property
            result = prop.getProperty(propertyName);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            //if have exception or not, file must close
            inputStream.close();
        }

        return result;
    }
}
