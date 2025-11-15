package com.example.tablayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FragmentStaggered extends Fragment {

    public FragmentStaggered() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Sử dụng layout chung cho Fragment
        View view = inflater.inflate(R.layout.fragment_common, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        // Lưu ý: Không cần setHasFixedSize(true) với StaggeredGridLayoutManager
        // vì các item có thể có chiều cao khác nhau.

        // 3. Dùng StaggeredGridLayoutManager (2 cột, cuộn dọc)
        // Layout này tạo ra hiệu ứng "zích-zắc" với các item có chiều cao khác nhau.
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        // Tạo dữ liệu mẫu
        List<SampleModel> data = createSampleData(40, "Staggered Item ");

        // Thiết lập Adapter
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getContext(), data);
        recyclerView.setAdapter(adapter);

        return view;
    }

    // Hàm tạo dữ liệu mẫu với chiều cao ảnh ngẫu nhiên để mô phỏng hiệu ứng Staggered
    private List<SampleModel> createSampleData(int count, String prefix) {
        List<SampleModel> list = new ArrayList<>();
        Random random = new Random();
        // Placeholder ảnh với chiều cao khác nhau (150px, 250px, 350px)
        String[] heightUrls = {
                "https://placehold.co/400x150/ff9966/white?text=Short+Item",
                "https://placehold.co/400x250/66ff99/black?text=Medium+Item",
                "https://placehold.co/400x350/9966ff/white?text=Tall+Item"
        };
        for (int i = 1; i <= count; i++) {
            // Lấy URL ngẫu nhiên để tạo item có chiều cao khác nhau
            String url = heightUrls[random.nextInt(heightUrls.length)];
            list.add(new SampleModel(prefix + i, url));
        }
        return list;
    }
}