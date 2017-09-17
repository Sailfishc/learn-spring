package com.sailfish.learnspring.factorybean;

/**
 * @author sailfish
 * @create 2017-09-09-下午9:29
 */
public class MySqlEntity extends DBEntity {

    private String column;

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }
}
