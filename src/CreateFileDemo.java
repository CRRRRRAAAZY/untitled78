import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
    public class CreateFileDemo
    {
        public static void main( String[] args ) throws IOException {
            try {
                File file = new File("D:\\newfile.txt");

                //创建一个新文件
                boolean fvar = file.createNewFile();
                if (fvar){
                    System.out.println("File has been created successfully");
                }
                else{
                    System.out.println("File already present at the specified location");
                }
            } catch (IOException e) {
                System.out.println("Exception Occurred:");
                e.printStackTrace();
            }
       FileWriter fileWriter=new FileWriter("D:\\newfile.txt");
            fileWriter.write("what\n the\n fuck\n");
            fileWriter.close();

        }
    }


