import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Deletion {
    public static void removeRecord(String filePath, String editId) {  // TO DELETE EMPLOYE
        System.out.println("Are you sure to remove this employee?(yes/no)");
        Scanner imp = new Scanner(System.in);

        String ok = imp.next();
        String tempfile = "temp.txt";
        File oldFile = new File(filePath);
        File newFile = new File(tempfile);
        Scanner x;
        if (ok.equals("yes")) {
            try {
                FileWriter fw = new FileWriter(tempfile, true);
                BufferedWriter bw = new BufferedWriter(fw);
                x = new Scanner(new File(filePath));

                while (x.hasNextLine()) {
                    String str = x.nextLine();
                    String arr[] = str.split("\t");
                    String id = arr[3];

                    if (!(id.equals(editId))) {

                        bw.write(arr[0] + "\t" + arr[1] + "\t" + arr[2] + "\t" + arr[3] + "\t" + arr[4] + "\t" + arr[5] + "\t" + arr[6] + "\t" + arr[7] + "\t" + arr[8] + "\t" + arr[9] + "\t" + arr[10] + "\t" + arr[11] + "\n");


                    }
                }
                System.out.println("Successfilly removed");
                x.close();
                bw.flush();
                bw.close();
                oldFile.delete();
                File dump = new File(filePath);
                newFile.renameTo(dump);
            } catch (Exception e) {
                System.out.println("Erorr");
            }
        }else {
            System.out.println("Remove Cancelled!!!!");
        }
    }
}
