package com.test.totaldemp.modle;

import java.util.List;

/**
 * Created by Administrator on 2018/7/3.
 */
public class College {

    // 大学名
    public String name;

    // 班级列表
    public List<Classes> classList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Classes> getClassList() {
        return classList;
    }

    public void setClassList(List<Classes> classList) {
        this.classList = classList;
    }
}