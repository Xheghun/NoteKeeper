package com.xheghun.notekeeper;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Xheghun.
 */

public class DatabaseDataWorker {
    private SQLiteDatabase mDb;

    public DatabaseDataWorker(SQLiteDatabase db) {
        mDb = db;
    }

    public void insertCourses() {
        insertCourse("study", "Study");
        insertCourse("work", "Work");
        insertCourse("personal_development", "Personal Development");
        insertCourse("un_categorized", "Un-categorized");
    }

    public void insertSampleNotes() {
        insertNote("study", "Sample Study Title", "Sample Study Text");
        insertNote("work", "Sample Work Title", "Sample Work Text");
        insertNote("personal_development", "Sample Personal Dev Title", "Sample Personal Dev Text");
        insertNote("un_categorized", "Sample Un-categorized Title", "Nothing Here!");
    }

    private void insertCourse(String courseId, String title) {
        ContentValues values = new ContentValues();
        values.put(NoteKeeperDatabaseContract.CourseInfoEntry.COLUMN_COURSE_ID, courseId);
        values.put(NoteKeeperDatabaseContract.CourseInfoEntry.COLUMN_COURSE_TITLE, title);

        long newRowId = mDb.insert(NoteKeeperDatabaseContract.CourseInfoEntry.TABLE_NAME, null, values);
    }

     private void insertNote(String courseId, String title, String text) {
        ContentValues values = new ContentValues();
        values.put(NoteKeeperDatabaseContract.NoteInfoEntry.COLUMN_COURSE_ID, courseId);
        values.put(NoteKeeperDatabaseContract.NoteInfoEntry.COLUMN_NOTE_TITLE, title);
        values.put(NoteKeeperDatabaseContract.NoteInfoEntry.COLUMN_NOTE_TEXT, text);

        long newRowId = mDb.insert(NoteKeeperDatabaseContract.NoteInfoEntry.TABLE_NAME, null, values);
    }

}
