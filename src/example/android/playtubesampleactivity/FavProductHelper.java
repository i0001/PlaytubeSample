package example.android.playtubesampleactivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class FavProductHelper extends SQLiteOpenHelper{

	private static int DB_VERSION = 1;
    private static String DB_FILENAME= "favDb";

	public FavProductHelper(Context con) {
		//SQLiteOpenHelperのコンストラクタ呼び出し
		super(con,DB_FILENAME,null,DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table favorite ( _id integer primary key autoincrement, title text not null, content text not null, thumbnail text not null );"
				);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + DB_FILENAME);
	      onCreate(db);

	}}