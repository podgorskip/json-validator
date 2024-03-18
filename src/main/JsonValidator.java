package main;

import java.io.*;
import java.util.regex.Pattern;

/**
 *
 * Class allowing to validate whether the provided input file contains a single asterisk in JSON Resource field
 */
public class JsonValidator {
    public static boolean validate(String filepath)  {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath))) {
            String resource = "\"Resource\"";
            Pattern pattern = Pattern.compile(resource);

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                if (pattern.matcher(line).find()) {
                    line = line.trim();

                    int offset = line.indexOf("\"", line.indexOf("\"") + 1);

                    String content = line.substring(line.indexOf("\"", offset + 1) + 1, line.lastIndexOf("\"")).trim();

                    return !content.equals("*");
                }
            }

        } catch (IOException e) {
            throw new RuntimeException("Couldn't find file: " + filepath);
        }

        return true;
    }

    public static void main(String[] args) {
        if (args.length < 1)
            throw new RuntimeException("File has not been specified");

        System.out.println(validate(args[0]));
    }
}
