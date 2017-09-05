package com.expenses.persistence.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;

@Entity
@Table(name = "expense_configuration", schema = "auto_expensas", catalog = "")
public class ExpenseConfigurationEntity {
    private Long id;
    private Enum type;
    private Enum propertyType;
    private BigDecimal amount;
    private Enum attribute;
    private String attributeValue;
    private Integer validDays;
    private Long condoId;
    private Collection<ExpenseEntity> expensesById;
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
    @Column(name = "property_type", nullable = false)
    public Enum getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(Enum propertyType) {
        this.propertyType = propertyType;
    }

    @Basic
    @Column(name = "amount", nullable = false, precision = 2)
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "attribute", nullable = false)
    public Enum getAttribute() {
        return attribute;
    }

    public void setAttribute(Enum attribute) {
        this.attribute = attribute;
    }

    @Basic
    @Column(name = "attribute_value", nullable = false, length = 45)
    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }

    @Basic
    @Column(name = "valid_days", nullable = false)
    public Integer getValidDays() {
        return validDays;
    }

    public void setValidDays(Integer validDays) {
        this.validDays = validDays;
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

        ExpenseConfigurationEntity that = (ExpenseConfigurationEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (propertyType != null ? !propertyType.equals(that.propertyType) : that.propertyType != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (attribute != null ? !attribute.equals(that.attribute) : that.attribute != null) return false;
        if (attributeValue != null ? !attributeValue.equals(that.attributeValue) : that.attributeValue != null)
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
        result = 31 * result + (attributeValue != null ? attributeValue.hashCode() : 0);
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
