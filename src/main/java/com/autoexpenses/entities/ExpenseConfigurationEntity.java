package com.autoexpenses.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;

@Entity
@Table(name = "expense_configuration", schema = "auto_expensas", catalog = "")
public class ExpenseConfigurationEntity {
    private Integer id;
    private Serializable type;
    private Serializable propertyType;
    private BigDecimal amount;
    private Serializable attribute;
    private String atributeValue;
    private Integer validDays;
    private Integer condoId;
    private Collection<ExpenseEntity> expensesById;
    private CondoEntity condoByCondoId;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "type")
    public Serializable getType() {
        return type;
    }

    public void setType(Serializable type) {
        this.type = type;
    }

    @Basic
    @Column(name = "property_type")
    public Serializable getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(Serializable propertyType) {
        this.propertyType = propertyType;
    }

    @Basic
    @Column(name = "amount")
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "attribute")
    public Serializable getAttribute() {
        return attribute;
    }

    public void setAttribute(Serializable attribute) {
        this.attribute = attribute;
    }

    @Basic
    @Column(name = "atribute_value")
    public String getAtributeValue() {
        return atributeValue;
    }

    public void setAtributeValue(String atributeValue) {
        this.atributeValue = atributeValue;
    }

    @Basic
    @Column(name = "valid_days")
    public Integer getValidDays() {
        return validDays;
    }

    public void setValidDays(Integer validDays) {
        this.validDays = validDays;
    }

    @Basic
    @Column(name = "condo_id")
    public Integer getCondoId() {
        return condoId;
    }

    public void setCondoId(Integer condoId) {
        this.condoId = condoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExpenseConfigurationEntity that = (ExpenseConfigurationEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (propertyType != null ? !propertyType.equals(that.propertyType) : that.propertyType != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (attribute != null ? !attribute.equals(that.attribute) : that.attribute != null) return false;
        if (atributeValue != null ? !atributeValue.equals(that.atributeValue) : that.atributeValue != null)
            return false;
        if (validDays != null ? !validDays.equals(that.validDays) : that.validDays != null) return false;
        if (condoId != null ? !condoId.equals(that.condoId) : that.condoId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (propertyType != null ? propertyType.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (attribute != null ? attribute.hashCode() : 0);
        result = 31 * result + (atributeValue != null ? atributeValue.hashCode() : 0);
        result = 31 * result + (validDays != null ? validDays.hashCode() : 0);
        result = 31 * result + (condoId != null ? condoId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "expenseConfigurationByExpenseConfigurationId")
    public Collection<ExpenseEntity> getExpensesById() {
        return expensesById;
    }

    public void setExpensesById(Collection<ExpenseEntity> expensesById) {
        this.expensesById = expensesById;
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
