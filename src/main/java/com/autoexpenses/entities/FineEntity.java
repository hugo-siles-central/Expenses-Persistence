package com.autoexpenses.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "fine", schema = "auto_expensas", catalog = "")
public class FineEntity {
    private Integer id;
    private String amount;
    private Serializable status;
    private Date creationDate;
    private Date dueDate;
    private Serializable fineType;
    private Integer externalEntityId;
    private ExpenseEntity expenseByExternalEntityId;
    private ExtraFeeEntity extraFeeByExternalEntityId;
    private PropertyEntity propertyByExternalEntityId;

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
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
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
    @Column(name = "fine_type")
    public Serializable getFineType() {
        return fineType;
    }

    public void setFineType(Serializable fineType) {
        this.fineType = fineType;
    }

    @Basic
    @Column(name = "external_entity_id")
    public Integer getExternalEntityId() {
        return externalEntityId;
    }

    public void setExternalEntityId(Integer externalEntityId) {
        this.externalEntityId = externalEntityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FineEntity that = (FineEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (creationDate != null ? !creationDate.equals(that.creationDate) : that.creationDate != null) return false;
        if (dueDate != null ? !dueDate.equals(that.dueDate) : that.dueDate != null) return false;
        if (fineType != null ? !fineType.equals(that.fineType) : that.fineType != null) return false;
        if (externalEntityId != null ? !externalEntityId.equals(that.externalEntityId) : that.externalEntityId != null)
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
        result = 31 * result + (fineType != null ? fineType.hashCode() : 0);
        result = 31 * result + (externalEntityId != null ? externalEntityId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "external_entity_id", referencedColumnName = "id", nullable = false)
    public ExpenseEntity getExpenseByExternalEntityId() {
        return expenseByExternalEntityId;
    }

    public void setExpenseByExternalEntityId(ExpenseEntity expenseByExternalEntityId) {
        this.expenseByExternalEntityId = expenseByExternalEntityId;
    }

    @ManyToOne
    @JoinColumn(name = "external_entity_id", referencedColumnName = "id", nullable = false)
    public ExtraFeeEntity getExtraFeeByExternalEntityId() {
        return extraFeeByExternalEntityId;
    }

    public void setExtraFeeByExternalEntityId(ExtraFeeEntity extraFeeByExternalEntityId) {
        this.extraFeeByExternalEntityId = extraFeeByExternalEntityId;
    }

    @ManyToOne
    @JoinColumn(name = "external_entity_id", referencedColumnName = "id", nullable = false)
    public PropertyEntity getPropertyByExternalEntityId() {
        return propertyByExternalEntityId;
    }

    public void setPropertyByExternalEntityId(PropertyEntity propertyByExternalEntityId) {
        this.propertyByExternalEntityId = propertyByExternalEntityId;
    }
}
