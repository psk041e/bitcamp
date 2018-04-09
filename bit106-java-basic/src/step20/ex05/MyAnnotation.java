// 애노테이션 프로퍼티
package step20.ex05;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
	String v1() default "가나다";
	int v2() default 100;
	float v3() default 3.14f;
	

}
