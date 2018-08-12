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
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AINAN
 */
@Entity
@Table(name = "KARYAWAN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Karyawan.findAll", query = "SELECT k FROM Karyawan k")
    , @NamedQuery(name = "Karyawan.findById", query = "SELECT k FROM Karyawan k WHERE k.id = :id")
    , @NamedQuery(name = "Karyawan.findByNama", query = "SELECT k FROM Karyawan k WHERE k.nama = :nama")
    , @NamedQuery(name = "Karyawan.findByTglLahir", query = "SELECT k FROM Karyawan k WHERE k.tglLahir = :tglLahir")
    , @NamedQuery(name = "Karyawan.findByTglMasuk", query = "SELECT k FROM Karyawan k WHERE k.tglMasuk = :tglMasuk")
    , @NamedQuery(name = "Karyawan.findByAlamat", query = "SELECT k FROM Karyawan k WHERE k.alamat = :alamat")
    , @NamedQuery(name = "Karyawan.findByGaji", query = "SELECT k FROM Karyawan k WHERE k.gaji = :gaji")
    , @NamedQuery(name = "Karyawan.findByEmail", query = "SELECT k FROM Karyawan k WHERE k.email = :email")
    , @NamedQuery(name = "Karyawan.findByJenisKelamin", query = "SELECT k FROM Karyawan k WHERE k.jenisKelamin = :jenisKelamin")
    , @NamedQuery(name = "Karyawan.findByPassword", query = "SELECT k FROM Karyawan k WHERE k.password = :password")})
public class Karyawan implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "NAMA")
    private String nama;
    @Column(name = "TGL_LAHIR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tglLahir;
    @Column(name = "TGL_MASUK")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tglMasuk;
    @Column(name = "ALAMAT")
    private String alamat;
    @Column(name = "GAJI")
    private BigInteger gaji;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "JENIS_KELAMIN")
    private String jenisKelamin;
    @Column(name = "PASSWORD")
    private String password;
    @OneToMany(mappedBy = "idKaryawan", fetch = FetchType.LAZY)
    private List<DataOvertime> dataOvertimeList;
    @JoinColumn(name = "ID_ROLE", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Role idRole;

    public Karyawan() {
    }

    public Karyawan(BigDecimal id) {
        this.id = id;
    }

    public Karyawan(BigDecimal id, String nama, Date tglLahir, Date tglMasuk, String alamat, BigInteger gaji, String email, String jenisKelamin, String password, Role idRole) {
        this.id = id;
        this.nama = nama;
        this.tglLahir = tglLahir;
        this.tglMasuk = tglMasuk;
        this.alamat = alamat;
        this.gaji = gaji;
        this.email = email;
        this.jenisKelamin = jenisKelamin;
        this.password = password;
        this.idRole = idRole;
    }
    
    

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Date getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(Date tglLahir) {
        this.tglLahir = tglLahir;
    }

    public Date getTglMasuk() {
        return tglMasuk;
    }

    public void setTglMasuk(Date tglMasuk) {
        this.tglMasuk = tglMasuk;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public BigInteger getGaji() {
        return gaji;
    }

    public void setGaji(BigInteger gaji) {
        this.gaji = gaji;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public List<DataOvertime> getDataOvertimeList() {
        return dataOvertimeList;
    }

    public void setDataOvertimeList(List<DataOvertime> dataOvertimeList) {
        this.dataOvertimeList = dataOvertimeList;
    }

    public Role getIdRole() {
        return idRole;
    }

    public void setIdRole(Role idRole) {
        this.idRole = idRole;
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
        if (!(object instanceof Karyawan)) {
            return false;
        }
        Karyawan other = (Karyawan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Karyawan[ id=" + id + " ]";
    }
    
}
