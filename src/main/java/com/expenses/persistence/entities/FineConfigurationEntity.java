package com.expenses.persistence.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;

@Entity
@Table(name = "fine_configuration", schema = "auto_expensas", catalog = "")
public class FineConfigurationEntity {
    private Long id;
    private BigDecimal amount;
    private Serializable amountType;
    private Integer validDays;
    private Enum accumulative;
    private Long condoId;
    private Collection<ExpenseEntity> expensesById;
    private Collection<ExtraFeeEntity> extraFeesById;
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
    @Column(name = "amount", nullable = false, precision = 2)
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "amount_type", nullable = false)
    public Serializable getAmountType() {
        return amountType;
    }

    public void setAmountType(Serializable amountType) {
        this.amountType = amountType;
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
    @Column(name = "accumulative", nullable = false)
    public Enum getAccumulative() {
        return accumulative;
    }

    public void setAccumulative(Enum accumulative) {
        this.accumulative = accumulative;
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

        FineConfigurationEntity that = (FineConfigurationEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (amountType != null ? !amountType.equals(that.amountType) : that.amountType != null) return false;
        if (validDays != null ? !validDays.equals(that.validDays) : that.validDays != null) return false;
        if (accumulative != null ? !accumulative.equals(that.accumulative) : that.accumulative != null) return false;
        if (condoId != null ? !condoId.equals(that.condoId) : that.condoId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (amountType != null ? amountType.hashCode() : 0);
        result = 31 * result + (validDays != null ? validDays.hashCode() : 0);
        result = 31 * result + (accumulative != null ? accumulative.hashCode() : 0);
        result = 31 * result + (condoId != null ? condoId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "fineConfigurationByFineConfigurationId")
    public Collection<ExpenseEntity> getExpensesById() {
        return expensesById;
    }

    public void setExpensesById(Collection<ExpenseEntity> expensesById) {
        this.expensesById = expensesById;
    }

    @OneToMany(mappedBy = "fineConfigurationByFineConfigurationId")
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
}
