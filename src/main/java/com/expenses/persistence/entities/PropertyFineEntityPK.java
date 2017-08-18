package com.expenses.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class PropertyFineEntityPK implements Serializable {
    private Long propertyId;
    private Long fineId;

    @Column(name = "property_id", nullable = false)
    @Id
    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
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

        PropertyFineEntityPK that = (PropertyFineEntityPK) o;

        if (propertyId != null ? !propertyId.equals(that.propertyId) : that.propertyId != null) return false;
        if (fineId != null ? !fineId.equals(that.fineId) : that.fineId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = propertyId != null ? propertyId.hashCode() : 0;
        result = 31 * result + (fineId != null ? fineId.hashCode() : 0);
        return result;
    }
}
