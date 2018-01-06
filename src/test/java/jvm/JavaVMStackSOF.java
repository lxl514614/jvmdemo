package jvm;

/**
 * JavaVMStackSOF
 *
 * @author Lee
 * @date 2018/1/6
 * description:
 * VM Args: -Xss128k
 * Created by Lee on 2018/1/6.
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength ++;
        stackLeak();
    }

    /**
     stack Length:6256629
     Exception in thread "main" java.lang.StackOverflowError
     at jvm.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:18)
     at jvm.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:18)
     at jvm.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:18)
     at jvm.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:18)
     ...
     * @param args
     */
    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();

        try {
            oom.stackLeak();

        }
        catch (Throwable e) {
            System.out.println("stack Length:" + oom.stackLength);
            throw e;
        }
    }
}
