package online.merkatos.merkatoslinks.feature;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class Member_DashBoard_RV_Adapter extends RecyclerView.Adapter<Member_DashBoard_RV_Adapter.DashboardPageViewHolder> {

    private static final int DEFAULT_NUM_OF_ROWS = 1;
    private final Context mContext;
    private final int mNumberOfItems;
    private final int DEFAULT_CONTENT_TYPE = -1;
    private final int mNumberOfFields;

    Member_DashBoard_RV_Adapter(Context conetext, int numberOfItems, int numberOfFields){
        mContext = conetext;
        mNumberOfItems = numberOfItems;
        mNumberOfFields = numberOfFields;
    }


    @NonNull
    @Override
    public DashboardPageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View content;
        if (-1 == viewType){
            content = LayoutInflater.from(mContext).inflate(R.layout.ui_main_carousel_layout, parent, false);
            return new DashboardPageViewHolder(content);
        } else if (0 == viewType){
            content = LayoutInflater.from(mContext).inflate(R.layout.ui_main_carousel_layout, parent, false);
            return new DashboardPageViewHolder(content);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull DashboardPageViewHolder holder, int position) {
        DashboardPageViewHolder.imageHolder.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_add_gray_24px));
        DashboardPageViewHolder.descHolder.setText("Criar novo anúncio");
        DashboardPageViewHolder.imageHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent campaign_registry = new Intent(mContext, Member_Publish_Page_Activity.class);
                mContext.startActivity(campaign_registry);
            }
        });
    }

    @Override
    public int getItemCount() {

        if (0 == mNumberOfFields ) return DEFAULT_NUM_OF_ROWS;
        return mNumberOfFields;
    }

    public static class DashboardPageViewHolder extends RecyclerView.ViewHolder{

        public static ImageView imageHolder;
        public static TextView descHolder;

        public DashboardPageViewHolder(View itemView) {
            super(itemView);
            imageHolder = itemView.findViewById(R.id.ui_piece_image_ID);
            descHolder = itemView.findViewById(R.id.ui_piece_desc_ID);
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
