package com.example.gymbudd;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

public class SettingActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preference);

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        pref.getString("prefUsername","NA");
        pref.getString("prefPassword","NA");
        pref.getString("prefLanguage","English");
        pref.getBoolean("prefTheme",false);
        pref.getBoolean("prefLockScreen",false);
        pref.getString("prefUpdateReminder","Monthly");
        pref.getBoolean("prefStayLoggedIn",true);
        pref.getBoolean("prefSync",false);
        pref.getString("version","NA");


    }
}
