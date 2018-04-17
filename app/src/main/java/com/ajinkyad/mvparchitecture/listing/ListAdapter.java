package com.ajinkyad.mvparchitecture.listing;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ajinkyad.mvparchitecture.R;

import java.util.List;


public class ListAdapter extends RecyclerView.Adapter<ListAdapter.NameItemHolder> {

    private LayoutInflater inflater;
    private Context context;
    private List<String> arrlstData;

    public ListAdapter(Context context, List<String> arrlstData) {
        inflater = LayoutInflater.from(context);
        this.context = context;
        this.arrlstData = arrlstData;
    }

    @Override
    public NameItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NameItemHolder(inflater.inflate(R.layout.custom_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(final NameItemHolder holder, final int position) {
        final String currentData = arrlstData.get(position);
        holder.txtvwTitle.setText(currentData);
    }

    @Override
    public int getItemCount() {
        return arrlstData.size();
    }


    class NameItemHolder extends RecyclerView.ViewHolder {
        TextView txtvwTitle;

        NameItemHolder(View view) {
            super(view);
            txtvwTitle = view.findViewById(R.id.txtvwTitle);
        }
    }


}
