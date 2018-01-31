package net.zjwu.mis.business.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "requirement")
public class Requirement implements Serializable {
    @Id
    private Integer id;

    private String name;

    private String author;

    @Column(name = "project_id")
    private Integer projectId;

    private String product;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "is_reviewed")
    private Boolean isReviewed;

    @Column(name = "old_type")
    private String oldType;

    @Column(name = "direct_cover_status")
    private String directCoverStatus;

    @Column(name = "is_approved")
    private Boolean isApproved;

    @Column(name = "screen_shot")
    private Integer screenShot;

    @Column(name = "requirement_doc")
    private Integer requirementDoc;

    @Column(name = "cover_testcase_num")
    private Integer coverTestcaseNum;

    @Column(name = "status_code")
    private String statusCode;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "create_user")
    private String createUser;

    @Column(name = "update_date")
    private Date updateDate;

    @Column(name = "update_user")
    private String updateUser;

    @Column(name = "default_assigner_id")
    private Integer defaultAssignerId;

    @Column(name = "defaultcc_uid")
    private String defaultccUid;

    private String descr;

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
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return project_id
     */
    public Integer getProjectId() {
        return projectId;
    }

    /**
     * @param projectId
     */
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    /**
     * @return product
     */
    public String getProduct() {
        return product;
    }

    /**
     * @param product
     */
    public void setProduct(String product) {
        this.product = product;
    }

    /**
     * @return is_active
     */
    public Boolean getIsActive() {
        return isActive;
    }

    /**
     * @param isActive
     */
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    /**
     * @return is_reviewed
     */
    public Boolean getIsReviewed() {
        return isReviewed;
    }

    /**
     * @param isReviewed
     */
    public void setIsReviewed(Boolean isReviewed) {
        this.isReviewed = isReviewed;
    }

    /**
     * @return old_type
     */
    public String getOldType() {
        return oldType;
    }

    /**
     * @param oldType
     */
    public void setOldType(String oldType) {
        this.oldType = oldType;
    }

    /**
     * @return direct_cover_status
     */
    public String getDirectCoverStatus() {
        return directCoverStatus;
    }

    /**
     * @param directCoverStatus
     */
    public void setDirectCoverStatus(String directCoverStatus) {
        this.directCoverStatus = directCoverStatus;
    }

    /**
     * @return is_approved
     */
    public Boolean getIsApproved() {
        return isApproved;
    }

    /**
     * @param isApproved
     */
    public void setIsApproved(Boolean isApproved) {
        this.isApproved = isApproved;
    }

    /**
     * @return screen_shot
     */
    public Integer getScreenShot() {
        return screenShot;
    }

    /**
     * @param screenShot
     */
    public void setScreenShot(Integer screenShot) {
        this.screenShot = screenShot;
    }

    /**
     * @return requirement_doc
     */
    public Integer getRequirementDoc() {
        return requirementDoc;
    }

    /**
     * @param requirementDoc
     */
    public void setRequirementDoc(Integer requirementDoc) {
        this.requirementDoc = requirementDoc;
    }

    /**
     * @return cover_testcase_num
     */
    public Integer getCoverTestcaseNum() {
        return coverTestcaseNum;
    }

    /**
     * @param coverTestcaseNum
     */
    public void setCoverTestcaseNum(Integer coverTestcaseNum) {
        this.coverTestcaseNum = coverTestcaseNum;
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
     * @return create_date
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return create_user
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * @param createUser
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    /**
     * @return update_date
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * @param updateDate
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * @return update_user
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * @param updateUser
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * @return default_assigner_id
     */
    public Integer getDefaultAssignerId() {
        return defaultAssignerId;
    }

    /**
     * @param defaultAssignerId
     */
    public void setDefaultAssignerId(Integer defaultAssignerId) {
        this.defaultAssignerId = defaultAssignerId;
    }

    /**
     * @return defaultcc_uid
     */
    public String getDefaultccUid() {
        return defaultccUid;
    }

    /**
     * @param defaultccUid
     */
    public void setDefaultccUid(String defaultccUid) {
        this.defaultccUid = defaultccUid;
    }

    /**
     * @return descr
     */
    public String getDescr() {
        return descr;
    }

    /**
     * @param descr
     */
    public void setDescr(String descr) {
        this.descr = descr;
    }
}