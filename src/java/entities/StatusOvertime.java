/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AINAN
 */
@Entity
@Table(name = "STATUS_OVERTIME")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StatusOvertime.findAll", query = "SELECT s FROM StatusOvertime s")
    , @NamedQuery(name = "StatusOvertime.findById", query = "SELECT s FROM StatusOvertime s WHERE s.id = :id")
    , @NamedQuery(name = "StatusOvertime.findByStatus", query = "SELECT s FROM StatusOvertime s WHERE s.status = :status")})
public class StatusOvertime implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "STATUS")
    private String status;
    @OneToMany(mappedBy = "idStatus", fetch = FetchType.LAZY)
    private List<DataOvertime> dataOvertimeList;

    public StatusOvertime() {
    }

    public StatusOvertime(BigDecimal id) {
        this.id = id;
    }

    public StatusOvertime(BigDecimal id, String status) {
        this.id = id;
        this.status = status;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public List<DataOvertime> getDataOvertimeList() {
        return dataOvertimeList;
    }

    public void setDataOvertimeList(List<DataOvertime> dataOvertimeList) {
        this.dataOvertimeList = dataOvertimeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StatusOvertime)) {
            return false;
        }
        StatusOvertime other = (StatusOvertime) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.StatusOvertime[ id=" + id + " ]";
    }
    
}
