package online.merkatos.merkatoslinks.feature;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import static android.view.View.GONE;

public class HomeActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    private static TextView content_header;

    //Instantiate the recyclerview and its adapter
    private static RecyclerView mRecyclerView;
    private static RecyclerView.Adapter mRecyclerViewAdapter;
    private static RecyclerView.LayoutManager mLinearLayoutManager;

    private static Toolbar mToolbar;
    private static ImageView content_filter;
    private static GridView filter_list;
    private static ListAdapter listAdapter;
    private static DrawerLayout drawer;
    private static NavigationView nav;
    private static TabLayout tabLayout;

    //Create an Array of content headers
    private static String[] HEADER_RAW_TEXT = null;

    //Instatite the Context Object as a member variable
    private Context mContext;
    private static String mFilterValure;
    private LoadingMainUIContentAsyncTask loadUi;
    private CoordinatorLayout mMainContentLayout;
    private ProgressBar pb;
    private static View lp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mContext = this;

        loadUi = new LoadingMainUIContentAsyncTask();
        loadUi.execute();

        lp = findViewById(R.id.ui_app_landing_page_include);

        pb = findViewById(R.id.app_land_page_progressBar);
        pb.setIndeterminate(true);

        //rootView = null;

        drawer = findViewById(R.id.ui_main_UI_drawer);
        nav = findViewById(R.id.ui_main_nav_side);
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // Get the item id number
                int id = item.getItemId();
                //Close the dashboard
                drawer.closeDrawers();

                //Start the dashboad activity if the id is equal to dashboard id number
                if (id == R.id.navigation_dashboard){
                    Intent dashboard = new Intent( mContext, Member_DashBoard_Activity.class );
                    startActivity(dashboard);
                }
                return true;
            }
        });
        nav.setVisibility(GONE);

        HEADER_RAW_TEXT = new String[]{
                getResources().getString(R.string.ui_content_header_crops_market),
                getResources().getString(R.string.ui_content_header_farm_inputs),
                getResources().getString(R.string.ui_content_header_farm_news)
        };

        mMainContentLayout = findViewById(R.id.ui_main_UI_drawer_CooLayout);
        //Instanciate the toobar to set the title and option_menu
        mToolbar = mMainContentLayout.findViewById(R.id.main_app_toolbar);
        mToolbar.setTitle(R.string.app_name);
        mToolbar.inflateMenu(R.menu.toobar_menu);
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.action_personna){

                    Intent registry = new Intent(mContext, Member_Registry_Activity.class);
                    startActivity(registry);
                    return true;
                }
                else {
                    Toast.makeText(mContext, "Selected", Toast.LENGTH_SHORT).show();
                    return true;
                }
            }
        });

        //mToolbar.setNavigationIcon(R.drawable.ic_menu_24px);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(Gravity.START);
            }
        });

        //Instantiate the fragment content header textview and content filter
        content_header = mMainContentLayout.findViewById(R.id.ui_main_content_header);
        content_filter = mMainContentLayout.findViewById(R.id.ui_main_content_header_filter);
        content_filter.setVisibility(View.VISIBLE);

        //Create a spinner to set the filter and its Adapter
        filter_list = mMainContentLayout.findViewById(R.id.ui_main_content_header_filter_list);

        listAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.user_province_name));

        filter_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mFilterValure = ((TextView) view).getText().toString();

                //Get the tab position to switch to the proper header content
                int tab_position = tabLayout.getSelectedTabPosition();
                switch (tab_position){
                    case 0:
                        content_header.setText(
                                HEADER_RAW_TEXT[0] +
                                        " na provincia de " + mFilterValure
                        );
                        break;
                    case 1:
                        content_header.setText(
                                HEADER_RAW_TEXT[1] +
                                        " na provincia de " + mFilterValure
                        );
                        break;
                    case 2:
                        content_header.setText(
                                HEADER_RAW_TEXT[2] +
                                        " na provincia de " + mFilterValure
                        );
                        break;
                    default:
                        break;
                }
                filter_list.setVisibility(GONE);
            }
        });

        filter_list.setAdapter(listAdapter);

        content_filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filter_list.setVisibility(View.VISIBLE);
            }
        });



        mRecyclerView = mMainContentLayout.findViewById(R.id.main_recyclerView);
        //Set this recyclerview as fixed size
        //mRecyclerView.setHasFixedSize(true);

        mLinearLayoutManager = new LinearLayoutManager(this);

        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        mRecyclerViewAdapter = new Main_Campaigns_Page_RV_Adapter(this, 3, 100);

        mRecyclerView.setAdapter(mRecyclerViewAdapter);

        //This is to ensure the filter is not open while the recyclerview is scrolling on small screens
        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState != RecyclerView.SCROLL_STATE_IDLE && filter_list.getVisibility() == View.VISIBLE){
                    filter_list.setVisibility(GONE);
                }
            }
        });

        //getSupportFragmentManager().beginTransaction().add(new Main_Content_Fragment_Singleton(),"temp").commitNow();
        tabLayout = mMainContentLayout.findViewById(R.id.main_tabLayout);

        //tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        tabLayout.addOnTabSelectedListener(this);

        TextView more = mRecyclerView.findViewById(R.id.ui_main_carousel_more_btn);
        /*more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent more_pieces_activity = new Intent(mContext, Main_More_Pieces_Activity.class);
                mContext.startActivity(more_pieces_activity);
            }
        });*/

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

    }

    private class LoadingMainUIContentAsyncTask extends AsyncTask<Void,Void,Boolean>{

        /**
         * Creates a new asynchronous task. This constructor must be invoked on the UI thread.
         */
        //Context context;
        public LoadingMainUIContentAsyncTask() {
            super();
        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            long time = SystemClock.elapsedRealtime();
            do {

            } while (SystemClock.elapsedRealtime() != (time+5000) );
            return true;
        }

        @Override
        protected void onPostExecute(final Boolean result) {
            super.onPostExecute(result);
            lp.setVisibility(GONE);
            ViewGroup v = (ViewGroup) drawer.getParent();
            v.removeView(drawer);
            drawer.setVisibility(View.VISIBLE);
            HomeActivity.this.setContentView(drawer);
        }
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

        if (filter_list.getVisibility() == View.VISIBLE){
            filter_list.setVisibility(View.GONE);
        }
        switch (tab.getPosition()){
            case 0:
                mRecyclerViewAdapter = new Main_Campaigns_Page_RV_Adapter(this,3,100);
                mRecyclerView.setAdapter(mRecyclerViewAdapter);
                if (mFilterValure == null ) {
                    content_header.setText(HEADER_RAW_TEXT[0]);
                } else {
                    content_header.setText(
                            HEADER_RAW_TEXT[0] + " na provincia de " + mFilterValure );
                }
                break;
            case 1:
                mRecyclerViewAdapter = new Main_Services_Page_RV_Adapter(this,3,101);
                mRecyclerView.setAdapter(mRecyclerViewAdapter);
                if (mFilterValure == null ) {
                    content_header.setText(HEADER_RAW_TEXT[1]);
                } else {
                    content_header.setText(
                        HEADER_RAW_TEXT[1] +
                                " na provincia de " + mFilterValure
                    );
                }
                break;
            case 2:

                mRecyclerViewAdapter = new Main_News_Page_RV_Adapter(this,6,100);
                mRecyclerView.setAdapter(mRecyclerViewAdapter);

                if (mFilterValure == null ) {
                    content_header.setText(HEADER_RAW_TEXT[2]);
                } else {
                    content_header.setText(
                            HEADER_RAW_TEXT[2] +
                                    " na provincia de " + mFilterValure
                    );
                }
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
