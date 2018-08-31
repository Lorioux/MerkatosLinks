package online.merkatos.merkatoslinks.feature;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Campaigns_RV_Adapter extends RecyclerView.Adapter<Campaigns_RV_Adapter.ViewHolder> {

    private Context mContext;

    /*
    * A constructor to take the a serializable content to be loaded into the views and a string parameter as signature for the view type to disp
    *
    */
    Campaigns_RV_Adapter(Context context){
        mContext = context;
    }

    @NonNull
    @Override
    public Campaigns_RV_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Let´s inflate the cardview layout that holds the image and description text.
        View carousel_container = LayoutInflater.from(mContext).inflate(R.layout.ui_main_carousel_layout, parent,false);
        //View carousel_piece = LayoutInflater.from(mContext).inflate(R.layout.ui_main_carousel_piece,null);

        return new ViewHolder(carousel_container);
    }

    @Override
    public void onBindViewHolder(@NonNull Campaigns_RV_Adapter.ViewHolder holder, int position) {
        /*holder.cultura_imagem.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_launcher_background));
        holder.cultura_nome.setText("Mandioca");*/
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return 3;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView cultura_imagem;
        public TextView cultura_nome;

        public ViewHolder(View container ) {
            super(container);
            LinearLayout ll = container.findViewById(R.id.ui_main_carousel_LinearLO);
            for (int i=0; i<ll.getChildCount(); i++) {
                ll.getChildAt(i).setVisibility(View.VISIBLE);
            }
            cultura_imagem = container.findViewById(R.id.ui_piece_image_ID);
            cultura_nome = container.findViewById(R.id.ui_piece_desc_ID);

        }
    }

}
