package com.example.tablayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment {
    private static final String ARG_LAYOUT_TYPE = "layout_type";
    private int layoutType;

    public static ListFragment newInstance(int layoutType) {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_LAYOUT_TYPE, layoutType);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            layoutType = getArguments().getInt(ARG_LAYOUT_TYPE);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);

        // Tạo dữ liệu mẫu
        List<Item> items = createSampleData();

        // Thiết lập LayoutManager và Adapter theo loại
        switch (layoutType) {
            case 0: // Linear
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                recyclerView.setAdapter(new ItemAdapter(items, R.layout.item_linear));
                break;
            case 1: // Grid
                recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
                recyclerView.setAdapter(new ItemAdapter(items, R.layout.item_grid));
                break;
            case 2: // Staggered
                recyclerView.setLayoutManager(
                        new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
                recyclerView.setAdapter(new ItemAdapter(items, R.layout.item_staggered));
                break;
        }

        return view;
    }

    private List<Item> createSampleData() {
        List<Item> items = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            items.add(new Item(
                    "Item " + i,
                    "Description for item " + i,
                    android.R.drawable.ic_dialog_info
            ));
        }
        return items;
    }
}