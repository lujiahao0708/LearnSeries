package club.hd.string;

/**
 * @author lujiahao
 * @date 2019/11/5
 */
public class StringDemo {
    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        System.out.println("基本数据类型 a == b : " + (a == b));

        User u1 = new User("zhangsan");
        User u2 = new User("zhangsan");
        System.out.println("引用类型变量 u1 == u2 : " + (u1 == u2));

        Object o1 = new Object();
        Object o2 = new Object();
        System.out.println("引用类型变量 新建两个object对象 o1.equals(o2) : " + (o1.equals(o2)));

        Object o3 = new Object();
        Object o4 = o3;
        System.out.println("引用类型变量 新建一个object对象 o3.equals(o4) : " + (o3.equals(o4)));

        String s1 = new String("zhangsan");
        String s2 = new String("zhangsan");
        System.out.println("引用类型变量 新建两个String对象 s1.equals(s2) : " + (s1.equals(s2)));

        String s3 = "zhangsan";
        String s4 = "zhangsan";
        System.out.println("引用类型变量 新建一个String对象 s3.equals(s4) : " + (s3.equals(s4)));

        System.out.println("引用类型变量 未重写equals方法 u1.equals(u2) : " + (u1.equals(u2)));
    }
}

class User {
    String name;

    public User(String name) {
        this.name = name;
    }
}
