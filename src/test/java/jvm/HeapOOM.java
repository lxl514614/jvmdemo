package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * HeapOOM
 *
 * @author Lee
 * @date 2018/1/6
 * description:
 * vm args:
 * -Xms20m -Mmx20m -XX:HeapDumpOnOutOfMemoryError
 * Created by Lee on 2018/1/6.
 */
public class HeapOOM {

    static class OOMObj {

    }

    /**
     java.lang.OutOfMemoryError: Java heap space
     Dumping heap to java_pid7936.hprof ...
     Heap dump file created [27837932 bytes in 0.161 secs]
     Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
     at java.util.Arrays.copyOf(Arrays.java:3210)
     at java.util.Arrays.copyOf(Arrays.java:3181)
     at java.util.ArrayList.grow(ArrayList.java:261)
     at java.util.ArrayList.ensureExplicitCapacity(ArrayList.java:235)
     at java.util.ArrayList.ensureCapacityInternal(ArrayList.java:227)
     at java.util.ArrayList.add(ArrayList.java:458)
     at jvm.HeapOOM.main(HeapOOM.java:26)
     * @param args
     */
    public static void main(String[] args) {
        List<OOMObj> list= new ArrayList<>();

        int i = 0;
        while (true) {
            list.add(new OOMObj());
            System.out.println("==>"+ i++);
        }
    }
}
