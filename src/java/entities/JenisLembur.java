/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
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
@Table(name = "JENIS_LEMBUR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JenisLembur.findAll", query = "SELECT j FROM JenisLembur j")
    , @NamedQuery(name = "JenisLembur.findByIdJenisLembur", query = "SELECT j FROM JenisLembur j WHERE j.idJenisLembur = :idJenisLembur")
    , @NamedQuery(name = "JenisLembur.findByJenisLembur", query = "SELECT j FROM JenisLembur j WHERE j.jenisLembur = :jenisLembur")})
public class JenisLembur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_JENIS_LEMBUR")
    private Short idJenisLembur;
    @Column(name = "JENIS_LEMBUR")
    private String jenisLembur;
    @OneToMany(mappedBy = "idJenisLembur", fetch = FetchType.LAZY)
    private List<DataOvertime> dataOvertimeList;

    public JenisLembur() {
    }

    public JenisLembur(Short idJenisLembur) {
        this.idJenisLembur = idJenisLembur;
    }

    public JenisLembur(Short idJenisLembur, String jenisLembur) {
        this.idJenisLembur = idJenisLembur;
        this.jenisLembur = jenisLembur;
    }

    public Short getIdJenisLembur() {
        return idJenisLembur;
    }

    public void setIdJenisLembur(Short idJenisLembur) {
        this.idJenisLembur = idJenisLembur;
    }

    public String getJenisLembur() {
        return jenisLembur;
    }

    public void setJenisLembur(String jenisLembur) {
        this.jenisLembur = jenisLembur;
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
        hash += (idJenisLembur != null ? idJenisLembur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JenisLembur)) {
            return false;
        }
        JenisLembur other = (JenisLembur) object;
        if ((this.idJenisLembur == null && other.idJenisLembur != null) || (this.idJenisLembur != null && !this.idJenisLembur.equals(other.idJenisLembur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.JenisLembur[ idJenisLembur=" + idJenisLembur + " ]";
    }
    
}
