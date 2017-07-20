package database;

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

import model.Universitas;

/**
 * Created by Evlive-Tenshi-PC on 7/5/2017.
 */

public class UniversitasDAO {

    private Context context;
    private SQLiteDatabase db;
    private DBHelper dbHelper;
    private String[] columns = { DBHelper.COLUMN_UNIVERSITAS_ID,
                    DBHelper.COLUMN_UNIVERSITAS_NAMA,
                    DBHelper.COLUMN_UNIVERSITAS_ALAMAT,
                    DBHelper.COLUMN_UNIVERSITAS_TANGGALPENTING,
                    DBHelper.COLUMN_UNIVERSITAS_JALURMASUK,
                    DBHelper.COLUMN_UNIVERSITAS_BERITAPENTING };

    public UniversitasDAO(Context context) {
        dbHelper = new DBHelper(context);
        this.context = context;
        try {
            open();
        } catch (SQLException e) {
            Log.e("UniversitasDAO", "SQLException on opening database "+ e.getMessage());
            e.printStackTrace();
        }
    }

    public void open() throws SQLException {
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Universitas createUniversitas(String nama, String alamat, Date tglPenting, String jalurMasuk, String beritaPenting) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String formatDate = formatter.format(tglPenting);
        ContentValues values = new ContentValues();
        values.put(DBHelper.COLUMN_UNIVERSITAS_NAMA, nama);
        values.put(DBHelper.COLUMN_UNIVERSITAS_ALAMAT, alamat);
        values.put(DBHelper.COLUMN_UNIVERSITAS_TANGGALPENTING, formatDate);
        values.put(DBHelper.COLUMN_UNIVERSITAS_JALURMASUK, jalurMasuk);
        values.put(DBHelper.COLUMN_UNIVERSITAS_BERITAPENTING, beritaPenting);
        long insertId = db.insert(DBHelper.TABLE_UNIVERSITAS, null, values);
        Cursor cursor = db.query(DBHelper.TABLE_UNIVERSITAS, columns, DBHelper.COLUMN_UNIVERSITAS_ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        Universitas newUniversitas = cursorToUniversitas(cursor);
        cursor.close();
        return newUniversitas;
    }

    public void deleteUniversitas(Universitas universitas) {
        long id = universitas.getIdUniversitas();
        System.out.println("Deleted jurusan with id: " + id);
        db.delete(DBHelper.TABLE_UNIVERSITAS, DBHelper.COLUMN_UNIVERSITAS_ID + " = " + id, null);
    }

    public List<Universitas> getAllUniversitas() {
        List<Universitas> listUniversitas = new ArrayList<Universitas>();
        Cursor cursor = db.query(DBHelper.TABLE_UNIVERSITAS, columns, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Universitas universitas = cursorToUniversitas(cursor);
            listUniversitas.add(universitas);
            cursor.moveToNext();
        }
        cursor.close();
        return listUniversitas;
    }

    public Universitas getUniversitasByNama(String namaUniversitas) {
        Universitas universitas = new Universitas();
        Cursor cursor = db.query(DBHelper.TABLE_UNIVERSITAS, columns, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            if (cursor.getString(1) == namaUniversitas) {
                universitas = cursorToUniversitas(cursor);
            }
            cursor.moveToNext();
        }
        cursor.close();
        return universitas;
    }

    public Universitas cursorToUniversitas(Cursor cursor) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date convertDate = new Date();
        try {
            convertDate = formatter.parse(cursor.getString(3));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Universitas universitas = new Universitas();
        universitas.setIdUniversitas(cursor.getLong(0));
        universitas.setNamaUniversitas(cursor.getString(1));
        universitas.setAlamatUniversitas(cursor.getString(2));
        universitas.setTglPenting(convertDate);
        universitas.setJlrMasuk(cursor.getString(4));
        universitas.setBeritaPenting(cursor.getString(5));
        return universitas;
    }
}
