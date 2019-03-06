package com.xheghun.notekeeper;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(JUnit4.class)
public class PracticeTest {
   static DataManager sDataManager;
    @BeforeClass
    public static void setUp() {
        sDataManager = DataManager.getInstance();
    }

    @Rule
    public ActivityTestRule<NoteListActivity> noteListActivityRule =
            new ActivityTestRule<>(NoteListActivity.class);

    @Test
    public void veiwNote() {
        int noteId = sDataManager.getNotes().size() -2;
        onView(withId(R.id.list_notes)).perform(click());
    }
}