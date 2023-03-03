package com.cks.exercise;

import java.util.List;

/**
 * @Author: cks
 * @Date: Created by 上午11:17 2021/4/13
 * @Package: com.cks.exercise
 * @Description:
 */
public class UserEntity {
    private List<String> name;

    private Integer age;

    public List<String> getName() {
        return name;
    }

    public void setName(List<String> name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
