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
import android.widget.LinearLayout;
import android.widget.TextView;

public class Main_Services_Page_RV_Adapter extends RecyclerView.Adapter<Main_Services_Page_RV_Adapter.AdapterViewHolder>  implements View.OnClickListener{

    private final int landscape;
    private final int mNumberOfItems;
    //private final String[] headlines;
    private Context mContext;

    /*
    * A constructor to take the a serializable content to be loaded into the views and a string parameter as signature for the view type to disp
    *
    */
    Main_Services_Page_RV_Adapter(Context context, @Nullable int numberOfItems, @Nullable int content_landscape_code){
        mContext = context;
       // headlines = new String[]{"Fertilizantes", "Insecticidas", "Pesticidas"};
        landscape = content_landscape_code;

        mNumberOfItems = numberOfItems;
    }

    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Let´s inflate the cardview layout that holds the image and description text.
        View carousel_container = null;
        //View carousel_piece = LayoutInflater.from(mContext).inflate(R.layout.ui_main_carousel_piece,null);
        if (100 == landscape){
             carousel_container = LayoutInflater.from(mContext).inflate(R.layout.ui_main_carousel_layout, parent,false);
            (carousel_container.findViewById(R.id.ui_main_carousel_btn_LO)).setVisibility(View.GONE);
            (carousel_container.findViewById(R.id.ui_main_carousel_LO_single_piece_include)).setVisibility(View.VISIBLE);

            (carousel_container.findViewById(R.id.ui_main_carousel_more_btn)).setOnClickListener(this);

        }  else if (101 == landscape){

            carousel_container = LayoutInflater.from(mContext).inflate(R.layout.ui_main_carousel_layout, parent,false);
            (carousel_container.findViewById(R.id.ui_main_carousel_LO_multi_piece_include)).setVisibility(View.VISIBLE);

            LinearLayout ll = carousel_container.findViewById(R.id.ui_main_carousel_LinearLO);

            for (int i=0; i<ll.getChildCount(); i++) {
                ll.getChildAt(i).setVisibility(View.VISIBLE);
            }
            (carousel_container.findViewById(R.id.ui_main_carousel_more_btn)).setOnClickListener(this);

        } else {



        }

        return new AdapterViewHolder(carousel_container);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder holder, int position) {

        switch (position){
            case 0:
                holder.cultura_nome.setText("Casa do Agricultor");
                break;
            case 1:
                holder.cultura_nome.setText("Agri-insumos");
                break;
            case 2:
                holder.cultura_nome.setText("K2");
                break;
            case 3:
                holder.cultura_nome.setText("Morais");
                break;
            default:
                break;
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
            more_pieces_activity.putExtra("seccao",1);
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
