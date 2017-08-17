package com.autoexpenses.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "condo", schema = "auto_expensas", catalog = "")
public class CondoEntity {
    private Integer id;
    private String name;
    private String address;
    private String telefonos;
    private Collection<ExpenseConfigurationEntity> expenseConfigurationsById;
    private Collection<FineConfigurationEntity> fineConfigurationsById;
    private Collection<OwnerEntity> ownersById;
    private Collection<PropertyEntity> propertiesById;
    private Collection<PropertySubTypeEntity> propertySubTypesById;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "telefonos")
    public String getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(String telefonos) {
        this.telefonos = telefonos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CondoEntity that = (CondoEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (telefonos != null ? !telefonos.equals(that.telefonos) : that.telefonos != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (telefonos != null ? telefonos.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "condoByCondoId")
    public Collection<ExpenseConfigurationEntity> getExpenseConfigurationsById() {
        return expenseConfigurationsById;
    }

    public void setExpenseConfigurationsById(Collection<ExpenseConfigurationEntity> expenseConfigurationsById) {
        this.expenseConfigurationsById = expenseConfigurationsById;
    }

    @OneToMany(mappedBy = "condoByCondoId")
    public Collection<FineConfigurationEntity> getFineConfigurationsById() {
        return fineConfigurationsById;
    }

    public void setFineConfigurationsById(Collection<FineConfigurationEntity> fineConfigurationsById) {
        this.fineConfigurationsById = fineConfigurationsById;
    }

    @OneToMany(mappedBy = "condoByCondoId")
    public Collection<OwnerEntity> getOwnersById() {
        return ownersById;
    }

    public void setOwnersById(Collection<OwnerEntity> ownersById) {
        this.ownersById = ownersById;
    }

    @OneToMany(mappedBy = "condoByCondoId")
    public Collection<PropertyEntity> getPropertiesById() {
        return propertiesById;
    }

    public void setPropertiesById(Collection<PropertyEntity> propertiesById) {
        this.propertiesById = propertiesById;
    }

    @OneToMany(mappedBy = "condoByCondoId")
    public Collection<PropertySubTypeEntity> getPropertySubTypesById() {
        return propertySubTypesById;
    }

    public void setPropertySubTypesById(Collection<PropertySubTypeEntity> propertySubTypesById) {
        this.propertySubTypesById = propertySubTypesById;
    }
}
