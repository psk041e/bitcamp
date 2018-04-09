// 애노테이션 프로퍼티 - value 프로퍼티
package step20.ex04;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
	String value();

}
