package com.example.rememberme;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class database {
	public static final String KEY_ROWID = "_id";
	public static final String KEY_NAME = "persons_name";
	public static final String KEY_RELATION = "persons_relation";
	public static final String KEY_BIRTHDAY = "persons_birthday";
	public static final String KEY_CELL = "persons_cell";
	public static final String KEY_EMAIL = "persons_email";
	public static final String KEY_ADDRESS = "persons_address";
	
	
	private static final String DATABASE_NAME = "FriendInfo";
	private static final String DATABASE_TABLE = "personalinfo";
	private static final int DATABASE_VERSION = 3;
	
	private DbHelper ourHelper;
	private final Context ourContext;
	private SQLiteDatabase ourDatabase;
	
	
	private static class DbHelper extends SQLiteOpenHelper{

		public DbHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			db.execSQL("CREATE TABLE " + DATABASE_TABLE + " (" +
					KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
					KEY_NAME + " TEXT NOT NULL, " +
					KEY_RELATION + " TEXT NOT NULL, " +
					KEY_BIRTHDAY + " TEXT NOT NULL, " +
					KEY_CELL + " TEXT NOT NULL, " +
					KEY_EMAIL + " TEXT NOT NULL, " +
					KEY_ADDRESS + " TEXT NOT NULL);"
			);
			
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
			onCreate(db);
		}
		
	}
	public database(Context c){
		ourContext = c;
	}
	public database open() throws SQLException{
		ourHelper = new DbHelper(ourContext);
		ourDatabase = ourHelper.getWritableDatabase();
		return this;
	}
	public void close(){
		ourHelper.close();
	}
	public long createEntry(String name, String relation, String birthday, String cell, String email, String address) {
		// TODO Auto-generated method stub
		ContentValues cv = new ContentValues();
		cv.put(KEY_NAME, name);
		cv.put(KEY_RELATION, relation);
		cv.put(KEY_BIRTHDAY, birthday);
		cv.put(KEY_CELL, cell);
		cv.put(KEY_EMAIL, email);
		cv.put(KEY_ADDRESS, address);
		return ourDatabase.insert(DATABASE_TABLE, null, cv);
	}
	public String getData() {
		// TODO Auto-generated method stub
		String[] columns = new String[]{ KEY_ROWID, KEY_NAME, KEY_RELATION, KEY_BIRTHDAY};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, null, null, null, null, null);
		String result = "";
		int iRow = c.getColumnIndex(KEY_ROWID);
		int iname = c.getColumnIndex(KEY_NAME);
		int irelation = c.getColumnIndex(KEY_RELATION);
		int ibirthday = c.getColumnIndex(KEY_BIRTHDAY);
		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
			result = result + c.getString(iRow) + " " + c.getString(iname) + " " + c.getString(irelation) + " " + c.getString(ibirthday) + "\n" ;			
		}
		return result;
	}
	public String getName(long l) {
		// TODO Auto-generated method stub
		String[] columns = new String[]{ KEY_ROWID, KEY_NAME, KEY_RELATION, KEY_BIRTHDAY};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, KEY_ROWID + "=" + l, null, null, null, null);
		if (c != null){
			c.moveToFirst();
			String name = c.getString(1);
			return name;
		}
		return null;
	}
	public String getRelation(long l) {
		// TODO Auto-generated method stub
		String[] columns = new String[]{ KEY_ROWID, KEY_NAME, KEY_RELATION, KEY_BIRTHDAY};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, KEY_ROWID + "=" + l, null, null, null, null);
		if (c != null){
			c.moveToFirst();
			String relation = c.getString(2);
			return relation;
		}
		
		return null;
	}
	public String getBday(long l) {
		// TODO Auto-generated method stub
		String[] columns = new String[]{ KEY_ROWID, KEY_NAME, KEY_RELATION, KEY_BIRTHDAY};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, KEY_ROWID + "=" + l, null, null, null, null);
		if (c != null){
			c.moveToFirst();
			String bday = c.getString(3);
			return bday;
		}
		
		return null;
	}
	
	public String getCell(String name) {
		// TODO Auto-generated method stub
		String[] columns = new String[]{ KEY_ROWID, KEY_NAME, KEY_RELATION, KEY_BIRTHDAY, KEY_CELL, KEY_EMAIL, KEY_ADDRESS};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns,KEY_NAME + " = ?", new String[] {
                "" + name
            }, null, null, null);
		
		if (c != null){
			c.moveToFirst();
			String cell = c.getString(4);
			return cell;
		}
		return null;
	}
	
	public String getDatabyName(String name) {
		
		String[] columns = new String[]{ KEY_ROWID, KEY_NAME, KEY_RELATION, KEY_BIRTHDAY, KEY_CELL, KEY_EMAIL, KEY_ADDRESS};
		
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns,KEY_NAME + " = ?", new String[] {
                "" + name
            }, null, null, null);
		
		String result = "";
		int iRow = c.getColumnIndex(KEY_ROWID);
		int iname = c.getColumnIndex(KEY_NAME);
		int irelation = c.getColumnIndex(KEY_RELATION);
		int ibirthday = c.getColumnIndex(KEY_BIRTHDAY);
		int icell = c.getColumnIndex(KEY_CELL);
		int iemail = c.getColumnIndex(KEY_EMAIL);
		int iaddress = c.getColumnIndex(KEY_ADDRESS);
		
		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
			result = result +"id:"+ c.getString(iRow) + "\n" +"name: "+ c.getString(iname) + "\n" +"relation: "+ c.getString(irelation) + "\n" +"birthday: "+ c.getString(ibirthday) + "\n" + "Cell Number:" + c.getString(icell) +"\n" + "Email:" + c.getString(iemail) + "\n" +"Address: " + c.getString(iaddress) +"\n" ;			
		}
		
		return result;
	}
	
