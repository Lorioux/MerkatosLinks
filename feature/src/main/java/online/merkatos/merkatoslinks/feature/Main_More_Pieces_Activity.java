package online.merkatos.merkatoslinks.feature;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Main_More_Pieces_Activity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private GridLayoutManager mGridLayoutManager;
    private Main_More_Pieces_RV_Adapter mRecyclerViewAdapter;
    private static String[] HEADER_RAW_TEXT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_more_pieces_grid_layout);

        Intent calling_intent = getIntent();

        int mCodigoSeccao = calling_intent.getIntExtra("seccao",0);

        HEADER_RAW_TEXT = new String[]{
                getResources().getString(R.string.ui_content_header_crops_market),
                getResources().getString(R.string.ui_content_header_farm_inputs),
                getResources().getString(R.string.ui_content_header_farm_news)
        };

        Toolbar toolbar = findViewById(R.id.ui_more_pieces_LO_toolbar);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_arrow_back_24px));
        toolbar.setTitle("Distrito de ...");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        TextView content_header = findViewById(R.id.ui_main_content_header);
        content_header.setText(HEADER_RAW_TEXT[mCodigoSeccao]);

        //Instantiiate the recycler view
        mRecyclerView = findViewById(R.id.main_recyclerView);
        //Set this recyclerview as fixed size
        //mRecyclerView.setHasFixedSize(true);

        mGridLayoutManager = new GridLayoutManager(this,3);

        mRecyclerView.setLayoutManager(mGridLayoutManager);

        mRecyclerViewAdapter = new Main_More_Pieces_RV_Adapter(this, 6,mCodigoSeccao);

        mRecyclerView.setAdapter(mRecyclerViewAdapter);
    }
}
