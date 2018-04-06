package step19.ex09;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@ Retention(RetentionPolicy.RUNTIME) // 실행하는 도중에도 주석이 남아있어 실행중 주석을 뽑아 쓸 수 있다.
public @interface Component {
    String value() default "";
}
