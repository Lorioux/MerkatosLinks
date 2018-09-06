package online.merkatos.merkatoslinks.feature;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Main_One_Piece_Details_Activity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private GridLayoutManager mGridLayoutManager;
    private Main_Campaigns_Page_RV_Adapter mRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_more_pieces_grid_layout);

        Toolbar toolbar = findViewById(R.id.ui_more_pieces_LO_toolbar);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_arrow_back_24px));
        toolbar.setTitle("Mais campanhas para si");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //Instantiiate the recycler view
        mRecyclerView = findViewById(R.id.main_recyclerView);
        //Set this recyclerview as fixed size
        //mRecyclerView.setHasFixedSize(true);

        mGridLayoutManager = new GridLayoutManager(this, 3);

        mRecyclerView.setLayoutManager(mGridLayoutManager);

        mRecyclerViewAdapter = new Main_Campaigns_Page_RV_Adapter(this, 18,102);

        mRecyclerView.setAdapter(mRecyclerViewAdapter);
    }
}
