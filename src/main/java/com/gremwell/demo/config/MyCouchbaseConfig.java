package com.gremwell.demo.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

@Configuration
@EnableCouchbaseRepositories(basePackages = { "com.gremwell.demo" })
public class MyCouchbaseConfig extends AbstractCouchbaseConfiguration {

    public static final List<String> NODE_LIST = Arrays.asList("localhost");
    public static final String BUCKET_NAME = "demo1";

    @Override
    public String getConnectionString() {
        return ("127.0.0.1");
    }

    @Override
    public String getUserName() {
        return "Administrator";
    }

    @Override
    public String getPassword() {
        return "password";
    }

    @Override
    public String getBucketName() {
        return BUCKET_NAME;
    }
}
