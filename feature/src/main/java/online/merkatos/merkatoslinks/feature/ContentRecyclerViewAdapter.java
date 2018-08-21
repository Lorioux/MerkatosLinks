package online.merkatos.merkatoslinks.feature;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ContentRecyclerViewAdapter extends RecyclerView.Adapter<ContentRecyclerViewAdapter.ViewHolder> {

    private Context mContext;

    ContentRecyclerViewAdapter(Context context){
        mContext = context;
    }


    @NonNull
    @Override
    public ContentRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Let´s inflate the cardview layout that holds the image and description text.
        View cardView = LayoutInflater.from(mContext).inflate(R.layout.content_, parent,false);
        return new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull ContentRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.cultura_imagem.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_launcher_background));
        holder.cultura_nome.setText("Mandioca");
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return 12;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView cultura_imagem;
        public TextView cultura_nome;

        public ViewHolder(View itemView) {
            super(itemView);
            cultura_imagem = itemView.findViewById(R.id.cultura_img);
            cultura_nome = itemView.findViewById(R.id.cultura_nome);

        }
    }
}
