package online.merkatos.merkatoslinks.feature;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

public class Member_Registry_Activity extends AppCompatActivity implements View.OnClickListener, BottomNavigationView.OnNavigationItemSelectedListener{

    private Button mSubmitBtn;
    private EditText alt_phone;
    private ImageView alt_phone_add_btn;
    private ImageView alt_phone_del_btn;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_user_profile_registry_layout);

        mContext = this;

        CollapsingToolbarLayout cll = findViewById(R.id.ui_alt_title_collapse);
        cll.setVisibility(View.GONE);
        Toolbar toolbar = findViewById(R.id.alt_app_toolbar);
        toolbar.setTitle("Registo");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_24px);
        toolbar.setNavigationOnClickListener(this);

        final Spinner org_name = findViewById(R.id.ui_user_content_org_name_spinner);
        final EditText new_org_name = findViewById(R.id.ui_user_content_org_add);

        //Instantiate phone entry field
        alt_phone = findViewById(R.id.ui_user_profile_alt_phone);

        alt_phone_add_btn = findViewById(R.id.ui_user_profile_alt_phone_add_btn);

        alt_phone_add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setVisibility(View.GONE);
                alt_phone.setVisibility(View.VISIBLE);
                alt_phone_del_btn.setVisibility(View.VISIBLE);
            }
        });

        alt_phone_del_btn = findViewById(R.id.ui_user_profile_alt_phone_delete);
        alt_phone_del_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                v.setVisibility(View.GONE);
                alt_phone.setVisibility(View.GONE);
                alt_phone_add_btn.setVisibility(View.VISIBLE);
            }

        });

        org_name.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == (parent.getCount()-1)){
                    new_org_name.setVisibility(View.VISIBLE);
                }
                 else {
                    new_org_name.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        mSubmitBtn = findViewById(R.id.ui_registry_user_profile_submit);

        //TODO (2): To improve this in order to load the filled  information into the database.
        mSubmitBtn.setOnClickListener(new View.OnClickListener(){
            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    //This callback method is invoked to navigate through the navigation bottom.
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    @Override
    public void onClick(View v) {
        //TODO (1): To optimize later
        finish();
    }
}
