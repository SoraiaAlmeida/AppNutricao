package br.edu.fateczl.appnutriprojeto.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "nutrition.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_USERS = "users";
    public static final String COLUMN_USER_ID = "id";
    public static final String COLUMN_USER_LOGIN = "login";
    public static final String COLUMN_USER_PASSWORD = "password";
    public static final String COLUMN_USER_HEIGHT = "height";
    public static final String COLUMN_USER_AGE = "age";
    public static final String COLUMN_USER_WEIGHT = "weight";

    public static final String TABLE_PLANS = "plans";
    public static final String COLUMN_PLAN_ID = "id";
    public static final String COLUMN_PLAN_NAME = "name";
    public static final String COLUMN_PLAN_TYPE = "type";
    public static final String COLUMN_PLAN_DESCRIPTION = "description";
    public static final String COLUMN_PLAN_USER_ID = "user_id";

    private static final String CREATE_TABLE_USERS = "CREATE TABLE " + TABLE_USERS + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_USER_LOGIN + " TEXT,"
            + COLUMN_USER_PASSWORD + " TEXT,"
            + COLUMN_USER_HEIGHT + " REAL,"
            + COLUMN_USER_AGE + " INTEGER,"
            + COLUMN_USER_WEIGHT + " REAL" + ")";

    private static final String CREATE_TABLE_PLANS = "CREATE TABLE " + TABLE_PLANS + "("
            + COLUMN_PLAN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_PLAN_NAME + " TEXT,"
            + COLUMN_PLAN_TYPE + " TEXT,"
            + COLUMN_PLAN_DESCRIPTION + " TEXT,"
            + COLUMN_PLAN_USER_ID + " INTEGER,"
            + "FOREIGN KEY(" + COLUMN_PLAN_USER_ID + ") REFERENCES " + TABLE_USERS + "(" + COLUMN_USER_ID + ")" + ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USERS);
        db.execSQL(CREATE_TABLE_PLANS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PLANS);
        onCreate(db);
    }
}
