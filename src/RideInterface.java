/**
 * RideInterface - 游乐设施接口
 * 定义游乐设施必须实现的所有方法
 */
public interface RideInterface {
    // 队列相关方法
    void addVisitorToQueue(Visitor visitor);
    void removeVisitorFromQueue();
    void printQueue();
    
    // 历史记录相关方法
    void addVisitorToHistory(Visitor visitor);
    boolean checkVisitorFromHistory(Visitor visitor);
    int numberOfVisitors();
    void printRideHistory();
    
    // 运行相关方法
    void runOneCycle();
}
