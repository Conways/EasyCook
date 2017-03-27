package com.conways.easycook.fragment;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.conways.easycook.Adapter.CookTypeAdapter;
import com.conways.easycook.R;
import com.conways.easycook.config.Config;
import com.conways.easycook.entity.CookType;

import java.util.ArrayList;
import java.util.List;

public class SelectFragment extends BaseFragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnSettingFragmentInteractionListener mListener;


    private SensorManager sensorManager;
    private Vibrator vibrator;
    private TextView tvTitle;
    private RecyclerView rvType;
    private CookTypeAdapter cookTypeAdapter;
    private List<CookType> list;

    public SelectFragment() {
    }

    public static SelectFragment newInstance(String param1, String param2) {
        SelectFragment fragment = new SelectFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_select, container, false);
        return view;
    }

    @Override
    protected void initTitle() {
        tvTitle=$(R.id.title_title);
        tvTitle.setVisibility(View.VISIBLE);
        tvTitle.setText(getText(R.string.menu_select));
    }


    @Override
    protected void initContent() {
        rvType=$(R.id.rv);
        rvType.setLayoutManager(new GridLayoutManager(getActivity(),2));
        list=new ArrayList<>();
        for (int i = 0; i <8 ; i++) {
            CookType cookType=new CookType();
            cookType.setName(i+" 种类");
            list.add(cookType);
        }
        cookTypeAdapter=new CookTypeAdapter(list,getActivity());
        rvType.setAdapter(cookTypeAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        updateManager();
    }

    @Override
    public void onPause() {
        super.onPause();
        sensorManager.unregisterListener(eventListener);
    }


    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {
            sensorManager.unregisterListener(eventListener);
        } else {
            updateManager();
        }
    }

    private void updateManager() {
        if (sensorManager == null) {
            sensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        }
        if (vibrator == null) {
            vibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
        }
        sensorManager.registerListener(eventListener, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
    }


    private SensorEventListener eventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {


            float[] values = event.values;
            float x = values[0];
            float y = values[1];
            float z = values[2];
            int medumValue = 19;
            if (Math.abs(x) > medumValue || Math.abs(y) > medumValue || Math.abs(z) > medumValue) {
                if (Config.rockable) {
                    vibrator.vibrate(200);
                }
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    };


    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onSettingFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnSettingFragmentInteractionListener) {
            mListener = (OnSettingFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnSettingFragmentInteractionListener {
        // TODO: Update argument type and name
        void onSettingFragmentInteraction(Uri uri);
    }
}
