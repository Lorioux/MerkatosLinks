package online.merkatos.merkatoslinks.feature;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

public class Main_Base_RecyclerView_Adapter extends RecyclerView.Adapter<Main_Base_RecyclerView_Adapter.PieceViewHolder> implements AdapterView.OnItemClickListener, View.OnClickListener {

    private final int mData;
    private final String mSectionName;
    private final String[] headlines;
    private Context mContext ;

    private Main_Base_RecyclerView_Adapter(Context context, int numberOfItems, @Nullable String sectionName ) {

        mContext = context;
        mData = numberOfItems;
        mSectionName = sectionName;
        headlines = new String[]{"Fertilizantes", "Insecticidas", "Pesticidas"};

    }

    public static Main_Base_RecyclerView_Adapter getNewInstance(Context context, int numberOfItems, @Nullable String sectionName){

        return  new Main_Base_RecyclerView_Adapter(context, numberOfItems, sectionName);

    }

    @NonNull
    @Override
    public PieceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View piece = LayoutInflater.from(mContext).inflate(R.layout.ui_main_carousel_piece, parent, false);

        return new PieceViewHolder(piece);
    }


    @Override
    public void onBindViewHolder(@NonNull PieceViewHolder holder, int position) {

        if (mSectionName.contentEquals("campaigns")){

            if (0 == position){

                holder.piece_image.setImageResource(R.drawable.img_corn);

                holder.piece_image.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        Intent more_pieces_activity = new Intent(mContext, Main_Campaigns_Content_Activity.class);
                        //more_pieces_activity.putExtra("seccao",0);
                        mContext.startActivity(more_pieces_activity);
                    }

                });
                holder.piece_desc.setText("Milho");

            } else {

                holder.piece_desc.setText("Outras culturas");

            }
        } else if (mSectionName.contentEquals("services")){

            if (0 == position){

                holder.piece_image.setImageResource(R.drawable.casa_do_agric);

                holder.piece_image.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        Intent more_pieces_activity = new Intent(mContext, Main_Services_Content_Activity.class);

                        mContext.startActivity(more_pieces_activity);
                    }

                });
                holder.piece_desc.setText("Casa do Agricultor");

            } else {

                holder.piece_desc.setText("Outros provedores");

            }

        } else if (mSectionName.contentEquals("dashboard")){
            
            holder.piece_image.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_add_gray_24px));

            holder.piece_desc.setText("Criar novo anúncio");



            holder.piece_image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent campaign_registry = new Intent(mContext, Main_Member_Publish_Page_Activity.class);
                    mContext.startActivity(campaign_registry);
                }
            });
            
        } else if (mSectionName.contentEquals("services_products")){

            if (0 == position){

                holder.piece_image.setImageResource(R.drawable.insecticide);

                holder.piece_image.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        Intent more_pieces_activity = new Intent(mContext, Main_One_Piece_Details_Activity.class);
                        //more_pieces_activity.putExtra("seccao",0);
                        mContext.startActivity(more_pieces_activity);
                    }

                });

                holder.piece_desc.setText("GOLD Shield Orthene");

            } else {

                holder.piece_desc.setText("Outras marcas");

            }
        }
            
        //holder.carousel_container.setAdapter(new Main_Campaigns_Page_RV_Adapter(mContext,9,0));

    }


    @Override
    public int getItemCount() {
        return mData;
    }

    public static class PieceViewHolder  extends RecyclerView.ViewHolder{

        public ImageView piece_image;
        public TextView piece_desc;

        //public CardView piece_frame;

        public PieceViewHolder(View itemView) {

            super(itemView);

            piece_image = itemView.findViewById(R.id.ui_campaigns_piece_FARMER_PHOTO);
            piece_desc = itemView.findViewById(R.id.ui_alt_piece_FARMER_NAME);

            //piece_frame = itemView.findViewById(R.id.ui_alt_carousel_piece_CView);

        }
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.ui_main_carousel_More_Pieces_Btn){

            Intent more_pieces_activity = new Intent(mContext, Main_More_Pieces_Activity.class);
            more_pieces_activity.putExtra("seccao",0);
            mContext.startActivity(more_pieces_activity);

        }
    }


    /**
     * Callback method to be invoked when an item in this AdapterView has
     * been clicked.
     * <p>
     * Implementers can call getItemAtPosition(position) if they need
     * to access the data associated with the selected item.
     *
     * @param parent   The AdapterView where the click happened.
     * @param view     The view within the AdapterView that was clicked (this
     *                 will be a view provided by the adapter)
     * @param position The position of the view in the adapter.
     * @param id       The row id of the item that was clicked.
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
