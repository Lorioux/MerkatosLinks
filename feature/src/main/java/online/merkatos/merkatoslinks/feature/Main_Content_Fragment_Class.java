package online.merkatos.merkatoslinks.feature;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Main_Content_Fragment_Class extends Fragment {

    public Main_Content_Fragment_Class(){}

    public static Main_Content_Fragment_Class getInstance(int page){
        Main_Content_Fragment_Class newInstance = new Main_Content_Fragment_Class();
        Bundle pages = new Bundle();
        pages.putInt("page", page);
        newInstance.setArguments(pages);
        return newInstance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Inflate the fragment layout here as a View
        return getLayoutInflater().inflate(R.layout.ui_main_content_recycler,container,false);
    }
}
