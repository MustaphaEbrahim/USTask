package com.mostafa.ustask_mostafaibrahim.UI.Main.View;

import static com.mostafa.ustask_mostafaibrahim.Util.SharedPreferenceHelper.nameDelivery;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.mostafa.ustask_mostafaibrahim.databinding.ActivityMainBinding;
import com.mostafa.ustask_mostafaibrahim.UI.Base.BaseActivity;
import com.mostafa.ustask_mostafaibrahim.UI.New.View.NewFragment;
import com.mostafa.ustask_mostafaibrahim.UI.Other.View.OtherFragment;
import com.mostafa.ustask_mostafaibrahim.Util.SharedPreferenceHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private ActivityMainBinding binding;
    private RecyclerViewClickInterface recyclerViewClickInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupView();
        nameDelivery();

    }

    private void nameDelivery() {
        String name = SharedPreferenceHelper.getSharedPreferenceString(getApplication(),nameDelivery,"");
        binding.nameDelivery.setText(name);
    }


    private void setupView() {

        initViewPager();
        binding.tabLayout.setupWithViewPager(binding.pager);


    }

    private void initViewPager() {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new NewFragment(), "  New ");
        adapter.addFragment(new OtherFragment(), "Others");
        binding.pager.setAdapter(adapter);

    }

    @Override
    public void initViewModel() {

    }

    @Override
    public void initObservers() {

    }

    @Override
    public void initErrorObservers() {

    }

    @Override
    public void initLoadingObservers() {

    }


    static class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        ViewPagerAdapter(FragmentManager manager) {
            super(manager, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }




}