public String getNamebyName(String name) {
		
		String[] columns = new String[]{ KEY_ROWID, KEY_NAME, KEY_RELATION, KEY_BIRTHDAY, KEY_CELL, KEY_EMAIL, KEY_ADDRESS};
		
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns,KEY_NAME + " = ?", new String[] {
                "" + name
            }, null, null, null);
		
		String result = "";
		int iRow = c.getColumnIndex(KEY_ROWID);
		int iname = c.getColumnIndex(KEY_NAME);
		int irelation = c.getColumnIndex(KEY_RELATION);
		int ibirthday = c.getColumnIndex(KEY_BIRTHDAY);
		int icell = c.getColumnIndex(KEY_CELL);
		int iemail = c.getColumnIndex(KEY_EMAIL);
		int iaddress = c.getColumnIndex(KEY_ADDRESS);
		
		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
			result =c.getString(iname) ;			
		}
		return result;
	}

public String getCellbyName(String name) {
	
	String[] columns = new String[]{ KEY_ROWID, KEY_NAME, KEY_RELATION, KEY_BIRTHDAY, KEY_CELL, KEY_EMAIL, KEY_ADDRESS};
	
	Cursor c = ourDatabase.query(DATABASE_TABLE, columns,KEY_NAME + " = ?", new String[] {
            "" + name
        }, null, null, null);
	
	String result = "";
	int iRow = c.getColumnIndex(KEY_ROWID);
	int iname = c.getColumnIndex(KEY_NAME);
	int irelation = c.getColumnIndex(KEY_RELATION);
	int ibirthday = c.getColumnIndex(KEY_BIRTHDAY);
	int icell = c.getColumnIndex(KEY_CELL);
	int iemail = c.getColumnIndex(KEY_EMAIL);
	int iaddress = c.getColumnIndex(KEY_ADDRESS);
	
	for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
		result =c.getString(icell) ;			
	}
	return result;
}
public String getBdaybyName(String n_ame) {
	// TODO Auto-generated method stub
	String[] columns = new String[]{ KEY_ROWID, KEY_NAME, KEY_RELATION, KEY_BIRTHDAY, KEY_CELL, KEY_EMAIL, KEY_ADDRESS};
	
	Cursor c = ourDatabase.query(DATABASE_TABLE, columns,KEY_NAME + " = ?", new String[] {
            "" + n_ame
        }, null, null, null);
	
	String result = "";
	int iRow = c.getColumnIndex(KEY_ROWID);
	int iname = c.getColumnIndex(KEY_NAME);
	int irelation = c.getColumnIndex(KEY_RELATION);
	int ibirthday = c.getColumnIndex(KEY_BIRTHDAY);
	int icell = c.getColumnIndex(KEY_CELL);
	int iemail = c.getColumnIndex(KEY_EMAIL);
	int iaddress = c.getColumnIndex(KEY_ADDRESS);
	
	for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
		result =c.getString(ibirthday) ;			
	}
	return result;
}

//----------------------------------Etotuk Ami Kaj Korsi
public Cursor fetchAllEntries() {

	Cursor Cursor = ourDatabase.query(DATABASE_TABLE, null, null, null, null, null, null);
		 
		  if (Cursor != null) {
		   Cursor.moveToFirst();
		  }
		  return Cursor;
}
public Cursor GetFriendInfo(long idOnClick) {

String where = KEY_ROWID + "=" + idOnClick;
Cursor c = 	ourDatabase.query(true, DATABASE_TABLE, null, where, null, null, null, null, null);
if (c != null) {
	c.moveToFirst();
}
return c;
}
//----------------------------------


}
