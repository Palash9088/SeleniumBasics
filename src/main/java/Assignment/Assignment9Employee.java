package Assignment;//import java.util.*;

import java.util.Objects;

public class Assignment9Employee {
    private int empId;
    private String empName;
    private int empManagerId;
    private String empDept;

    @Override
    public boolean equals(Object o) {
            Assignment9Employee e = (Assignment9Employee) o;
        return this.empId == e.empId && this.empName.equals(e.empName);
/*        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return getEmpId() == employee.getEmpId() && getEmpManagerId() == employee.getEmpManagerId() && getEmpName().equals(employee.getEmpName()) && getEmpDept().equals(employee.getEmpDept());*/
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmpId(), getEmpName(), getEmpManagerId(), getEmpDept());
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getEmpManagerId() {
        return empManagerId;
    }

    public void setEmpManagerId(int empManagerId) {
        this.empManagerId = empManagerId;
    }

    public String getEmpDept() {
        return empDept;
    }

    public void setEmpDept(String empDept) {
        this.empDept = empDept;
    }


}
