package model;

import java.util.Date;

/**
 * Created by Evlive-Tenshi-PC on 7/5/2017.
 */

public class Universitas {

    private long idUniversitas;
    private String namaUniversitas;
    private String alamatUniversitas;
    private Date tglPenting;
    private String jlrMasuk;
    private String beritaPenting;

    public Universitas() {
    }

    public Universitas(String namaUniversitas, String alamatUniversitas, Date tglPenting, String jlrMasuk, String beritaPenting) {
        this.namaUniversitas = namaUniversitas;
        this.alamatUniversitas = alamatUniversitas;
        this.tglPenting = tglPenting;
        this.jlrMasuk = jlrMasuk;
        this.beritaPenting = beritaPenting;
    }

    public long getIdUniversitas() {
        return idUniversitas;
    }

    public void setIdUniversitas(long idUniversitas) {
        this.idUniversitas = idUniversitas;
    }

    public String getNamaUniversitas() {
        return namaUniversitas;
    }

    public void setNamaUniversitas(String namaUniversitas) {
        this.namaUniversitas = namaUniversitas;
    }

    public String getAlamatUniversitas() {
        return alamatUniversitas;
    }

    public void setAlamatUniversitas(String alamatUniversitas) {
        this.alamatUniversitas = alamatUniversitas;
    }

    public Date getTglPenting() {
        return tglPenting;
    }

    public void setTglPenting(Date tglPenting) {
        this.tglPenting = tglPenting;
    }

    public String getJlrMasuk() {
        return jlrMasuk;
    }

    public void setJlrMasuk(String jlrMasuk) {
        this.jlrMasuk = jlrMasuk;
    }

    public String getBeritaPenting() {
        return beritaPenting;
    }

    public void setBeritaPenting(String beritaPenting) {
        this.beritaPenting = beritaPenting;
    }
}
