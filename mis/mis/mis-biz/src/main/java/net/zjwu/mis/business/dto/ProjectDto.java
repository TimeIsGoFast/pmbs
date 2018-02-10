package net.zjwu.mis.business.dto;

import javax.persistence.Column;
import javax.persistence.Id;

public class ProjectDto {

    private Integer id;
    private String name;
    private String picUrl;
    private Integer createdUser;
    private String createdDt;
    private Boolean isActive;
    private String shortname;
    private String statusCode;
    private String emailConfig;
    private Integer ownerId;
    private String department;
    private String descr;

    private static final long serialVersionUID = 1L;

}
