package com.aking.token.context;

import com.aking.token.dto.AuthSessionDTO;
import org.springframework.core.NamedThreadLocal;

/**
 * @ClassName SessionContext
 * @Description ThreadLocal
 * ThreadLocal 提供了线程本地变量，它可以保证访问到的变量属于当前线程，
 * 每个线程都保存有一个变量副本，每个线程的变量都不同。
 * ThreadLocal 相当于提供了一种线程隔离，将变量与线程相绑定。
 * @Author yangkang
 * @Date 2020/4/4 22:19
 * @Version 1.0
 **/
public class SessionContext {
    private static final ThreadLocal<AuthSessionDTO> CURRENT_SESSION = new NamedThreadLocal<>("session");

    public static AuthSessionDTO getSession() {
        return CURRENT_SESSION.get();
    }

    public static void setCurrentSession(AuthSessionDTO session) {
        removeSession();
        CURRENT_SESSION.set(session);
    }

    public static void removeSession() {
        CURRENT_SESSION.remove();
    }

    public static String getToken() {
        AuthSessionDTO session = getSession();
        return null != session ? session.getToken() : "";
    }

    public static Long getUserId() {
        AuthSessionDTO session = getSession();
        return null != session ? session.getUserId() : null;
    }

    public static String getMobile() {
        AuthSessionDTO session = getSession();
        return null != session ? session.getMobile() : "";
    }

    public static String getName() {
        AuthSessionDTO session = getSession();
        return null != session ? session.getName() : "";
    }
}
