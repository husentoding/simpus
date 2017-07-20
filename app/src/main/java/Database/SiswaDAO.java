package pemula.simpus.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pemula.simpus.model.Siswa;
import pemula.simpus.model.Universitas;

/**
 * Created by Evlive-Tenshi-PC on 7/5/2017.
 */

public class SiswaDAO {

    private Context context;
    private SQLiteDatabase db;
    private DBHelper dbHelper;
    private String[] columns = { DBHelper.COLUMN_SISWA_ID,
            DBHelper.COLUMN_SISWA_EMAIL,
            DBHelper.COLUMN_SISWA_PASSWORD,
            DBHelper.COLUMN_SISWA_NAMA,
            DBHelper.COLUMN_SISWA_KELAMIN,
            DBHelper.COLUMN_SISWA_TANGGALLAHIR,
            DBHelper.COLUMN_SISWA_ASALSEKOLAH,
            DBHelper.COLUMN_SISWA_PIL1,
            DBHelper.COLUMN_SISWA_PIL2,
            DBHelper.COLUMN_SISWA_TIPEAKUN,
            DBHelper.COLUMN_SISWA_SUBSCRIBE1,
            DBHelper.COLUMN_SISWA_SUBSCRIBE2,
            DBHelper.COLUMN_SISWA_SUBSCRIBE3,
            DBHelper.COLUMN_SISWA_SUBSCRIBE4,
            DBHelper.COLUMN_SISWA_SUBSCRIBE5,
            DBHelper.COLUMN_SISWA_SUBSCRIBE6,
            DBHelper.COLUMN_SISWA_SUBSCRIBE7,
            DBHelper.COLUMN_SISWA_SUBSCRIBE8,
            DBHelper.COLUMN_SISWA_SUBSCRIBE9,
            DBHelper.COLUMN_SISWA_SUBSCRIBE10 };

    public SiswaDAO(Context context) {
        dbHelper = new DBHelper(context);
        this.context = context;
        try {
            open();
        } catch (SQLException e) {
            Log.e("SiswaDAO", "SQLException on opening database "+ e.getMessage());
            e.printStackTrace();
        }
    }

