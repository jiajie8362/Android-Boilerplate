package cn.funvideo.android_boilerplate.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class RibotsAdapter extends RecyclerView.Adapter<RibotsAdapter.RibotViewHolder> {
    @Override
    public RibotViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RibotViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class RibotViewHolder extends RecyclerView.ViewHolder {
        public RibotViewHolder(View itemView) {
            super(itemView);
        }
    }
}
