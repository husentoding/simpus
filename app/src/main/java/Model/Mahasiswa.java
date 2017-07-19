package Model;

import java.util.Date;

/**
 * Created by Evlive-Tenshi-PC on 7/5/2017.
 */

public class Mahasiswa {

    private Integer idMahasiswa;
    private String emailMahasiswa;
    private String passwordMahasiswa;
    private String namaMahasiswa;
    private char jenisKelaminMahasiswa;
    private Date tglLahirMahasiswa;
    private String asalUniversitas;

    public Mahasiswa(String emailMahasiswa, String passwordMahasiswa, String namaMahasiswa, String asalUniversitas) {
        this.emailMahasiswa = emailMahasiswa;
        this.passwordMahasiswa = passwordMahasiswa;
        this.namaMahasiswa = namaMahasiswa;
        this.asalUniversitas = asalUniversitas;
    }

    public Integer getIdMahasiswa() {
        return idMahasiswa;
    }

    public void setIdMahasiswa(Integer idMahasiswa) {
        this.idMahasiswa = idMahasiswa;
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

    public char getJenisKelamin() {
        return jenisKelaminMahasiswa;
    }

    public void setJenisKelamin(char jenisKelamin) {
        this.jenisKelaminMahasiswa = jenisKelamin;
    }

    public Date getTglLahir() {
        return tglLahirMahasiswa;
    }

    public void setTglLahir(Date tglLahir) {
        this.tglLahirMahasiswa = tglLahir;
    }

    public String getAsalUniversitas() {
        return asalUniversitas;
    }

    public void setAsalUniversitas(String asalUniversitas) {
        this.asalUniversitas = asalUniversitas;
    }
}
