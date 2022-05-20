package back;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class LimparFile {
    public static void limparFile() throws IOException {
        Writer out = new FileWriter("File");
        out.write("");
        out.flush();
        System.out.println(".: SAÍNDO DO PROGRAMA :.");
    }
}
