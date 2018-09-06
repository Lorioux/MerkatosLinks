package online.merkatos.merkatoslinks.feature;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Main_Campaigns_Content_Activity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private Context mContext;
    private Main_News_Page_RV_Adapter mMemberDashboardAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_main_campaigns_advs_page_io);

        mContext = this;

        TabLayout tabLayout = findViewById(R.id.main_tabLayout);
        tabLayout.getTabAt(0).setText("Produtores");
        tabLayout.getTabAt(1).setText("Grupos de produtores");
        tabLayout.removeTabAt(2);

        ((Toolbar)findViewById(R.id.toolbar)).setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mRecyclerView = findViewById(R.id.main_recyclerView);

        //Instatiate the GridLayoutManager to handle the recyclerview content
        mLinearLayoutManager = new LinearLayoutManager(mContext);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        //Instantiate the content adapter class for the recyclerview
        mMemberDashboardAdapter = new Main_News_Page_RV_Adapter(mContext,12, 1);
        mRecyclerView.setAdapter(mMemberDashboardAdapter);
    }

}
