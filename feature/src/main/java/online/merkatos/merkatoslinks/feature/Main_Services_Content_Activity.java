package online.merkatos.merkatoslinks.feature;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Main_Services_Content_Activity extends AppCompatActivity implements TabLayout.OnTabSelectedListener{

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private Context mContext;
    private Main_Services_Provider_Details_RV_Adapter servicesPageRvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.ui_main_services_advs_page_io);

        mContext = this;

        TabLayout tabLayout = findViewById(R.id.main_tabLayout);
        tabLayout.getTabAt(0).setText("Produtos");
        tabLayout.getTabAt(1).setText("Agentes revendores");
        tabLayout.removeTabAt(2);

        tabLayout.setOnTabSelectedListener(this);

        ((Toolbar)findViewById(R.id.ui_services_advs_ToolBar)).setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mRecyclerView = findViewById(R.id.ui_main_content_RecyclerViewer);

        //Instatiate the GridLayoutManager to handle the recyclerview content
        mLinearLayoutManager = new LinearLayoutManager(mContext);

        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        //Instantiate the content adapter class for the recyclerview
        servicesPageRvAdapter = new Main_Services_Provider_Details_RV_Adapter(mContext,0, 3);

        mRecyclerView.setAdapter(servicesPageRvAdapter);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

        switch (tab.getPosition()){
            case 0:

                mRecyclerView.setAdapter(servicesPageRvAdapter);

                break;

            case 1:

                Main_News_Page_RV_Adapter servicesPageRvAdapter = Main_News_Page_RV_Adapter.getNewInstance(mContext, 6, 2);

                mRecyclerView.setAdapter(servicesPageRvAdapter);
                break;
            default:
                break;
        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
