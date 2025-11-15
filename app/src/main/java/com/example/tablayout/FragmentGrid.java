package com.example.tablayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FragmentGrid extends Fragment {

    public FragmentGrid() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Sử dụng layout chung cho Fragment
        View view = inflater.inflate(R.layout.fragment_common, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        // 2. Dùng GridLayoutManager (2 cột)
        // Các item sẽ được bố trí theo dạng lưới 2 cột
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        // Tạo dữ liệu mẫu
        List<SampleModel> data = createSampleData(30, "Grid Item ");

        // Thiết lập Adapter
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getContext(), data);
        recyclerView.setAdapter(adapter);

        return view;
    }

    // Hàm tạo dữ liệu mẫu
    private List<SampleModel> createSampleData(int count, String prefix) {
        List<SampleModel> list = new ArrayList<>();
        // Sử dụng các placeholder ảnh khác để dễ phân biệt với Tab 1
        String[] imageUrls = {
                "https://placehold.co/400x200/ff66b2/white?text=Tab+2",
                "https://placehold.co/400x200/66b2ff/white?text=Layout+Grid",
                "https://placehold.co/400x200/b2ff66/black?text=Sample+Data"
        };
        for (int i = 1; i <= count; i++) {
            String url = imageUrls[i % imageUrls.length];
            list.add(new SampleModel(prefix + i, url));
        }
        return list;
    }
}