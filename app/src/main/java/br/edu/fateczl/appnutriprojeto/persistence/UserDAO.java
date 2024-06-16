package br.edu.fateczl.appnutriprojeto.persistence;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import br.edu.fateczl.appnutriprojeto.model.User;

public class UserDAO {
    private SQLiteDatabase db;

    public UserDAO(Context context) {
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public long addUser(User user) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_USER_LOGIN, user.getLogin());
        values.put(DatabaseHelper.COLUMN_USER_PASSWORD, user.getPassword());
        values.put(DatabaseHelper.COLUMN_USER_HEIGHT, user.getHeight());
        values.put(DatabaseHelper.COLUMN_USER_AGE, user.getAge());
        values.put(DatabaseHelper.COLUMN_USER_WEIGHT, user.getWeight());

        return db.insert(DatabaseHelper.TABLE_USERS, null, values);
    }

    public User getUser(String login, String password) {
        String[] columns = {
                DatabaseHelper.COLUMN_USER_ID,
                DatabaseHelper.COLUMN_USER_LOGIN,
                DatabaseHelper.COLUMN_USER_PASSWORD,
                DatabaseHelper.COLUMN_USER_HEIGHT,
                DatabaseHelper.COLUMN_USER_AGE,
                DatabaseHelper.COLUMN_USER_WEIGHT
        };
        String selection = DatabaseHelper.COLUMN_USER_LOGIN + " = ? AND " + DatabaseHelper.COLUMN_USER_PASSWORD + " = ?";
        String[] selectionArgs = {login, password};

        Cursor cursor = db.query(DatabaseHelper.TABLE_USERS, columns, selection, selectionArgs, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            User user = new User();
            user.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_USER_ID)));
            user.setLogin(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_USER_LOGIN)));
            user.setPassword(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_USER_PASSWORD)));
            user.setHeight(cursor.getFloat(cursor.getColumnIndex(DatabaseHelper.COLUMN_USER_HEIGHT)));
            user.setAge(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_USER_AGE)));
            user.setWeight(cursor.getFloat(cursor.getColumnIndex(DatabaseHelper.COLUMN_USER_WEIGHT)));
            cursor.close();
            return user;
        } else {
            return null;
        }
    }

    public User getUserById(int userId) {
        String[] columns = {
                DatabaseHelper.COLUMN_USER_ID,
                DatabaseHelper.COLUMN_USER_LOGIN,
                DatabaseHelper.COLUMN_USER_PASSWORD,
                DatabaseHelper.COLUMN_USER_HEIGHT,
                DatabaseHelper.COLUMN_USER_AGE,
                DatabaseHelper.COLUMN_USER_WEIGHT
        };
        String selection = DatabaseHelper.COLUMN_USER_ID + " = ?";
        String[] selectionArgs = {String.valueOf(userId)};

        Cursor cursor = db.query(DatabaseHelper.TABLE_USERS, columns, selection, selectionArgs, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            User user = new User();
            user.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_USER_ID)));
            user.setLogin(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_USER_LOGIN)));
            user.setPassword(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_USER_PASSWORD)));
            user.setHeight(cursor.getFloat(cursor.getColumnIndex(DatabaseHelper.COLUMN_USER_HEIGHT)));
            user.setAge(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_USER_AGE)));
            user.setWeight(cursor.getFloat(cursor.getColumnIndex(DatabaseHelper.COLUMN_USER_WEIGHT)));
            cursor.close();
            return user;
        } else {
            return null;
        }
    }

    public void updateUser(User user) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_USER_HEIGHT, user.getHeight());
        values.put(DatabaseHelper.COLUMN_USER_AGE, user.getAge());
        values.put(DatabaseHelper.COLUMN_USER_WEIGHT, user.getWeight());

        String selection = DatabaseHelper.COLUMN_USER_ID + " = ?";
        String[] selectionArgs = {String.valueOf(user.getId())};

        db.update(DatabaseHelper.TABLE_USERS, values, selection, selectionArgs);
    }
}
