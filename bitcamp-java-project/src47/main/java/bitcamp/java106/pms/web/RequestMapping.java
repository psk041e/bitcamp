package bitcamp.java106.pms.web;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface RequestMapping {
    String value() default "";  //값을 안준다면 빈문자열
}
