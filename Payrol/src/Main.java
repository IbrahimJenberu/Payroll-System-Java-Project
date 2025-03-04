import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.Float.parseFloat;

// main class
public class Main {
    public static boolean Search;


    public static void main(String[] args) {   // main method
        Scanner in = new Scanner(System.in);

        boolean menubool=true;

        Scanner input = new Scanner(System.in);
        boolean mainbool=true;

        while(mainbool){
        if (Main.login()) {
            while (menubool) {
                Main.munu();  // CALL MUNU METHOD

                System.out.print("Enter your choice:  ");
                int choice = input.nextInt();
                menubool = true;

                    switch (choice) {
                        case 1:
                            boolean flag1 = true;
                            while (flag1) {
                            System.out.println("************* Employee List **********");
                            System.out.println("\t\t 1. Employee List");
                            System.out.println("\t\t 2. Admin List");
                            System.out.println("\t\t 3. Back to main menu");

                                System.out.print("Enter your Choice: ");
                            int value = in.nextInt();
                            if (value == 1) {
                                System.out.println("************* Employee List *********");
                                Registration.display(1);
                                flag1 = false;
                            } else if (value == 2) {
                                System.out.println("************* Admin List *********");
                                Registration.display(2);
                                flag1 = false;
                                } else if(value == 3){
                                menubool =true;
                                break;
                                 }else {
                                    System.out.println("Invalid input");
                                    flag1 = true;
                                }
                                }

                                menubool = true;
                                break;
                        case 2:
                            boolean flag = true;
                            while (flag) {
                                System.out.println("*************** Register employee **********************");
                                System.out.println("\t\t 1. Employee Registration");
                                System.out.println("\t\t 2. Admin Registration");
                                System.out.println("\t\t 3. Back to main menu");

                                System.out.print("Enter your Choice: ");
                                int value = in.nextInt();


                                if (value == 1) {
                                    boolean flag3 = true;
                                    while (flag3){
                                    System.out.println("************* Employee Registration *********");
                                    System.out.println("\t\t A. Monthly Salary Employee Registration");
                                    System.out.println("\t\t B. Hourly Salary Employee Registration");
                                    System.out.println("\t\t C. Contract Salary Employee Registration");
                                    System.out.println("\t\t D. Back to registration menu");
                                    System.out.print("Enter your Choice: ");
                                    String value2 = in.next();
                                    if (value2.toUpperCase().equals("A")) {
                                        Registration.EmployeRegister("A",1);
                                        flag3 = false;
                                    } else if (value2.toUpperCase().equals("B")) {
                                        Registration.EmployeRegister("B",1);
                                        flag3 = false;
                                    } else if (value2.toUpperCase().equals("C")) {
                                        Registration.EmployeRegister("C",1);
                                        flag3 = false;
                                    } else if (value2.toUpperCase().equals("D")) {
                                        menubool = false;
                                        flag = true;
                                        flag3=false;

                                    } else {
                                        System.out.println("Invalid input !!!!!!!!");
                                        flag3 = true;
                                    }
                                }
//                                    flag = false;
                                } else if (value == 2) {
                                    System.out.println("************* Admin Registration *********");
                                    Registration.EmployeRegister(2,1);
                                    flag = false;
                                } else if(value == 3){
                                    menubool =true;
                                    break;
                                }else {
                                    System.out.println("Invalid input");
                                    flag = true;
                                }
                            }

                            menubool = true;
                            break;
                        case 3:

                            System.out.println("*************** Employe Search **********************");

                            System.out.println("\t\t 1. Search by Name");
                            System.out.println("\t\t 2. Search by Id");
                            System.out.print("Enter your Choice: ");
                            int val = in.nextInt();
                            if (val == 1) {
                                Scanner inp = new Scanner(System.in);
                                System.out.print("Enter First Name:  ");
                                String username = inp.nextLine();

                                Main.search(username);
                            }
                            if (val == 2) {
                                    Scanner imp = new Scanner(System.in);
                                    System.out.print("Enter ID: EM-  ");
                                    String searchid = "EM-" + imp.next();

                                Main.search(searchid,1);
                            }

                            menubool = true;
                            break;
                        case 4:
                            String editId="";
                            String removeid="";
                            boolean flag4 = true;
                            while (flag4) {
                                System.out.println("************* Employee Remove *********");
                                System.out.println("\t\t 1. Remove Employee");
                                System.out.println("\t\t 2. Back to menu");

                                System.out.print("Enter your Choice: ");
                                int value2 = in.nextInt();

                                if (value2 == 1) {
                                    Scanner i = new Scanner(System.in);
                                    System.out.print("Enter Id Tobe Removed: EM-");
                                    removeid = "EM-"+i.next();
                                    flag4 = false;

                                } else if (value2 == 2) {
                                    menubool = true;
                                    flag4 = false;
                                    break;
                                } else {
                                    System.out.println("Invalid input");
                                    flag4 = true;
                                }
                            }

                            String filePath = "employee.txt";
                            Deletion.removeRecord(filePath,removeid);
                            menubool = true;
                            break;
                        case 5:
                             editId="";
                            int value2=0;
                             flag4 = true;
                            while (flag4) {
                                System.out.println("************* Employee Edit *********");
                                System.out.println("\t\t 1. Monthly Employee Salary");
                                System.out.println("\t\t 2. Hourly Employee Salary");
                                System.out.println("\t\t 3. Contract Employee Salary");
                                System.out.println("\t\t 4. Back to menu");

                                System.out.print("Enter your Choice: ");
                                value2 = in.nextInt();

                                if (value2 == 1) {
                                    Scanner inp = new Scanner(System.in);
                                    System.out.print("Enter Id Tobe Edited: ");
                                    editId = "EM-" + inp.next();
                                    try {

                                        System.out.print("Gross-salary: ");
                                        float salary = input.nextFloat();
                                        while (salary < 0) {
                                            System.out.println("Salary is not negative");
                                            System.out.print("Gross-salary: ");
                                            salary = input.nextFloat();
                                        }
                                        Registration.setGrossSalary(salary);
                                    } catch (Exception e) {
                                        System.out.println("Salary is number");
                                    }
                                    flag4 = false;

                                } else if(value2 == 2){
                                    Scanner inp = new Scanner(System.in);
                                    System.out.print("Enter Id Tobe Edited: EM-");
                                    editId = "EM-" + inp.next();
                                    try {
                                        System.out.print("Gross-salary: ");
                                        float salary = input.nextFloat();
                                        while (salary < 0) {
                                            System.out.println("Salary is not negative");
                                            System.out.print("Gross-salary: ");
                                            salary = input.nextFloat();
                                        }
                                        Registration.setGrossSalary(salary);
                                    } catch (Exception e) {
                                        System.out.println("Salary is number");
                                    }
                                    flag4 = false;

                                }else if(value2 == 3){
                                    Scanner inp = new Scanner(System.in);
                                    System.out.print("Enter Id Tobe Edited: ");
                                    editId = "EM-" + inp.next();
                                    try {

                                        System.out.print("Gross-salary: ");
                                        float salary = input.nextFloat();
                                        while (salary < 0) {
                                            System.out.println("Salary is not negative");
                                            System.out.print("Gross-salary: ");
                                            salary = input.nextFloat();
                                        }
                                        Registration.setGrossSalary(salary);
                                    } catch (Exception e) {
                                        System.out.println("Salary is number");
                                    }
                                    flag4 = false;

                                }
                                else if (value2 == 4) {
                                    menubool = true;
                                    flag4 = false;
                                    break;
                                } else {
                                    System.out.println("Invalid input");
                                    flag4 = true;
                                }
                            }

                             filePath = "employee.txt";
                            double newSalary = Registration.getGrossSalary();
                            EditSalary.editRecord(filePath,editId,newSalary,value2);
                            menubool = true;
                                break;
                        case 6:
                            menubool = false;
                            mainbool = false;
                            break;
                        default:
                            System.out.println("Invalid Input!!!!!!!! ");
                            Main.munu();
                            System.out.print("Enter your choice:  ");
                            choice = input.nextInt();
                    }
                }
           }
        else {
            throw new IllegalArgumentException("User not Found");
            }
        }
    }

