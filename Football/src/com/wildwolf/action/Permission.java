/**
 * 
 */
package com.wildwolf.action;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Administrator
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Permission {
	String name();
}
