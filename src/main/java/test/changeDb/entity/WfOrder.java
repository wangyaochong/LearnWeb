package test.changeDb.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "wf_order")
public class WfOrder {
    @Id
    String id;
    Integer version;
    String process_Id;
    String creator;
    String create_Time;
    String expire_Time;
    String last_Update_Time;
    String last_Updator;
    String priority;
    String parent_Id;
    String parent_Node_Name;
    String order_No;
    String variable;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getProcess_Id() {
        return process_Id;
    }

    public void setProcess_Id(String process_Id) {
        this.process_Id = process_Id;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreate_Time() {
        return create_Time;
    }

    public void setCreate_Time(String create_Time) {
        this.create_Time = create_Time;
    }

    public String getExpire_Time() {
        return expire_Time;
    }

    public void setExpire_Time(String expire_Time) {
        this.expire_Time = expire_Time;
    }

    public String getLast_Update_Time() {
        return last_Update_Time;
    }

    public void setLast_Update_Time(String last_Update_Time) {
        this.last_Update_Time = last_Update_Time;
    }

    public String getLast_Updator() {
        return last_Updator;
    }

    public void setLast_Updator(String last_Updator) {
        this.last_Updator = last_Updator;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getParent_Id() {
        return parent_Id;
    }

    public void setParent_Id(String parent_Id) {
        this.parent_Id = parent_Id;
    }

    public String getParent_Node_Name() {
        return parent_Node_Name;
    }

    public void setParent_Node_Name(String parent_Node_Name) {
        this.parent_Node_Name = parent_Node_Name;
    }

    public String getOrder_No() {
        return order_No;
    }

    public void setOrder_No(String order_No) {
        this.order_No = order_No;
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }
}
