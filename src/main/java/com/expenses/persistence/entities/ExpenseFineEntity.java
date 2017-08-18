package com.expenses.persistence.entities;

import javax.persistence.*;

@Entity
@Table(name = "expense_fine", schema = "auto_expensas", catalog = "")
@IdClass(ExpenseFineEntityPK.class)
public class ExpenseFineEntity {
    private Long expenseId;
    private Long fineId;
    private ExpenseEntity expenseByExpenseId;
    private FineEntity fineByFineId;

    @Id
    @Column(name = "expense_id", nullable = false, insertable = false, updatable = false)
    public Long getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(Long expenseId) {
        this.expenseId = expenseId;
    }

    @Id
    @Column(name = "fine_id", nullable = false, insertable = false, updatable = false)
    public Long getFineId() {
        return fineId;
    }

    public void setFineId(Long fineId) {
        this.fineId = fineId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExpenseFineEntity that = (ExpenseFineEntity) o;

        if (expenseId != null ? !expenseId.equals(that.expenseId) : that.expenseId != null) return false;
        if (fineId != null ? !fineId.equals(that.fineId) : that.fineId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = expenseId != null ? expenseId.hashCode() : 0;
        result = 31 * result + (fineId != null ? fineId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "expense_id", referencedColumnName = "id", nullable = false,
                insertable = false, updatable = false)
    public ExpenseEntity getExpenseByExpenseId() {
        return expenseByExpenseId;
    }

    public void setExpenseByExpenseId(ExpenseEntity expenseByExpenseId) {
        this.expenseByExpenseId = expenseByExpenseId;
    }

    @ManyToOne
    @JoinColumn(name = "fine_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public FineEntity getFineByFineId() {
        return fineByFineId;
    }

    public void setFineByFineId(FineEntity fineByFineId) {
        this.fineByFineId = fineByFineId;
    }
}
