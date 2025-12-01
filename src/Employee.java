/**
 * Employee类 - 继承自Person
 * 表示主题公园的员工
 */
public class Employee extends Person {
    // 员工特有实例变量
    private String employeeId;
    private String department;
    private String position;
    
    // 默认构造函数
    public Employee() {
        super();
        this.employeeId = "E0000";
        this.department = "General";
        this.position = "Staff";
    }
    
    // 带参数的构造函数
    public Employee(String name, int age, String gender, 
                   String employeeId, String department, String position) {
        super(name, age, gender);
        this.employeeId = employeeId;
        this.department = department;
        this.position = position;
    }
    
    // 实现抽象方法
    @Override
    public void displayInfo() {
        System.out.println("=== Employee Information ===");
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Gender: " + getGender());
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Department: " + department);
        System.out.println("Position: " + position);
        System.out.println("---------------------------");
    }
    
    // Getter 和 Setter 方法
    public String getEmployeeId() {
        return employeeId;
    }
    
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }
    
    public String getPosition() {
        return position;
    }
    
    public void setPosition(String position) {
        this.position = position;
    }
}
