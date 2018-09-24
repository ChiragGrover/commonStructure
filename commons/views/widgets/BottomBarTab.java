package skycap.com.driver.go4er.views.widgets;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import skycap.com.driver.go4er.R;

public class BottomBarTab extends FrameLayout {

    private ImageView bottomBarIcon, bottomBarIconCenter;
    private TextView bottomBarItemText;
    private LinearLayout messageBadgeCountLayout;
    private Context mContext;
    private int mTabPosition = -1;

    public BottomBarTab(Context context, @DrawableRes int icon, String description) {
        this(context, null, icon, description);
    }

    public BottomBarTab(Context context, AttributeSet attrs, int icon, String description) {
        this(context, attrs, 0, icon, description);
    }

    public BottomBarTab(Context context, AttributeSet attrs, int defStyleAttr, int icon, String description) {
        super(context, attrs, defStyleAttr);
        init(context, icon, description);
    }

    public BottomBarTab(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
    }

    private void init(Context context, int selectedIcon, String description) {
        mContext = context;

        View bottomBarItemView = LayoutInflater.from(context).inflate(R.layout.item_bottom_bar, null, false);

        bottomBarItemText = bottomBarItemView.findViewById(R.id.textView_bottom_item);
        messageBadgeCountLayout = bottomBarItemView.findViewById(R.id.badge_count_layout);
        bottomBarIcon = bottomBarItemView.findViewById(R.id.imageView_bottom_bar);
        bottomBarIconCenter = bottomBarItemView.findViewById(R.id.imageView_bottom_bar_center);

        if (description.equals("")) {
            bottomBarIcon.requestLayout();
            bottomBarIcon.setVisibility(View.GONE);
            bottomBarIconCenter.setVisibility(View.VISIBLE);
            bottomBarIconCenter.setImageResource(selectedIcon);
            bottomBarItemText.setVisibility(View.GONE);
        } else {
            bottomBarIcon.setVisibility(View.VISIBLE);
            bottomBarItemText.setText(description);
            bottomBarIconCenter.setVisibility(View.VISIBLE);
            bottomBarIcon.setImageResource(selectedIcon);
        }

        setUnselectedTabProperty();

        addView(bottomBarItemView);
    }

    @Override
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        if (selected) {
            setSelectedTabProperty();
        } else {
            setUnselectedTabProperty();
        }
    }

    private void setSelectedTabProperty() {
        bottomBarItemText.setTextSize(10);
        bottomBarItemText.setTextColor(ContextCompat.getColor(mContext, R.color.colorPrimaryDark));
        bottomBarItemText.setPadding(12, 0, 12, 10);

        bottomBarIcon.setPadding(0, 0, 0, 0);

        if (getTabPosition() == 2) {
            bottomBarIconCenter.setImageResource(R.drawable.ic_selected_delivery);
        }
//        if (getTabPosition() == 1) {
//            messageBadgeCountLayout.setVisibility(View.INVISIBLE);
//        }
//        if (getTabPosition() == 3) {
//            messageBadgeCountLayout.setVisibility(View.INVISIBLE);
//        }
    }

    private void setUnselectedTabProperty() {
        bottomBarItemText.setTextSize(10);
        bottomBarItemText.setTextColor(ContextCompat.getColor(mContext, R.color.unselectedBarColor));
        bottomBarItemText.setPadding(12, 0, 12, 10);

        bottomBarIcon.setPadding(0, 0, 0, 0);
        bottomBarIconCenter.setVisibility(View.VISIBLE);

        if (getTabPosition() == 2) {
            bottomBarIconCenter.setImageResource(R.drawable.ic_unselected_delivery);
        }
    }

    public void setTabPosition(int position) {
        mTabPosition = position;
        if (position == 0) {
            setSelected(true);
        }
    }

    public int getTabPosition() {
        return mTabPosition;
    }
}
