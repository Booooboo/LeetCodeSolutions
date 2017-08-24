import javax.xml.validation.Validator;

/**
 * Created by sunhongbo on 17/8/1.
 */
public class Singleton {

    private static Singleton sInstance;

    private Singleton() {

    }

    /*
    * 懒汉模式
    * */
    public static synchronized Singleton getInstance() {
        if (sInstance == null) {
            sInstance = new Singleton();
        }
        return sInstance;
    }

    // 多线程同步效率问题
    public static Singleton getInstanceUpper() {
        if (sInstance == null) {
            synchronized (Singleton.class) {
                if (sInstance == null) { // 防止队列中还有一个线程在等待进入
                    sInstance = new Singleton();
                }
            }
        }
        return sInstance;
    }

    // sInstance = new Singleton(); 会分三步执行
    // 一 为sInstance分配空间 二 调用 Singleton 的构造函数来初始化成员变量 三 instance对象指向分配的内存空间
    // 如果1-3-2执行 sInstance没有被初始化 使用的时候会报错
    private static volatile Singleton sInstancev;
    public static Singleton getInstanceV() {
        if (sInstancev == null) {
            synchronized (Singleton.class) {
                if (sInstancev == null) {
                    sInstancev = new Singleton();
                }
            }
        }
        return sInstancev;
    }

    //饿汉模式
    private static final Singleton sSingleton = new Singleton();

    public static Singleton getSingleton() {
        return sSingleton;
    }

    //静态内部类的方式
    private static final class SingletonHolder {
        private static  Singleton sSingleton = new Singleton();
    }

    public static final Singleton getInstanceInnerClass() {
        return SingletonHolder.sSingleton;
    }






}
