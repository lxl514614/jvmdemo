package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * RuntimeConstantPoolOOM
 *
 * @author Lee
 * @date 2018/1/6
 * description:
 * VM Args: -XX:permSize=10M -XX:MaxPermSize=10M
 * 注意: 以上配置jdk1.8中可能无效
 * 永久带在1.7版本之前可配置7
 * Java HotSpot(TM) 64-Bit Server VM warning: ignoring option PermSize=10M; support was removed in 8.0
   Java HotSpot(TM) 64-Bit Server VM warning: ignoring option MaxPermSize=10M; support was removed in 8.0
 * Created by Lee on 2018/1/6.
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {

        // 使用list保持常量池引用,避免 full gc 回收
        List<String> list = new ArrayList<>();
        // 10Mb的persize在interge范围内足够产生oom
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}
