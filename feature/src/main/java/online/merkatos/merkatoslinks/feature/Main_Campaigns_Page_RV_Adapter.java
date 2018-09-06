package online.merkatos.merkatoslinks.feature;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class Main_Campaigns_Page_RV_Adapter extends RecyclerView.Adapter<Main_Campaigns_Page_RV_Adapter.AdapterViewHolder>  implements View.OnClickListener{

    private final int landscape;
    private final int mNumberOfItems;
    //private final String[] headlines;
    private Context mContext;

    /*
    * A constructor to take the a serializable content to be loaded into the views and a string parameter as signature for the view type to disp
    *
    */
    Main_Campaigns_Page_RV_Adapter(Context context, @Nullable int numberOfItems, @Nullable int content_landscape_code){
        mContext = context;
       // headlines = new String[]{"Fertilizantes", "Insecticidas", "Pesticidas"};
        landscape = content_landscape_code;

        mNumberOfItems = numberOfItems;
    }

    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Let´s inflate the cardview layout that holds the image and description text.
        View carousel_container =
             carousel_container = LayoutInflater.from(mContext).inflate(R.layout.ui_main_carousel_layout, parent,false);
            (carousel_container.findViewById(R.id.ui_main_carousel_LO_multi_piece_include)).setVisibility(View.VISIBLE);/*
            (carousel_container.findViewById(R.id.ui_main_carousel_LO_single_piece_include)).setVisibility(View.VISIBLE);*/

            (carousel_container.findViewById(R.id.ui_main_carousel_more_btn)).setOnClickListener(this);

        return new AdapterViewHolder(carousel_container);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder holder, int position) {
        //TODO : improve later
        //Set the service providers names into the content from the received data
        //TODO : this condition statement need to be improved
        //Set the product name from the received data
        holder.cultura_imagem.setImageResource(R.drawable.img_corn);
        holder.cultura_imagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent more_pieces_activity = new Intent(mContext, Main_Campaigns_Content_Activity.class);
                //more_pieces_activity.putExtra("seccao",0);
                mContext.startActivity(more_pieces_activity);
            }
        });
        if (0 == position){
            holder.cultura_nome.setText("Milho");
        } else {
            holder.cultura_nome.setText("Outras culturas");
        }
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return mNumberOfItems;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.ui_main_carousel_more_btn){
            Intent more_pieces_activity = new Intent(mContext, Main_More_Pieces_Activity.class);
            more_pieces_activity.putExtra("seccao",0);
            mContext.startActivity(more_pieces_activity);
        }
    }

    public static class AdapterViewHolder extends RecyclerView.ViewHolder{

        public ImageView cultura_imagem;
        public TextView cultura_nome, content_headlineHolder,more_btnHolder;

        public AdapterViewHolder(View container ) {
            super(container);

            cultura_imagem = container.findViewById(R.id.ui_piece_Image_ID);
            cultura_nome = container.findViewById(R.id.ui_piece_Topic_ID);
            content_headlineHolder = itemView.findViewById(R.id.ui_main_carousel_header);

        }
    }

}
