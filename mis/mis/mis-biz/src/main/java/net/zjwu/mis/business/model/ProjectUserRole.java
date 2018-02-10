package net.zjwu.mis.business.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "project_user_role")
public class ProjectUserRole implements Serializable{
	@Id
    private Integer id;
	
	@Column(name = "project_id")
    private Integer projectId;
	@Column(name = "user_id")
    private Integer userId;
	@Column(name = "role_id")
    private Integer roleId;
	private static final long serialVersionUID = 1L;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}