public class SalaryEmp extends Employee implements InterfaceTax{
    private String firstname;
    private   String lastname;
    private int Emp_id;
    private double emp_gsalary;
    SalaryEmp(String firstName,String middleName,String lastName,String id,String gender,String employeType,
              float grossSalary,String zone,String woreda,String city,String tel){
            super(firstName,middleName,lastName,id,gender,employeType,grossSalary,zone,woreda,city,tel);
            setEmp_gsalary(grossSalary);
    }

    public double getEmp_gsalary() {
        return emp_gsalary;
    }

    public void setEmp_gsalary(double gsalary) {
        double baseSalary;
        if(emp_gsalary >= 0){
            emp_gsalary = gsalary;
        }
        else
            throw new IllegalArgumentException("Weekly salary must be >= 0.0");
    }

    @Override
    public double earning() {  // inherit from employee class
        double taxRate = 0.15;
        double deduction = 0;
        if (getGrossSalary() > 0 && getGrossSalary() <= 600) {
            taxRate = 0;

        }
        else if(getGrossSalary() > 600 && getGrossSalary()<=1650){
            taxRate = 0.1;
            deduction = 60;
        }
        else if(getGrossSalary()>1650 && getGrossSalary()<=3200){
            taxRate = 0.15;
            deduction=142.5;
        }
        else if(getGrossSalary()>3200 && getGrossSalary()<=5250){
            taxRate = 0.2;
            deduction = 302.50;
        }
        else if(getGrossSalary()>5250 && getGrossSalary()<=7800){
            taxRate = 0.25;
            deduction = 565;
        }
        else if(getGrossSalary()>7800 && getGrossSalary()<=10900){
            taxRate = 0.3;
            deduction =955;
        }
        else if(getGrossSalary() >10900){
            taxRate = 0.35;
            deduction = 1500;
        }
        else{
            System.out.println("wrong gross salary!");
        }


        return getGrossSalary()-getGrossSalary()*taxRate-deduction;
    }
    public String toString(int code){ // to formated text
        if(code==1) {
            return String.format(" Employee First Name: %s\n Middle Name: %s\n Last Name: %s\n Id : %s\n Gender: %s\n Employe Type: %s\n Gross-Salary: $%f\n Total Earn Salary: $%f\n Zone: %s\n Woreda: %s\n City: %s\n Tel: %s",
                    getFirstName(), getMiddleName(), getLastName(), getId(), getGender(), getEmployeType(), getGrossSalary(), earning(), getZone(), getWoreda(), getCity(), getTel());
        }else {
            return String.format(" Employee First Name: %s\n Middle Name: %s\n Last Name: %s\n Id : %s\n Gender: %s\n Employe Type: %s\n Gross-Salary: %f\n Total Earn Salary: %f\n Zone: %s\n Password: %s\n City: %s\n Tel: %s",
                    getFirstName(), getMiddleName(), getLastName(), getId(), getGender(), getEmployeType(), getGrossSalary(), earning(), getZone(), getWoreda(), getCity(), getTel());

            }

        }

    @Override
    public void taxStatus() { // implemments from interface class
        System.out.println("Tax is implemented according to country civil-servant tax law");
    }
}
