package Util;

import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by josepita on 13/08/2017.
 */
public class ReadFromFile {
    public String readFromFile(String FileName) throws IOException {
        String fileContent = "";
        FileInputStream inputStream = new FileInputStream(FileName);
        try {
            fileContent = IOUtils.toString(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            inputStream.close();
        }
        return fileContent;
    }
}
