package com.cs527.web.entity;


public class Departments {

    private Long departmentId;
    private String department;

    @Override
    public String toString() {
        return "Departments{" +
                "departmentId=" + departmentId +
                ", department='" + department + '\'' +
                '}';
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }


    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

}
