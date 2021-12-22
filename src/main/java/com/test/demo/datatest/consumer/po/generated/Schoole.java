package com.test.demo.datatest.consumer.po.generated;

import java.io.Serializable;

public class Schoole implements Serializable {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column schoole.schoole_name
     *
     * @mbg.generated
     */
    private String schooleName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column schoole.schoole_address
     *
     * @mbg.generated
     */
    private String schooleAddress;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column schoole.schoole_type
     *
     * @mbg.generated
     */
    private String schooleType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column schoole.schoole_amount
     *
     * @mbg.generated
     */
    private String schooleAmount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column schoole.schoole_admin
     *
     * @mbg.generated
     */
    private String schooleAdmin;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table schoole
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column schoole.schoole_name
     *
     * @return the value of schoole.schoole_name
     *
     * @mbg.generated
     */
    public String getSchooleName() {
        return schooleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column schoole.schoole_name
     *
     * @param schooleName the value for schoole.schoole_name
     *
     * @mbg.generated
     */
    public void setSchooleName(String schooleName) {
        this.schooleName = schooleName == null ? null : schooleName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column schoole.schoole_address
     *
     * @return the value of schoole.schoole_address
     *
     * @mbg.generated
     */
    public String getSchooleAddress() {
        return schooleAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column schoole.schoole_address
     *
     * @param schooleAddress the value for schoole.schoole_address
     *
     * @mbg.generated
     */
    public void setSchooleAddress(String schooleAddress) {
        this.schooleAddress = schooleAddress == null ? null : schooleAddress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column schoole.schoole_type
     *
     * @return the value of schoole.schoole_type
     *
     * @mbg.generated
     */
    public String getSchooleType() {
        return schooleType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column schoole.schoole_type
     *
     * @param schooleType the value for schoole.schoole_type
     *
     * @mbg.generated
     */
    public void setSchooleType(String schooleType) {
        this.schooleType = schooleType == null ? null : schooleType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column schoole.schoole_amount
     *
     * @return the value of schoole.schoole_amount
     *
     * @mbg.generated
     */
    public String getSchooleAmount() {
        return schooleAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column schoole.schoole_amount
     *
     * @param schooleAmount the value for schoole.schoole_amount
     *
     * @mbg.generated
     */
    public void setSchooleAmount(String schooleAmount) {
        this.schooleAmount = schooleAmount == null ? null : schooleAmount.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column schoole.schoole_admin
     *
     * @return the value of schoole.schoole_admin
     *
     * @mbg.generated
     */
    public String getSchooleAdmin() {
        return schooleAdmin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column schoole.schoole_admin
     *
     * @param schooleAdmin the value for schoole.schoole_admin
     *
     * @mbg.generated
     */
    public void setSchooleAdmin(String schooleAdmin) {
        this.schooleAdmin = schooleAdmin == null ? null : schooleAdmin.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table schoole
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", schooleName=").append(schooleName);
        sb.append(", schooleAddress=").append(schooleAddress);
        sb.append(", schooleType=").append(schooleType);
        sb.append(", schooleAmount=").append(schooleAmount);
        sb.append(", schooleAdmin=").append(schooleAdmin);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table schoole
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
        Schoole other = (Schoole) that;
        return (this.getSchooleName() == null ? other.getSchooleName() == null : this.getSchooleName().equals(other.getSchooleName()))
            && (this.getSchooleAddress() == null ? other.getSchooleAddress() == null : this.getSchooleAddress().equals(other.getSchooleAddress()))
            && (this.getSchooleType() == null ? other.getSchooleType() == null : this.getSchooleType().equals(other.getSchooleType()))
            && (this.getSchooleAmount() == null ? other.getSchooleAmount() == null : this.getSchooleAmount().equals(other.getSchooleAmount()))
            && (this.getSchooleAdmin() == null ? other.getSchooleAdmin() == null : this.getSchooleAdmin().equals(other.getSchooleAdmin()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table schoole
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSchooleName() == null) ? 0 : getSchooleName().hashCode());
        result = prime * result + ((getSchooleAddress() == null) ? 0 : getSchooleAddress().hashCode());
        result = prime * result + ((getSchooleType() == null) ? 0 : getSchooleType().hashCode());
        result = prime * result + ((getSchooleAmount() == null) ? 0 : getSchooleAmount().hashCode());
        result = prime * result + ((getSchooleAdmin() == null) ? 0 : getSchooleAdmin().hashCode());
        return result;
    }
}