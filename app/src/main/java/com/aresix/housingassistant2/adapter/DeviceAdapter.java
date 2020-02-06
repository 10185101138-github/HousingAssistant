package com.aresix.housingassistant2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aresix.housingassistant2.R;

public class DeviceAdapter extends RecyclerView.Adapter<DeviceAdapter.DeviceViewHolder> {

    private Context mContext;
    private OnItemClickListener mListener;

    private int[] mDrawables={R.drawable.air_conditoner,R.drawable.tv,R.drawable.player,R.drawable.curtain,
            R.drawable.illumination,R.drawable.add_dev};
    private String[] mName={"空调","电视","音响","窗帘","照明","添加设备"};

    public DeviceAdapter(Context context, OnItemClickListener listener) {
        mContext = context;
        mListener = listener;
    }

    @NonNull
    @Override
    public DeviceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DeviceViewHolder(LayoutInflater.from(mContext)
                .inflate(R.layout.activity_device_adapter,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DeviceViewHolder holder, final int position) {
        holder.dev.setImageResource(mDrawables[position]);
        holder.name.setText(mName[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDrawables.length;
    }

    class DeviceViewHolder extends RecyclerView.ViewHolder{

        private ImageView dev;
        private TextView name;
        public DeviceViewHolder(@NonNull View itemView) {
            super(itemView);
            dev=itemView.findViewById(R.id.deviceTypePic);
            name=itemView.findViewById(R.id.deviceType);
        }
    }

    public interface OnItemClickListener{
        void onClick(int pos);
    }
}
