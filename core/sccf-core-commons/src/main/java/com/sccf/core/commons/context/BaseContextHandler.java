package com.sccf.core.commons.context;

import com.sccf.core.commons.vo.LoginInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qianguobing
 * @date 2018-09-15 14:48
 */
public class BaseContextHandler {
    public static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal();

    public static void set(String key, Object value) {
        Map map = (Map)threadLocal.get();
        if (map == null) {
            map = new HashMap();
            threadLocal.set(map);
        }
        map.put(key, value);
    }

    public static Object get(String key) {
        Map map = (Map)threadLocal.get();
        if (map == null) {
            map = new HashMap();
            threadLocal.set(map);
        }
        return map.get(key);
    }

    public static LoginInfo getLoginInfo() {
        Object obj = get("loginInfo");
        if (obj != null) {
            return (LoginInfo)obj;
        }
        return null;
    }

    public static void setLoginInfo(LoginInfo loginInfo) {
        set("loginInfo", loginInfo);
    }

    public static String getToken() {
        Object obj = get("loginToken");
        if (obj != null) {
            return obj.toString();
        }
        return null;
    }

    public static void setToken(String token) {
        set("loginToken", token);
    }

    public static void remove() {
        threadLocal.remove();
    }
}
