package online.merkatos.merkatoslinks.feature;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Main_News_Page_RV_Adapter extends RecyclerView.Adapter<Main_News_Page_RV_Adapter.AdapterViewHolder>  implements View.OnClickListener{

    private final int landscape;
    private final int mNumberOfItems;
    //private final String[] headlines;
    private Context mContext;

    /*
    * A constructor to take the a serializable content to be loaded into the views and a string parameter as signature for the view type to disp
    *
    */
    private Main_News_Page_RV_Adapter(Context context, @Nullable int numberOfItems, @Nullable int content_landscape_code){
        mContext = context;
        landscape = content_landscape_code;

        mNumberOfItems = numberOfItems;
    }

    public static Main_News_Page_RV_Adapter getNewInstance(Context context, @Nullable int numberOfItems, @Nullable int content_landscape_code){

        return new Main_News_Page_RV_Adapter(context, numberOfItems, content_landscape_code);

    }

    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Let´s inflate the cardview layout that holds the image and description text.
        View carousel_container = null;

        if (landscape == 0){

            carousel_container = LayoutInflater.from(mContext).inflate(R.layout.ui_alt_carousel_piece_news, parent,false);

        } else if (landscape == 2){
            carousel_container = LayoutInflater.from(mContext).inflate(R.layout.ui_alt_services_agents_piece, parent,false);
        }
        else {

            carousel_container = LayoutInflater.from(mContext).inflate(R.layout.ui_alt_campaigns_farmers_piece, parent,false);

        }

        return new AdapterViewHolder(carousel_container);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder holder, int position) {

        if (landscape == 0){
            switch (position){
                case 0:
                    holder.topic_name.setText("Feira económica e agricola");
                    holder.more_btnHolder.setOnClickListener(this);
                    break;
                case 1:
                    holder.topic_name.setText("Previsão de chuvas no distrito de...");
                    break;
                case 2:
                    holder.topic_name.setText("Praga de gafanhotos ...");
                    break;
                case 3:
                    holder.topic_name.setText("Preço de amendoim ...");
                    break;
                default:
                    break;
            }
        }

    }

    @Override
    public int getItemCount() {
        return mNumberOfItems;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.ui_main_carousel_More_Pieces_Btn){
            Intent more_pieces_activity = new Intent(mContext, Main_More_Pieces_Activity.class);
            mContext.startActivity(more_pieces_activity);
        }
    }

    public static class AdapterViewHolder extends RecyclerView.ViewHolder{

        public ImageView cultura_imagem;
        public TextView content_headlineHolder, more_btnHolder, topic_name, topic_memo;
        public ImageButton memo_speaker;

        public AdapterViewHolder(View container ) {
            super(container);

            cultura_imagem = container.findViewById(R.id.ui_campaigns_piece_FARMER_PHOTO);
            content_headlineHolder = itemView.findViewById(R.id.ui_main_carousel_District_Name);

            memo_speaker = itemView.findViewById(R.id.ui_piece_desc_speaker_BTN);
            more_btnHolder = itemView.findViewById(R.id.ui_piece_desc_more_BTN);
            topic_name = itemView.findViewById(R.id.ui_alt_piece_FARMER_NAME);
            topic_memo = itemView.findViewById(R.id.ui_alt_piece_QTY_Label);

        }
    }

}
