package com.kevin.building.db.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.kevin.building.db.MySQLiteOpenHelper;
import com.kevin.building.db.modle.Person;

public class PersonDao
{
	private static PersonDao instance = null;

	private MySQLiteOpenHelper helper;
	private final String PERSON_TABLE_NAME = "PERSON";

	public static PersonDao getInstance(Context context)
	{
		if (null == instance)
		{
			synchronized (PersonDao.class)
			{
				if (null == instance)
				{
					instance = new PersonDao(context);
				}
			}
		}
		return instance;
	}

	private PersonDao(Context context)
	{
		helper = new MySQLiteOpenHelper(context);
	}

	public boolean insert(Person person)
	{
		SQLiteDatabase db = helper.getWritableDatabase();
		// db.insert(PERSON_TABLE_NAME, nullColumnHack, values)

		return false;
	}
}
