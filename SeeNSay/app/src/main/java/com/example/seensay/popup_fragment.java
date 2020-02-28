package com.example.seensay;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class popup_fragment extends Fragment {
    Icon picParam;
    Text nameParam;
    TextView name;
    ImageView pic;
    Button dismissButton;

    public popup_fragment() {
    }

    public static popup_fragment newInstance(Icon picParam, Text nameParam) {
        popup_fragment fragment = new popup_fragment();
        fragment.picParam = picParam;
        fragment.nameParam = nameParam;
        return fragment;
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.popup_fragment_layout, container, false);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Set values for view here
        pic = view.findViewById(R.id.pic);
        name = view.findViewById(R.id.name);

        pic.setImageIcon(picParam);
        name.setText((CharSequence) nameParam);
    }

}
