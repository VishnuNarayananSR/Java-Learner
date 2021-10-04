//author: sushen


import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.lang.*;

// Write your code below.
class EncryptDecryptFile {
    public void writeDecryptionFile(String message) {
        try {

            FileWriter f1 = new FileWriter(Solution.filepath + "DecryptionFile.txt");
            f1.write(message);
            f1.close();
        } catch (Exception e) {
            System.out.println("Some exception!");
        }

    }

    public String readEncryptionFile() {
        File f2 = new File(FileOperations.filepath + "EncryptionFile.txt");
        String result;
        StringBuilder sb = new StringBuilder();
        try {
            Scanner sc = new Scanner(f2);

            while (sc.hasNext()) {
                sb.append(sc.nextLine());
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("Some more exception!");
        }
        result = sb.toString();
        return result;

    }
}

public class FileOperations {
    public static String filepath = System.getenv("OUTPUT_PATH").substring(0,
            System.getenv("OUTPUT_PATH").lastIndexOf("\\") + 1);

    private static String generateString() {
        char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();
        StringBuilder generatedString = new StringBuilder(20);
        Random random = new Random();
        for (int i = 0; i < 40; i++) {
            char c = chars[random.nextInt(chars.length)];
            generatedString.append(c);
        }
        return generatedString.toString();
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String message = sc.nextLine();

        try {
            EncryptDecryptFile f = new EncryptDecryptFile();

            String encryptFilename = Solution.filepath + "EncryptionFile.txt";
            String generatedString = generateString();
            BufferedWriter writer = new BufferedWriter(new FileWriter(encryptFilename));
            writer.write(generatedString);
            writer.close();

            if (f.readEncryptionFile().equals(generatedString)) {
                f.writeDecryptionFile(message);

                String decryptFilename = Solution.filepath + "DecryptionFile.txt";
                BufferedReader reader = new BufferedReader(new FileReader(decryptFilename));
                String messageFromFile = reader.readLine();
                reader.close();

                System.out.println(messageFromFile);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

}