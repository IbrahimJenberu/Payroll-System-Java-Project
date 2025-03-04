public abstract class Employee {
    private static String FirstName;
    private  static String MiddleName;
    private static String Id;
    private static String LastName;

    private static String Gender;
    private static float GrossSalary;
    private static String Zone;
    private static String Woreda;
    private static String City;
    private static String Tel;
    private static String EmployeType;


    Employee(String firstName,String middleName,String lastName,String id,String gender,String employeType,
             float grossSalary,String zone,String woreda,String city,String tel){
        FirstName = firstName;
        MiddleName = middleName;
        LastName = lastName;
        Id  = id;
        Gender = gender;

        EmployeType = employeType;
        GrossSalary = grossSalary;
        Zone = zone;
        City = city;
        Woreda = woreda;
        Tel = tel;
    }


    public static String getFirstName() {
        return FirstName;
    }

    public static void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public static String getMiddleName() {
        return MiddleName;
    }

    public static void setMiddleName(String middleName) {
        MiddleName = middleName;
    }

    public static String getId() {
        return Id;
    }

    public static void setId(String id) {
        Id = id;
    }

    public static String getLastName() {
        return LastName;
    }

    public static void setLastName(String lastName) {
        LastName = lastName;
    }

    public static String getGender() {
        return Gender;
    }

    public static void setGender(String gender) {
        Gender = gender;
    }

    public static float getGrossSalary() {
        return GrossSalary;
    }

    public static void setGrossSalary(float grossSalary) {
        GrossSalary = grossSalary;
    }

    public static String getZone() {
        return Zone;
    }

    public static void setZone(String zone) {
        Zone = zone;
    }

    public static String getWoreda() {
        return Woreda;
    }

    public static void setWoreda(String woreda) {
        Woreda = woreda;
    }

    public static String getCity() {
        return City;
    }

    public static void setCity(String city) {
        City = city;
    }
    public static String getTel() {
        return Tel;
    }
    public static void setTel(String tel) {
        Tel = tel;
    }
    public static String getEmployeType() {
        return EmployeType;
    }
    public static void setEmployeType(String employeType) {
        EmployeType = employeType;
    }
    public abstract double earning();   // abstract method

}
