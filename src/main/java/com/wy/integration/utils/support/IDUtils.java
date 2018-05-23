package com.wy.integration.utils.support;

import java.util.UUID;

public abstract class IDUtils {
    public IDUtils() {
    }

    public static String UUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}