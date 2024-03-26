package hei.school.soratra.file;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Component
public class TextFileHandler {
    public File textToTXTFile(String text) throws IOException {
        File file = File.createTempFile("text", ".txt");
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(text.getBytes());
        }
        return file;
    }
}
