package online.merkatos.merkatoslinks.feature;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

class Main_Base_Adapter extends BaseAdapter {

    private final int mLayoutResID;
    private final int mNumberOfItems;

    public Main_Base_Adapter(Context context, int numberOfItems, int layoutResId) {

        mNumberOfItems = numberOfItems;

        mLayoutResID = layoutResId;

    }

    @Override
    public int getCount() {

        return mNumberOfItems;

    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {

        return 0;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {

            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.ui_main_carousel_piece, parent, false);

            return convertView;

        }

        return convertView;
    }
}
