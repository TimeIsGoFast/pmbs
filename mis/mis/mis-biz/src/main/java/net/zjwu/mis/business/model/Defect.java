package net.zjwu.mis.business.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "defect")
public class Defect implements Serializable {
    @Id
    private Integer id;

    @Column(name = "defect_num")
    private String defectNum;

    private String title;

    @Column(name = "requirement_id")
    private Integer requirementId;

    @Column(name = "creator_uid")
    private Integer creatorUid;

    @Column(name = "release_id")
    private Integer releaseId;

    @Column(name = "cycle_id")
    private Integer cycleId;

    @Column(name = "defect_tatus_id")
    private Integer defectTatusId;

    @Column(name = "resolution_id")
    private Integer resolutionId;

    @Column(name = "severity_id")
    private Integer severityId;

    @Column(name = "assignee_uid")
    private Integer assigneeUid;

    @Column(name = "cc_user_name")
    private String ccUserName;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "last_update_date")
    private Date lastUpdateDate;

    @Column(name = "last_update_uid")
    private Integer lastUpdateUid;

    @Column(name = "status_code")
    private String statusCode;

    @Column(name = "reason_id")
    private Integer reasonId;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return defect_num
     */
    public String getDefectNum() {
        return defectNum;
    }

    /**
     * @param defectNum
     */
    public void setDefectNum(String defectNum) {
        this.defectNum = defectNum;
    }

    /**
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return requirement_id
     */
    public Integer getRequirementId() {
        return requirementId;
    }

    /**
     * @param requirementId
     */
    public void setRequirementId(Integer requirementId) {
        this.requirementId = requirementId;
    }

    /**
     * @return creator_uid
     */
    public Integer getCreatorUid() {
        return creatorUid;
    }

    /**
     * @param creatorUid
     */
    public void setCreatorUid(Integer creatorUid) {
        this.creatorUid = creatorUid;
    }

    /**
     * @return release_id
     */
    public Integer getReleaseId() {
        return releaseId;
    }

    /**
     * @param releaseId
     */
    public void setReleaseId(Integer releaseId) {
        this.releaseId = releaseId;
    }

    /**
     * @return cycle_id
     */
    public Integer getCycleId() {
        return cycleId;
    }

    /**
     * @param cycleId
     */
    public void setCycleId(Integer cycleId) {
        this.cycleId = cycleId;
    }

    /**
     * @return defect_tatus_id
     */
    public Integer getDefectTatusId() {
        return defectTatusId;
    }

    /**
     * @param defectTatusId
     */
    public void setDefectTatusId(Integer defectTatusId) {
        this.defectTatusId = defectTatusId;
    }

    /**
     * @return resolution_id
     */
    public Integer getResolutionId() {
        return resolutionId;
    }

    /**
     * @param resolutionId
     */
    public void setResolutionId(Integer resolutionId) {
        this.resolutionId = resolutionId;
    }

    /**
     * @return severity_id
     */
    public Integer getSeverityId() {
        return severityId;
    }

    /**
     * @param severityId
     */
    public void setSeverityId(Integer severityId) {
        this.severityId = severityId;
    }

    /**
     * @return assignee_uid
     */
    public Integer getAssigneeUid() {
        return assigneeUid;
    }

    /**
     * @param assigneeUid
     */
    public void setAssigneeUid(Integer assigneeUid) {
        this.assigneeUid = assigneeUid;
    }

    /**
     * @return cc_user_name
     */
    public String getCcUserName() {
        return ccUserName;
    }

    /**
     * @param ccUserName
     */
    public void setCcUserName(String ccUserName) {
        this.ccUserName = ccUserName;
    }

    /**
     * @return created_date
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * @param createdDate
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @return last_update_date
     */
    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    /**
     * @param lastUpdateDate
     */
    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    /**
     * @return last_update_uid
     */
    public Integer getLastUpdateUid() {
        return lastUpdateUid;
    }

    /**
     * @param lastUpdateUid
     */
    public void setLastUpdateUid(Integer lastUpdateUid) {
        this.lastUpdateUid = lastUpdateUid;
    }

    /**
     * @return status_code
     */
    public String getStatusCode() {
        return statusCode;
    }

    /**
     * @param statusCode
     */
    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * @return reason_id
     */
    public Integer getReasonId() {
        return reasonId;
    }

    /**
     * @param reasonId
     */
    public void setReasonId(Integer reasonId) {
        this.reasonId = reasonId;
    }
}