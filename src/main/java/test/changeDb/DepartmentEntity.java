package test.changeDb;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "department")
@Table(uniqueConstraints = {@UniqueConstraint(columnNames={"label", "parent_id"})} )
public class DepartmentEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "label", nullable = false)
    private String label;
    @Column(name = "comment")
    private String comment;
    @Column(name = "level")
    private Integer level;
    @Column(name = "isIndependent")
    private Boolean isIndependent = true;
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private DepartmentEntity parent;
    @OneToMany(mappedBy = "parent", fetch = FetchType.EAGER)
    private List<DepartmentEntity> children;

    @Override
    public String toString() {
        return "DepartmentEntity{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", comment='" + comment + '\'' +
                ", level=" + level +
                ", isIndependent=" + isIndependent +
//                ", parent=" + parent +
//                ", children=" + children +
                '}';
    }

    public DepartmentEntity() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Boolean getIsIndependent() {
        return isIndependent;
    }

    public void setIsIndependent(Boolean isIndependent) {
        this.isIndependent = isIndependent;
    }

    public DepartmentEntity getParent() {
        return parent;
    }

    public void setParent(DepartmentEntity parent) {
        this.parent = parent;
    }

    public List<DepartmentEntity> getChildren() {
        return children;
    }

    public void setChildren(List<DepartmentEntity> children) {
        this.children = children;
    }
}
