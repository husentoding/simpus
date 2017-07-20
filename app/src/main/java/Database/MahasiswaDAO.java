package database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import model.Mahasiswa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Evlive-Tenshi-PC on 7/5/2017.
 */

public class MahasiswaDAO {

    private Context context;
    private SQLiteDatabase db;
    private DBHelper dbHelper;
    private String[] columns = { DBHelper.COLUMN_MAHASISWA_ID,
            DBHelper.COLUMN_MAHASISWA_EMAIL,
            DBHelper.COLUMN_MAHASISWA_PASSWORD,
            DBHelper.COLUMN_MAHASISWA_NAMA,
            DBHelper.COLUMN_MAHASISWA_KELAMIN,
            DBHelper.COLUMN_MAHASISWA_TANGGALLAHIR,
            DBHelper.COLUMN_MAHASISWA_ASALUNIVERSITAS };

    public MahasiswaDAO(Context context) {
        dbHelper = new DBHelper(context);
        this.context = context;
        try {
            open();
        } catch (SQLException e) {
            Log.e("MahasiswaDAO", "SQLException on opening database "+ e.getMessage());
            e.printStackTrace();
        }
    }

    public void open() throws SQLException {
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Mahasiswa createMahasiswa(String emailMahasiswa, String passwordMahasiswa, String namaMahasiswa, String asalUniversitas) {
        ContentValues values = new ContentValues();
        values.put(DBHelper.COLUMN_MAHASISWA_EMAIL, emailMahasiswa);
        values.put(DBHelper.COLUMN_MAHASISWA_PASSWORD, passwordMahasiswa);
        values.put(DBHelper.COLUMN_MAHASISWA_NAMA, namaMahasiswa);
        values.put(DBHelper.COLUMN_MAHASISWA_ASALUNIVERSITAS, asalUniversitas);
        long insertId = db.insert(DBHelper.TABLE_MAHASISWA, null, values);
        Cursor cursor = db.query(DBHelper.TABLE_MAHASISWA, columns, DBHelper.COLUMN_MAHASISWA_ID + " = " + insertId, null, null, null, null);
        cursor.moveToFirst();
        Mahasiswa newMahasiswa = cursorToMahasiswa(cursor);
        cursor.close();
        return newMahasiswa;
    }

    public void deleteMahasiswa(Mahasiswa mahasiswa) {
        long id = mahasiswa.getIdMahasiswa();
        System.out.println("Deleted mahasiswa with id: " + id);
        db.delete(DBHelper.TABLE_MAHASISWA, DBHelper.COLUMN_MAHASISWA_ID + " = " + id, null);
    }

    public List<Mahasiswa> getAllMahasiswa() {
        List<Mahasiswa> listMahasiswa =  new ArrayList<Mahasiswa>();
        Cursor cursor = db.query(DBHelper.TABLE_MAHASISWA, columns, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Mahasiswa mahasiswa = cursorToMahasiswa(cursor);
            listMahasiswa.add(mahasiswa);
            cursor.moveToNext();
        }
        cursor.close();
        return listMahasiswa;
    }

    public Mahasiswa getMahasiswa(String emailMahasiswa) {
        Mahasiswa mahasiswa = new Mahasiswa();
        Cursor cursor = db.query(DBHelper.TABLE_MAHASISWA, columns, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            if (cursor.getString(1) == emailMahasiswa) {
                mahasiswa = cursorToMahasiswa(cursor);
            }
            cursor.moveToNext();
        }
        cursor.close();
        return mahasiswa;
    }

    public Mahasiswa cursorToMahasiswa(Cursor cursor) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date convertDate = new Date();
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setIdMahasiswa(cursor.getLong(0));
        mahasiswa.setEmailMahasiswa(cursor.getString(1));
        mahasiswa.setPasswordMahasiswa(cursor.getString(2));
        mahasiswa.setNamaMahasiswa(cursor.getString(3));
        if (cursor.getString(4) != null) {
            mahasiswa.setJenisKelaminMahasiswa(cursor.getString(4));
        }
        else {
            mahasiswa.setJenisKelaminMahasiswa(null);
        }
        if (cursor.getString(5) != null) {
            try {
                convertDate = formatter.parse(cursor.getString(5));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            mahasiswa.setTglLahirMahasiswa(convertDate);
        }
        else {
            mahasiswa.setTglLahirMahasiswa(null);
        }
        mahasiswa.setAsalUniversitas(cursor.getString(6));
        return mahasiswa;
    }

}
