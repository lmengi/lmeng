package com.lmeng.annotations;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2015/10/16.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
public @interface Entity {
}
