package com.conways.easycook.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.conways.easycook.R;
import com.conways.easycook.activity.CookDetailActivity;
import com.conways.easycook.activity.LanguagueSelectActivity;
import com.conways.easycook.config.Config;
import com.conways.easycook.sp.SpConstants;
import com.conways.easycook.sp.SpManager;

/**
 * A simple {@link BaseFragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SettingFragment.OnSettingFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SettingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SettingFragment extends BaseFragment implements CompoundButton
        .OnCheckedChangeListener, View.OnClickListener {

    public static final int LANGUAGUE_SET_REQUEST_CODE = 0x1000;
    public static final int LANGUAGUE_SET_RESULT_CODE = 0x1001;


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnSettingFragmentInteractionListener mListener;

    private TextView tvTitle;
    private CheckBox cbRockAble;

    private FrameLayout flSkin;
    private FrameLayout flLanguagueItem;
    private TextView tvLanguague;

    public SettingFragment() {
    }

    public static SettingFragment newInstance(String param1, String param2) {
        SettingFragment fragment = new SettingFragment();
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
        return inflater.inflate(R.layout.fragment_setting, container, false);
    }


    @Override
    protected void initTitle() {
        tvTitle = $(R.id.title_title);
        tvTitle.setVisibility(View.VISIBLE);
        tvTitle.setText(getText(R.string.menu_setting));
        tvTitle.setOnClickListener(this);

    }

    @Override
    protected void initContent() {
        cbRockAble = $(R.id.rockable_switcher);
        cbRockAble.setOnCheckedChangeListener(this);
        cbRockAble.setChecked(Config.rockable);
        flSkin = $(R.id.skin_item);
        flSkin.setOnClickListener(this);
        flLanguagueItem = $(R.id.languague_item);
        flLanguagueItem.setOnClickListener(this);
        tvLanguague = $(R.id.languague);
        updateLanguage();
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == getActivity().RESULT_CANCELED) {
            return;
        }

        if (requestCode == LANGUAGUE_SET_REQUEST_CODE) {
            updateLanguage();
        }
    }

    private void updateLanguage() {
        String languageTag = SpManager.getInstance().getLanguage();
        switch (languageTag) {
            case SpConstants.Langue.LANGUAGE_SIMPLE_CHINESE:
                tvLanguague.setText(getText(R.string.language_simplified_chinese));
                break;
            case SpConstants.Langue.LANGUAGE_TRADITIONAL_CHINESE:
                tvLanguague.setText(getText(R.string.language_traditional_chinese));
                break;
            case SpConstants.Langue.LANGUAGE_ENGLISH:
                tvLanguague.setText(getText(R.string.language_english));
                break;
            case SpConstants.Langue.LANGUAGE_JAPANESE:
                tvLanguague.setText(getText(R.string.language_japanese));
                break;
            default:
                break;


        }
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
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

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked == Config.rockable) {
            return;
        }
        Config.rockable = isChecked;
        SpManager.getInstance().setRockable(isChecked);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.languague_item:
                toTargetActivityForReasult(LanguagueSelectActivity.class, LANGUAGUE_SET_REQUEST_CODE);
//                showProgress("请求中..");
                break;
            case R.id.skin_item:
//                showProgress("请求中..");
                toTargetActivity(CookDetailActivity.class);
                break;

            default:
                break;


        }
    }

    public interface OnSettingFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