    public void open() throws SQLException {
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Siswa createSiswa(String emailSiswa, String passwordSiswa, String namaSiswa, String asalSekolah, String pil1) {
        ContentValues values = new ContentValues();
        values.put(DBHelper.COLUMN_SISWA_EMAIL, emailSiswa);
        values.put(DBHelper.COLUMN_SISWA_PASSWORD, passwordSiswa);
        values.put(DBHelper.COLUMN_SISWA_NAMA, namaSiswa);
        values.put(DBHelper.COLUMN_SISWA_ASALSEKOLAH, asalSekolah);
        values.put(DBHelper.COLUMN_SISWA_PIL1, pil1);
        long insertId = db.insert(DBHelper.TABLE_SISWA, null, values);
        Cursor cursor = db.query(DBHelper.TABLE_SISWA, columns, DBHelper.COLUMN_JURUSAN_ID + " = " + insertId, null, null, null, null);
        cursor.moveToFirst();
        Siswa newSiswa = cursorToSiswa(cursor);
        cursor.close();
        return newSiswa;
    }

    public Siswa createSiswa(String emailSiswa, String passwordSiswa, String namaSiswa, String asalSekolah, String pil1, String pil2) {
        ContentValues values = new ContentValues();
        values.put(DBHelper.COLUMN_SISWA_EMAIL, emailSiswa);
        values.put(DBHelper.COLUMN_SISWA_PASSWORD, passwordSiswa);
        values.put(DBHelper.COLUMN_SISWA_NAMA, namaSiswa);
        values.put(DBHelper.COLUMN_SISWA_ASALSEKOLAH, asalSekolah);
        values.put(DBHelper.COLUMN_SISWA_PIL1, pil1);
        values.put(DBHelper.COLUMN_SISWA_PIL2, pil2);
        long insertId = db.insert(DBHelper.TABLE_SISWA, null, values);
        Cursor cursor = db.query(DBHelper.TABLE_SISWA, columns, DBHelper.COLUMN_JURUSAN_ID + " = " + insertId, null, null, null, null);
        cursor.moveToFirst();
        Siswa newSiswa = cursorToSiswa(cursor);
        cursor.close();
        return newSiswa;
    }

    public void deleteSiswa(Siswa siswa) {
        long id = siswa.getIdSiswa();
        System.out.println("Deleted siswa with id: " + id);
        db.delete(DBHelper.TABLE_SISWA, DBHelper.COLUMN_SISWA_ID + " = " + id, null);
    }

    public List<Siswa> getAllSiswa() {
        List<Siswa> listSiswa = new ArrayList<Siswa>();
        Cursor cursor = db.query(DBHelper.TABLE_SISWA, columns, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Siswa siswa = cursorToSiswa(cursor);
            listSiswa.add(siswa);
            cursor.moveToNext();
        }
        cursor.close();
        return listSiswa;
    }

    public Siswa getSiswa(String emailSiswa) {
        Siswa siswa = new Siswa();
        Cursor cursor = db.query(DBHelper.TABLE_SISWA, columns, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
           if (cursor.getString(1) == emailSiswa) {
               siswa = cursorToSiswa(cursor);
           }
           cursor.moveToNext();
        }
        cursor.close();
        return siswa;
    }

    public Siswa cursorToSiswa(Cursor cursor) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date convertDate = new Date();
        UniversitasDAO universitasDAO = new UniversitasDAO(context);
        Universitas universitas;

        Siswa siswa = new Siswa();
        siswa.setIdSiswa(cursor.getLong(0));
        siswa.setEmailSiswa(cursor.getString(1));
        siswa.setPasswordSiswa(cursor.getString(2));
        siswa.setNamaSiswa(cursor.getString(3));
        siswa.setJenisKelaminSiswa(cursor.getString(4));
        if (cursor.getString(5) != null) {
            try {
                convertDate = formatter.parse(cursor.getString(5));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            siswa.setTglLahirSiswa(convertDate);
        }
        else {
            siswa.setTglLahirSiswa(null);
        }
        siswa.setAsalSekolah(cursor.getString(6));
        siswa.setPil1(cursor.getString(7));
        if (cursor.getString(8) != null) {
            siswa.setPil2(cursor.getString(8));
        }
        else {
            siswa.setPil2(null);
        }
        siswa.setPremium(cursor.getString(9));

        //set subscribe
        if (cursor.getString(10) != null) {
            universitas = universitasDAO.getUniversitasByNama(cursor.getString(10));
            if (universitas.getNamaUniversitas() == cursor.getString(10)) {
                siswa.setUniversitas1(universitas);
            }
        }
        else {
            siswa.setUniversitas1(null);
        }
        if (cursor.getString(11) != null) {
            universitas = universitasDAO.getUniversitasByNama(cursor.getString(11));
            if (universitas.getNamaUniversitas() == cursor.getString(11)) {
                siswa.setUniversitas2(universitas);
            }
        }
        else {
            siswa.setUniversitas2(null);
        }
        if (cursor.getString(12) != null) {
            universitas = universitasDAO.getUniversitasByNama(cursor.getString(12));
            if (universitas.getNamaUniversitas() == cursor.getString(12)) {
                siswa.setUniversitas3(universitas);
            }
        }
        else {
            siswa.setUniversitas3(null);
        }
        if (cursor.getString(13) != null) {
            universitas = universitasDAO.getUniversitasByNama(cursor.getString(13));
            if (universitas.getNamaUniversitas() == cursor.getString(13)) {
                siswa.setUniversitas4(universitas);
            }
        }
        else {
            siswa.setUniversitas4(null);
        }
        if (cursor.getString(14) != null) {
            universitas = universitasDAO.getUniversitasByNama(cursor.getString(14));
            if (universitas.getNamaUniversitas() == cursor.getString(14)) {
                siswa.setUniversitas5(universitas);
            }
        }
        else {
            siswa.setUniversitas5(null);
        }
        if (cursor.getString(15) != null) {
            universitas = universitasDAO.getUniversitasByNama(cursor.getString(15));
            if (universitas.getNamaUniversitas() == cursor.getString(15)) {
                siswa.setUniversitas6(universitas);
            }
        }
        else {
            siswa.setUniversitas6(null);
        }
        if (cursor.getString(16) != null) {
            universitas = universitasDAO.getUniversitasByNama(cursor.getString(16));
            if (universitas.getNamaUniversitas() == cursor.getString(16)) {
                siswa.setUniversitas7(universitas);
            }
        }
        else {
            siswa.setUniversitas7(null);
        }
        if (cursor.getString(17) != null) {
            universitas = universitasDAO.getUniversitasByNama(cursor.getString(17));
            if (universitas.getNamaUniversitas() == cursor.getString(17)) {
                siswa.setUniversitas8(universitas);
            }
        }
        else {
            siswa.setUniversitas8(null);
        }
        if (cursor.getString(18) != null) {
            universitas = universitasDAO.getUniversitasByNama(cursor.getString(18));
            if (universitas.getNamaUniversitas() == cursor.getString(18)) {
                siswa.setUniversitas9(universitas);
            }
        }
        else {
            siswa.setUniversitas9(null);
        }
        if (cursor.getString(19) != null) {
            universitas = universitasDAO.getUniversitasByNama(cursor.getString(19));
            if (universitas.getNamaUniversitas() == cursor.getString(19)) {
                siswa.setUniversitas10(universitas);
            }
        }
        else {
            siswa.setUniversitas10(null);
        }
        return siswa;
    }
}
