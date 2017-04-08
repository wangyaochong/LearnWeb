package test.changeDb.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity(name="wf_hist_order")
public class WfHistOrder {
    @Id
    String id;
    String process_Id;
    Integer order_State;
    String creator;
    String create_Time;
    String end_Time;
    String expire_Time;
    Integer priority;
    String parent_Id;
    String order_No;
    String variable;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProcess_Id() {
        return process_Id;
    }

    public void setProcess_Id(String process_Id) {
        this.process_Id = process_Id;
    }

    public Integer getOrder_State() {
        return order_State;
    }

    public void setOrder_State(Integer order_State) {
        this.order_State = order_State;
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

    public String getEnd_Time() {
        return end_Time;
    }

    public void setEnd_Time(String end_Time) {
        this.end_Time = end_Time;
    }

    public String getExpire_Time() {
        return expire_Time;
    }

    public void setExpire_Time(String expire_Time) {
        this.expire_Time = expire_Time;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getParent_Id() {
        return parent_Id;
    }

    public void setParent_Id(String parent_Id) {
        this.parent_Id = parent_Id;
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
