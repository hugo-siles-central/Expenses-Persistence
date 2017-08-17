package com.autoexpenses.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "expense", schema = "auto_expensas", catalog = "")
public class ExpenseEntity {
    private Integer id;
    private BigDecimal amount;
    private Serializable status;
    private Date creationDate;
    private Date dueDate;
    private Date period;
    private Integer expenseConfigurationId;
    private Integer propertyId;
    private Integer fineConfigurationId;
    private ExpenseConfigurationEntity expenseConfigurationByExpenseConfigurationId;
    private PropertyEntity propertyByPropertyId;
    private FineConfigurationEntity fineConfigurationByFineConfigurationId;
    private Collection<FineEntity> finesById;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
    @Column(name = "status")
    public Serializable getStatus() {
        return status;
    }

    public void setStatus(Serializable status) {
        this.status = status;
    }

    @Basic
    @Column(name = "creation_date")
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Basic
    @Column(name = "due_date")
    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @Basic
    @Column(name = "period")
    public Date getPeriod() {
        return period;
    }

    public void setPeriod(Date period) {
        this.period = period;
    }

    @Basic
    @Column(name = "expense_configuration_id")
    public Integer getExpenseConfigurationId() {
        return expenseConfigurationId;
    }

    public void setExpenseConfigurationId(Integer expenseConfigurationId) {
        this.expenseConfigurationId = expenseConfigurationId;
    }

    @Basic
    @Column(name = "property_id")
    public Integer getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }

    @Basic
    @Column(name = "fine_configuration_id")
    public Integer getFineConfigurationId() {
        return fineConfigurationId;
    }

    public void setFineConfigurationId(Integer fineConfigurationId) {
        this.fineConfigurationId = fineConfigurationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExpenseEntity that = (ExpenseEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (creationDate != null ? !creationDate.equals(that.creationDate) : that.creationDate != null) return false;
        if (dueDate != null ? !dueDate.equals(that.dueDate) : that.dueDate != null) return false;
        if (period != null ? !period.equals(that.period) : that.period != null) return false;
        if (expenseConfigurationId != null ? !expenseConfigurationId.equals(that.expenseConfigurationId) : that.expenseConfigurationId != null)
            return false;
        if (propertyId != null ? !propertyId.equals(that.propertyId) : that.propertyId != null) return false;
        if (fineConfigurationId != null ? !fineConfigurationId.equals(that.fineConfigurationId) : that.fineConfigurationId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (dueDate != null ? dueDate.hashCode() : 0);
        result = 31 * result + (period != null ? period.hashCode() : 0);
        result = 31 * result + (expenseConfigurationId != null ? expenseConfigurationId.hashCode() : 0);
        result = 31 * result + (propertyId != null ? propertyId.hashCode() : 0);
        result = 31 * result + (fineConfigurationId != null ? fineConfigurationId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "expense_configuration_id", referencedColumnName = "id", nullable = false)
    public ExpenseConfigurationEntity getExpenseConfigurationByExpenseConfigurationId() {
        return expenseConfigurationByExpenseConfigurationId;
    }

    public void setExpenseConfigurationByExpenseConfigurationId(ExpenseConfigurationEntity expenseConfigurationByExpenseConfigurationId) {
        this.expenseConfigurationByExpenseConfigurationId = expenseConfigurationByExpenseConfigurationId;
    }

    @ManyToOne
    @JoinColumn(name = "property_id", referencedColumnName = "id", nullable = false)
    public PropertyEntity getPropertyByPropertyId() {
        return propertyByPropertyId;
    }

    public void setPropertyByPropertyId(PropertyEntity propertyByPropertyId) {
        this.propertyByPropertyId = propertyByPropertyId;
    }

    @ManyToOne
    @JoinColumn(name = "fine_configuration_id", referencedColumnName = "id", nullable = false)
    public FineConfigurationEntity getFineConfigurationByFineConfigurationId() {
        return fineConfigurationByFineConfigurationId;
    }

    public void setFineConfigurationByFineConfigurationId(FineConfigurationEntity fineConfigurationByFineConfigurationId) {
        this.fineConfigurationByFineConfigurationId = fineConfigurationByFineConfigurationId;
    }

    @OneToMany(mappedBy = "expenseByExternalEntityId")
    public Collection<FineEntity> getFinesById() {
        return finesById;
    }

    public void setFinesById(Collection<FineEntity> finesById) {
        this.finesById = finesById;
    }
}
