package com.xheghun.notekeeper;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import static com.xheghun.notekeeper.CourseEventBroadcastHelper.PACKAGE_NAME;

public class NoteReminderReceiver extends BroadcastReceiver {

    public static final String EXTRA_NOTE_TITLE = PACKAGE_NAME+"extra.NOTE_TITLE";
    public static final String EXTRA_NOTE_TEXT = PACKAGE_NAME+"extra.NOTE_TEXT";
    public static final String EXTRA_NOTE_ID = PACKAGE_NAME+"extra.NOTE_ID";
    @Override
    public void onReceive(Context context, Intent intent) {
        String noteTitle = intent.getStringExtra(EXTRA_NOTE_TITLE);
        String noteText = intent.getStringExtra(EXTRA_NOTE_TEXT);
        int noteId = intent.getIntExtra(EXTRA_NOTE_ID,0);

        NoteReminderNotification.notify(context,noteTitle,noteText,noteId);
    }
}
