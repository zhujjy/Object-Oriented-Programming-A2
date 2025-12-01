/**
 * Visitor类 - 继承自Person
 * 表示主题公园的游客
 */
public class Visitor extends Person {
    // 游客特有实例变量
    private String visitorId;
    private String ticketType;
    private boolean hasMembership;
    
    // 默认构造函数
    public Visitor() {
        super();
        this.visitorId = "V0000";
        this.ticketType = "Standard";
        this.hasMembership = false;
    }
    
    // 带参数的构造函数
    public Visitor(String name, int age, String gender, 
                  String visitorId, String ticketType, boolean hasMembership) {
        super(name, age, gender);
        this.visitorId = visitorId;
        this.ticketType = ticketType;
        this.hasMembership = hasMembership;
    }
    
    // 实现抽象方法
    @Override
    public void displayInfo() {
        System.out.println("=== Visitor Information ===");
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Gender: " + getGender());
        System.out.println("Visitor ID: " + visitorId);
        System.out.println("Ticket Type: " + ticketType);
        System.out.println("Membership: " + (hasMembership ? "Yes" : "No"));
        System.out.println("---------------------------");
    }
    
    // Getter 和 Setter 方法
    public String getVisitorId() {
        return visitorId;
    }
    
    public void setVisitorId(String visitorId) {
        this.visitorId = visitorId;
    }
    
    public String getTicketType() {
        return ticketType;
    }
    
    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }
    
    public boolean hasMembership() {
        return hasMembership;
    }
    
    public void setHasMembership(boolean hasMembership) {
        this.hasMembership = hasMembership;
    }
}
