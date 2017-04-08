package test.changeDb.entity;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by huyoule on 2015/8/11.
 */

@Entity(name = "cloudprojectinfo")
public class ProjectEntity implements Serializable {
    /* 项目ID */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    /* 项目名称 */
    private String projectName;

    /* 创建时间 */
    private String createTime;

    private Long departmentId;

    private Long userGroupId;

    /* 项目对应Aliyun用户名称 */
    private String aliyunName;

    /* 用户组ID */
    private String groupId;

    public ProjectEntity() {
    }

    public ProjectEntity(Long projectID,
                         String projectName,
                         String createTime,
                         Long departmentId) {
        this.id = projectID;
        this.projectName = projectName;
        this.createTime = createTime;
        this.departmentId = departmentId;
    }

    public void setProjectID(Long projectID) {this.id = projectID;}

    public Long getProjectID() {return this.id;}

    public void setProjectName(String projectName) {this.projectName = projectName;}

    public String getProjectName() {return this.projectName;}

    public void setCreateTime(String createTime) {this.createTime = createTime;}

    public String getCreateTime() {return this.createTime;}


    public void setDepartmentId(Long departmentId) {this.departmentId = departmentId;}

    public Long getDepartmentId() {return this.departmentId;}

    public void setUserGroupId(Long userGroupId) {this.userGroupId = userGroupId;}

    public Long getUserGroupId() {return this.userGroupId;}

    public String getGroupId() {return this.groupId;}

    public void setGroupId(String groupId) {this.groupId = groupId;}

    public String getAliyunName() {return this.aliyunName;}

    public void setAliyunName(String aliyunName) {this.aliyunName = aliyunName;}

    @Override
    public String toString() {
        return "ProjectEntity{" +
                "projectID='" + id + '\'' +
                ", projectName='" + projectName + '\'' +
                ", createTime='" + createTime + '\'' +
                ", userGroupId='" + userGroupId + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", aliyunName='" + aliyunName + '\'' +
                '}';
    }
}
