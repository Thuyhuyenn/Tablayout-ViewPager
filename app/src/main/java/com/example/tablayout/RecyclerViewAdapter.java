package com.example.tablayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide; // Cần thêm thư viện Glide/Picasso trong build.gradle

import java.util.List;
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private final List<SampleModel> dataList;
    private final Context context;

    public RecyclerViewAdapter(Context context, List<SampleModel> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SampleModel model = dataList.get(position);

        holder.titleTextView.setText(model.getTitle());

        // Sử dụng Glide để tải ảnh (Giả định đã thêm thư viện Glide)
        // Trong dự án thực tế, bạn cần thêm implementation 'com.github.bumptech.glide:glide:4.12.0'
        // và <uses-permission android:name="android.permission.INTERNET" />
        Glide.with(context)
                .load(model.getImageUrl())
                .placeholder(R.drawable.ic_launcher_background) // Ảnh placeholder
                .error(R.drawable.ic_launcher_background) // Ảnh lỗi
                .into(holder.imageView);

        // Xử lý sự kiện click
        holder.itemView.setOnClickListener(v -> {
            Toast.makeText(context, "Clicked: " + model.getTitle(), Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView titleTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item_image);
            titleTextView = itemView.findViewById(R.id.item_title);
        }
    }
}