    public static  void munu(){    // TO DISPLAY MUNU
        System.out.println("********** Menu ***********\n");
        System.out.println("\t\t 1. view Emoloyee info");
        System.out.println("\t\t 2. Registration");
        System.out.println("\t\t 3. Search Emoloyee");
        System.out.println("\t\t 4. Remove Emoloyee");
        System.out.println("\t\t 5. Edit Emoloyee Salary");
        System.out.println("\t\t 6. Close program Emoloyee\n");
    }
    public static boolean login(){   // LOGIN METHOD RETURN TRUE WHEN USER IS FOUD

        boolean status=false;
        while (!status) {
            Scanner input = new Scanner(System.in);
            System.out.println("***************** Payroll System ******************");
            System.out.println(".........Login........");
            System.out.print("Enter Id:EM-  ");
            String username = "EM-" + input.nextLine();
            System.out.print("Enter password:  ");
            String password = input.nextLine();

            File file = new File("admin.txt");
            Scanner s = null;
            try {

                s = new Scanner(file);

                while (s.hasNextLine()) {
                    String str = s.nextLine();
                    String arr[] = str.split("\t");

                    if (username.toUpperCase().equals(arr[3].toUpperCase()) && password.equals(arr[9])) {
                        status = true;
                        break;
                    }
                }
                s.close();
            } catch (IOException e) {
                System.out.println("exception");
            }
            if (!status){
                System.out.println("Incorrect password Try again");
            }
        }


        return status;
    }
    public static void search(String name){  // SEARCH BY ID

        Scanner input = new Scanner(System.in);

        File file = new File("employee.txt");
        Scanner s=null;
        try {

            s = new Scanner(file);

            while (s.hasNextLine()) {
                String str = s.nextLine();
                String arr[] = str.split("\t");

                if(name.toUpperCase().equals(arr[0])){
                    Search = true;
                    System.out.println("***************************");
                    System.out.println("User Found!!!!!!!!");
                    System.out.println("*****************************");
                    String fname = arr[0];
                    String mname = arr[1];
                    String lname = arr[2];
                    String id = arr[3];
                    String gender = arr[4];
                    String empType = arr[5];
                    float gsalary = parseFloat(arr[6]);

                    String zone = arr[8];
                    String woreda = arr[9];
                    String city = arr[10];
                    String tel = arr[11];
                    SalaryEmp obj = new SalaryEmp(fname,mname,lname,id,gender,empType,gsalary,zone,woreda,city,tel);
                    System.out.println(obj.toString(1));
                    break;
                }

                }
            if(!Search){
                System.out.println("***************************");
                System.out.println("User Not Found!!!!!!!!");
                System.out.println("*****************************");

            }
            s.close();
        }
        catch (IOException e){
            System.out.println("exception");
        }

    }
    public static void search(String searchid ,int code){   // SEARCH BY NAME

        Scanner input = new Scanner(System.in);
        Search = false;

        File file = new File("employee.txt");
        Scanner s=null;
        try {

            s = new Scanner(file);

            while (s.hasNextLine()) {
                String str = s.nextLine();
                String arr[] = str.split("\t");

                if (searchid.toUpperCase().equals(arr[3])) {
                    Search = true;
                    if (code == 1) {

                        System.out.println("***************************");
                        System.out.println("User Found!!!!!!!!");
                        System.out.println("*****************************");
                        String fname = arr[0];
                        String mname = arr[1];
                        String lname = arr[2];
                        String id = arr[3];
                        String gender = arr[4];
                        String empType = arr[5];
                        float gsalary = parseFloat(arr[6]);

                        String zone = arr[8];
                        String woreda = arr[9];
                        String city = arr[10];
                        String tel = arr[11];
                        SalaryEmp obj = new SalaryEmp(fname, mname, lname, id, gender, empType, gsalary, zone, woreda, city, tel);

                        System.out.println(obj.toString(1));

                    }
                }
                }
            if (code == 1) {
                if (!Search) {
                    System.out.println("***************************");
                    System.out.println("User Not Found!!!!!!!!");
                    System.out.println("*****************************");

                }
            }

            s.close();
        }
        catch (Exception e){
            System.out.println("exception");
        }

    }

}

