package com.kevin.building.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteOpenHelper extends SQLiteOpenHelper
{

	public static final String DATABASE_NAME = "build.db";
	private static final int DATABASE_VERSION = 1;
	private static final String TABLE_PERSON = "person";
	private SQLiteDatabase db = null;
	private Cursor cursor = null;

	public MySQLiteOpenHelper(Context context, String name, CursorFactory factory, int version)
	{
		super(context, name, factory, version);
		db = this.getWritableDatabase();
	}

	public MySQLiteOpenHelper(Context context)
	{
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		db = this.getWritableDatabase();
	}

	@Override
	public void onCreate(SQLiteDatabase db)
	{
		this.db = db;
		db.execSQL("CREATE TABLE " + TABLE_PERSON + " (" + "id" + " text not null, " + "name" + " text not null, "
				+ "age" + " text" + ");");

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
		// TODO Auto-generated method stub

	}

}
