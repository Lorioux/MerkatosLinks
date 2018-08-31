package online.merkatos.merkatoslinks.feature;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;

public class Main_Content_View_Pager_Adapter_Class extends PagerAdapter {

    private final int tab_count;

    public Main_Content_View_Pager_Adapter_Class(int count) {
        super();
        tab_count = count;
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return tab_count;
    }

    /**
     * Determines whether a page View is associated with a specific key object
     * as returned by {@link #instantiateItem(ViewGroup, int)}. This method is
     * required for a PagerAdapter to function properly.
     *
     * @param view   Page View to check for association with <code>object</code>
     * @param object Object to check for association with <code>view</code>
     * @return true if <code>view</code> is associated with the key object <code>object</code>
     */
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return true;
    }
}
