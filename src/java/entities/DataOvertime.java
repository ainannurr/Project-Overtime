/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AINAN
 */
@Entity
@Table(name = "DATA_OVERTIME")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DataOvertime.findAll", query = "SELECT d FROM DataOvertime d")
    , @NamedQuery(name = "DataOvertime.findById", query = "SELECT d FROM DataOvertime d WHERE d.id = :id")
    , @NamedQuery(name = "DataOvertime.findByTgl", query = "SELECT d FROM DataOvertime d WHERE d.tgl = :tgl")
    , @NamedQuery(name = "DataOvertime.findByJamMasuk", query = "SELECT d FROM DataOvertime d WHERE d.jamMasuk = :jamMasuk")
    , @NamedQuery(name = "DataOvertime.findByJamPulang", query = "SELECT d FROM DataOvertime d WHERE d.jamPulang = :jamPulang")
    , @NamedQuery(name = "DataOvertime.findByKeterangan", query = "SELECT d FROM DataOvertime d WHERE d.keterangan = :keterangan")
    , @NamedQuery(name = "DataOvertime.findByUpahLembur", query = "SELECT d FROM DataOvertime d WHERE d.upahLembur = :upahLembur")})
public class DataOvertime implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "TGL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tgl;
    @Column(name = "JAM_MASUK")
    @Temporal(TemporalType.TIMESTAMP)
    private Date jamMasuk;
    @Column(name = "JAM_PULANG")
    @Temporal(TemporalType.TIMESTAMP)
    private Date jamPulang;
    @Column(name = "KETERANGAN")
    private String keterangan;
    @Column(name = "UPAH_LEMBUR")
    private BigInteger upahLembur;
    @JoinColumn(name = "ID_JENIS_LEMBUR", referencedColumnName = "ID_JENIS_LEMBUR")
    @ManyToOne(fetch = FetchType.LAZY)
    private JenisLembur idJenisLembur;
    @JoinColumn(name = "ID_KARYAWAN", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Karyawan idKaryawan;
    @JoinColumn(name = "ID_STATUS", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private StatusOvertime idStatus;

    public DataOvertime() {
    }

    public DataOvertime(BigDecimal id) {
        this.id = id;
    }

    public DataOvertime(BigDecimal id, Date tgl, Date jamMasuk, Date jamPulang, String keterangan, BigInteger upahLembur, JenisLembur idJenisLembur, Karyawan idKaryawan, StatusOvertime idStatus) {
        this.id = id;
        this.tgl = tgl;
        this.jamMasuk = jamMasuk;
        this.jamPulang = jamPulang;
        this.keterangan = keterangan;
        this.upahLembur = upahLembur;
        this.idJenisLembur = idJenisLembur;
        this.idKaryawan = idKaryawan;
        this.idStatus = idStatus;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Date getTgl() {
        return tgl;
    }

    public void setTgl(Date tgl) {
        this.tgl = tgl;
    }

    public Date getJamMasuk() {
        return jamMasuk;
    }

    public void setJamMasuk(Date jamMasuk) {
        this.jamMasuk = jamMasuk;
    }

    public Date getJamPulang() {
        return jamPulang;
    }

    public void setJamPulang(Date jamPulang) {
        this.jamPulang = jamPulang;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public BigInteger getUpahLembur() {
        return upahLembur;
    }

    public void setUpahLembur(BigInteger upahLembur) {
        this.upahLembur = upahLembur;
    }

    public JenisLembur getIdJenisLembur() {
        return idJenisLembur;
    }

    public void setIdJenisLembur(JenisLembur idJenisLembur) {
        this.idJenisLembur = idJenisLembur;
    }

    public Karyawan getIdKaryawan() {
        return idKaryawan;
    }

    public void setIdKaryawan(Karyawan idKaryawan) {
        this.idKaryawan = idKaryawan;
    }

    public StatusOvertime getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(StatusOvertime idStatus) {
        this.idStatus = idStatus;
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
        if (!(object instanceof DataOvertime)) {
            return false;
        }
        DataOvertime other = (DataOvertime) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.DataOvertime[ id=" + id + " ]";
    }
    
}
