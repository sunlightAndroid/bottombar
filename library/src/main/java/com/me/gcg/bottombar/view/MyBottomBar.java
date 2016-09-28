package com.me.gcg.bottombar.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.me.gcg.bottombar.R;

/**
 * Created by imSunLight on 2016/9/19.
 */
public class MyBottomBar extends LinearLayout implements View.OnClickListener {
    private static final String TAG = "MyBottomBar";
    private ImageView firstIcon, secondIcon, thirdIcon, forthIcon,fifthIcon,sixthIcon;
    private TextView tv_first, tv_second, tv_third, tv_forth,tv_fifth,tv_sixth;
    private BottombarCallback mBottombarCallback;

    //未选中时——》 图片  文字颜色
    private int firsticon, secondicon, thirdicon, forthicon,fifthicon,sixthicon;
    private int first_color, second_color, third_color, forth_color,fifth_color,sixth_color;
    //选中时--》图片  文字颜色
    private int first_select_icon, second_select_icon, third_select_icon, forth_select_icon,fifth_select_icon,sixth_select_icon;
    private int first_select_color, second_select_color, third_select_color, forth_select_color,fifth_select_color,sixth_select_color;

    private RelativeLayout rl_first, rl_second, rl_third, rl_forth,rl_fifth,rl_sixth;

    public MyBottomBar(Context context) {
        this(context, null);
    }

