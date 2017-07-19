package Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.Date;

import pemula.simpus.model.Universitas;

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
        this.dbHelper = context;

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
        ContentValues values = new ContentValues();
        values.put(DBHelper.COLUMN_UNIVERSITAS_NAMA, nama);
        values.put(DBHelper.COLUMN_UNIVERSITAS_ALAMAT, alamat);
        values.put(DBHelper.COLUMN_UNIVERSITAS_TANGGALPENTING, tglPenting);
        values.put(DBHelper.COLUMN_UNIVERSITAS_JALURMASUK, jalurMasuk);
        values.put(DBHelper.COLUMN_UNIVERSITAS_BERITAPENTING, beritaPenting);

    }

}
