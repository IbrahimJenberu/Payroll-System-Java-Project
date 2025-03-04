import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class EditSalary {
    public static void editRecord(String filePath, String editId,double newSalary,int code) { // TO EDIT EMPLOYEE SALARY
        String tempfile = "temp.txt";
        File oldFile = new File(filePath);
        File newFile = new File(tempfile);
        Scanner x;

        try{
            FileWriter fw = new FileWriter(tempfile,true);
            BufferedWriter bw = new BufferedWriter(fw);
            x = new Scanner(new File(filePath));

            while (x.hasNextLine()){
                String str = x.nextLine();
                String arr[] = str.split("\t");
                String id = arr[3];

                if (id.equals(editId)){
                    if (code == 1) {

                        SalaryEmp se = new SalaryEmp(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], (float) newSalary, arr[7], arr[8], arr[9], arr[10]);
                        bw.write(arr[0] + "\t" + arr[1] + "\t" + arr[2] + "\t" + arr[3] + "\t" + arr[4] + "\t" + arr[5] + "\t" + newSalary + "\t" + se.earning() + "\t" + arr[8] + "\t" + arr[9] + "\t" + arr[10] + "\t" + arr[11] + "\n");
                    } else if (code == 2) {

                        HourlyEmployee he = new HourlyEmployee(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], (float) newSalary, arr[7], arr[8], arr[9], arr[10],Integer.valueOf(arr[9]));
                        bw.write(arr[0] + "\t" + arr[1] + "\t" + arr[2] + "\t" + arr[3] + "\t" + arr[4] + "\t" + arr[5] + "\t" + newSalary + "\t" + he.earning() + "\t" + arr[8] + "\t" + arr[9] + "\t" + arr[10] + "\t" + arr[11] + "\n");
                    } else if (code == 3) {

                        ContractEmployee ce = new ContractEmployee(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], (float) newSalary, arr[7], arr[8], arr[9], arr[10]);
                        bw.write(arr[0] + "\t" + arr[1] + "\t" + arr[2] + "\t" + arr[3] + "\t" + arr[4] + "\t" + arr[5] + "\t" + newSalary + "\t" + ce.earning() + "\t" + arr[8] + "\t" + arr[9] + "\t" + arr[10] + "\t" + arr[11] + "\n");
                    }
                    System.out.println("Successfully edited");

                }else {
                    bw.write(arr[0] + "\t" + arr[1] + "\t" + arr[2] + "\t" + arr[3] + "\t" + arr[4] + "\t" + arr[5] + "\t" + arr[6] + "\t" + arr[7] + "\t" + arr[8] + "\t" + arr[9] + "\t" + arr[10] + "\t" + arr[11]+"\n");
                }
            }
            x.close();
            bw.flush();
            bw.close();
            oldFile.delete();
            File dump = new File(filePath);
            newFile.renameTo(dump);
        }catch (Exception e){
            System.out.println("Erorr");
        }
    }
}
