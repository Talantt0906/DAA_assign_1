package talant_work;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CSVWriter {
    private PrintWriter writer;

    
    public CSVWriter(String fileName) throws IOException {
        writer = new PrintWriter(new FileWriter(fileName, true)); 
    }

    // 写入一行
    public void writeRow(String... values) {
        String line = String.join(",", values);
        writer.println(line);
    }

    // 关闭
    public void close() {
        writer.close();
    }
}



