
package com.conways.easycook.activity;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.conways.easycook.Adapter.LanguageSlectAdapter;
import com.conways.easycook.R;
import com.conways.easycook.fragment.SettingFragment;
import com.conways.easycook.sp.SpConstants;
import com.conways.easycook.sp.SpManager;

public class LanguagueSelectActivity extends BaseActivity implements View.OnClickListener {
    private RecyclerView rvLanguagueList;
    private LanguageSlectAdapter slectAdapter;
    private String[] languages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_languague_select);
        initTitle();
        initContent();
    }

    private void initTitle() {
        ivBack = $(R.id.title_back_icon);
        tvTitle = $(R.id.title_title);
        tvAction = $(R.id.title_action_text);
        ivBack.setVisibility(View.VISIBLE);
        tvTitle.setVisibility(View.VISIBLE);
        tvAction.setVisibility(View.VISIBLE);
        ivBack.setOnClickListener(this);
        ivBack.setImageResource(R.drawable.arrow_back_white);
        tvTitle.setText(getText(R.string.language_select));
        tvAction.setText(getText(R.string.save));
        tvAction.setOnClickListener(this);
    }

    private void initContent() {
        languages = getResources().getStringArray(R.array.languages);
        rvLanguagueList = $(R.id.languague_list);
        rvLanguagueList.setLayoutManager(new LinearLayoutManager(this));
        rvLanguagueList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration
                .VERTICAL));
        int position = 0;
        String language = getText(R.string.language_simplified_chinese).toString();
        String languageTag = SpManager.getInstance().getLanguage();
        switch (languageTag) {
            case SpConstants.Langue.LANGUAGE_SIMPLE_CHINESE:
                language = getText(R.string.language_simplified_chinese).toString();
                break;
            case SpConstants.Langue.LANGUAGE_TRADITIONAL_CHINESE:
                language = getText(R.string.language_traditional_chinese).toString();
                break;
            case SpConstants.Langue.LANGUAGE_ENGLISH:
                language = getText(R.string.language_english).toString();
                break;
            case SpConstants.Langue.LANGUAGE_JAPANESE:
                language = getText(R.string.language_japanese).toString();
                break;
            default:
                break;
        }

        for (int i = 0; i < languages.length; i++) {
            if (languages[i].equals(language)) {
                position = i;
                break;
            }
        }
        slectAdapter = new LanguageSlectAdapter(this, languages, position);
        rvLanguagueList.setAdapter(slectAdapter);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.title_back_icon:
                this.finish();
                break;
            case R.id.title_action_text:
                save();
                break;
            default:
                break;
        }
    }


    private void save() {
        String language = languages[slectAdapter.getSlectPosition()];
        if (language.equals(getText(R.string.language_simplified_chinese).toString())) {
            SpManager.getInstance().setLangague(SpConstants.Langue.LANGUAGE_SIMPLE_CHINESE);
        } else if (language.equals(getText(R.string.language_traditional_chinese).toString())) {
            SpManager.getInstance().setLangague(SpConstants.Langue.LANGUAGE_TRADITIONAL_CHINESE);
        } else if (language.equals(getText(R.string.language_english).toString())) {
            SpManager.getInstance().setLangague(SpConstants.Langue.LANGUAGE_ENGLISH);
        } else {
            SpManager.getInstance().setLangague(SpConstants.Langue.LANGUAGE_JAPANESE);
        }
        setResult(SettingFragment.LANGUAGUE_SET_RESULT_CODE);
        this.finish();
    }
}
