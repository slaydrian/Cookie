package a18080.a0.a0.http127.cookie;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;

public class DBHandler extends SQLiteOpenHelper {
    //information of database
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "coupleDB.db";
    public static final String TABLE_NAME = "Couple";
    public static final String COLUMN_COUPLE_NAME = "coupleName";
    public static final String COLUMN_NAME1 = "name1";
    public static final String COLUMN_NAME2 = "name2";

    //initialize the database
    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE" + TABLE_NAME + "(" + COLUMN_COUPLE_NAME + "TEXT COUPLENAME," + COLUMN_NAME1 + "TEXT," + COLUMN_NAME2 + "TEXT )";
        db.execSQL(CREATE_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,
                          int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }
    public String loadHandler() {
        String result = "";
        String query = "Select*FROM" + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            int result_0 = cursor.getInt(0);
            String result_1 = cursor.getString(1);
            result += String.valueOf(result_0) + " " + result_1 +
                    System.getProperty("line.separator");
        }
        cursor.close();
        db.close();
        return result;
    }
    public void addHandler(Couple couple) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_COUPLE_NAME, couple.getCoupleName());
        values.put(COLUMN_NAME1, couple.getName(1));
        values.put(COLUMN_NAME2, couple.getName(2));
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME, null, values);
        db.close();
    }
    public Couple findHandler(String coupleName) {
        String query = "Select * FROM " + TABLE_NAME + "WHERE" + COLUMN_COUPLE_NAME + " = " + "'" + coupleName + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Couple couple = new Couple();
        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            couple.setCoupleName(cursor.getString(0));
            couple.setName(1, cursor.getString(1));
            couple.setName(2, cursor.getString(2));
            cursor.close();
        } else {
            couple = null;
        }
        db.close();
        return couple;
    }
    public boolean deleteHandler(String coupleName) {
        boolean result = false;
        String query = "Select*FROM" + TABLE_NAME + "WHERE" + COLUMN_COUPLE_NAME + "= '" + coupleName + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Couple couple = new Couple();
        if (cursor.moveToFirst()) {
            couple.setCoupleName(cursor.getString(0));
            db.delete(TABLE_NAME, COLUMN_COUPLE_NAME + "=?",
                    new String[] {
                couple.getCoupleName()
            });
            cursor.close();
            result = true;
        }
        db.close();
        return result;
    }
    public boolean updateHandler(String couplename, String name1, String name2) {
        SQLiteDatabase db = this
                .getWritableDatabase();
        ContentValues args = new ContentValues();
        args.put(COLUMN_COUPLE_NAME, couplename);
        args.put(COLUMN_NAME1, name1);
        args.put(COLUMN_NAME2, name2);
        return db.update(TABLE_NAME, args, COLUMN_COUPLE_NAME + "=" + couplename, null) > 0;
    }
}
