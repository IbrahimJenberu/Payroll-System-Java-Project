public class HourlyEmployee extends Employee implements InterfaceTax{
    private String firstname;
    private   String lastname;
    private int Emp_id;
    private double emp_gsalary;
    private int Hour;
    HourlyEmployee(String firstName,String middleName,String lastName,String id,String gender,String employeType,
              float grossSalary,String zone,String woreda,String city,String tel,int hour){
        super(firstName,middleName,lastName,id,gender,employeType,grossSalary,zone,woreda,city,tel);
        setEmp_gsalary(grossSalary);
        setHour(hour);
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

    public int getHour() {
        return Hour;
    }

    public void setHour(int hour) {
        this.Hour = hour;
    }

    @Override
    public double earning() {

        return getGrossSalary()*getHour();
    }
    public String toString(int code){
        if(code==1) {
            return String.format(" Employee First Name: %s\n Middle Name: %s\n Last Name: %s\n Id : %s\n Gender: %s\n Employe Type: %s\n Gross-Salary: %f\n Total Earn Salary: %f\n Zone: %s\n Woreda: %s\n City: %s\n Tel: %s",
                    getFirstName(), getMiddleName(), getLastName(), getId(), getGender(), getEmployeType(), getGrossSalary(), earning(), getZone(), getWoreda(), getCity(), getTel());
        }else {
            return String.format(" Employee First Name: %s\n Middle Name: %s\n Last Name: %s\n Id : %s\n Gender: %s\n Employe Type: %s\n Gross-Salary: %f\n Total Earn Salary: %f\n Zone: %s\n Password: %s\n City: %s\n Tel: %s",
                    getFirstName(), getMiddleName(), getLastName(), getId(), getGender(), getEmployeType(), getGrossSalary(), earning(), getZone(), getWoreda(), getCity(), getTel());

        }
    }

    @Override
    public void taxStatus() {
        System.out.println("Have no tax its salary is according to working hour");
    }
}
