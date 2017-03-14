package com.conways.easycook.activity;

import android.net.Uri;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.conways.easycook.R;
import com.conways.easycook.fragment.SelectFragment;
import com.conways.easycook.fragment.SettingFragment;

public class MainActivity extends BaseActivity implements View.OnClickListener, SelectFragment
        .OnSettingFragmentInteractionListener, SettingFragment.OnSettingFragmentInteractionListener {

    private static final String SELECT_TAG = "select_tag";
    private static final String SETTING_TAG = "setting_tag";
    private static final String CURRENT_MENU = "current_menu";

    private static final int SELECT_MENU = 0;
    private static final int SETTING_MENU = 1;

    private LinearLayout llSelect;
    private ImageView ivSlectIcon;
    private TextView tvSlectText;

    private LinearLayout llSetting;
    private ImageView ivSettingIcon;
    private TextView tvSettingText;

    private FragmentManager fragmentManager;

    private SelectFragment selectFragment;
    private SettingFragment settingFragment;

    private int currentMenu = SELECT_MENU;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        restoreFragment(savedInstanceState);
    }

    private void init() {
        fragmentManager = getSupportFragmentManager();

        llSelect = $(R.id.menu_select);
        llSelect.setOnClickListener(this);
        ivSlectIcon = $(R.id.menu_select_icon);
        tvSlectText = $(R.id.menu_select_text);
        llSetting = $(R.id.menu_setting);
        llSetting.setOnClickListener(this);
        ivSettingIcon = $(R.id.menu_setting_icon);
        tvSettingText = $(R.id.menu_setting_text);
    }

    private void restoreFragment(Bundle savedInstanceState) {
        if (null == savedInstanceState) {
            setMenu(SELECT_MENU);
        } else {
            selectFragment = (SelectFragment) fragmentManager.findFragmentByTag(SELECT_TAG);
            settingFragment = (SettingFragment) fragmentManager.findFragmentByTag(SETTING_TAG);
            currentMenu = savedInstanceState.getInt(CURRENT_MENU, SELECT_MENU);
            setMenu(currentMenu);
        }

    }


    private void setMenu(int id) {
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        resetAll(fragmentTransaction);
        currentMenu = id;
        switch (id) {
            case SELECT_MENU:
                tvSlectText.setTextColor(getColorById(R.color.mainColor));
                ivSlectIcon.setImageResource(R.mipmap.ic_launcher);
                if (selectFragment == null) {
                    selectFragment = SelectFragment.newInstance("11", "22");
                    fragmentTransaction.add(R.id.fragment_hold, selectFragment, SELECT_TAG);
                } else {
                    fragmentTransaction.show(selectFragment);
                }
                break;
            case SETTING_MENU:
                tvSettingText.setTextColor(getColorById(R.color.mainColor));
                ivSettingIcon.setImageResource(R.mipmap.ic_launcher);
                if (settingFragment == null) {
                    settingFragment = SettingFragment.newInstance("33", "44");
                    fragmentTransaction.add(R.id.fragment_hold, settingFragment, SETTING_TAG);
                } else {
                    fragmentTransaction.show(settingFragment);
                }
                break;

            default:
                break;

        }
        fragmentTransaction.commit();
    }


    private void resetAll( FragmentTransaction fragmentTransaction) {
        tvSlectText.setTextColor(getColorById(R.color.mainGray));
        tvSettingText.setTextColor(getColorById(R.color.mainGray));

        ivSlectIcon.setImageResource(R.mipmap.ic_launcher);
        ivSettingIcon.setImageResource(R.mipmap.ic_launcher);


        if (selectFragment != null) {
            fragmentTransaction.hide(selectFragment);
        }
        if (settingFragment != null) {
            fragmentTransaction.hide(settingFragment);
        }

    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(CURRENT_MENU, currentMenu);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.menu_select:
                setMenu(SELECT_MENU);
                break;
            case R.id.menu_setting:
                setMenu(SETTING_MENU);
                break;
            default:
                break;
        }
    }

    @Override
    public void onSettingFragmentInteraction(Uri uri) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
