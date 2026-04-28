package ss16_IO_stream.copy_file_text;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyFileText {
    public static void main(String[] args) {
        String sourcePath = "src/ss16_IO_stream/copy_file_text/source.txt";
        File sourceFile = new File(sourcePath);

        String parentPath = sourceFile.getParent();
        File destFile = new File(parentPath, "target.txt");
        String destPath = destFile.getPath();

        if (!sourceFile.exists()) {
            System.err.println("Lỗi: File nguồn không tồn tại!");
            return;
        }
        if (destFile.exists()) {
            System.out.println("Cảnh báo: File đích đã tồn tại, dữ liệu sẽ bị ghi đè!");
        }
        copyFileText(sourcePath, destPath);
    }
    public static void copyFileText(String src, String dest) {
        int count  = 0;
        try (FileReader reader = new FileReader(src);
             FileWriter writer = new FileWriter(dest)){
            int charCode;
            while ((charCode = reader.read()) != -1){
                writer.write(charCode);
                count++;
            }
            System.out.println("Sao chép thành công!");
            System.out.println("Tổng số ký tự đã sao chép: " + count);
        } catch (IOException e){
            System.err.println("Lỗi trong quá trình sao chép: " + e.getMessage());
        }
    }
}
