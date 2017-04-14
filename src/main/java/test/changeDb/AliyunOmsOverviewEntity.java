package test.changeDb;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

/**
 * Created by y0367 on 2015/10/29.
 */
@Entity(name = "aliyunomsoverview")
public class AliyunOmsOverviewEntity implements Serializable {
    @Id
    private String id;

    private String instanceId;

    private String instanceName;

    private String region;

    private String regionType;

    private Long department;

    private String project;

    private String product;

    private String startTime;

    private String date;

    private String price;

    private Boolean isVisible;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegionType() { return regionType; }

    public void setRegionType(String regionType) {
        this.regionType = regionType;
    }

    public Long getDepartment() {
        return department;
    }

    public void setDepartment(Long department) {
        this.department = department;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getInstanceName() {
        return instanceName;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    public Boolean getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(Boolean isVisible) {
        this.isVisible = isVisible;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }


}
