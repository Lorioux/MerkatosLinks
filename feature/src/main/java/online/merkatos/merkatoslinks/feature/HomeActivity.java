package online.merkatos.merkatoslinks.feature;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private TextView content_header;

    //Instantiate the recyclerview and its adapter
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mRecyclerViewAdapter;
    private RecyclerView.LayoutManager mLinearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.main_app_toolbar);
        toolbar.setTitle(R.string.app_name);
        toolbar.setNavigationIcon(R.drawable.ic_home_48px);

        //Instantiate the fragment content header textview
        this.content_header = findViewById(R.id.fragment_header);

        TabLayout tabLayout = findViewById(R.id.main_tabLayout);

        mRecyclerView = findViewById(R.id.main_recyclerView);
        //Set this recyclerview as fixed size
        mRecyclerView.setHasFixedSize(true);

        mLinearLayoutManager = new LinearLayoutManager(this);

        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        mRecyclerViewAdapter = new ContentRecyclerViewAdapter(this);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);

        getSupportFragmentManager().beginTransaction().add(new Main_Content_Fragment_Class(),"temp").commitNow();

    }

}
