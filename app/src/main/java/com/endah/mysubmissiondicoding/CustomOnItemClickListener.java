package com.endah.mysubmissiondicoding;

import android.view.View;

public class CustomOnItemClickListener implements View.OnClickListener {
    private int position;
    private ListHistoryAdapter.OnItemClickCallback onItemClickCallback;
    CustomOnItemClickListener(int position, ListHistoryAdapter.OnItemClickCallback onItemClickCallback){
        this.position = position;
        this.onItemClickCallback = onItemClickCallback;
    }
    @Override
    public void onClick(View view) { onItemClickCallback.onItemClicked(view, position); }
    public interface OnItemClickCallback {
    void onItemClicked(View view, int position);


    }
}
