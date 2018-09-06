package online.merkatos.merkatoslinks.feature;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

//This class implements LoaderManager callbacks to load content on backgroung.

public class Member_DashBoard_Activity extends AppCompatActivity implements LoaderManager.LoaderCallbacks <ArrayList<String>> {

    private Context mContext;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private Member_DashBoard_RV_Adapter mMemberDashboardAdapter;
    private final int LOADER_ID = R.id.ui_main_member_dashboard_page;
    private TextView mContentHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_main_member_dashboard_io);

        mContext = this;//getApplicationContext();

        /*Toolbar toolbar = findViewById(R.id.dashboard_app_toolbar);
        toolbar.setVisibility(View.VISIBLE);
        toolbar.setTitle("Painel de Controlo");*/

        //toolbar.setNavigationIcon(R.drawable.ic_arrow_back_24px);
        /*CollapsingToolbarLayout cll = findViewById(R.id.ui_alt_title_collapse);
        cll.setVisibility(View.VISIBLE);*/

        mContentHeader = findViewById(R.id.ui_main_content_header);
        mContentHeader.setText("Provedor de serviços e insumos agrícolas");

        //Instantiate the recyclerview to display the members contents
        mRecyclerView = findViewById(R.id.main_recyclerView);

        //Instatiate the GridLayoutManager to handle the recyclerview content
        mLinearLayoutManager = new LinearLayoutManager(mContext);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        //Instantiate the content adapter class for the recyclerview
        mMemberDashboardAdapter = new Member_DashBoard_RV_Adapter(mContext,0, 3);
        mRecyclerView.setAdapter(mMemberDashboardAdapter);

        //getSupportLoaderManager().initLoader(LOADER_ID, null,this);

        //To Handle the Bottom Navigation
        BottomNavigationView footer_nav = findViewById(R.id.ui_main_member_dashboard_page_footer_nav);
        footer_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.navigation_profile){
                    Intent registry = new Intent(mContext, Member_Registry_Activity.class);
                    startActivity(registry);
                    return true;
                }
                return true;
            }
        });
    }

    @NonNull
    @Override
    public Loader<ArrayList<String>> onCreateLoader(int id, @Nullable Bundle args) {
        return null;
    }

    @Override
    public void onLoadFinished(@NonNull Loader<ArrayList<String>> loader, ArrayList<String> data) {

    }

    /**
     * Called when a previously created loader is being reset, and thus
     * making its data unavailable.  The application should at this point
     * remove any references it has to the Loader's data.
     * <p>
     * <p>This will always be called from the process's main thread.
     *
     * @param loader The Loader that is being reset.
     */
    @Override
    public void onLoaderReset(@NonNull Loader<ArrayList<String>> loader) {

    }

}
