package com.xheghun.notekeeper;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class CourseRecyclerAdapter extends RecyclerView.Adapter<CourseRecyclerAdapter.ViewHolder> {
    private final Context mContext;

    private final LayoutInflater layoutInflater;
    private final List<CourseInfo> mCourses;

    CourseRecyclerAdapter(Context mContext, List<CourseInfo> mNotes) {
        this.mContext = mContext;
        layoutInflater = LayoutInflater.from(mContext);
        this.mCourses = mNotes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.item_note_list, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CourseInfo course = mCourses.get(holder.getAdapterPosition());
        holder.textCourse.setText(course.getTitle());
        holder.mCurrentPosition = holder.getAdapterPosition();
    }

    @Override
    public int getItemCount() {
        return mCourses.size();
    }


    //InnerClass
    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView textCourse;
        public int mCurrentPosition;

        public ViewHolder(View view) {
            super(view);
            textCourse = view.findViewById(R.id.text_title);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, mCourses.get(mCurrentPosition).getTitle(), Snackbar.LENGTH_SHORT).show();
                }
            });
        }
    }
}
