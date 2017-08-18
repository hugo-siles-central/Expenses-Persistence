package com.expenses.persistence.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "property", schema = "auto_expensas", catalog = "")
public class PropertyEntity {
    private Long id;
    private String code;
    private Enum type;
    private Long condoId;
    private Long subTypeId;
    private Long ownerId;
    private Collection<ExpenseEntity> expensesById;
    private Collection<ExtraFeeEntity> extraFeesById;
    private CondoEntity condoByCondoId;
    private PropertySubTypeEntity propertySubTypeBySubTypeId;
    private OwnerEntity ownerByOwnerId;
    private Collection<PropertyFineEntity> propertyFinesById;

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
    @Column(name = "code", nullable = false, length = 45)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
    @Column(name = "condo_id", nullable = false, insertable = false, updatable = false)
    public Long getCondoId() {
        return condoId;
    }

    public void setCondoId(Long condoId) {
        this.condoId = condoId;
    }

    @Basic
    @Column(name = "sub_type_id", nullable = false, insertable = false, updatable = false)
    public Long getSubTypeId() {
        return subTypeId;
    }

    public void setSubTypeId(Long subTypeId) {
        this.subTypeId = subTypeId;
    }

    @Basic
    @Column(name = "owner_id", nullable = false, insertable = false, updatable = false)
    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PropertyEntity that = (PropertyEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (condoId != null ? !condoId.equals(that.condoId) : that.condoId != null) return false;
        if (subTypeId != null ? !subTypeId.equals(that.subTypeId) : that.subTypeId != null) return false;
        if (ownerId != null ? !ownerId.equals(that.ownerId) : that.ownerId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (condoId != null ? condoId.hashCode() : 0);
        result = 31 * result + (subTypeId != null ? subTypeId.hashCode() : 0);
        result = 31 * result + (ownerId != null ? ownerId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "propertyByPropertyId")
    public Collection<ExpenseEntity> getExpensesById() {
        return expensesById;
    }

    public void setExpensesById(Collection<ExpenseEntity> expensesById) {
        this.expensesById = expensesById;
    }

    @OneToMany(mappedBy = "propertyByPropertyId")
    public Collection<ExtraFeeEntity> getExtraFeesById() {
        return extraFeesById;
    }

    public void setExtraFeesById(Collection<ExtraFeeEntity> extraFeesById) {
        this.extraFeesById = extraFeesById;
    }

    @ManyToOne
    @JoinColumn(name = "condo_id", referencedColumnName = "id", nullable = false)
    public CondoEntity getCondoByCondoId() {
        return condoByCondoId;
    }

    public void setCondoByCondoId(CondoEntity condoByCondoId) {
        this.condoByCondoId = condoByCondoId;
    }

    @ManyToOne
    @JoinColumn(name = "sub_type_id", referencedColumnName = "id", nullable = false)
    public PropertySubTypeEntity getPropertySubTypeBySubTypeId() {
        return propertySubTypeBySubTypeId;
    }

    public void setPropertySubTypeBySubTypeId(PropertySubTypeEntity propertySubTypeBySubTypeId) {
        this.propertySubTypeBySubTypeId = propertySubTypeBySubTypeId;
    }

    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id", nullable = false)
    public OwnerEntity getOwnerByOwnerId() {
        return ownerByOwnerId;
    }

    public void setOwnerByOwnerId(OwnerEntity ownerByOwnerId) {
        this.ownerByOwnerId = ownerByOwnerId;
    }

    @OneToMany(mappedBy = "propertyByPropertyId")
    public Collection<PropertyFineEntity> getPropertyFinesById() {
        return propertyFinesById;
    }

    public void setPropertyFinesById(Collection<PropertyFineEntity> propertyFinesById) {
        this.propertyFinesById = propertyFinesById;
    }
}
