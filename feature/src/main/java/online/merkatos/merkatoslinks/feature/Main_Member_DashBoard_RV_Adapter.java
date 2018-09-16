package online.merkatos.merkatoslinks.feature;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class Main_Member_DashBoard_RV_Adapter extends RecyclerView.Adapter<Main_Member_DashBoard_RV_Adapter.DashboardPageViewHolder> {

    private static final int DEFAULT_NUM_OF_ROWS = 1;
    private final Context mContext;
    private final int mNumberOfItems;
    private final int DEFAULT_CONTENT_TYPE = -1;
    private final int mNumberOfFields;

    private String[] headlines;

    Main_Member_DashBoard_RV_Adapter(Context conetext, int numberOfItems, int numberOfFields){

        mContext = conetext;
        mNumberOfItems = numberOfItems;
        mNumberOfFields = numberOfFields;
        headlines = new String[]{"Fertilizantes", "Insecticidas", "Pesticidas"};
    }


    @NonNull
    @Override
    public DashboardPageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View content = LayoutInflater.from(mContext).inflate(R.layout.ui_main_carousel_layout, parent, false);

            return new DashboardPageViewHolder(content);

    }

    @Override
    public void onBindViewHolder(@NonNull DashboardPageViewHolder holder, int position) {

        DashboardPageViewHolder.district_nameHolder.setText(headlines[position]);

        holder.container.setAdapter(Main_Base_RecyclerView_Adapter.getNewInstance(mContext,1, "dashboard"));

    }

    @Override
    public int getItemCount() {

        if (0 == mNumberOfFields ) return DEFAULT_NUM_OF_ROWS;

        return mNumberOfFields;
    }

    public static class DashboardPageViewHolder extends RecyclerView.ViewHolder{

        public static ImageView imageHolder;
        public static TextView descHolder, district_nameHolder;
        private final RecyclerView container;

        public DashboardPageViewHolder(View itemView) {

            super(itemView);

            imageHolder = itemView.findViewById(R.id.ui_campaigns_piece_FARMER_PHOTO);

            descHolder = itemView.findViewById(R.id.ui_alt_piece_FARMER_NAME);

            district_nameHolder = itemView.findViewById(R.id.ui_main_carousel_District_Name);

            container = itemView.findViewById(R.id.ui_main_recyclerView_piece);

        }

    }

    @Override
    public int getItemViewType(int position) {

        if (0 == mNumberOfFields) {

            return DEFAULT_CONTENT_TYPE;
        }
        return 0;
    }
}
