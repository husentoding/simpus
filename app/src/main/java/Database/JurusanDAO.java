package database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import model.Jurusan;
import model.Universitas;

/**
 * Created by Evlive-Tenshi-PC on 7/5/2017.
 */

public class JurusanDAO {

    private Context context;
    private SQLiteDatabase db;
    private DBHelper dbHelper;
    private String[] columns = { DBHelper.COLUMN_JURUSAN_ID,
            DBHelper.COLUMN_JURUSAN_NAMA,
            DBHelper.COLUMN_JURUSAN_PASSINGGRADE,
            DBHelper.COLUMN_JURUSAN_AKREDITASI,
            DBHelper.COLUMN_JURUSAN_UNIVERSITAS };

    public JurusanDAO(Context context) {
        dbHelper = new DBHelper(context);
        this.context = context;
        try {
            open();
        } catch (SQLException e) {
            Log.e("JurusanDAO", "SQLException on opening database "+ e.getMessage());
            e.printStackTrace();
        }
    }

    public void open() throws SQLException {
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Jurusan createJurusan(String namaUniversitas, String namaFakultas, String akreditasi, double passingGrade) {
        open();
        ContentValues values = new ContentValues();
        values.put(DBHelper.COLUMN_JURUSAN_UNIVERSITAS, namaUniversitas);
        values.put(DBHelper.COLUMN_JURUSAN_NAMA, namaFakultas);
        values.put(DBHelper.COLUMN_JURUSAN_AKREDITASI, akreditasi);
        values.put(DBHelper.COLUMN_JURUSAN_PASSINGGRADE, passingGrade);
        long insertId = db.insert(DBHelper.TABLE_JURUSAN, null, values);
        Cursor cursor = db.query(DBHelper.TABLE_JURUSAN, columns, DBHelper.COLUMN_JURUSAN_ID + " = " + insertId, null,
            null, null, null);
        cursor.moveToFirst();
        Jurusan newJurusan = cursorToJurusan(cursor);
        cursor.close();
        return newJurusan;
    }

    public void deleteJurusan(Jurusan jurusan) {
        long id = jurusan.getIdJurusan();
        System.out.println("Deleted jurusan with id: " + id);
        db.delete(DBHelper.TABLE_JURUSAN, DBHelper.COLUMN_JURUSAN_ID + " = " + id, null);
    }

    public List<Jurusan> getAllJurusan() {
        List<Jurusan> listJurusan = new ArrayList<Jurusan>();
        Cursor cursor = db.query(DBHelper.TABLE_JURUSAN, columns, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Jurusan jurusan = cursorToJurusan(cursor);
            listJurusan.add(jurusan);
            cursor.moveToNext();
        }
        cursor.close();
        return listJurusan;
    }

    public Jurusan getJurusan(String namaUniversitas, String namaFakultas) {
        Jurusan jurusan = new Jurusan();
        Cursor cursor = db.query(DBHelper.TABLE_JURUSAN, columns, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            if ((cursor.getString(1) == namaUniversitas) && (cursor.getString(2) == namaFakultas)) {
                jurusan = cursorToJurusan(cursor);
            }
            cursor.moveToNext();
        }
        cursor.close();
        return jurusan;
    }

    private Jurusan cursorToJurusan(Cursor cursor) {
        Jurusan jurusan = new Jurusan();
        jurusan.setIdJurusan(cursor.getInt(0));

        //get Universitas
        String namaUniversitas = cursor.getString(1);
        UniversitasDAO dao = new UniversitasDAO(context);
        Universitas universitas = dao.getUniversitasByNama(namaUniversitas);
        if (universitas != null) {
            jurusan.setUniversitas(universitas);
        }
        jurusan.setNamaFakultas(cursor.getString(2));
        jurusan.setAkreditasi(cursor.getString(3));
        jurusan.setPassingGrade(cursor.getDouble(4));
        return jurusan;
    }
}
