import java.util.*;

/**
 * AssignmentTwo类 - 主程序类
 * 包含main方法和各个部分的演示方法
 */
public class AssignmentTwo {
    
    public static void main(String[] args) {
        System.out.println("=== Theme Park Management System ===");
        System.out.println("Starting demonstration...\n");
        
        AssignmentTwo demo = new AssignmentTwo();
        
        // 演示各个部分
        demo.partThree();
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        demo.partFourA();
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        demo.partFourB();
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        demo.partFive();
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        demo.partSix();
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        demo.partSeven();
        
        System.out.println("\n=== All demonstrations completed ===");
    }
    
    // Part 3 演示 - 等待队列
    public void partThree() {
        System.out.println("PART 3 - WAITING QUEUE DEMONSTRATION");
        
        // 创建员工
        Employee operator = new Employee("John Operator", 30, "Male", 
                                        "E1001", "Ride Operations", "Ride Operator");
        
        // 创建游乐设施
        Ride rollerCoaster = new Ride("Thunder Coaster", "Roller Coaster", 140, operator, 4);
        
        // 创建游客
        Visitor v1 = new Visitor("Alice", 25, "Female", "V1001", "Standard", false);
        Visitor v2 = new Visitor("Bob", 30, "Male", "V1002", "Premium", true);
        Visitor v3 = new Visitor("Charlie", 22, "Male", "V1003", "Standard", false);
        Visitor v4 = new Visitor("Diana", 28, "Female", "V1004", "Standard", true);
        Visitor v5 = new Visitor("Eve", 35, "Female", "V1005", "Premium", false);
        
        // 添加游客到队列
        System.out.println("\n1. Adding 5 visitors to queue:");
        rollerCoaster.addVisitorToQueue(v1);
        rollerCoaster.addVisitorToQueue(v2);
        rollerCoaster.addVisitorToQueue(v3);
        rollerCoaster.addVisitorToQueue(v4);
        rollerCoaster.addVisitorToQueue(v5);
        
        // 打印队列
        System.out.println("\n2. Current waiting queue:");
        rollerCoaster.printQueue();
        
        // 移除一个游客
        System.out.println("\n3. Removing one visitor from queue:");
        rollerCoaster.removeVisitorFromQueue();
        
        // 再次打印队列
        System.out.println("\n4. Updated waiting queue:");
        rollerCoaster.printQueue();
    }
    
    // Part 4A 演示 - 乘坐历史记录
    public void partFourA() {
        System.out.println("PART 4A - RIDE HISTORY DEMONSTRATION");
        
        // 创建员工和设施
        Employee operator = new Employee("Sarah Manager", 35, "Female", 
                                        "E1002", "Management", "Supervisor");
        Ride waterRide = new Ride("Splash Mountain", "Water Ride", 120, operator, 6);
        
        // 创建游客
        Visitor v1 = new Visitor("Frank", 40, "Male", "V2001", "Premium", true);
        Visitor v2 = new Visitor("Grace", 18, "Female", "V2002", "Student", false);
        Visitor v3 = new Visitor("Henry", 25, "Male", "V2003", "Standard", false);
        Visitor v4 = new Visitor("Ivy", 32, "Female", "V2004", "Premium", true);
        Visitor v5 = new Visitor("Jack", 28, "Male", "V2005", "Standard", true);
        
        // 添加游客到历史记录
        System.out.println("\n1. Adding 5 visitors to ride history:");
        waterRide.addVisitorToHistory(v1);
        waterRide.addVisitorToHistory(v2);
        waterRide.addVisitorToHistory(v3);
        waterRide.addVisitorToHistory(v4);
        waterRide.addVisitorToHistory(v5);
        
        // 检查游客是否在历史记录中
        System.out.println("\n2. Checking if visitor is in history:");
        waterRide.checkVisitorFromHistory(v3);
        
        Visitor newVisitor = new Visitor("Newbie", 20, "Male", "V9999", "Standard", false);
        waterRide.checkVisitorFromHistory(newVisitor);
        
        // 打印游客数量
        System.out.println("\n3. Number of visitors in history: " + waterRide.numberOfVisitors());
        
        // 打印所有游客历史记录
        System.out.println("\n4. Ride history (using Iterator):");
        waterRide.printRideHistory();
    }
    
    // Part 4B 演示 - 排序历史记录
    public void partFourB() {
        System.out.println("PART 4B - SORTING RIDE HISTORY");
        
        // 创建员工和设施
        Employee operator = new Employee("Mike Supervisor", 40, "Male", 
                                        "E1003", "Operations", "Manager");
        Ride ferrisWheel = new Ride("Sky Wheel", "Ferris Wheel", 100, operator, 8);
        
        // 创建游客（不同年龄和姓名）
        Visitor v1 = new Visitor("Zack", 45, "Male", "V3001", "Standard", false);
        Visitor v2 = new Visitor("Amy", 22, "Female", "V3002", "Student", true);
        Visitor v3 = new Visitor("Brian", 30, "Male", "V3003", "Premium", false);
        Visitor v4 = new Visitor("Cathy", 22, "Female", "V3004", "Standard", true);
        Visitor v5 = new Visitor("David", 35, "Male", "V3005", "Premium", true);
        
        // 添加游客到历史记录
        System.out.println("\n1. Adding 5 visitors to ride history:");
        ferrisWheel.addVisitorToHistory(v1);
        ferrisWheel.addVisitorToHistory(v2);
        ferrisWheel.addVisitorToHistory(v3);
        ferrisWheel.addVisitorToHistory(v4);
        ferrisWheel.addVisitorToHistory(v5);
        
        // 打印排序前的历史记录
        System.out.println("\n2. Ride history BEFORE sorting:");
        ferrisWheel.printRideHistory();
        
        // 创建比较器并排序
        System.out.println("\n3. Sorting ride history by age and name:");
        VisitorComparator comparator = new VisitorComparator();
        ferrisWheel.sortRideHistory(comparator);
        
        // 打印排序后的历史记录
        System.out.println("\n4. Ride history AFTER sorting:");
        ferrisWheel.printRideHistory();
    }
    
