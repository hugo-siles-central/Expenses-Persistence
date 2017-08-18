package com.expenses.persistence.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "property_sub_type", schema = "auto_expensas", catalog = "")
public class PropertySubTypeEntity {
    private Long id;
    private Enum type;
    private String description;
    private Long condoId;
    private Collection<PropertyEntity> propertiesById;
    private CondoEntity condoByCondoId;

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "type", nullable = false)
    public Enum getType() {
        return type;
    }

    public void setType(Enum type) {
        this.type = type;
    }

    @Basic
    @Column(name = "description", nullable = false, length = 45)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "condo_id", nullable = false, insertable = false, updatable = false)
    public Long getCondoId() {
        return condoId;
    }

    public void setCondoId(Long condoId) {
        this.condoId = condoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PropertySubTypeEntity that = (PropertySubTypeEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (condoId != null ? !condoId.equals(that.condoId) : that.condoId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (condoId != null ? condoId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "propertySubTypeBySubTypeId")
    public Collection<PropertyEntity> getPropertiesById() {
        return propertiesById;
    }

    public void setPropertiesById(Collection<PropertyEntity> propertiesById) {
        this.propertiesById = propertiesById;
    }

    @ManyToOne
    @JoinColumn(name = "condo_id", referencedColumnName = "id", nullable = false)
    public CondoEntity getCondoByCondoId() {
        return condoByCondoId;
    }

    public void setCondoByCondoId(CondoEntity condoByCondoId) {
        this.condoByCondoId = condoByCondoId;
    }
}
