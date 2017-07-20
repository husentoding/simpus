package pemula.simpus.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Evlive-Tenshi-PC on 7/5/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "database";
    private static final Integer DATABASE_VERSION = 1;

    // columns of siswa table
    public static final String TABLE_SISWA = "Siswa";
    public static final String COLUMN_SISWA_ID = "id";
    public static final String COLUMN_SISWA_EMAIL = "email";
    public static final String COLUMN_SISWA_PASSWORD ="password";
    public static final String COLUMN_SISWA_NAMA = "nama";
    public static final String COLUMN_SISWA_KELAMIN = "jenis_kelamin";
    public static final String COLUMN_SISWA_TANGGALLAHIR = "tgl_lahir";
    public static final String COLUMN_SISWA_ASALSEKOLAH = "asal_sekolah";
    public static final String COLUMN_SISWA_PIL1 = "pil1";
    public static final String COLUMN_SISWA_PIL2 = "pil2";
    public static final String COLUMN_SISWA_TIPEAKUN = "premium";
    public static final String COLUMN_SISWA_SUBSCRIBE1 =  "susbcribe1";
    public static final String COLUMN_SISWA_SUBSCRIBE2 =  "susbcribe2";
    public static final String COLUMN_SISWA_SUBSCRIBE3 =  "susbcribe3";
    public static final String COLUMN_SISWA_SUBSCRIBE4 =  "susbcribe4";
    public static final String COLUMN_SISWA_SUBSCRIBE5 =  "susbcribe5";
    public static final String COLUMN_SISWA_SUBSCRIBE6 =  "susbcribe6";
    public static final String COLUMN_SISWA_SUBSCRIBE7 =  "susbcribe7";
    public static final String COLUMN_SISWA_SUBSCRIBE8 =  "susbcribe8";
    public static final String COLUMN_SISWA_SUBSCRIBE9 =  "susbcribe9";
    public static final String COLUMN_SISWA_SUBSCRIBE10 =  "susbcribe10";

    //columns of mahasiswa table
    public static final String TABLE_MAHASISWA = "Mahasiswa";
    public static final String COLUMN_MAHASISWA_ID = "id";
    public static final String COLUMN_MAHASISWA_EMAIL = "email";
    public static final String COLUMN_MAHASISWA_PASSWORD = "password";
    public static final String COLUMN_MAHASISWA_NAMA = "nama";
    public static final String COLUMN_MAHASISWA_KELAMIN = "jenis_kelamin";
    public static final String COLUMN_MAHASISWA_TANGGALLAHIR = "tgl_lahir";
    public static final String COLUMN_MAHASISWA_ASALUNIVERSITAS = "asal_universitas";

    //columns of universitas table
    public static final String TABLE_UNIVERSITAS = "Universitas";
    public static final String COLUMN_UNIVERSITAS_ID = "id";
    public static final String COLUMN_UNIVERSITAS_NAMA = "nama";
    public static final String COLUMN_UNIVERSITAS_ALAMAT = "alamat";
    public static final String COLUMN_UNIVERSITAS_TANGGALPENTING = "tgl_penting";
    public static final String COLUMN_UNIVERSITAS_JALURMASUK = "jlr_masuk";
    public static final String COLUMN_UNIVERSITAS_BERITAPENTING = "berita_penting";

    //columns of jurusan table
    public static final String TABLE_JURUSAN = "Jurusan";
    public static final String COLUMN_JURUSAN_ID = "id";
    public static final String COLUMN_JURUSAN_UNIVERSITAS = "universitas";
    public static final String COLUMN_JURUSAN_NAMA = "nama";
    public static final String COLUMN_JURUSAN_AKREDITASI = "akreditasi";
    public static final String COLUMN_JURUSAN_PASSINGGRADE = "passing_grade";

    //SQL statement for Siswa table creation
    private static final String SQL_CREATE_TABLE_SISWA = "CREATE TABLE " + TABLE_SISWA + "("
            + COLUMN_SISWA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_SISWA_EMAIL + " TEXT NOT NULL, "
            + COLUMN_SISWA_PASSWORD + " TEXT NOT NULL, "
            + COLUMN_SISWA_NAMA + " TEXT NOT NULL, "
            + COLUMN_SISWA_KELAMIN + " TEXT, "
            + COLUMN_SISWA_TANGGALLAHIR + " TEXT, "
            + COLUMN_SISWA_ASALSEKOLAH + " TEXT NOT NULL, "
            + COLUMN_SISWA_PIL1 + "TEXT, "
            + COLUMN_SISWA_PIL2 + "TEXT, "
            + COLUMN_SISWA_TIPEAKUN + "TEXT, "
            + COLUMN_SISWA_SUBSCRIBE1 + "TEXT, "
            + COLUMN_SISWA_SUBSCRIBE2 + "TEXT, "
            + COLUMN_SISWA_SUBSCRIBE3 + "TEXT, "
            + COLUMN_SISWA_SUBSCRIBE4 + "TEXT, "
            + COLUMN_SISWA_SUBSCRIBE5 + "TEXT, "
            + COLUMN_SISWA_SUBSCRIBE6 + "TEXT, "
            + COLUMN_SISWA_SUBSCRIBE7 + "TEXT, "
            + COLUMN_SISWA_SUBSCRIBE8 + "TEXT, "
            + COLUMN_SISWA_SUBSCRIBE9 + "TEXT, "
            + COLUMN_SISWA_SUBSCRIBE10 + "TEXT "
            +");";

    //SQL statement for Mahasiswa table creation
    private static final String SQL_CREATE_TABLE_MAHASISWA = "CREATE TABLE " + TABLE_MAHASISWA + "("
            + COLUMN_MAHASISWA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_MAHASISWA_EMAIL + " TEXT NOT NULL, "
            + COLUMN_MAHASISWA_PASSWORD + " TEXT NOT NULL, "
            + COLUMN_MAHASISWA_NAMA + " TEXT NOT NULL, "
            + COLUMN_MAHASISWA_KELAMIN + " TEXT, "
            + COLUMN_MAHASISWA_TANGGALLAHIR + " TEXT, "
            + COLUMN_MAHASISWA_ASALUNIVERSITAS + " TEXT NOT NULL "
            +");";

    //SQL statement for Universitas
    private static final String SQL_CREATE_TABLE_UNIVERSITAS = "CREATE TABLE " + TABLE_UNIVERSITAS + "("
            + COLUMN_UNIVERSITAS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_UNIVERSITAS_NAMA + " TEXT NOT NULL, "
            + COLUMN_UNIVERSITAS_ALAMAT + " TEXT NOT NULL, "
            + COLUMN_UNIVERSITAS_TANGGALPENTING + " TEXT, "
            + COLUMN_UNIVERSITAS_JALURMASUK + " TEXT, "
            + COLUMN_UNIVERSITAS_BERITAPENTING + " TEXT "
            +");";

    //SQL statement for Jurusan
    private static final String SQL_CREATE_TABLE_JURUSAN = "CREATE TABLE " + TABLE_JURUSAN + "("
            + COLUMN_JURUSAN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_JURUSAN_UNIVERSITAS + " TEXT NOT NULL, "
            + COLUMN_JURUSAN_NAMA + " TEXT NOT NULL, "
            + COLUMN_JURUSAN_AKREDITASI + " TEXT, "
            + COLUMN_JURUSAN_PASSINGGRADE + " DOUBLE "
            +");";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_MAHASISWA);
        db.execSQL(SQL_CREATE_TABLE_UNIVERSITAS);
        db.execSQL(SQL_CREATE_TABLE_JURUSAN);
        db.execSQL(SQL_CREATE_TABLE_SISWA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w("DBHelper", "Upgrade database from version " + oldVersion + " to " + newVersion);

        //clear data
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MAHASISWA);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SISWA);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_JURUSAN);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_UNIVERSITAS);

        onCreate(db);
    }

    public DBHelper(Context context, String name, CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }
}
