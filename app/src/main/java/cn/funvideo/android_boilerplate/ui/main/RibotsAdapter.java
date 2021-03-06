package cn.funvideo.android_boilerplate.ui.main;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cn.funvideo.android_boilerplate.R;
import cn.funvideo.android_boilerplate.data.model.Ribot;

public class RibotsAdapter extends RecyclerView.Adapter<RibotsAdapter.RibotViewHolder> {

    private List<Ribot> ribots;

    @Override
    public RibotViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_ribot, parent, false);
        return new RibotViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RibotViewHolder holder, int position) {
        Ribot ribot = ribots.get(position);
        holder.hexColorView.setBackgroundColor(Color.parseColor(ribot.profile().hexColor()));
        holder.nameTextView.setText(String.format("%s %s",
                ribot.profile().name().first(), ribot.profile().name().last()));
        holder.emailTextView.setText(ribot.profile().email());
    }

    @Override
    public int getItemCount() {
        return ribots == null ? 0 : ribots.size();
    }

    public void setRibots(List<Ribot> ribots) {
        this.ribots = ribots;
    }

    public class RibotViewHolder extends RecyclerView.ViewHolder {
        View hexColorView;
        TextView nameTextView;
        TextView emailTextView;

        public RibotViewHolder(View itemView) {
            super(itemView);
            hexColorView = itemView.findViewById(R.id.view_hex_color);
            nameTextView = (TextView) itemView.findViewById(R.id.text_name);
            emailTextView = (TextView) itemView.findViewById(R.id.text_email);
        }
    }
}
