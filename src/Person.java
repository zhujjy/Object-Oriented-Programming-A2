/**
 * Person类 - 抽象基类
 * 表示系统中的所有人，包括员工和游客
 */
public abstract class Person {
    // 实例变量
    private String name;
    private int age;
    private String gender;
    
    // 默认构造函数
    public Person() {
        this.name = "Unknown";
        this.age = 0;
        this.gender = "Unknown";
    }
    
    // 带参数的构造函数
    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    
    // Getter 和 Setter 方法
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public String getGender() {
        return gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    // 抽象方法 - 每个子类需要实现自己的信息显示方式
    public abstract void displayInfo();
}
