package com.test.demo.datatest.consumer.po.generated;

import java.io.Serializable;

public class StudentToSchool implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student_to_school.student_id
     *
     * @mbg.generated
     */
    private String studentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student_to_school.schoole_id
     *
     * @mbg.generated
     */
    private String schooleId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table student_to_school
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student_to_school.student_id
     *
     * @return the value of student_to_school.student_id
     *
     * @mbg.generated
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student_to_school.student_id
     *
     * @param studentId the value for student_to_school.student_id
     *
     * @mbg.generated
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId == null ? null : studentId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student_to_school.schoole_id
     *
     * @return the value of student_to_school.schoole_id
     *
     * @mbg.generated
     */
    public String getSchooleId() {
        return schooleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student_to_school.schoole_id
     *
     * @param schooleId the value for student_to_school.schoole_id
     *
     * @mbg.generated
     */
    public void setSchooleId(String schooleId) {
        this.schooleId = schooleId == null ? null : schooleId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student_to_school
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", studentId=").append(studentId);
        sb.append(", schooleId=").append(schooleId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student_to_school
     *
     * @mbg.generated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        StudentToSchool other = (StudentToSchool) that;
        return (this.getStudentId() == null ? other.getStudentId() == null : this.getStudentId().equals(other.getStudentId()))
            && (this.getSchooleId() == null ? other.getSchooleId() == null : this.getSchooleId().equals(other.getSchooleId()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student_to_school
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getStudentId() == null) ? 0 : getStudentId().hashCode());
        result = prime * result + ((getSchooleId() == null) ? 0 : getSchooleId().hashCode());
        return result;
    }
}