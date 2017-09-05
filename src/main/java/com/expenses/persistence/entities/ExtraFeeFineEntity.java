package com.expenses.persistence.entities;

import javax.persistence.*;

@Entity
@Table(name = "extra_fee_fine", schema = "auto_expensas", catalog = "")
@IdClass(ExtraFeeFineEntityPK.class)
public class ExtraFeeFineEntity {
    private Long extraFeeId;
    private Long fineId;
    private ExtraFeeEntity extraFeeByExtraFeeId;
    private FineEntity fineByFineId;

    @Id
    @Column(name = "extra_fee_id", nullable = false)
    public Long getExtraFeeId() {
        return extraFeeId;
    }

    public void setExtraFeeId(Long extraFeeId) {
        this.extraFeeId = extraFeeId;
    }

    @Id
    @Column(name = "fine_id", nullable = false)
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

        ExtraFeeFineEntity that = (ExtraFeeFineEntity) o;

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

    @ManyToOne
    @JoinColumn(name = "extra_fee_id", referencedColumnName = "id", nullable = false,
                insertable = false, updatable = false)
    public ExtraFeeEntity getExtraFeeByExtraFeeId() {
        return extraFeeByExtraFeeId;
    }

    public void setExtraFeeByExtraFeeId(ExtraFeeEntity extraFeeByExtraFeeId) {
        this.extraFeeByExtraFeeId = extraFeeByExtraFeeId;
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
