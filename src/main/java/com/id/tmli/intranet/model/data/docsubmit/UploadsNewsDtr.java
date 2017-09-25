package com.id.tmli.intranet.model.data.docsubmit;

import javax.persistence.*;
import java.util.Date;


/**
 * Created by hito.mario on 05/02/2017.
 */
@Entity
@Table(name="UPLOADS_NEWS")
public class UploadsNewsDtr {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="tgl_upload")
    private Date tglUpload;

    @Column(name="nomor")
    private String nomor;

    @Column(name="kategori")
    private String kategori;

    @Column(name="remarks")
    private String remarks;

    @Column(name="kantor_upload")
    private String kantorUpload;

    @Column(name="user_upload")
    private String userUpload;

    @Column(name="status")
    private String status;

    @Column(name="spaj_no")
    private String spajNo;

    @Column(name="nama_file_a1")
    private String namaFileA1;

    @Column(name="nama_file_a2")
    private String namaFileA2;

    @Column(name="nama_file_a3")
    private String namaFileA3;

    @Column(name="nama_file_a4")
    private String namaFileA4;

    @Column(name="nama_file_a5")
    private String namaFileA5;

    @Column(name="nama_file_b1")
    private String namaFileB1;

    @Column(name="nama_file_b2")
    private String namaFileB2;

    @Column(name="nama_file_b3")
    private String namaFileB3;

    @Column(name="nama_file_b4")
    private String namaFileB4;

    @Column(name="nama_file_b5")
    private String namaFileB5;

    @Column(name="user_update_upload")
    private String userUpdateUpload;

    @Column(name="tgl_update_upload")
    private Date tglUpdateUpload;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTglUpload() {
        return tglUpload;
    }

    public void setTglUpload(Date tglUpload) {
        this.tglUpload = tglUpload;
    }

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getKantorUpload() {
        return kantorUpload;
    }

    public void setKantorUpload(String kantorUpload) {
        this.kantorUpload = kantorUpload;
    }

    public String getUserUpload() {
        return userUpload;
    }

    public void setUserUpload(String userUpload) {
        this.userUpload = userUpload;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpajNo() {
        return spajNo;
    }

    public void setSpajNo(String spajNo) {
        this.spajNo = spajNo;
    }

    public String getNamaFileA1() {
        return namaFileA1;
    }

    public void setNamaFileA1(String namaFileA1) {
        this.namaFileA1 = namaFileA1;
    }

    public String getNamaFileA2() {
        return namaFileA2;
    }

    public void setNamaFileA2(String namaFileA2) {
        this.namaFileA2 = namaFileA2;
    }

    public String getNamaFileA3() {
        return namaFileA3;
    }

    public void setNamaFileA3(String namaFileA3) {
        this.namaFileA3 = namaFileA3;
    }

    public String getNamaFileA4() {
        return namaFileA4;
    }

    public void setNamaFileA4(String namaFileA4) {
        this.namaFileA4 = namaFileA4;
    }

    public String getNamaFileA5() {
        return namaFileA5;
    }

    public void setNamaFileA5(String namaFileA5) {
        this.namaFileA5 = namaFileA5;
    }

    public String getNamaFileB1() {
        return namaFileB1;
    }

    public void setNamaFileB1(String namaFileB1) {
        this.namaFileB1 = namaFileB1;
    }

    public String getNamaFileB2() {
        return namaFileB2;
    }

    public void setNamaFileB2(String namaFileB2) {
        this.namaFileB2 = namaFileB2;
    }

    public String getNamaFileB3() {
        return namaFileB3;
    }

    public void setNamaFileB3(String namaFileB3) {
        this.namaFileB3 = namaFileB3;
    }

    public String getNamaFileB4() {
        return namaFileB4;
    }

    public void setNamaFileB4(String namaFileB4) {
        this.namaFileB4 = namaFileB4;
    }

    public String getNamaFileB5() {
        return namaFileB5;
    }

    public void setNamaFileB5(String namaFileB5) {
        this.namaFileB5 = namaFileB5;
    }

    public String getUserUpdateUpload() {
        return userUpdateUpload;
    }

    public void setUserUpdateUpload(String userUpdateUpload) {
        this.userUpdateUpload = userUpdateUpload;
    }

    public Date getTglUpdateUpload() {
        return tglUpdateUpload;
    }

    public void setTglUpdateUpload(Date tglUpdateUpload) {
        this.tglUpdateUpload = tglUpdateUpload;
    }
}
