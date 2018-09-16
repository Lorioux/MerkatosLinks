package online.merkatos.merkatoslinks.feature;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;

public class Main_Notifications_Page_Activity extends AppCompatActivity {

    private android.support.v7.widget.Toolbar toolbar;
    private RecyclerView notifications_recycler;

    private Context context;
    private ContextMenu context_menu;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = this;

        setContentView(R.layout.ui_main_notifications_layout);

        toolbar = findViewById(R.id.ui_services_advs_ToolBar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_24px);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //Handle the notifications recycler to visualize all notifications to this user
        notifications_recycler = findViewById(R.id.ui_notifications_pieces_RECYCLER_V);

        notifications_recycler.setLayoutManager(new LinearLayoutManager(this));

        notifications_recycler.setAdapter(new RecyclerView.Adapter() {
            @NonNull
            @Override
            public NotificationsPiecesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View piece = LayoutInflater.from(context).inflate(R.layout.ui_main_notifications_piece, parent, false);
                return new NotificationsPiecesHolder(piece);

            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

                final NotificationsPiecesHolder vHolder = (NotificationsPiecesHolder)holder;

                if (position == 0 || position == 1){
                    vHolder.notifications_author.setTextSize(18);
                    vHolder.notifications_author.setTextColor(Color.BLACK);
                    vHolder.notifications_content.setTextSize(16);
                    vHolder.notifications_content.setTextColor(Color.BLACK);
                    vHolder.notifications_date.setText("10:58 min");
                    vHolder.notifications_date.setTextColor(Color.BLUE);
                }

                vHolder.notifications_container.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        vHolder.notifications_author.setTextSize(14);
                        vHolder.notifications_author.setTextColor(Color.GRAY/*android.R.color.darker_gray*/);
                        vHolder.notifications_content.setTextSize(14);
                        vHolder.notifications_content.setTextColor(Color.GRAY);
                        vHolder.notifications_date.setTextColor(Color.GRAY);
                    }
                });

                vHolder.notifications_container.setOnLongClickListener(new View.OnLongClickListener() {

                    @Override
                    public boolean onLongClick(final View v) {

                        PopupMenu popupMenu = new PopupMenu(context,v);

                        getMenuInflater().inflate(R.menu.ui_notifications_context_menu, popupMenu.getMenu());

                        popupMenu.show();

                        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem item) {

                                int id = item.getItemId();
                                if (id == R.id.notifications_delete){
                                    /*ViewGroup parent = (ViewGroup) v.getParent();
                                    parent.removeView(v);*/
                                    v.setVisibility(View.GONE);
                                }
                                return false;
                            }
                        });

                        return true;

                    }
                });

            }

            @Override
            public int getItemCount() {
                return 6;
            }
        });

    }

    private class NotificationsPiecesHolder extends RecyclerView.ViewHolder{

        public final TextView notifications_author, notifications_content, notifications_date;
        public final View notifications_container;

        public NotificationsPiecesHolder(View v) {
            super(v);

            notifications_author = v.findViewById(R.id.ui_notifications_piece_Author_Name);

            notifications_content = v.findViewById(R.id.ui_notifications_piece_CONTENT);

            notifications_date = v.findViewById(R.id.ui_notifications_piece_DateTime);

            notifications_container = v;

        }
    }
}
