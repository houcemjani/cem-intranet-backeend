package com.ads.Investigationintranet.persistence.implementation.mongo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MongoFileDescription {
    String inputStream();
    String filename() default "";
    String contentType() default "";
    String uploadDate() default "";
}