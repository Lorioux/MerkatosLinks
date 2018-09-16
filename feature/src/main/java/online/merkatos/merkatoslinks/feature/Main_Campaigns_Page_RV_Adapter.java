package online.merkatos.merkatoslinks.feature;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.ButtonBarLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Main_Campaigns_Page_RV_Adapter extends RecyclerView.Adapter<Main_Campaigns_Page_RV_Adapter.AdapterViewHolder> implements View.OnClickListener{

    private final int mNumberOfItems;
    //private final String[] headlines;
    private Context mContext;

    /*
    * A constructor to take the a serializable content to be loaded into the views and a string parameter as signature for the view type to disp
    *
    */
    private Main_Campaigns_Page_RV_Adapter(Context context, @Nullable int numberOfItems){
        mContext = context;

        mNumberOfItems = numberOfItems;
    }

    public static Main_Campaigns_Page_RV_Adapter getNewInstance(Context context, @Nullable int numberOfItems){

        return  new Main_Campaigns_Page_RV_Adapter(context, numberOfItems);
    }

    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //Let´s inflate the cardview layout that holds the image and description text.
        View container = LayoutInflater.from(mContext).inflate(R.layout.ui_main_carousel_layout, parent, false);
        return new AdapterViewHolder(container);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder holder, int position) {
        //TODO : improve later
        //Set the service providers names into the content from the received data
        //TODO : this condition statement need to be improved
        //Set the product name from the received data
        //holder.distric_nameHolder.setText("Nacaroa");

        holder.piece_btnBarHolder.setOnClickListener(this);

        holder.more_pieceHolder.setOnClickListener(this);

        holder.carousel_container.setAdapter(Main_Base_RecyclerView_Adapter.getNewInstance(mContext,9, "campaigns"));

    }


    @Override
    public int getItemViewType(int position) {
        return 1;
    }

    @Override
    public int getItemCount() {
        return mNumberOfItems;
    }

    @Override
    public void onClick(View v) {

        int id = v.getId();
        if (id == R.id.ui_main_carousel_More_Pieces_Btn || id == R.id.ui_main_carousel_btnBAR_LO ){

            Intent more_pieces_activity = new Intent(mContext, Main_More_Pieces_Activity.class);
            more_pieces_activity.putExtra("seccao",0);
            mContext.startActivity(more_pieces_activity);

        }
    }

    public static class AdapterViewHolder extends RecyclerView.ViewHolder{

        private final ButtonBarLayout piece_btnBarHolder;

        public TextView distric_nameHolder, more_pieceHolder;

        public RecyclerView carousel_container;

        public AdapterViewHolder(View container ) {

            super(container);

            distric_nameHolder = container.findViewById(R.id.ui_main_carousel_District_Name);

            more_pieceHolder = container.findViewById(R.id.ui_main_carousel_More_Pieces_Btn);

            piece_btnBarHolder = container.findViewById(R.id.ui_main_carousel_btnBAR_LO);

            carousel_container = itemView.findViewById(R.id.ui_main_recyclerView_piece);

        }
    }

}
