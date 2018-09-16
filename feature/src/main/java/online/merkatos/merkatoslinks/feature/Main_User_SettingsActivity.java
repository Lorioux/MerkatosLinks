package online.merkatos.merkatoslinks.feature;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;

public class Main_User_SettingsActivity extends PreferenceActivity implements SharedPreferences.OnSharedPreferenceChangeListener {
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getLayoutInflater().inflate(R.xml.ui_main_preferences,null);
        addPreferencesFromResource(R.xml.ui_main_preferences);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);

    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {

        //boolean value;

        if (s.contentEquals(getString(R.string.preference_notify_mode_key))) {

           boolean  value = sharedPreferences.getBoolean( s, true );

           Preference notify_mode = getPreferenceManager().findPreference(s);

            if (value == false) {

                notify_mode.setSummary("Não");

            } else {
                notify_mode.setSummary("Sim");
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sharedPreferences.unregisterOnSharedPreferenceChangeListener(this);
    }
}
