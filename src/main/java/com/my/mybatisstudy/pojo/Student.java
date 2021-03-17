package com.my.mybatisstudy.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.my.mybatisstudy.annotation.JsonTypeHandle;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Student implements Serializable {
    private Integer id;

    private String name;

    private String fPhone;

    private String mPhone;

    private String phone;

    private String idCard;

    private Integer classroomTeacherId;

    private Integer schoolId;

    private Integer classId;

    private Integer orgId;

    private Integer gradeId;

    private Integer lessonTime;

    private Integer gLessonTime;

    private BigDecimal lessonMoney;

    private String projectNo;

    private Integer lessonSurplus;

    private Integer lessonLock;

    private BigDecimal mathScore;

    private BigDecimal physicsScore;

    private BigDecimal chemistryScore;

    private BigDecimal biologyScore;

    private BigDecimal geographyScore;

    private BigDecimal chineseScore;

    private BigDecimal englishScore;

    private BigDecimal historyScore;

    private BigDecimal politicsScore;

    @JsonTypeHandle
    private StudentInfo studentInfo;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    private Integer createUserId;

    private String createUser;

    private Short status;

    private Integer modifyUserId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date modifyTime;

    private String modifyUser;

    private String remake;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table student
     *
     * @mbg.generated Tue Mar 26 23:24:00 CST 2019
     */
    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getfPhone() {
        return fPhone;
    }

    public void setfPhone(String fPhone) {
        this.fPhone = fPhone == null ? null : fPhone.trim();
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone == null ? null : mPhone.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public Integer getClassroomTeacherId() {
        return classroomTeacherId;
    }

    public void setClassroomTeacherId(Integer classroomTeacherId) {
        this.classroomTeacherId = classroomTeacherId;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public Integer getLessonTime() {
        return lessonTime;
    }

    public void setLessonTime(Integer lessonTime) {
        this.lessonTime = lessonTime;
    }

    public Integer getgLessonTime() {
        return gLessonTime;
    }

    public void setgLessonTime(Integer gLessonTime) {
        this.gLessonTime = gLessonTime;
    }

    public BigDecimal getLessonMoney() {
        return lessonMoney;
    }

    public void setLessonMoney(BigDecimal lessonMoney) {
        this.lessonMoney = lessonMoney;
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo == null ? null : projectNo.trim();
    }

    public Integer getLessonSurplus() {
        return lessonSurplus;
    }

    public void setLessonSurplus(Integer lessonSurplus) {
        this.lessonSurplus = lessonSurplus;
    }

    public Integer getLessonLock() {
        return lessonLock;
    }

    public void setLessonLock(Integer lessonLock) {
        this.lessonLock = lessonLock;
    }

    public BigDecimal getMathScore() {
        return mathScore;
    }

    public void setMathScore(BigDecimal mathScore) {
        this.mathScore = mathScore;
    }

    public BigDecimal getPhysicsScore() {
        return physicsScore;
    }

    public void setPhysicsScore(BigDecimal physicsScore) {
        this.physicsScore = physicsScore;
    }

    public BigDecimal getChemistryScore() {
        return chemistryScore;
    }

    public void setChemistryScore(BigDecimal chemistryScore) {
        this.chemistryScore = chemistryScore;
    }

    public BigDecimal getBiologyScore() {
        return biologyScore;
    }

    public void setBiologyScore(BigDecimal biologyScore) {
        this.biologyScore = biologyScore;
    }

    public BigDecimal getGeographyScore() {
        return geographyScore;
    }

    public void setGeographyScore(BigDecimal geographyScore) {
        this.geographyScore = geographyScore;
    }

    public BigDecimal getChineseScore() {
        return chineseScore;
    }

    public void setChineseScore(BigDecimal chineseScore) {
        this.chineseScore = chineseScore;
    }

    public BigDecimal getEnglishScore() {
        return englishScore;
    }

    public void setEnglishScore(BigDecimal englishScore) {
        this.englishScore = englishScore;
    }

    public BigDecimal getHistoryScore() {
        return historyScore;
    }

    public void setHistoryScore(BigDecimal historyScore) {
        this.historyScore = historyScore;
    }

    public BigDecimal getPoliticsScore() {
        return politicsScore;
    }

    public void setPoliticsScore(BigDecimal politicsScore) {
        this.politicsScore = politicsScore;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Integer getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(Integer modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser == null ? null : modifyUser.trim();
    }

    public String getRemake() {
        return remake;
    }

    public void setRemake(String remake) {
        this.remake = remake == null ? null : remake.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbg.generated Tue Mar 26 23:24:00 CST 2019
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        Student other = (Student) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getfPhone() == null ? other.getfPhone() == null : this.getfPhone().equals(other.getfPhone()))
            && (this.getmPhone() == null ? other.getmPhone() == null : this.getmPhone().equals(other.getmPhone()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getIdCard() == null ? other.getIdCard() == null : this.getIdCard().equals(other.getIdCard()))
            && (this.getClassroomTeacherId() == null ? other.getClassroomTeacherId() == null : this.getClassroomTeacherId().equals(other.getClassroomTeacherId()))
            && (this.getSchoolId() == null ? other.getSchoolId() == null : this.getSchoolId().equals(other.getSchoolId()))
            && (this.getClassId() == null ? other.getClassId() == null : this.getClassId().equals(other.getClassId()))
            && (this.getOrgId() == null ? other.getOrgId() == null : this.getOrgId().equals(other.getOrgId()))
            && (this.getGradeId() == null ? other.getGradeId() == null : this.getGradeId().equals(other.getGradeId()))
            && (this.getLessonTime() == null ? other.getLessonTime() == null : this.getLessonTime().equals(other.getLessonTime()))
            && (this.getgLessonTime() == null ? other.getgLessonTime() == null : this.getgLessonTime().equals(other.getgLessonTime()))
            && (this.getLessonMoney() == null ? other.getLessonMoney() == null : this.getLessonMoney().equals(other.getLessonMoney()))
            && (this.getProjectNo() == null ? other.getProjectNo() == null : this.getProjectNo().equals(other.getProjectNo()))
            && (this.getLessonSurplus() == null ? other.getLessonSurplus() == null : this.getLessonSurplus().equals(other.getLessonSurplus()))
            && (this.getLessonLock() == null ? other.getLessonLock() == null : this.getLessonLock().equals(other.getLessonLock()))
            && (this.getMathScore() == null ? other.getMathScore() == null : this.getMathScore().equals(other.getMathScore()))
            && (this.getPhysicsScore() == null ? other.getPhysicsScore() == null : this.getPhysicsScore().equals(other.getPhysicsScore()))
            && (this.getChemistryScore() == null ? other.getChemistryScore() == null : this.getChemistryScore().equals(other.getChemistryScore()))
            && (this.getBiologyScore() == null ? other.getBiologyScore() == null : this.getBiologyScore().equals(other.getBiologyScore()))
            && (this.getGeographyScore() == null ? other.getGeographyScore() == null : this.getGeographyScore().equals(other.getGeographyScore()))
            && (this.getChineseScore() == null ? other.getChineseScore() == null : this.getChineseScore().equals(other.getChineseScore()))
            && (this.getEnglishScore() == null ? other.getEnglishScore() == null : this.getEnglishScore().equals(other.getEnglishScore()))
            && (this.getHistoryScore() == null ? other.getHistoryScore() == null : this.getHistoryScore().equals(other.getHistoryScore()))
            && (this.getPoliticsScore() == null ? other.getPoliticsScore() == null : this.getPoliticsScore().equals(other.getPoliticsScore()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateUserId() == null ? other.getCreateUserId() == null : this.getCreateUserId().equals(other.getCreateUserId()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getModifyUserId() == null ? other.getModifyUserId() == null : this.getModifyUserId().equals(other.getModifyUserId()))
            && (this.getModifyTime() == null ? other.getModifyTime() == null : this.getModifyTime().equals(other.getModifyTime()))
            && (this.getModifyUser() == null ? other.getModifyUser() == null : this.getModifyUser().equals(other.getModifyUser()))
            && (this.getRemake() == null ? other.getRemake() == null : this.getRemake().equals(other.getRemake()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbg.generated Tue Mar 26 23:24:00 CST 2019
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getfPhone() == null) ? 0 : getfPhone().hashCode());
        result = prime * result + ((getmPhone() == null) ? 0 : getmPhone().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getIdCard() == null) ? 0 : getIdCard().hashCode());
        result = prime * result + ((getClassroomTeacherId() == null) ? 0 : getClassroomTeacherId().hashCode());
        result = prime * result + ((getSchoolId() == null) ? 0 : getSchoolId().hashCode());
        result = prime * result + ((getClassId() == null) ? 0 : getClassId().hashCode());
        result = prime * result + ((getOrgId() == null) ? 0 : getOrgId().hashCode());
        result = prime * result + ((getGradeId() == null) ? 0 : getGradeId().hashCode());
        result = prime * result + ((getLessonTime() == null) ? 0 : getLessonTime().hashCode());
        result = prime * result + ((getgLessonTime() == null) ? 0 : getgLessonTime().hashCode());
        result = prime * result + ((getLessonMoney() == null) ? 0 : getLessonMoney().hashCode());
        result = prime * result + ((getProjectNo() == null) ? 0 : getProjectNo().hashCode());
        result = prime * result + ((getLessonSurplus() == null) ? 0 : getLessonSurplus().hashCode());
        result = prime * result + ((getLessonLock() == null) ? 0 : getLessonLock().hashCode());
        result = prime * result + ((getMathScore() == null) ? 0 : getMathScore().hashCode());
        result = prime * result + ((getPhysicsScore() == null) ? 0 : getPhysicsScore().hashCode());
        result = prime * result + ((getChemistryScore() == null) ? 0 : getChemistryScore().hashCode());
        result = prime * result + ((getBiologyScore() == null) ? 0 : getBiologyScore().hashCode());
        result = prime * result + ((getGeographyScore() == null) ? 0 : getGeographyScore().hashCode());
        result = prime * result + ((getChineseScore() == null) ? 0 : getChineseScore().hashCode());
        result = prime * result + ((getEnglishScore() == null) ? 0 : getEnglishScore().hashCode());
        result = prime * result + ((getHistoryScore() == null) ? 0 : getHistoryScore().hashCode());
        result = prime * result + ((getPoliticsScore() == null) ? 0 : getPoliticsScore().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getModifyUserId() == null) ? 0 : getModifyUserId().hashCode());
        result = prime * result + ((getModifyTime() == null) ? 0 : getModifyTime().hashCode());
        result = prime * result + ((getModifyUser() == null) ? 0 : getModifyUser().hashCode());
        result = prime * result + ((getRemake() == null) ? 0 : getRemake().hashCode());
        return result;
    }
}