    public MyBottomBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyBottomBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        LayoutInflater.from(context).inflate(R.layout.mybottombar, this, true);
        initView();
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyBottomBar);
        if (typedArray != null) {
            int backgroundColor = typedArray.getColor(R.styleable.MyBottomBar_bottombar_background, Color.WHITE);
            setBackgroundColor(backgroundColor);

            boolean isThree = typedArray.getBoolean(R.styleable.MyBottomBar_three_buttom_count, true);
            int tabcount = typedArray.getInteger(R.styleable.MyBottomBar_bottombar_tabcount, 3);

            firsticon = typedArray.getResourceId(R.styleable.MyBottomBar_bottombar_first_icon, R.mipmap.ic_launcher);
            firstIcon.setImageResource(firsticon);
            String firsttext = typedArray.getString(R.styleable.MyBottomBar_bottombar_first_text);
            tv_first.setText(firsttext);
            first_color = typedArray.getColor(R.styleable.MyBottomBar_bottombar_first_textcolor, Color.GRAY);
            tv_first.setTextColor(first_color);
            first_select_icon = typedArray.getResourceId(R.styleable.MyBottomBar_bottom_first_select_icon, R.mipmap.ic_launcher);
            first_select_color = typedArray.getColor(R.styleable.MyBottomBar_bottom_first_select_textcolor, Color.WHITE);


            secondicon = typedArray.getResourceId(R.styleable.MyBottomBar_bottombar_second_icon, R.mipmap.ic_launcher);
            secondIcon.setImageResource(secondicon);
            String secondtext = typedArray.getString(R.styleable.MyBottomBar_bottombar_second_text);
            tv_second.setText(secondtext);
            second_color = typedArray.getColor(R.styleable.MyBottomBar_bottombar_second_textcolor, Color.GRAY);
            tv_second.setTextColor(second_color);
            second_select_icon = typedArray.getResourceId(R.styleable.MyBottomBar_bottom_second_select_icon, R.mipmap.ic_launcher);
            second_select_color = typedArray.getColor(R.styleable.MyBottomBar_bottom_second_select_textcolor, Color.WHITE);

            thirdicon = typedArray.getResourceId(R.styleable.MyBottomBar_bottombar_third_icon, R.mipmap.ic_launcher);
            thirdIcon.setImageResource(thirdicon);
            String thirdtext = typedArray.getString(R.styleable.MyBottomBar_bottombar_third_text);
            tv_third.setText(thirdtext);
            third_color = typedArray.getColor(R.styleable.MyBottomBar_bottombar_third_textcolor, Color.GRAY);
            tv_third.setTextColor(third_color);
            third_select_icon = typedArray.getResourceId(R.styleable.MyBottomBar_bottom_third_select_icon, R.mipmap.ic_launcher);
            third_select_color = typedArray.getColor(R.styleable.MyBottomBar_bottom_third_select_textcolor, Color.WHITE);


            forthicon = typedArray.getResourceId(R.styleable.MyBottomBar_bottombar_forth_icon, R.mipmap.ic_launcher);
            forthIcon.setImageResource(forthicon);
            String forthtext = typedArray.getString(R.styleable.MyBottomBar_bottombar_forth_text);
            tv_forth.setText(forthtext);
            forth_color = typedArray.getColor(R.styleable.MyBottomBar_bottombar_forth_textcolor, Color.GRAY);
            tv_forth.setTextColor(forth_color);
            forth_select_icon = typedArray.getResourceId(R.styleable.MyBottomBar_bottom_forth_select_icon, R.mipmap.ic_launcher);
            forth_select_color = typedArray.getColor(R.styleable.MyBottomBar_bottom_forth_select_textcolor, Color.WHITE);


            fifthicon = typedArray.getResourceId(R.styleable.MyBottomBar_bottombar_fifth_icon, R.mipmap.ic_launcher);
            fifthIcon.setImageResource(fifthicon);
            String fifthtext = typedArray.getString(R.styleable.MyBottomBar_bottombar_fifth_text);
            tv_fifth.setText(fifthtext);
            fifth_color = typedArray.getColor(R.styleable.MyBottomBar_bottombar_fifth_textcolor, Color.GRAY);
            tv_fifth.setTextColor(fifth_color);
            fifth_select_icon = typedArray.getResourceId(R.styleable.MyBottomBar_bottom_fifth_select_icon, R.mipmap.ic_launcher);
            fifth_select_color = typedArray.getColor(R.styleable.MyBottomBar_bottom_fifth_select_textcolor, Color.WHITE);


            sixthicon = typedArray.getResourceId(R.styleable.MyBottomBar_bottombar_sixth_icon, R.mipmap.ic_launcher);
            sixthIcon.setImageResource(sixthicon);
            String sixthtext = typedArray.getString(R.styleable.MyBottomBar_bottombar_sixth_text);
            tv_sixth.setText(sixthtext);
            sixth_color = typedArray.getColor(R.styleable.MyBottomBar_bottombar_sixth_textcolor, Color.GRAY);
            tv_sixth.setTextColor(sixth_color);
            sixth_select_icon = typedArray.getResourceId(R.styleable.MyBottomBar_bottom_sixth_select_icon, R.mipmap.ic_launcher);
            sixth_select_color = typedArray.getColor(R.styleable.MyBottomBar_bottom_sixth_select_textcolor, Color.WHITE);

            switch (tabcount){
                case 1:
                    rl_second.setVisibility(View.GONE);
                    rl_third.setVisibility(View.GONE);
                    rl_forth.setVisibility(View.GONE);
                    rl_fifth.setVisibility(View.GONE);
                    rl_sixth.setVisibility(View.GONE);
                    break;
                case 2:
                    rl_third.setVisibility(View.GONE);
                    rl_forth.setVisibility(View.GONE);
                    rl_fifth.setVisibility(View.GONE);
                    rl_sixth.setVisibility(View.GONE);
                    break;
                case 3:
                    rl_forth.setVisibility(View.GONE);
                    rl_fifth.setVisibility(View.GONE);
                    rl_sixth.setVisibility(View.GONE);
                    break;
                case 4:
                    rl_fifth.setVisibility(View.GONE);
                    rl_sixth.setVisibility(View.GONE);
                    break;
                case 5:
                    rl_sixth.setVisibility(View.GONE);
                    break;
                case 6:
                    break;
            }
        }
        initListener();
    }

    private void initListener() {
        rl_first.setOnClickListener(this);
        rl_second.setOnClickListener(this);
        rl_third.setOnClickListener(this);
        rl_forth.setOnClickListener(this);
        rl_fifth.setOnClickListener(this);
        rl_sixth.setOnClickListener(this);
    }

    private void initView() {
        firstIcon = (ImageView) findViewById(R.id.img_fisrtIcon);
        secondIcon = (ImageView) findViewById(R.id.img_secondIcon);
        thirdIcon = (ImageView) findViewById(R.id.img_thirdIcon);
        forthIcon = (ImageView) findViewById(R.id.img_forthIcon);
        fifthIcon= (ImageView) findViewById(R.id.img_fifthIcon);
        sixthIcon= (ImageView) findViewById(R.id.img_sixthIcon);
        tv_first = (TextView) findViewById(R.id.tv_first);
        tv_second = (TextView) findViewById(R.id.tv_second);
        tv_third = (TextView) findViewById(R.id.tv_third);
        tv_forth = (TextView) findViewById(R.id.tv_forth);
        tv_fifth= (TextView) findViewById(R.id.tv_fifth);
        tv_sixth= (TextView) findViewById(R.id.tv_sixth);
        rl_first = (RelativeLayout) findViewById(R.id.rl_first);
        rl_second = (RelativeLayout) findViewById(R.id.rl_second);
        rl_third = (RelativeLayout) findViewById(R.id.rl_third);
        rl_forth = (RelativeLayout) findViewById(R.id.rl_forth);
        rl_fifth= (RelativeLayout) findViewById(R.id.rl_fifth);
        rl_sixth= (RelativeLayout) findViewById(R.id.rl_sixth);
    }

    public ImageView getFirstIcon() {
        return firstIcon;
    }

    public ImageView getSecondIcon() {
        return secondIcon;
    }

    public ImageView getThirdIcon() {
        return thirdIcon;
    }

    public ImageView getForthIcon() {
        return forthIcon;
    }

    public TextView getTv_first() {
        return tv_first;
    }

    public TextView getTv_second() {
        return tv_second;
    }

    public TextView getTv_third() {
        return tv_third;
    }

    public TextView getTv_forth() {
        return tv_forth;
    }

    public RelativeLayout getRl_forth() {
        return rl_forth;
    }

    public void setOnItemClickListener(BottombarCallback bottombarCallback) {
        mBottombarCallback = bottombarCallback;
    }

    @Override
    public void onClick(View v) {
        Log.d(TAG, "onClick() returned: " + "点击了---");
        setAllNormall();
        int id = v.getId();
        if (id == R.id.rl_first) {
            firstIcon.setImageResource(first_select_icon);
            tv_first.setTextColor(first_select_color);
            mBottombarCallback.onItemClicker(0);

        } else if (id == R.id.rl_second) {
            secondIcon.setImageResource(second_select_icon);
            tv_second.setTextColor(second_select_color);
            mBottombarCallback.onItemClicker(1);

        } else if (id == R.id.rl_third) {
            thirdIcon.setImageResource(third_select_icon);
            tv_third.setTextColor(third_select_color);
            mBottombarCallback.onItemClicker(2);

        } else if (id == R.id.rl_forth) {
            Log.d(TAG, "onClick() returned: " + "点击了4");
            forthIcon.setImageResource(forth_select_icon);
            tv_forth.setTextColor(forth_select_color);
            mBottombarCallback.onItemClicker(3);

        }else if (id == R.id.rl_fifth) {
            Log.d(TAG, "onClick() returned: " + "点击了5");
            fifthIcon.setImageResource(fifth_select_icon);
            tv_fifth.setTextColor(fifth_select_color);
            mBottombarCallback.onItemClicker(4);
        }else if (id == R.id.rl_sixth) {
            sixthIcon.setImageResource(sixth_select_icon);
            tv_sixth.setTextColor(sixth_select_color);
            mBottombarCallback.onItemClicker(5);
        }
    }

    private void setAllNormall() {
        firstIcon.setImageResource(firsticon);
        tv_first.setTextColor(first_color);

        secondIcon.setImageResource(secondicon);
        tv_second.setTextColor(second_color);

        thirdIcon.setImageResource(thirdicon);
        tv_third.setTextColor(third_color);

        forthIcon.setImageResource(forthicon);
        tv_forth.setTextColor(forth_color);

        fifthIcon.setImageResource(fifthicon);
        tv_fifth.setTextColor(fifth_color);

        sixthIcon.setImageResource(sixthicon);
        tv_sixth.setTextColor(sixth_color);
    }

    public interface BottombarCallback {
        void onItemClicker(int position);
    }
}
