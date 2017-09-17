package com.sailfish.learnspring.hook;

/**
 * @author sailfish
 * @create 2017-09-09-下午4:07
 */
public class Teacher {

    private String name;
    private String age;
    private boolean smoking;  //是否抽烟

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public boolean isSmoking() {
        return smoking;
    }

    public void setSmoking(boolean smoking) {
        this.smoking = smoking;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", smoking=" + smoking +
                '}';
    }
}
