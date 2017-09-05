package com.expenses.persistence.entities;

import javax.persistence.*;

@Entity
@Table(name = "property_fine", schema = "auto_expensas", catalog = "")
@IdClass(PropertyFineEntityPK.class)
public class PropertyFineEntity {
    private Long propertyId;
    private Long fineId;
    private PropertyEntity propertyByPropertyId;
    private FineEntity fineByFineId;

    @Id
    @Column(name = "property_id", nullable = false, insertable = false, updatable = false)
    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
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

        PropertyFineEntity that = (PropertyFineEntity) o;

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

    @ManyToOne
    @JoinColumn(name = "property_id", referencedColumnName = "id",
                nullable = false, insertable = false, updatable = false)
    public PropertyEntity getPropertyByPropertyId() {
        return propertyByPropertyId;
    }

    public void setPropertyByPropertyId(PropertyEntity propertyByPropertyId) {
        this.propertyByPropertyId = propertyByPropertyId;
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
