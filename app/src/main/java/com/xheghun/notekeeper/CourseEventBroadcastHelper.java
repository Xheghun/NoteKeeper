package com.xheghun.notekeeper;

import android.content.Context;
import android.content.Intent;

public class CourseEventBroadcastHelper {
    public static final String PACKAGE_NAME = "com.xheghun.notekeeper.";

    public static final String ACTION_COURSE_EVENT = PACKAGE_NAME+"action.COURSE_EVENT";
    public static final String EXTRA_COURSE_ID = PACKAGE_NAME + "extra.COURSE_ID";
    public static final String EXTRA_COURSE_MESSAGE = PACKAGE_NAME+"extra.COURSE_MESSAGE";

    public static void sendEventBroadcast(Context context, String courseId, String courseMessage) {
        Intent intent = new Intent(ACTION_COURSE_EVENT);
        intent.putExtra(EXTRA_COURSE_ID, courseId);
        intent.putExtra(EXTRA_COURSE_MESSAGE, courseMessage);
        context.sendBroadcast(intent);
    }
}
