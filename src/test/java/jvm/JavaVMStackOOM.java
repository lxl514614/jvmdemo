package jvm;

/**
 * JavaVMStackOOM
 *
 * @author Lee
 * @date 2018/1/6
 * description:
 * VM Args : -Xss2M
 * Created by Lee on 2018/1/6.
 */
public class JavaVMStackOOM {

    public void dontStop() {
        while (true) {

        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });

            thread.start();
        }
    }

    /**
     * 该程序因机器配置不同,执行时间不同
     * @param args
     */
    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}
