package com.muzi.easychat.transaction.service;

import java.util.Objects;

/**
 * Description:
 * Author: <a href="https://github.com/MuziGeek">muzi</a>
 * Date: 2023-10-02
 */
public class SecureInvokeHolder {
    private static final ThreadLocal<Boolean> INVOKE_THREAD_LOCAL = new ThreadLocal<>();

    public static boolean isInvoking() {
        return Objects.nonNull(INVOKE_THREAD_LOCAL.get());
    }

    public static void setInvoking() {
        INVOKE_THREAD_LOCAL.set(Boolean.TRUE);
    }

    public static void invoked() {
        INVOKE_THREAD_LOCAL.remove();
    }
}
