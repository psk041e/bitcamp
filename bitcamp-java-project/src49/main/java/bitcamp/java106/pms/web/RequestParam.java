package bitcamp.java106.pms.web;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface RequestParam {
    // 파라미터 이름을 지정하는 애노테이션
    String value() default "";

}
