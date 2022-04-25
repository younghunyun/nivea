package kr.bespinlab.nivea.handler;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestHandler {
	boolean loginCheck() default false;
}
