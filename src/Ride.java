import java.util.*;
import java.io.*;

/**
 * Ride类 - 实现RideInterface接口
 * 表示主题公园中的游乐设施
 */
public class Ride implements RideInterface {
    // 基本实例变量
    private String rideName;
    private String rideType;
    private int minHeight;
    private Employee operator;  // 负责的员工
    private int maxRider;       // 每周期最大游客数
    private int numOfCycles;    // 已运行周期数
    
    // 集合：等待队列和乘坐历史
    private Queue<Visitor> waitingQueue;
    private LinkedList<Visitor> rideHistory;
    
    // 默认构造函数
    public Ride() {
        this.rideName = "Unknown Ride";
        this.rideType = "General";
        this.minHeight = 120;
        this.operator = null;
        this.maxRider = 4;
        this.numOfCycles = 0;
        this.waitingQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }
    
    // 带参数的构造函数
    public Ride(String rideName, String rideType, int minHeight, 
               Employee operator, int maxRider) {
        this.rideName = rideName;
        this.rideType = rideType;
        this.minHeight = minHeight;
        this.operator = operator;
        this.maxRider = maxRider;
        this.numOfCycles = 0;
        this.waitingQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }
    
    // Getter 和 Setter 方法
    public String getRideName() {
        return rideName;
    }
    
    public void setRideName(String rideName) {
        this.rideName = rideName;
    }
    
    public String getRideType() {
        return rideType;
    }
    
    public void setRideType(String rideType) {
        this.rideType = rideType;
    }
    
    public int getMinHeight() {
        return minHeight;
    }
    
    public void setMinHeight(int minHeight) {
        this.minHeight = minHeight;
    }
    
    public Employee getOperator() {
        return operator;
    }
    
    public void setOperator(Employee operator) {
        this.operator = operator;
    }
    
    public int getMaxRider() {
        return maxRider;
    }
    
    public void setMaxRider(int maxRider) {
        this.maxRider = maxRider;
    }
    
    public int getNumOfCycles() {
        return numOfCycles;
    }
    
