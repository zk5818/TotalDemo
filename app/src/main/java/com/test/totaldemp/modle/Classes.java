package com.test.totaldemp.modle;

import java.util.List;

/**
 * Created by Administrator on 2018/7/3.
 */

public class Classes {
    // 班级名
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 班级中的学生列表
    public List<String> students;
}
