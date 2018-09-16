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

public class Main_More_Pieces_RV_Adapter extends RecyclerView.Adapter<Main_More_Pieces_RV_Adapter.ViewHolder> {

    private final int mLandscape;
    private final int mNumberOfItems;
    //private final String[] headlines;
    private Context mContext;

    /*
    * A constructor to take the a serializable content to be loaded into the views and a string parameter as signature for the view type to disp
    *
    */
    public Main_More_Pieces_RV_Adapter(Context context, @Nullable int numberOfItems, @Nullable int content_landscape_code){
        mContext = context;
       // headlines = new String[]{"Fertilizantes", "Insecticidas", "Pesticidas"};
        mLandscape = content_landscape_code;

        mNumberOfItems = numberOfItems;
    }

    @NonNull
    @Override
    public Main_More_Pieces_RV_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Let´s inflate the cardview layout that holds the image and description text.
        View carousel_container = LayoutInflater.from(mContext).inflate(R.layout.ui_main_carousel_piece, parent,false);

        return new ViewHolder(carousel_container);
    }

    @Override
    public void onBindViewHolder(@NonNull Main_More_Pieces_RV_Adapter.ViewHolder holder, int position) {




        if (mLandscape == 0){
            //TODO : improve later
            //Set the service providers names into the content from the received data
            //TODO : this condition statement need to be improved
            //Set the service provider name from the received data
            if (0 == position){
                holder.cultura_nome.setText("Milho");
                holder.cultura_imagem.setImageResource(R.drawable.img_corn);
                holder.cultura_imagem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent more_pieces_activity = new Intent(mContext, Main_Campaigns_Content_Activity.class);
                        //more_pieces_activity.putExtra("seccao",0);
                        mContext.startActivity(more_pieces_activity);
                    }
                });

            } else {
                holder.cultura_nome.setText("Outros culturas");
            }
        } else {
            //TODO : improve later
            //Set the service providers names into the content from the received data
            //TODO : this condition statement need to be improved
            //Set the service provider name from the received data
            if (0 == position){
                holder.cultura_nome.setText("Casa do Agricultor");
            } else {
                holder.cultura_nome.setText("Outros provedores");
            }
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

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView cultura_imagem;
        public TextView cultura_nome, content_headlineHolder,more_btnHolder;

        public ViewHolder(View container ) {
            super(container);

            cultura_imagem = container.findViewById(R.id.ui_campaigns_piece_FARMER_PHOTO);
            cultura_nome = container.findViewById(R.id.ui_alt_piece_FARMER_NAME);
            content_headlineHolder = itemView.findViewById(R.id.ui_main_carousel_District_Name);
            more_btnHolder = itemView.findViewById(R.id.ui_main_carousel_More_Pieces_Btn);
        }
    }

}
