package com.example1.springDemo1.MyFeature;

import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

import com.example1.springDemo1.selector.MyDeferredImportSelector;
import com.example1.springDemo1.selector.MyDeferredImportSelector.MyDeferredImportGroup;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;



@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(MyDeferredImportSelector.class)
public @interface EnableMyFeature {

}
