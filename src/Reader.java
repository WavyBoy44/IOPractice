import java.util.*;
import java.io.*;
public class Reader {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("src/user_data.txt"));
        BufferedWriter errWriter = new BufferedWriter(new FileWriter("src/error_data.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/valid_data.txt"));
        try{
            while(reader.readLine() != null){
                try {
                    String line = reader.readLine();
                    String[] attr = line.split(",");
                    if(attr.length != 3){
                        System.out.println("Error: missing data");
                        errWriter.write(line + "\n");
                    }
                    else {
                        String name = attr[0].trim();
                        String email = attr[1].trim();
                        int age = Integer.parseInt(attr[2].trim());
                        if(age < 0){
                            System.out.println("Error: age can not be less than 0");
                            errWriter.write(line + "\n");
                        }
                        else{
                            writer.write(line + "\n");
                        }
                    }



                }catch (Exception e){
                    throw new RuntimeException(e);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            reader.close();
            writer.close();
            errWriter.close();
        }

    }
}
