package entity;

import lombok.Data;
import org.apache.ibatis.type.Alias;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by【王耀冲】on 【2017/6/13】 at 【23:04】.
 */
@Data
@Entity
public class TestEntity implements IEntity,IConsumingItemEntity,IObjectEntity{
    @Id
    @GenericGenerator(name="generator",strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "generator")
    String id;
    String name;
    Integer age;
    Long inDate;
    Long outDate;
    String title;
    String description;
    String type;

    public TestEntity() {
    }

    public TestEntity(String name, Integer age, Long inDate, Long outDate, String title, String description, String type) {
        this.name = name;
        this.age = age;
        this.inDate = inDate;
        this.outDate = outDate;
        this.title = title;
        this.description = description;
        this.type = type;
    }

//    public Long getInDate() {
//        return inDate;
//    }
//
//    public void setInDate(Long inDate) {
//        this.inDate = inDate;
//    }
//
//    public Long getOutDate() {
//        return outDate;
//    }
//
//    public void setOutDate(Long outDate) {
//        this.outDate = outDate;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
}
