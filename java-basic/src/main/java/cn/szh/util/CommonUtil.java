package cn.szh.util;

/**
 * @author Zhenhao.Shi
 * @date 2023/4/11 17:08
 */
public class CommonUtil {

    public static boolean equals(Object obj, Object... objs) {
        if (null == objs || obj == null || objs.length == 0) {
            return false;
        }

        for (Object tmp : objs) {
            if (obj.equals(tmp)) {
                return true;
            }
        }

        return false;
    }

}
