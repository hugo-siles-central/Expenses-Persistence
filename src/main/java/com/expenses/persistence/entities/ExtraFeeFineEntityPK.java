package com.expenses.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ExtraFeeFineEntityPK implements Serializable {
    private Long extraFeeId;
    private Long fineId;

    @Column(name = "extra_fee_id", nullable = false)
    @Id
    public Long getExtraFeeId() {
        return extraFeeId;
    }

    public void setExtraFeeId(Long extraFeeId) {
        this.extraFeeId = extraFeeId;
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

        ExtraFeeFineEntityPK that = (ExtraFeeFineEntityPK) o;

        if (extraFeeId != null ? !extraFeeId.equals(that.extraFeeId) : that.extraFeeId != null) return false;
        if (fineId != null ? !fineId.equals(that.fineId) : that.fineId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = extraFeeId != null ? extraFeeId.hashCode() : 0;
        result = 31 * result + (fineId != null ? fineId.hashCode() : 0);
        return result;
    }
}
