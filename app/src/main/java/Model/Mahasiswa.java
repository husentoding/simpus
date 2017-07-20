package model;

import java.util.Date;

/**
 * Created by Evlive-Tenshi-PC on 7/5/2017.
 */

public class Mahasiswa {

    private long idMahasiswa;
    private String emailMahasiswa;
    private String passwordMahasiswa;
    private String namaMahasiswa;
    private String jenisKelaminMahasiswa;
    private Date tglLahirMahasiswa;
    private String asalUniversitas;

    public Mahasiswa() {
    }

    public Mahasiswa(String emailMahasiswa, String passwordMahasiswa, String namaMahasiswa, String asalUniversitas) {
        this.emailMahasiswa = emailMahasiswa;
        this.passwordMahasiswa = passwordMahasiswa;
        this.namaMahasiswa = namaMahasiswa;
        this.asalUniversitas = asalUniversitas;
    }

    public long getIdMahasiswa() {
        return idMahasiswa;
    }

    public void setIdMahasiswa(long idMahasiswa) {
        this.idMahasiswa = idMahasiswa;
    }

    public String getJenisKelaminMahasiswa() {
        return jenisKelaminMahasiswa;
    }

    public void setJenisKelaminMahasiswa(String jenisKelaminMahasiswa) {
        this.jenisKelaminMahasiswa = jenisKelaminMahasiswa;
    }

    public Date getTglLahirMahasiswa() {
        return tglLahirMahasiswa;
    }

    public void setTglLahirMahasiswa(Date tglLahirMahasiswa) {
        this.tglLahirMahasiswa = tglLahirMahasiswa;
    }

    public String getEmailMahasiswa() {
        return emailMahasiswa;
    }

    public void setEmailMahasiswa(String emailMahasiswa) {
        this.emailMahasiswa = emailMahasiswa;
    }

    public String getPasswordMahasiswa() {
        return passwordMahasiswa;
    }

    public void setPasswordMahasiswa(String passwordMahasiswa) {
        this.passwordMahasiswa = passwordMahasiswa;
    }

    public String getNamaMahasiswa() {
        return namaMahasiswa;
    }

    public void setNamaMahasiswa(String namaMahasiswa) {
        this.namaMahasiswa = namaMahasiswa;
    }

    public String getAsalUniversitas() {
        return asalUniversitas;
    }

    public void setAsalUniversitas(String asalUniversitas) {
        this.asalUniversitas = asalUniversitas;
    }
}
