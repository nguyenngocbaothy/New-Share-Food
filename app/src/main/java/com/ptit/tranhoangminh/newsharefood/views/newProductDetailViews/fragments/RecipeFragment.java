package com.ptit.tranhoangminh.newsharefood.views.newProductDetailViews.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ptit.tranhoangminh.newsharefood.R;

public class RecipeFragment extends Fragment {
    TextView tvRecipe;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            String materials = bundle.getString("recipe");
            tvRecipe.setText(materials);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recipe,null);
        tvRecipe = view.findViewById(R.id.textviewNewRecipe);
        return view;
    }

    public void setRecipe(String recipe) {
        tvRecipe.setText(recipe);
    }
}
