package pemula.simpus.model;

import java.util.Date;

/**
 * Created by Evlive-Tenshi-PC on 7/5/2017.
 */

public class Siswa {

    private long idSiswa;
    private String emailSiswa;
    private String passwordSiswa;
    private String namaSiswa;
    private String jenisKelaminSiswa;
    private Date tglLahirSiswa;
    private String asalSekolah;
    private String pil1;
    private String pil2;
    private String premium;
    private Universitas universitas1;
    private Universitas universitas2;
    private Universitas universitas3;
    private Universitas universitas4;
    private Universitas universitas5;
    private Universitas universitas6;
    private Universitas universitas7;
    private Universitas universitas8;
    private Universitas universitas9;
    private Universitas universitas10;

    public Siswa() {
    }

    public Siswa(String emailSiswa, String passwordSiswa, String namaSiswa, String asalSekolah, String pil1) {
        this.emailSiswa = emailSiswa;
        this.passwordSiswa = passwordSiswa;
        this.namaSiswa = namaSiswa;
        this.asalSekolah = asalSekolah;
        this.pil1 = pil1;
        this.premium = "N";
    }

    public Siswa(String emailSiswa, String passwordSiswa, String namaSiswa, String asalSekolah, String pil1, String pil2) {
        this.emailSiswa = emailSiswa;
        this.passwordSiswa = passwordSiswa;
        this.namaSiswa = namaSiswa;
        this.asalSekolah = asalSekolah;
        this.pil1 = pil1;
        this.pil2 = pil2;
        this.premium = "N";
    }

    public long getIdSiswa() {
        return idSiswa;
    }

    public void setIdSiswa(long idSiswa) {
        this.idSiswa = idSiswa;
    }

    public String getEmailSiswa() {
        return emailSiswa;
    }

    public void setEmailSiswa(String emailSiswa) {
        this.emailSiswa = emailSiswa;
    }

    public String getPasswordSiswa() {
        return passwordSiswa;
    }

    public void setPasswordSiswa(String passwordSiswa) {
        this.passwordSiswa = passwordSiswa;
    }

    public String getNamaSiswa() {
        return namaSiswa;
    }

    public void setNamaSiswa(String namaSiswa) {
        this.namaSiswa = namaSiswa;
    }

    public String getJenisKelaminSiswa() {
        return jenisKelaminSiswa;
    }

    public void setJenisKelaminSiswa(String jenisKelaminSiswa) {
        this.jenisKelaminSiswa = jenisKelaminSiswa;
    }

    public Date getTglLahirSiswa() {
        return tglLahirSiswa;
    }

    public void setTglLahirSiswa(Date tglLahirSiswa) {
        this.tglLahirSiswa = tglLahirSiswa;
    }

    public String getAsalSekolah() {
        return asalSekolah;
    }

    public void setAsalSekolah(String asalSekolah) {
        this.asalSekolah = asalSekolah;
    }

    public String getPil1() {
        return pil1;
    }

    public void setPil1(String pil1) {
        this.pil1 = pil1;
    }

    public String getPil2() {
        return pil2;
    }

    public void setPil2(String pil2) {
        this.pil2 = pil2;
    }

    public String getPremium() {
        return premium;
    }

    public void setPremium(String premium) {
        this.premium = premium;
    }

    public Universitas getUniversitas1() {
        return universitas1;
    }

    public void setUniversitas1(Universitas universitas1) {
        this.universitas1 = universitas1;
    }

    public Universitas getUniversitas2() {
        return universitas2;
    }

    public void setUniversitas2(Universitas universitas2) {
        this.universitas2 = universitas2;
    }

    public Universitas getUniversitas3() {
        return universitas3;
    }

    public void setUniversitas3(Universitas universitas3) {
        this.universitas3 = universitas3;
    }

    public Universitas getUniversitas4() {
        return universitas4;
    }

    public void setUniversitas4(Universitas universitas4) {
        this.universitas4 = universitas4;
    }

    public Universitas getUniversitas5() {
        return universitas5;
    }

    public void setUniversitas5(Universitas universitas5) {
        this.universitas5 = universitas5;
    }

    public Universitas getUniversitas6() {
        return universitas6;
    }

    public void setUniversitas6(Universitas universitas6) {
        this.universitas6 = universitas6;
    }

    public Universitas getUniversitas7() {
        return universitas7;
    }

    public void setUniversitas7(Universitas universitas7) {
        this.universitas7 = universitas7;
    }

    public Universitas getUniversitas8() {
        return universitas8;
    }

    public void setUniversitas8(Universitas universitas8) {
        this.universitas8 = universitas8;
    }

    public Universitas getUniversitas9() {
        return universitas9;
    }

    public void setUniversitas9(Universitas universitas9) {
        this.universitas9 = universitas9;
    }

    public Universitas getUniversitas10() {
        return universitas10;
    }

    public void setUniversitas10(Universitas universitas10) {
        this.universitas10 = universitas10;
    }
}
