package skycap.com.driver.go4er.views.widgets;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;

import skycap.com.driver.go4er.R;


@SuppressWarnings("unused")
public class BottomBar extends LinearLayout {
    private static final int TRANSLATE_DURATION_MILLIS = 200;

    private final Interpolator mInterpolator = new AccelerateDecelerateInterpolator();
    private boolean mVisible = true;

    private LinearLayout mTabLayout;

    private LayoutParams mTabParams;
    private int mCurrentPosition = 0;
    private OnTabSelectedListener mListener;

    public BottomBar(Context context) {
        this(context, null);
    }

    public BottomBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BottomBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        setOrientation(VERTICAL);

        mTabLayout = new LinearLayout(context);
        mTabLayout.setOrientation(LinearLayout.HORIZONTAL);
        addView(mTabLayout, new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        mTabParams = new LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT);
        mTabParams.weight = 1;
    }

    public BottomBar addItem(final BottomBarTab tab) {
        tab.setOnClickListener(v -> {
            if (mListener == null) return;

            int pos = tab.getTabPosition();
            if (mCurrentPosition == pos) {
                mListener.onTabReselected(pos);
            } else {
                mListener.onTabSelected(pos, mCurrentPosition);
                tab.setSelected(true);
                mListener.onTabUnselected(mCurrentPosition);
                mTabLayout.getChildAt(mCurrentPosition).setSelected(false);
                mCurrentPosition = pos;
            }
        });
        tab.setTabPosition(mTabLayout.getChildCount());
        tab.setLayoutParams(mTabParams);
        mTabLayout.addView(tab);
        return this;
    }

    public void setOnTabSelectedListener(OnTabSelectedListener onTabSelectedListener) {
        mListener = onTabSelectedListener;
    }

    public void setCurrentItem(final int position) {
        mTabLayout.post(() -> mTabLayout.getChildAt(position).performClick());
    }

    public void setTabsForCompanyDriver() {
        mTabLayout.post(() -> {
            mTabLayout.getChildAt(1).setVisibility(View.GONE);
            mTabLayout.getChildAt(3).setVisibility(View.GONE);
        });
    }

    public void setSelectedTabView(int icon, int position) {
        AppCompatImageView imageview = mTabLayout.getChildAt(position).findViewById(R.id.imageView_bottom_bar);
        imageview.setImageResource(icon);
    }

    public void setUnselectedTabView(int icon, int position) {
        AppCompatImageView imageview = mTabLayout.getChildAt(position).findViewById(R.id.imageView_bottom_bar);
        imageview.setImageResource(icon);
    }

    public void setBadgeCount(int unseenMessage, String type) {
        int currentPosition;

        if (type.equals("message")) {
            currentPosition = 1;
        } else {
            currentPosition = 3;
        }

        LinearLayout badgeCountLayout = mTabLayout.getChildAt(currentPosition).findViewById(R.id.badge_count_layout);
        AppCompatTextView badgeCount = mTabLayout.getChildAt(currentPosition).findViewById(R.id.badge_count);
        if (unseenMessage != 0) {
            badgeCountLayout.setVisibility(View.VISIBLE);
            badgeCount.setText(unseenMessage + "");
        } else {
            badgeCount.setText(0 + "");
            badgeCountLayout.setVisibility(View.GONE);
        }
    }

    public interface OnTabSelectedListener {
        void onTabSelected(int position, int prePosition);

        void onTabUnselected(int position);

        void onTabReselected(int position);
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        return new SavedState(superState, mCurrentPosition);
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());

        if (mCurrentPosition != ss.position) {
            mTabLayout.getChildAt(mCurrentPosition).setSelected(false);
            mTabLayout.getChildAt(ss.position).setSelected(true);
        }
        mCurrentPosition = ss.position;
    }

    public int getCurrentItemPosition() {
        return mCurrentPosition;
    }

    static class SavedState extends BaseSavedState {
        private int position;

        public SavedState(Parcel source) {
            super(source);
            position = source.readInt();
        }

        public SavedState(Parcelable superState, int position) {
            super(superState);
            this.position = position;
        }

        @Override
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(position);
        }

        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
    }


    public void hide() {
        hide(true);
    }

    public void show() {
        show(true);
    }

    public void hide(boolean anim) {
        toggle(false, anim, false);
    }

    public void show(boolean anim) {
        toggle(true, anim, false);
    }

    public boolean isVisible() {
        return mVisible;
    }

    private void toggle(final boolean visible, final boolean animate, boolean force) {
        if (mVisible != visible || force) {
            mVisible = visible;
            int height = getHeight();
            if (height == 0 && !force) {
                ViewTreeObserver vto = getViewTreeObserver();
                if (vto.isAlive()) {
                    vto.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                        @Override
                        public boolean onPreDraw() {
                            ViewTreeObserver currentVto = getViewTreeObserver();
                            if (currentVto.isAlive()) {
                                currentVto.removeOnPreDrawListener(this);
                            }
                            toggle(visible, animate, true);
                            return true;
                        }
                    });
                    return;
                }
            }
            int translationY = visible ? 0 : height;
            if (animate) {
                animate().setInterpolator(mInterpolator)
                        .setDuration(TRANSLATE_DURATION_MILLIS)
                        .translationY(translationY);
            } else {
                ViewCompat.setTranslationY(this, translationY);
            }
        }
    }
}
