package com.expenses.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ExpenseFineEntityPK implements Serializable {
    private Long expenseId;
    private Long fineId;

    @Column(name = "expense_id", nullable = false)
    @Id
    public Long getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(Long expenseId) {
        this.expenseId = expenseId;
    }

    @Column(name = "fine_id", nullable = false)
    @Id
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

        ExpenseFineEntityPK that = (ExpenseFineEntityPK) o;

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
}
