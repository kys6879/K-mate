package com.soksok.kmate.view.recommend.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.soksok.kmate.http.model.Recommend;
import com.soksok.kmate.view.recommend.ListFragment;
import com.soksok.kmate.view.recommend.MateFragment;

import java.util.ArrayList;

public class RecommendAdapter extends FragmentStatePagerAdapter {

    private ArrayList<Recommend> spots;
    private ArrayList<Recommend> restaurants;
    private ArrayList<Recommend> informations;

    public RecommendAdapter(@NonNull FragmentManager fm, int behavior, ArrayList<Recommend> spots, ArrayList<Recommend> restaurants, ArrayList<Recommend> informations) {
        super(fm, behavior);
        this.spots = spots;
        this.restaurants = restaurants;
        this.informations = informations;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: // 메이트
                return new MateFragment();

            case 1: // 관광지
                return new ListFragment(spots);

            case 2: // 맛집
                return new ListFragment(restaurants);

            case 3: // 정보
                return new ListFragment(informations);

            default:
                throw new IllegalArgumentException("unexpected position: " + position);
        }
    }
}
