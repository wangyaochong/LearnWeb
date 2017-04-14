package test.changeDb;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by y0367 on 2015/10/29.
 */
@Entity(name = "aliyunomsentity")
public class AliyunOmsEntity implements Serializable {
    @Id
    private String id;

    private String instanceId;

    private String instanceName;

    private String region;

    private Long department;

    private String project;

    private String product;

    private String date;

    private String price;

    private String createDate;

    private String testEndDate;

    private boolean isDf;

    @OneToMany(fetch = FetchType.EAGER)
    @Cascade(value={CascadeType.DELETE})
    private List<AliyunOmsItemEntity> omsItemList;

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<AliyunOmsItemEntity> getOmsItemList() {
        return omsItemList;
    }

    public void setOmsItemList(List<AliyunOmsItemEntity> omsItemList) {
        this.omsItemList = omsItemList;
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

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getTestEndDate() {
        return testEndDate;
    }

    public void setTestEndDate(String testEndDate) {
        this.testEndDate = testEndDate;
    }

    public boolean getIsDf() { return isDf; }

    public void setIsDf(boolean isDf) { this.isDf = isDf; }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }
}
