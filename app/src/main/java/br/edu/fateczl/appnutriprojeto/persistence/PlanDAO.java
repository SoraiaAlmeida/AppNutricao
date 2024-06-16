package br.edu.fateczl.appnutriprojeto.persistence;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import br.edu.fateczl.appnutriprojeto.model.Plan;

import java.util.ArrayList;
import java.util.List;

public class PlanDAO {
    private SQLiteDatabase db;

    public PlanDAO(Context context) {
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public long addPlan(Plan plan) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_PLAN_NAME, plan.getName());
        values.put(DatabaseHelper.COLUMN_PLAN_TYPE, plan.getType());
        values.put(DatabaseHelper.COLUMN_PLAN_DESCRIPTION, plan.getDescription());
        values.put(DatabaseHelper.COLUMN_PLAN_USER_ID, plan.getUserId());

        return db.insert(DatabaseHelper.TABLE_PLANS, null, values);
    }

    @SuppressLint("Range")
    public List<Plan> getPlans(int userId) {
        List<Plan> plans = new ArrayList<>();
        String[] columns = {
                DatabaseHelper.COLUMN_PLAN_ID,
                DatabaseHelper.COLUMN_PLAN_NAME,
                DatabaseHelper.COLUMN_PLAN_TYPE,
                DatabaseHelper.COLUMN_PLAN_DESCRIPTION,
                DatabaseHelper.COLUMN_PLAN_USER_ID
        };
        String selection = DatabaseHelper.COLUMN_PLAN_USER_ID + " = ?";
        String[] selectionArgs = {String.valueOf(userId)};

        Cursor cursor = db.query(DatabaseHelper.TABLE_PLANS, columns, selection, selectionArgs, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                Plan plan = new Plan();
                plan.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PLAN_ID)));
                plan.setName(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_PLAN_NAME)));
                plan.setType(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_PLAN_TYPE)));
                plan.setDescription(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_PLAN_DESCRIPTION)));
                plan.setUserId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PLAN_USER_ID)));
                plans.add(plan);
            } while (cursor.moveToNext());
            cursor.close();
        }
        return plans;
    }

    @SuppressLint("Range")
    public Plan getPlanById(int planId) {
        Plan plan = null;
        String[] columns = {
                DatabaseHelper.COLUMN_PLAN_ID,
                DatabaseHelper.COLUMN_PLAN_NAME,
                DatabaseHelper.COLUMN_PLAN_TYPE,
                DatabaseHelper.COLUMN_PLAN_DESCRIPTION,
                DatabaseHelper.COLUMN_PLAN_USER_ID
        };
        String selection = DatabaseHelper.COLUMN_PLAN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(planId)};

        Cursor cursor = db.query(DatabaseHelper.TABLE_PLANS, columns, selection, selectionArgs, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            plan = new Plan();
            plan.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PLAN_ID)));
            plan.setName(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_PLAN_NAME)));
            plan.setType(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_PLAN_TYPE)));
            plan.setDescription(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_PLAN_DESCRIPTION)));
            plan.setUserId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PLAN_USER_ID)));
            cursor.close();
        }
        return plan;
    }

    public void updatePlan(Plan plan) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_PLAN_NAME, plan.getName());
        values.put(DatabaseHelper.COLUMN_PLAN_TYPE, plan.getType());
        values.put(DatabaseHelper.COLUMN_PLAN_DESCRIPTION, plan.getDescription());

        String selection = DatabaseHelper.COLUMN_PLAN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(plan.getId())};

        db.update(DatabaseHelper.TABLE_PLANS, values, selection, selectionArgs);
    }

    public void deletePlan(int planId) {
        String selection = DatabaseHelper.COLUMN_PLAN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(planId)};

        db.delete(DatabaseHelper.TABLE_PLANS, selection, selectionArgs);
    }
}
