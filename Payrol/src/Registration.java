import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.Float.parseFloat;

public class Registration extends SalaryEmp {
     public static int hour;
     Scanner input = new Scanner(System.in);

     Registration(String firstName, String middleName, String lastName, String id,
               String gender, String employeSalary, float grossSalary, String zone, String woreda, String city,
               String tel) {

          super(firstName, middleName, lastName, id, gender, employeSalary, grossSalary, zone, woreda, city, tel);

     }

     public static <T> void EmployeRegister(T code, int isEditCode) { // to register employee and generics concept
          String file = (code.equals("A") || code.equals("B") || code.equals("C")) ? "employee.txt" : "admin.txt";
          Scanner input = new Scanner(System.in);

          SalaryEmp se = new SalaryEmp(getFirstName(), getMiddleName(), getLastName(), getId(), getGender(),
                    getEmployeType(), getGrossSalary(), getZone(), getWoreda(), getCity(), getTel());

          System.out.print("First Name : ");
          String firstName = input.nextLine();
          while (!firstName.matches("^[a-zA-Z]+$")) {
               System.out.println("Wrong First Name");
               System.out.print("First Name : ");
               firstName = input.nextLine();
          }
          setFirstName(firstName);

          System.out.print("Middle Name : ");
          String middleName = input.nextLine();
          while (!middleName.matches("^[a-zA-Z]+$")) {
               System.out.println("Wrong Middle Name");
               System.out.print("Middle Name : ");
               middleName = input.nextLine();
          }
          setMiddleName(middleName);
          System.out.print("Last Name : ");
          String lastName = input.nextLine();
          while (!lastName.matches("^[a-zA-Z]+$")) {
               System.out.println("Wrong Last Name");
               System.out.print("Last Name : ");
               lastName = input.nextLine();
          }
          setLastName(lastName);

          System.out.print("Employee Id :EM- ");
          String empID = input.nextLine();
          String userName = "EM-" + empID;

          Main.search(userName, 0);
          while (!(Main.Search == false)) {
               System.out.println("There is Employee with the same Id, Please enter Another Id!!!");
               System.out.print("Employee Id :EM- ");
               empID = input.next();
               userName = "EM-" + empID;
               Main.search(userName, 0);
          }
          setId(userName);

          System.out.print("Gender Male/Female: ");
          String sex = String.valueOf(input.next().toUpperCase().charAt(0));
          if (sex.equalsIgnoreCase("M")) {
               sex = "MALE";
               setGender(sex);
          } else if (sex.equalsIgnoreCase("F")) {
               sex = "FEMALE";
               setGender(sex);
          } else {
               while (!(sex.equalsIgnoreCase("M") || sex.equalsIgnoreCase("F"))) {
                    System.out.println("Invalid Gender");
                    System.out.print("Gender Male/Female: ");
                    sex = String.valueOf(input.next().toUpperCase().charAt(0));

               }
               setGender(sex);

          }
          System.out.print("Employee Type : ");
          String type = input.next();
          setEmployeType(type);
          float salary = 0;
          boolean fg = true;
          while (fg) {

               try {
                    fg = false;
                    Scanner in = new Scanner(System.in);
                    System.out.print("Gross-salary: $");
                    salary = in.nextFloat();
                    while (salary < 0) {
                         System.out.println("Salary is not negative");
                         System.out.print("Gross-salary: ");
                         salary = input.nextFloat();
                    }

               } catch (Exception e) {
                    System.out.println("Salary is number Enter again");
                    fg = true;
               }
               setGrossSalary(salary);
          }

          System.out.print("Zone : ");
          String zone = input.next();
          setZone(zone);

          if (code.equals("A")) {
               System.out.print("Woreda : ");
               String Woreda = input.next();
               setWoreda(Woreda);
          } else if (code.equals("B")) {
               System.out.print("Working Hour : ");
               hour = input.nextInt();

          } else if (code.equals("C")) {
               System.out.print("Woreda : ");
               String EWoreda = input.next();
               setWoreda(EWoreda);
          } else {
               System.out.print("Enter Password : ");
               String pass = input.next();
               setWoreda(pass);
          }

          System.out.print("K. sub-city : ");
          String city = input.next();
          setCity(city);
          input.nextLine();
          System.out.print("Tel-Number :(+251) ");
          long tel = input.nextLong();
          while (String.valueOf(tel).length() < 9) {
               System.out.println("Wrong phone number Input Register again with valid phone number Eth");
               System.out.print("Tel-Number :(+251) ");
               tel = input.nextLong();
          }
          setTel("+251" + tel);

          if (isEditCode == 1) {

               BufferedWriter bf = null;

               try {
                    bf = new BufferedWriter(new FileWriter(new File(file), true));
               } catch (IOException e) {
                    throw new RuntimeException(e);
               }

               try {
                    if (code.equals("A")) {
                         bf.write("\n" + getFirstName().toUpperCase() + "\t" + getMiddleName().toUpperCase() + "\t"
                                   + getLastName().toUpperCase() + "\t" + getId() + "\t" + getGender().toUpperCase()
                                   + "\t" + getEmployeType().toUpperCase() + "\t" + getGrossSalary() + "\t"
                                   + se.earning() + "\t" + getZone().toUpperCase() + "\t" + getWoreda().toUpperCase()
                                   + "\t" + getCity().toUpperCase() + "\t" + getTel());
                    } else if (code.equals("B")) {
                         HourlyEmployee hem = new HourlyEmployee(getFirstName(), getMiddleName(), getLastName(),
                                   getId(), getGender(), getEmployeType(), getGrossSalary(), getZone(),
                                   String.valueOf(hour), getCity(), getTel(), hour);

                         bf.write("\n" + getFirstName().toUpperCase() + "\t" + getMiddleName().toUpperCase() + "\t"
                                   + getLastName().toUpperCase() + "\t" + getId() + "\t" + getGender().toUpperCase()
                                   + "\t" + getEmployeType().toUpperCase() + "\t" + getGrossSalary() + "\t"
                                   + hem.earning() + "\t" + getZone().toUpperCase() + "\t" + getWoreda() + "\t"
                                   + getCity().toUpperCase() + "\t" + getTel());
                    } else if (code.equals("C")) {
                         ContractEmployee hem = new ContractEmployee(getFirstName(), getMiddleName(), getLastName(),
                                   getId(), getGender(), getEmployeType(), getGrossSalary(), getZone(), getWoreda(),
                                   getCity(), getTel());

                         bf.write("\n" + getFirstName().toUpperCase() + "\t" + getMiddleName().toUpperCase() + "\t"
                                   + getLastName().toUpperCase() + "\t" + getId() + "\t" + getGender().toUpperCase()
                                   + "\t" + getEmployeType().toUpperCase() + "\t" + getGrossSalary() + "\t"
                                   + se.earning() + "\t" + getZone().toUpperCase() + "\t" + getWoreda().toUpperCase()
                                   + "\t" + getCity().toUpperCase() + "\t" + getTel());
                    } else {
                         bf.write("\n" + getFirstName().toUpperCase() + "\t" + getMiddleName().toUpperCase() + "\t"
                                   + getLastName().toUpperCase() + "\t" + getId() + "\t" + getGender().toUpperCase()
                                   + "\t" + getEmployeType().toUpperCase() + "\t" + getGrossSalary() + "\t"
                                   + se.earning() + "\t" + getZone().toUpperCase() + "\t" + getWoreda().toUpperCase()
                                   + "\t" + getCity().toUpperCase() + "\t" + getTel());
                    }
                    System.out.println("**************************");
                    System.out.println("Successfully Registered");
                    System.out.println("**************************");

                    bf.close();
               } catch (IOException e) {
                    throw new RuntimeException(e);
               }
          }
     }

     public static void display(int code) { // Display employee info
          String fil = (code == 1) ? "employee.txt" : "admin.txt";

          File file = new File(fil);
          Scanner s = null;
          try {

               s = new Scanner(file);
               int count = 0;
               while (s.hasNextLine()) {
                    String str = s.nextLine();
                    String arr[] = str.split("\t");
                    count++;

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

                    SalaryEmp obj = new SalaryEmp(fname, mname, lname, id, gender, empType, gsalary, zone, woreda, city,
                              tel);

                    System.out.println("***************** " + count + " ***********************");

                    System.out.println(obj.toString(code)); // to formated display
               }
               s.close();
          } catch (IOException e) {
               System.out.println("exception");
          }
     }
}
