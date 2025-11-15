package com.example.tablayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FragmentLinear extends Fragment {

    public FragmentLinear() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_common, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        // 1. Dùng LinearLayoutManager (Mặc định: Vertical)
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Tạo dữ liệu mẫu
        List<SampleModel> data = createSampleData(20, "Linear Item ");

        // Thiết lập Adapter
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getContext(), data);
        recyclerView.setAdapter(adapter);

        return view;
    }

    // Hàm tạo dữ liệu mẫu
    private List<SampleModel> createSampleData(int count, String prefix) {
        List<SampleModel> list = new ArrayList<>();
        String[] imageUrls = {
                "https://placehold.co/400x150/007bff/white?text=Tab+1",
                "https://placehold.co/400x150/28a745/white?text=Layout+Linear",
                "https://placehold.co/400x150/ffc107/black?text=Data+Sample"
        };
        for (int i = 1; i <= count; i++) {
            String url = imageUrls[i % imageUrls.length];
            list.add(new SampleModel(prefix + i, url));
        }
        return list;
    }
}