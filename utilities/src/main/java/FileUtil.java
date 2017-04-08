import java.io.*;

public class FileUtil {

    public static String inputStreamToString(InputStream is) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        String lineToRead;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
        while ((lineToRead = bufferedReader.readLine()) != null) {
            stringBuilder.append(lineToRead);
        }
        bufferedReader.close();
        return stringBuilder.toString();
    }

    public static String FileToString(File file) throws IOException {

        InputStream is = new FileInputStream(file);
        StringBuilder stringBuilder = new StringBuilder();
        String lineToRead;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
        while ((lineToRead = bufferedReader.readLine()) != null) {
            stringBuilder.append(lineToRead);
        }
        bufferedReader.close();
        return stringBuilder.toString();
    }

    public static String FileToString(String filePath) throws IOException {

        if(filePath != null && filePath != ""){
            File file = new File(filePath);
            return FileToString(file);
        }

        return null;
    }

}
