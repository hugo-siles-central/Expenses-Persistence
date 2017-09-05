package com.expenses.persistence.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "fine", schema = "auto_expensas", catalog = "")
public class FineEntity {
    private Long id;
    private String amount;
    private Enum status;
    private Date creationDate;
    private Date dueDate;
    private Collection<ExpenseFineEntity> expenseFinesById;
    private Collection<ExtraFeeFineEntity> extraFeeFinesById;
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
    @Column(name = "amount", nullable = false, length = 45)
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
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
    @Column(name = "due_date", nullable = true)
    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
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

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (dueDate != null ? dueDate.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "fineByFineId")
    public Collection<ExpenseFineEntity> getExpenseFinesById() {
        return expenseFinesById;
    }

    public void setExpenseFinesById(Collection<ExpenseFineEntity> expenseFinesById) {
        this.expenseFinesById = expenseFinesById;
    }

    @OneToMany(mappedBy = "fineByFineId")
    public Collection<ExtraFeeFineEntity> getExtraFeeFinesById() {
        return extraFeeFinesById;
    }

    public void setExtraFeeFinesById(Collection<ExtraFeeFineEntity> extraFeeFinesById) {
        this.extraFeeFinesById = extraFeeFinesById;
    }

    @OneToMany(mappedBy = "fineByFineId")
    public Collection<PropertyFineEntity> getPropertyFinesById() {
        return propertyFinesById;
    }

    public void setPropertyFinesById(Collection<PropertyFineEntity> propertyFinesById) {
        this.propertyFinesById = propertyFinesById;
    }
}
