package myapp.bmp.com.dbapp.Fragment;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

public class myDB extends SQLiteOpenHelper {

    private static final String create_table = String.format("create table %s(" +
                    "%s TEXT PRIMARY KEY," +
                    "%s TEXT(50)," +
                    "%s TEXT(50))",
            dbinfo.tblogin,
            dbinfo.column.id,
            dbinfo.column.email,
            dbinfo.column.password);

    public myDB(Context context) {
        super(context, dbinfo.dbname, null, dbinfo.dbversion);
    }
    public long InserData(String id,String email,String pwd){
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            String sql=String.format("Insert into %s(%s,%s,%s) values(?,?,?)",
                    dbinfo.tblogin,dbinfo.column.id,dbinfo.column.email,dbinfo.column.password);
            SQLiteStatement stm = db.compileStatement(sql);
            stm.bindString(1,id);
            stm.bindString(2,email);
            stm.bindString(3,pwd);
            db.close();
            Log.d("18SepV1","Insert data complete===>"+sql);
            return stm.executeInsert();

        }catch (Exception e) {
            return -1;
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(create_table);
        Log.d("18SepV1", create_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String strdrop = "Drop table If exists " + dbinfo.tblogin;
        db.execSQL(strdrop);
        onCreate(db);
    }
}
