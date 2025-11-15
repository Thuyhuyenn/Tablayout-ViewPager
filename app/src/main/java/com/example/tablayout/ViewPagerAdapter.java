package com.example.tablayout;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {

    // Danh sách tiêu đề Tab
    private final String[] tabTitles = new String[]{"Linear Layout", "Grid Layout", "Staggered Grid"};

    public ViewPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // Trả về Fragment tương ứng với vị trí Tab
        switch (position) {
            case 0:
                return new FragmentLinear(); // Sử dụng Linear
            case 1:
                return new FragmentGrid(); // Sử dụng Grid
            case 2:
                return new FragmentStaggered(); // Sử dụng Staggered
            default:
                return new FragmentLinear();
        }
    }

    @Override
    public int getItemCount() {
        return tabTitles.length;
    }

    // Hàm để lấy tiêu đề Tab
    public String getTabTitle(int position) {
        return tabTitles[position];
    }
}