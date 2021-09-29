package com.gremwell.demo.persistence.model;

public class VulnData {

    private String param;
    private String value;

    public VulnData() {
    }

    public VulnData(String param, String value) {
        this.param = param;
        this.value = value;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