    // 队列相关方法实现
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor == null) {
            System.out.println("Error: Visitor cannot be null");
            return;
        }
        
        waitingQueue.add(visitor);
        System.out.println("Visitor " + visitor.getName() + " added to the queue for " + rideName);
    }
    
    @Override
    public void removeVisitorFromQueue() {
        if (waitingQueue.isEmpty()) {
            System.out.println("Error: Queue is empty, cannot remove visitor");
            return;
        }
        
        Visitor removed = waitingQueue.poll();
        System.out.println("Visitor " + removed.getName() + " removed from the queue");
    }
    
    @Override
    public void printQueue() {
        if (waitingQueue.isEmpty()) {
            System.out.println("The waiting queue for " + rideName + " is empty");
            return;
        }
        
        System.out.println("=== Waiting Queue for " + rideName + " ===");
        int position = 1;
        for (Visitor visitor : waitingQueue) {
            System.out.println(position + ". " + visitor.getName() + " (ID: " + visitor.getVisitorId() + ")");
            position++;
        }
        System.out.println("Total visitors in queue: " + waitingQueue.size());
    }
    
    // 历史记录相关方法实现
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        if (visitor == null) {
            System.out.println("Error: Visitor cannot be null");
            return;
        }
        
        rideHistory.add(visitor);
        System.out.println("Visitor " + visitor.getName() + " added to ride history");
    }
    
    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        if (visitor == null) {
            System.out.println("Error: Visitor cannot be null");
            return false;
        }
        
        boolean found = rideHistory.contains(visitor);
        System.out.println("Visitor " + visitor.getName() + " found in history: " + found);
        return found;
    }
    
    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }
    
    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("No visitors have taken " + rideName + " yet");
            return;
        }
        
        System.out.println("=== Ride History for " + rideName + " ===");
        System.out.println("Total visitors: " + rideHistory.size());
        System.out.println("Total cycles run: " + numOfCycles);
        
        // 使用Iterator遍历（作业要求）
        Iterator<Visitor> iterator = rideHistory.iterator();
        int count = 1;
        while (iterator.hasNext()) {
            Visitor visitor = iterator.next();
            System.out.println(count + ". " + visitor.getName() + " (ID: " + visitor.getVisitorId() + ")");
            count++;
        }
    }
    
    // 运行相关方法实现
    @Override
    public void runOneCycle() {
        // 检查是否有操作员
        if (operator == null) {
            System.out.println("Error: No operator assigned to " + rideName);
            return;
        }
        
        // 检查等待队列是否为空
        if (waitingQueue.isEmpty()) {
            System.out.println("Error: No visitors in queue for " + rideName);
            return;
        }
        
        System.out.println("=== Running " + rideName + " for one cycle ===");
        System.out.println("Operator: " + operator.getName());
        
        int ridersThisCycle = 0;
        
        // 从队列中移除游客并添加到历史记录
        while (ridersThisCycle < maxRider && !waitingQueue.isEmpty()) {
            Visitor visitor = waitingQueue.poll();
            rideHistory.add(visitor);
            System.out.println("Visitor " + visitor.getName() + " took the ride");
            ridersThisCycle++;
        }
        
        numOfCycles++;
        System.out.println("Cycle completed. Riders this cycle: " + ridersThisCycle);
        System.out.println("Visitors left in queue: " + waitingQueue.size());
    }
    
    // 排序方法（Part 4B）
    public void sortRideHistory(Comparator<Visitor> comparator) {
        if (rideHistory.size() <= 1) {
            System.out.println("Not enough visitors to sort");
            return;
        }
        
        Collections.sort(rideHistory, comparator);
        System.out.println("Ride history sorted successfully");
    }
    
    // 导出到文件（Part 6）
    public void exportRideHistory(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            // 写入标题行
            writer.println("Visitor Name,Visitor ID,Age,Gender,Ticket Type,Membership");
            
            // 写入每个游客的信息
            for (Visitor visitor : rideHistory) {
                writer.println(visitor.getName() + "," + 
                              visitor.getVisitorId() + "," + 
                              visitor.getAge() + "," + 
                              visitor.getGender() + "," + 
                              visitor.getTicketType() + "," + 
                              visitor.hasMembership());
            }
            
            System.out.println("Ride history exported to " + filename + " successfully");
            System.out.println("Total visitors exported: " + rideHistory.size());
            
        } catch (IOException e) {
            System.out.println("Error exporting ride history: " + e.getMessage());
        }
    }
    
    // 从文件导入（Part 7）
    public void importRideHistory(String filename) {
        int importedCount = 0;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean isFirstLine = true;
            
            while ((line = reader.readLine()) != null) {
                // 跳过标题行
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                
                // 使用逗号分割
                String[] parts = line.split(",");
                if (parts.length >= 6) {
                    String name = parts[0];
                    String visitorId = parts[1];
                    int age = Integer.parseInt(parts[2]);
                    String gender = parts[3];
                    String ticketType = parts[4];
                    boolean hasMembership = Boolean.parseBoolean(parts[5]);
                    
                    // 创建Visitor对象并添加到历史记录
                    Visitor visitor = new Visitor(name, age, gender, visitorId, ticketType, hasMembership);
                    rideHistory.add(visitor);
                    importedCount++;
                }
            }
            
            System.out.println("Ride history imported from " + filename + " successfully");
            System.out.println("Total visitors imported: " + importedCount);
            
        } catch (FileNotFoundException e) {
            System.out.println("Error: File " + filename + " not found");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error parsing data: " + e.getMessage());
        }
    }
    
    // 其他辅助方法
    public void displayRideInfo() {
        System.out.println("=== Ride Information ===");
        System.out.println("Name: " + rideName);
        System.out.println("Type: " + rideType);
        System.out.println("Minimum Height: " + minHeight + "cm");
        System.out.println("Max Riders per Cycle: " + maxRider);
        System.out.println("Cycles Run: " + numOfCycles);
        if (operator != null) {
            System.out.println("Operator: " + operator.getName());
        } else {
            System.out.println("Operator: Not assigned");
        }
        System.out.println("Visitors in Queue: " + waitingQueue.size());
        System.out.println("Visitors in History: " + rideHistory.size());
    }
}
