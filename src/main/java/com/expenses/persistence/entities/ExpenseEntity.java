package com.expenses.persistence.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "expense", schema = "auto_expensas", catalog = "")
public class ExpenseEntity {
    private Long id;
    private BigDecimal amount;
    private Enum status;
    private Date creationDate;
    private Date dueDate;
    private Date period;
    private Long expenseConfigurationId;
    private Long propertyId;
    private Long fineConfigurationId;
    private ExpenseConfigurationEntity expenseConfigurationByExpenseConfigurationId;
    private PropertyEntity propertyByPropertyId;
    private FineConfigurationEntity fineConfigurationByFineConfigurationId;
    private Collection<ExpenseFineEntity> expenseFinesById;

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
    @Column(name = "amount", nullable = false, precision = 2)
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "status", nullable = false)
    public Enum getStatus() {
        return status;
    }

    public void setStatus(Enum status) {
        this.status = status;
    }

    @Basic
    @Column(name = "creation_date", nullable = false)
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Basic
    @Column(name = "due_date", nullable = false)
    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @Basic
    @Column(name = "period", nullable = false)
    public Date getPeriod() {
        return period;
    }

    public void setPeriod(Date period) {
        this.period = period;
    }

    @Basic
    @Column(name = "expense_configuration_id", nullable = false, insertable = false, updatable = false)
    public Long getExpenseConfigurationId() {
        return expenseConfigurationId;
    }

    public void setExpenseConfigurationId(Long expenseConfigurationId) {
        this.expenseConfigurationId = expenseConfigurationId;
    }

    @Basic
    @Column(name = "property_id", nullable = false)
    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    @Basic
    @Column(name = "fine_configuration_id", nullable = false, insertable = false, updatable = false)
    public Long getFineConfigurationId() {
        return fineConfigurationId;
    }

    public void setFineConfigurationId(Long fineConfigurationId) {
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
    @JoinColumn(name = "property_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
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

    @OneToMany(mappedBy = "expenseByExpenseId")
    public Collection<ExpenseFineEntity> getExpenseFinesById() {
        return expenseFinesById;
    }

    public void setExpenseFinesById(Collection<ExpenseFineEntity> expenseFinesById) {
        this.expenseFinesById = expenseFinesById;
    }
}
