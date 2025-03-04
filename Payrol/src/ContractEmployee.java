public class ContractEmployee extends Employee implements InterfaceTax{
    private String firstname;
    private   String lastname;
    private int Emp_id;
    private double emp_gsalary;

    ContractEmployee(String firstName,String middleName,String lastName,String id,String gender,String employeType,
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
    public double earning() {   // INHERIT FROM EMPLOYEE ABSTRACT CLASS
        double taxRate = 0.15;


        if (getGrossSalary() > 50000) {
            taxRate = 0.25;

        }
        else if(getGrossSalary() < 50000){
            taxRate = 1;

        }
        else{
            System.out.println("wrong gross salary!");
        }
        return getGrossSalary()*taxRate;
    }
    public String toString(int code){    // FORMATTED FORM OF EMPLOYEE ATTRIBUTES
        if(code==1) {
            return String.format(" Employee First Name: %s\n Middle Name: %s\n Last Name: %s\n Id : %s\n Gender: %s\n Employe Type: %s\n Gross-Salary: %f\n Total Earn Salary: %f\n Zone: %s\n Woreda: %s\n City: %s\n Tel: %s",
                    getFirstName(), getMiddleName(), getLastName(), getId(), getGender(), getEmployeType(), getGrossSalary(), earning(), getZone(), getWoreda(), getCity(), getTel());
        }else {
            return String.format(" Employee First Name: %s\n Middle Name: %s\n Last Name: %s\n Id : %s\n Gender: %s\n Employe Type: %s\n Gross-Salary: %f\n Total Earn Salary: %f\n Zone: %s\n Password: %s\n City: %s\n Tel: %s",
                    getFirstName(), getMiddleName(), getLastName(), getId(), getGender(), getEmployeType(), getGrossSalary(), earning(), getZone(), getWoreda(), getCity(), getTel());
        }
    }

    @Override
    public void taxStatus() {  // OVERRIDE FROM INTERFACE CLASS INTERFACETAX
        System.out.println("The tax Rate is implement when the contract is greater than $50000");
    }
}

