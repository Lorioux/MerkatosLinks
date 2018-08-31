package online.merkatos.merkatoslinks.feature;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;

public class Member_Publish_Page_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_member_content_publishing_page);

        //To Take a picture or load from a folder.
        ImageView content_phone = findViewById(R.id.ui_user_content_photo);
        content_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //To add or delete adicional content description field.
        final EditText plus_desc = findViewById(R.id.ui_user_content_desc_plus);
        final ImageButton delete_plus_desc = findViewById(R.id.ui_user_content_desc_plus_delete);
        final ImageButton add_plus_desc = findViewById(R.id.ui_user_content_desc_plus_add);

        add_plus_desc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setVisibility(View.GONE);
                plus_desc.setVisibility(View.VISIBLE);
                delete_plus_desc.setVisibility(View.VISIBLE);

            }
        });

        delete_plus_desc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setVisibility(View.GONE);
                plus_desc.setVisibility(View.GONE);
                add_plus_desc.setVisibility(View.VISIBLE);
            }
        });

        //To show up opnitional fied to add organizations name
        final Spinner org_names = findViewById(R.id.ui_user_content_org_name_spinner);
        final EditText add_org_name = findViewById(R.id.ui_user_content_org_add);
        org_names.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == (parent.getCount()-1)){
                    add_org_name.setVisibility(View.VISIBLE);
                } else if(add_org_name.getVisibility() == View.VISIBLE){
                    add_org_name.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //To publish the content
        Button publish = findViewById(R.id.ui_user_content_record_publish);
        publish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //To implement later.
                finish();
            }
        });
    }
}
