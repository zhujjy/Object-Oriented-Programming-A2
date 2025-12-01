import java.util.Comparator;

/**
 * VisitorComparator类 - 实现Comparator接口
 * 用于对Visitor对象进行排序
 */
public class VisitorComparator implements Comparator<Visitor> {
    
    // 实现compare方法，使用多个实例变量进行比较
    @Override
    public int compare(Visitor v1, Visitor v2) {
        // 首先按年龄排序（升序）
        int ageCompare = Integer.compare(v1.getAge(), v2.getAge());
        if (ageCompare != 0) {
            return ageCompare;
        }
        
        // 如果年龄相同，按姓名排序（字母顺序）
        int nameCompare = v1.getName().compareTo(v2.getName());
        if (nameCompare != 0) {
            return nameCompare;
        }
        
        // 如果姓名也相同，按游客ID排序
        return v1.getVisitorId().compareTo(v2.getVisitorId());
    }
}
