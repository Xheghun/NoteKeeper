package com.xheghun.notekeeper;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.net.Uri;
import android.os.AsyncTask;

public class NoteUploaderJobService extends JobService {
    public static final String EXTRA_DATA_URI = "com.xheghun.extras.DATA_URI";
    private NoteUploader noteUploader;

    public NoteUploaderJobService() {
    }

    @Override
    public boolean onStartJob(final JobParameters jobParameters) {
        AsyncTask<JobParameters,Void,Void> task = new AsyncTask<JobParameters, Void, Void>() {
            @Override
            protected Void doInBackground(JobParameters... backgroundJobParameters) {
                JobParameters jobParams = backgroundJobParameters[0];
                String stringDataUri = jobParams.getExtras().getString(EXTRA_DATA_URI);
                Uri dataUri = Uri.parse(stringDataUri);
                noteUploader.doUpload(dataUri);

                if (!noteUploader.isCanceled())
                    jobFinished(jobParams,false);
                return null;
            }
        };

        noteUploader = new NoteUploader(this);
        task.execute(jobParameters);
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        noteUploader.cancel();
        return true;
    }
}
