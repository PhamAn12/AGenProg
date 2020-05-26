package Population;


import java.io.*;

public class FileModifiedDir {

    public static void moveFileDir(String sourceDir,String destiantionDir) {
        InputStream inStream = null;
        OutputStream outStream = null;
        try {
            File afile = new File(sourceDir);
            String parentPathOfAfile = afile.getParentFile().getName();
            new File(destiantionDir + parentPathOfAfile).mkdir();
            File bfile = new File(destiantionDir + parentPathOfAfile + "\\" + afile.getName());
            inStream = new FileInputStream(afile);
            outStream = new FileOutputStream(bfile);

            byte[] buffer = new byte[1024];

            int length;
            //copy the file content in bytes
            while ((length = inStream.read(buffer)) > 0){

                outStream.write(buffer, 0, length);

            }

            inStream.close();
            outStream.close();
            System.out.println("File is copied successful!");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void moveRawFileDir(String sourceDir,String destiantionDir) {
        InputStream inStream = null;
        OutputStream outStream = null;
        try {
            File afile = new File(sourceDir);

            File bfile = new File(destiantionDir);
            inStream = new FileInputStream(afile);
            outStream = new FileOutputStream(bfile);

            byte[] buffer = new byte[1024];

            int length;
            //copy the file content in bytes
            while ((length = inStream.read(buffer)) > 0){

                outStream.write(buffer, 0, length);

            }

            inStream.close();
            outStream.close();
            System.out.println("File is copied successful!");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
