package model;

/**
 * Created by Evlive-Tenshi-PC on 7/5/2017.
 */

public class Jurusan {

    private long idJurusan;
    private Universitas universitas;
    private String namaFakultas;
    private String akreditasi;
    private double passingGrade;

    public Jurusan() {
    }

    public Jurusan(Universitas universitas, String namaFakultas, String akreditasi, double passingGrade) {
        this.universitas = universitas;
        this.namaFakultas = namaFakultas;
        this.akreditasi = akreditasi;
        this.passingGrade = passingGrade;
    }

    public long getIdJurusan() {
        return idJurusan;
    }

    public void setIdJurusan(long idJurusan) {
        this.idJurusan = idJurusan;
    }

    public Universitas getUniversitas() {
        return universitas;
    }

    public void setUniversitas(Universitas universitas) {
        this.universitas = universitas;
    }

    public String getNamaFakultas() {
        return namaFakultas;
    }

    public void setNamaFakultas(String namaFakultas) {
        this.namaFakultas = namaFakultas;
    }

    public String getAkreditasi() {
        return akreditasi;
    }

    public void setAkreditasi(String akreditasi) {
        this.akreditasi = akreditasi;
    }

    public double getPassingGrade() {
        return passingGrade;
    }

    public void setPassingGrade(double passingGrade) {
        this.passingGrade = passingGrade;
    }
}
