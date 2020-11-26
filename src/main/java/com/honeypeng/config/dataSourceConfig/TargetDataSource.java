package com.honeypeng.config.dataSourceConfig;

import java.lang.annotation.*;

/**
 * Created by PengWX on 2020/11/25.
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {

    String name() default TargetDataSource.MASTER;

    public static String MASTER = "ds1";
    public static String SLAVE = "ds2";
}
