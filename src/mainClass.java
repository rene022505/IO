import java.io.*;

public class mainClass {

    public static void main(String[] args) {
        try {
            File file = new File("C:\\Users\\qzytlx\\Documents\\IntelliJ Projects\\Random\\newfile.txt");
            boolean fvar = file.createNewFile();
            if (fvar) {
                System.out.println("File has been created successfully");
            } else {
                System.out.println("File already present at the specified location");
            }

            /*----------------------------------------------------------------------*/

            FileOutputStream fos = null;

            String content = "Test String cool";

            fos = new FileOutputStream(file);

            byte byteArray[] = content.getBytes();

            fos.write(byteArray);
            fos.flush();
            System.out.println("File was written to successfully");

            fos.close();

            /*----------------------------------------------------------------------*/

            BufferedWriter bw = null;

            content = "This String is way cooler";

            FileWriter fw = new FileWriter(file);

            bw = new BufferedWriter(fw);

            bw.write(content);
            System.out.println("File was written to successfully");

            bw.close();
            fw.close();

            /*----------------------------------------------------------------------*/

            fw = new FileWriter(file, true);

            content = "Das bitte noch dranhängen, danke!";

            bw = new BufferedWriter(fw);

            PrintWriter pw = new PrintWriter(bw);

            bw.write(content);
            pw.println("");
            pw.println(content);

            System.out.println("File was appended to successfully");

            bw.close();
            fw.close();

            /*--------------------------------------------------------------------------*/

            FileInputStream fis = new FileInputStream(file);

            /*Passed the FileInputStream to BufferedInputStream
             *For Fast read using the buffer array.*/
            BufferedInputStream bis = null;
            bis = new BufferedInputStream(fis);

            /*available() method of BufferedInputStream
             * returns 0 when there are no more bytes
             * present in the file to be read*/
            while (bis.available() > 0) {
                System.out.print((char) bis.read());
            }

            fis.close();
            bis.close();

            /*-----------------------------------------------------------------------------*/

            BufferedReader br = new BufferedReader(new FileReader(file));

            //One way of reading the file
            System.out.println("Reading the file using readLine() method:");
            String contentLine = br.readLine();
            while (contentLine != null) {
                System.out.println(contentLine);
                contentLine = br.readLine();
            }

            BufferedReader br2 = new BufferedReader(new FileReader(file));

            //Second way of reading the file
            System.out.println("Reading the file using read() method:");
            int num = 0;
            char ch;
            while ((num = br2.read()) != -1) {
                ch = (char) num;
                System.out.print(ch);
            }

        } catch (IOException e) {
            System.out.println("Exception Occurred:");
            e.printStackTrace();
        }
    }

}