    // Part 5 演示 - 运行一个周期
    public void partFive() {
        System.out.println("PART 5 - RUN ONE CYCLE DEMONSTRATION");
        
        // 创建员工和设施
        Employee operator = new Employee("Lisa Operator", 28, "Female", 
                                        "E1004", "Ride Operations", "Operator");
        Ride carousel = new Ride("Magic Carousel", "Carousel", 90, operator, 3);
        
        // 创建10个游客
        System.out.println("\n1. Creating 10 visitors:");
        List<Visitor> visitors = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Visitor visitor = new Visitor("Visitor" + i, 20 + i, 
                                         i % 2 == 0 ? "Female" : "Male", 
                                         "V400" + i, 
                                         i % 3 == 0 ? "Premium" : "Standard", 
                                         i % 2 == 0);
            visitors.add(visitor);
        }
        
        // 添加所有游客到队列
        System.out.println("\n2. Adding all visitors to queue:");
        for (Visitor visitor : visitors) {
            carousel.addVisitorToQueue(visitor);
        }
        
        // 打印队列
        System.out.println("\n3. Queue before running cycle:");
        carousel.printQueue();
        
        // 运行一个周期（应处理3个游客）
        System.out.println("\n4. Running one cycle (max 3 visitors):");
        carousel.runOneCycle();
        
        // 打印运行后的队列
        System.out.println("\n5. Queue after running cycle:");
        carousel.printQueue();
        
        // 打印历史记录
        System.out.println("\n6. Ride history after cycle:");
        carousel.printRideHistory();
        
        // 演示错误情况：没有操作员
        System.out.println("\n7. Testing error case - no operator:");
        Ride brokenRide = new Ride("Broken Ride", "Test", 100, null, 2);
        brokenRide.addVisitorToQueue(visitors.get(0));
        brokenRide.runOneCycle();
        
        // 演示错误情况：空队列
        System.out.println("\n8. Testing error case - empty queue:");
        Ride emptyRide = new Ride("Empty Ride", "Test", 100, operator, 2);
        emptyRide.runOneCycle();
    }
    
    // Part 6 演示 - 写入文件
    public void partSix() {
        System.out.println("PART 6 - WRITING TO FILE DEMONSTRATION");
        
        // 创建员工和设施
        Employee operator = new Employee("Tom Export", 32, "Male", 
                                        "E1005", "IT", "Data Manager");
        Ride exportRide = new Ride("Data Coaster", "Data Ride", 110, operator, 5);
        
        // 创建5个游客
        System.out.println("\n1. Creating 5 visitors:");
        Visitor v1 = new Visitor("Export1", 25, "Male", "V5001", "Standard", false);
        Visitor v2 = new Visitor("Export2", 30, "Female", "V5002", "Premium", true);
        Visitor v3 = new Visitor("Export3", 22, "Male", "V5003", "Student", false);
        Visitor v4 = new Visitor("Export4", 35, "Female", "V5004", "Premium", true);
        Visitor v5 = new Visitor("Export5", 28, "Male", "V5005", "Standard", false);
        
        // 添加游客到历史记录
        System.out.println("\n2. Adding visitors to ride history:");
        exportRide.addVisitorToHistory(v1);
        exportRide.addVisitorToHistory(v2);
        exportRide.addVisitorToHistory(v3);
        exportRide.addVisitorToHistory(v4);
        exportRide.addVisitorToHistory(v5);
        
        // 导出到文件
        System.out.println("\n3. Exporting ride history to file:");
        String filename = "ride_history_export.csv";
        exportRide.exportRideHistory(filename);
        
        System.out.println("\n4. File export completed. Check for " + filename + " in project directory.");
    }
    
    // Part 7 演示 - 读取文件
    public void partSeven() {
        System.out.println("PART 7 - READING FROM FILE DEMONSTRATION");
        
        // 创建员工和新的设施（用于导入）
        Employee operator = new Employee("Emma Import", 29, "Female", 
                                        "E1006", "IT", "Data Specialist");
        Ride importRide = new Ride("Import Wheel", "Import Ride", 105, operator, 4);
        
        // 从文件导入历史记录
        System.out.println("\n1. Importing ride history from file:");
        String filename = "ride_history_export.csv";
        importRide.importRideHistory(filename);
        
        // 验证导入结果
        System.out.println("\n2. Verifying import results:");
        System.out.println("Number of visitors imported: " + importRide.numberOfVisitors());
        
        System.out.println("\n3. Imported ride history:");
        importRide.printRideHistory();
        
        // 演示错误情况：文件不存在
        System.out.println("\n4. Testing error case - file not found:");
        importRide.importRideHistory("nonexistent_file.csv");
    }
}
