package com.alertlsodialogdemo.widget;

import android.app.ActionBar;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.alertlsodialogdemo.R;

import java.util.ArrayList;
import java.util.List;

import static android.view.ViewGroup.LayoutParams;

/**
 * 提示类
 * 多功能的Dialog
 * Created by Yuniko on 2015/8/14.
 */
public class AlertIosDialog {
    private Context context;
    private static Dialog dialog;
    private ViewGroup bgViewGroup, functionViewGroup, selectpanelViewGroup, leftpanelViewGroup, rightpanelViewGroup, titleViewGroup, listViewGroup, mainViewGroup;
    private TextView titleTextView, leftTextView, rightTextView;
    private Button negButton, posButton, cancleButton;
    private ImageView lineIamgeView, lefticonImageView, righticonImageView;
    private ScrollView mainScrollView;
    private Display display;
    private List<ListItems> listListItems;
    private boolean showTitle = false;
    private boolean showMsg = false;
    private boolean showPosBtn = false;
    private boolean showNegBtn = false;
    private boolean showSelsetPanel = false;
    private boolean setLeftOnClik = false;
    private boolean setRightOnClik = false;
    private boolean showList = false;
    private boolean showCountDown = false;
    private boolean showCanclebtn = false;


    /**
     * ************************************************* list AlertDialog *************************************
     */
    public interface OnListItemsClickListener {
        void onClick(int which);
    }

    private class ListItems {
        String itemname;
        OnListItemsClickListener onListItemsClickListener;
        ListItemsColor itemscolor;

        public ListItems(String name, ListItemsColor color, OnListItemsClickListener itemsClickListener) {
            this.itemname = name;
            this.itemscolor = color;
            this.onListItemsClickListener = itemsClickListener;
        }
    }

    public enum ListItemsColor {
        Blue("#037BFF"), Red("#FD4A2E");

        private String name;

        private ListItemsColor(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    /**
     * ************************************************* nomal AlertDialog *************************************
     */

    public AlertIosDialog(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        display = windowManager.getDefaultDisplay();
        this.context = context;
    }

    private void init() {
        //获取Dialog布局
        View view = LayoutInflater.from(context).inflate(R.layout.view_alertdialog, null);
        //获取自定义Dialog布局中的控件
        bgViewGroup = (ViewGroup) view.findViewById(R.id.view_alertdialog_layout_bg);
        titleTextView = (TextView) view.findViewById(R.id.view_alertdialog_textview_title);
        titleTextView.setVisibility(View.GONE);
        msgTextView = (TextView) view.findViewById(R.id.view_alertdialog_textview_msg);
        msgTextView.setVisibility(View.GONE);
        negButton = (Button) view.findViewById(R.id.view_alertdialog_button_neg);
        negButton.setVisibility(View.GONE);
        posButton = (Button) view.findViewById(R.id.view_alertdialog_button_pos);
        posButton.setVisibility(View.GONE);
        lineIamgeView = (ImageView) view.findViewById(R.id.view_alertdialog_imageview_line);
        lineIamgeView.setVisibility(View.GONE);
        selectpanelViewGroup = (ViewGroup) view.findViewById(R.id.view_alertdialog_layout_select_panel);
        selectpanelViewGroup.setVisibility(View.GONE);
        leftpanelViewGroup = (ViewGroup) view.findViewById(R.id.view_alertdialog_layout_left_panel);
        leftpanelViewGroup.setVisibility(View.GONE);
        rightpanelViewGroup = (ViewGroup) view.findViewById(R.id.view_alertdialog_layout_right_panel);
        rightpanelViewGroup.setVisibility(View.GONE);
        righticonImageView = (ImageView) view.findViewById(R.id.view_alertdialog_imageview_right_icon);
        righticonImageView.setVisibility(View.GONE);
        lefticonImageView = (ImageView) view.findViewById(R.id.view_alertdialog_imageview_left_icon);
        lefticonImageView.setVisibility(View.GONE);
        leftTextView = (TextView) view.findViewById(R.id.view_alertdialog_textview_left_text);
        leftTextView.setVisibility(View.GONE);
        rightTextView = (TextView) view.findViewById(R.id.view_alertdialog_textview_right_text);
        rightTextView.setVisibility(View.GONE);
        functionViewGroup = (ViewGroup) view.findViewById(R.id.view_alertdialog_layout_function);
        titleViewGroup = (ViewGroup) view.findViewById(R.id.view_alertdialog_layout_title);
        titleViewGroup.setVisibility(View.GONE);
        cancleButton = (Button) view.findViewById(R.id.view_alertdialog_button_cancle);
        cancleButton.setVisibility(View.GONE);
        listViewGroup = (ViewGroup) view.findViewById(R.id.view_alertdialog_layout_list);
        listViewGroup.setVisibility(View.GONE);
        mainScrollView = (ScrollView) view.findViewById(R.id.view_alertdialog_scrollview_id);
        mainViewGroup = (ViewGroup) view.findViewById(R.id.view_alertdialog_layout_mainview);

        //调整dialog背景的大少(默认)
        bgViewGroup.setLayoutParams(new FrameLayout.LayoutParams((int) (display.getWidth() * 0.85), ActionBar.LayoutParams.WRAP_CONTENT));
    }

    public AlertIosDialog builder(int style) {

        //获取Dialog布局
        View view = LayoutInflater.from(context).inflate(R.layout.view_alertdialog, null);
        //获取自定义Dialog布局中的控件
        bgViewGroup = (ViewGroup) view.findViewById(R.id.view_alertdialog_layout_bg);
        titleTextView = (TextView) view.findViewById(R.id.view_alertdialog_textview_title);
        titleTextView.setVisibility(View.GONE);
        msgTextView = (TextView) view.findViewById(R.id.view_alertdialog_textview_msg);
        msgTextView.setVisibility(View.GONE);
        negButton = (Button) view.findViewById(R.id.view_alertdialog_button_neg);
        negButton.setVisibility(View.GONE);
        posButton = (Button) view.findViewById(R.id.view_alertdialog_button_pos);
        posButton.setVisibility(View.GONE);
        lineIamgeView = (ImageView) view.findViewById(R.id.view_alertdialog_imageview_line);
        lineIamgeView.setVisibility(View.GONE);
        selectpanelViewGroup = (ViewGroup) view.findViewById(R.id.view_alertdialog_layout_select_panel);
        selectpanelViewGroup.setVisibility(View.GONE);
        leftpanelViewGroup = (ViewGroup) view.findViewById(R.id.view_alertdialog_layout_left_panel);
        leftpanelViewGroup.setVisibility(View.GONE);
        rightpanelViewGroup = (ViewGroup) view.findViewById(R.id.view_alertdialog_layout_right_panel);
        rightpanelViewGroup.setVisibility(View.GONE);
        righticonImageView = (ImageView) view.findViewById(R.id.view_alertdialog_imageview_right_icon);
        righticonImageView.setVisibility(View.GONE);
        lefticonImageView = (ImageView) view.findViewById(R.id.view_alertdialog_imageview_left_icon);
        lefticonImageView.setVisibility(View.GONE);
        leftTextView = (TextView) view.findViewById(R.id.view_alertdialog_textview_left_text);
        leftTextView.setVisibility(View.GONE);
        rightTextView = (TextView) view.findViewById(R.id.view_alertdialog_textview_right_text);
        rightTextView.setVisibility(View.GONE);
        functionViewGroup = (ViewGroup) view.findViewById(R.id.view_alertdialog_layout_function);
        titleViewGroup = (ViewGroup) view.findViewById(R.id.view_alertdialog_layout_title);
        titleViewGroup.setVisibility(View.GONE);
        cancleButton = (Button) view.findViewById(R.id.view_alertdialog_button_cancle);
        cancleButton.setVisibility(View.GONE);
        listViewGroup = (ViewGroup) view.findViewById(R.id.view_alertdialog_layout_list);
        listViewGroup.setVisibility(View.GONE);
        mainScrollView = (ScrollView) view.findViewById(R.id.view_alertdialog_scrollview_id);
        mainViewGroup = (ViewGroup) view.findViewById(R.id.view_alertdialog_layout_mainview);

        //定义Dialog布局的参数(默认)
        dialog = new Dialog(context, style);
        dialog.setContentView(view);
        if (style == R.style.ActionListDialogStyle) {
            Window dialogWindow = dialog.getWindow();
            dialogWindow.setGravity(Gravity.LEFT | Gravity.BOTTOM);
            WindowManager.LayoutParams lp = dialogWindow.getAttributes();
            lp.x = 0;
            lp.y = 0;
            dialogWindow.setAttributes(lp);
        }

        //调整dialog背景的大少(默认)
        bgViewGroup.setLayoutParams(new FrameLayout.LayoutParams((int) (display.getWidth() * 0.85), ActionBar.LayoutParams.WRAP_CONTENT));
        return this;
    }

    //设置AlertIsoDialog大小
    public AlertIosDialog setAlertDialogSize(double size) {
        bgViewGroup.setLayoutParams(new FrameLayout.LayoutParams((int) (display.getWidth() * size), LayoutParams.WRAP_CONTENT));
        return this;
    }

    //设置AlertIsoDialog的Style
    public AlertIosDialog setAlertDialogStyle(int style) {
        dialog = new Dialog(context, style);
//        dialog.setContentView(view);
        Window dialogWindow = dialog.getWindow();
        dialogWindow.setGravity(Gravity.CENTER | Gravity.BOTTOM);
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.x = 0;
        lp.y = 0;
        dialogWindow.setAttributes(lp);
        return this;
    }

    //设置标题
    public AlertIosDialog setTitle(String title) {
        showTitle = true;
        if ("".equals(title)) {
            titleTextView.setText("标题");
        } else {
            titleTextView.setText(title);
        }
        return this;
    }

    //设置内容
    public AlertIosDialog setMsg(String msg) {
        showMsg = true;
        if ("".equals(msg)) {
            msgTextView.setText("内容");
        } else {
            msgTextView.setText(msg);
        }
        return this;
    }

    //设置选择面板
    public AlertIosDialog setSelsctPanel(int lefticon, int righticon, String leftcontext, String rightcontext) {

        showSelsetPanel = true;
        if ("".equals(leftcontext)) {
            leftTextView.setVisibility(View.GONE);
        } else {
            leftTextView.setText(leftcontext);
            leftTextView.setVisibility(View.VISIBLE);
        }
        if ("".equals(rightcontext)) {
            rightTextView.setVisibility(View.GONE);
        } else {
            rightTextView.setText(rightcontext);
            rightTextView.setVisibility(View.VISIBLE);
        }

        if ("".equals(lefticon) || lefticon == 0) {
            lefticonImageView.setVisibility(View.GONE);
        } else {
            lefticonImageView.setBackgroundResource(lefticon);
            lefticonImageView.setVisibility(View.VISIBLE);
        }
        if ("".equals(righticon) || righticon == 0) {
            righticonImageView.setVisibility(View.GONE);
        } else {
            righticonImageView.setBackgroundResource(righticon);
            righticonImageView.setVisibility(View.VISIBLE);
        }

        return this;
    }


    //设置左面板监听
    public AlertIosDialog setLeftPanelOnClick(final OnClickListener leftlistener) {
        setLeftOnClik = true;
        leftpanelViewGroup.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                leftlistener.onClick(v);
                dialog.dismiss();
            }
        });
        return this;
    }

    //设置右面监听
    public AlertIosDialog setRightPanelOnClick(final OnClickListener rightlistener) {
        setRightOnClik = true;
        rightpanelViewGroup.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                rightlistener.onClick(v);
                dialog.dismiss();
            }
        });
        return this;
    }

    //设置取消
    public AlertIosDialog setCancleable(boolean cancle) {
        dialog.setCancelable(cancle);
        return this;
    }

    //设置PositiveButton
    public AlertIosDialog setPositiveButton(String text, final OnClickListener listener) {
        showPosBtn = true;
        if ("".equals(text)) {
            posButton.setText("确定");
        } else {
            posButton.setText(text);
        }
        posButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(v);
                dialog.dismiss();
            }
        });
        return this;
    }

    //设置触摸外界不销毁
    public AlertIosDialog setCancleOnTouchOutside(boolean cancle) {
        dialog.setCanceledOnTouchOutside(cancle);
        return this;
    }

    //增加List的Item
    public AlertIosDialog addListItems(String strItem, ListItemsColor color, final OnListItemsClickListener listener) {
        showList = true;
        if (listListItems == null) {
            listListItems = new ArrayList<ListItems>();
        }
        listListItems.add(new ListItems(strItem, color, listener));
        return this;
    }

    //设置取消按键的监听
    public AlertIosDialog setCanaleBtnClickListener(String text, final OnClickListener listener) {
        showCanclebtn = true;
        if ("".equals(text)) {
            cancleButton.setText("取消");
        } else {
            cancleButton.setText(text);
        }
        cancleButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                listener.onClick(v);
                dialog.dismiss();
            }
        });
        return this;

    }

    //设置List
    private void setListItems() {
        if (listListItems == null || listListItems.size() <= 0) {
            return;
        }
        int size = listListItems.size();

        if (size > 7) {
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) mainScrollView.getLayoutParams();
            params.height = display.getHeight() / 2;
            mainScrollView.setLayoutParams(params);
        }

        for (int i = 1; i <= size; i++) {
            final int index = i;
            ListItems listItems = listListItems.get(i - 1);
            String strItem = listItems.itemname;
            ListItemsColor color = listItems.itemscolor;
            final OnListItemsClickListener listener = listItems.onListItemsClickListener;

            TextView textView = new TextView(context);
            textView.setText(strItem);
            textView.setTextSize(18);
            textView.setGravity(Gravity.CENTER);

            //Item背景图片
            if (size == 1) {//首条目
                if (showTitle) {
                    textView.setBackgroundResource(R.drawable.selector_bottom_btn);
                } else {
                    textView.setBackgroundResource(R.drawable.selector_single_btn);
                }
            } else {
                if (showTitle) {
                    if (i >= 1 && i < size) {//中间条目
                        textView.setBackgroundResource(R.drawable.selector_middle_btn);
                    } else {
                        textView.setBackgroundResource(R.drawable.selector_bottom_btn);
//                        mainViewGroup.setBackgroundResource(R.drawable.transparency_bar_on);
                    }
                } else {
                    if (i == 1) {//底部条目
                        textView.setBackgroundResource(R.drawable.selector_top_btn);
                    } else if (i < size) {
                        textView.setBackgroundResource(R.drawable.selector_middle_btn);
                    } else {
                        textView.setBackgroundResource(R.drawable.selector_bottom_btn);
//                        mainViewGroup.setBackgroundResource(R.drawable.transparency_bar_on);
                    }
                }
            }

            // 字体颜色
            if (color == null) {
                textView.setTextColor(Color.parseColor(ListItemsColor.Blue
                        .getName()));
            } else {
                textView.setTextColor(Color.parseColor(color.getName()));
            }

            // 高度
            float scale = context.getResources().getDisplayMetrics().density;
            int height = (int) (45 * scale + 0.5f);
            textView.setLayoutParams(new LinearLayout.LayoutParams(
                    LayoutParams.MATCH_PARENT, height));

            // 点击事件
            textView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(index);
                    dialog.dismiss();
                }
            });

            listViewGroup.addView(textView);
        }
    }


    //设置NegativeButton
    public AlertIosDialog setNegativeButton(String text, final OnClickListener listener) {
        showNegBtn = true;
        if ("".equals(text)) {
            negButton.setText("取消");
        } else {
            negButton.setText(text);
        }
        negButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(v);
                dialog.dismiss();
            }
        });
        return this;
    }

    //设置计时器
    public AlertIosDialog setCountDown(int time, String msg, final OnTimeAlertViewClickListener positiveListener) {
        showCountDown = true;
        timeCount = time;
        timeMessgae = msg;
        if ("".equals(msg)) {
            msgTextView.setText("内容");
        } else {
            msgTextView.setText(timeCount + timeMessgae);
        }
//        handler.sendEmptyMessage(0);
        msgTextView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != positiveListener) {
                    positiveListener.confirm();
                }
                dialog.dismiss();
            }
        });
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                handler.removeMessages(0);
                positiveListener.confirm();
            }
        });
        handler.sendEmptyMessage(-1);
        return this;
    }

    private static int timeCount;//倒计时时间
    private static String timeMessgae;//倒计时信息
    private static TextView msgTextView;
    //倒计时
    static Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            int what = msg.what;
            if (what == 0) {
                if (timeCount > 0) {
                    timeCount--;
                    msgTextView.setText(timeCount + timeMessgae);
                    handler.sendEmptyMessageDelayed(0, 1000);
                } else {
                    dialog.dismiss();
                    handler.removeMessages(0);
                }
            } else {
                handler.sendEmptyMessageDelayed(0, 1000);
            }
            super.handleMessage(msg);
        }
    };

    //调用时间接口
    public interface OnTimeAlertViewClickListener {
        public abstract void confirm();
    }

    public interface DialogItemClickListener {
        public abstract void confirm(String result);
    }

    //设置整体布局
    private void setLayout() {

        //默认标题样式
        if (!showTitle && !showMsg && !showSelsetPanel && !showList) {
            titleTextView.setText("提示");
            titleTextView.setVisibility(View.VISIBLE);
            titleViewGroup.setVisibility(View.VISIBLE);
        }

        if (showTitle) {
            titleTextView.setVisibility(View.VISIBLE);
            titleViewGroup.setVisibility(View.VISIBLE);
        }

        if (showMsg) {
            msgTextView.setVisibility(View.VISIBLE);
        }

        if (!showPosBtn && !showNegBtn && !showSelsetPanel && !showList) {
            posButton.setText("确定");
            posButton.setVisibility(View.VISIBLE);
            functionViewGroup.setVisibility(View.VISIBLE);
            posButton.setBackgroundResource(R.drawable.alertdialog_single_selector);
            posButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
        }

        if (showPosBtn && showNegBtn && !showList) {
            posButton.setVisibility(View.VISIBLE);
            posButton.setBackgroundResource(R.drawable.alertdialog_right_selector);
            negButton.setVisibility(View.VISIBLE);
            negButton.setBackgroundResource(R.drawable.alertdialog_left_selector);
            lineIamgeView.setVisibility(View.VISIBLE);
        }

        if (showPosBtn && !showNegBtn && !showList) {
            posButton.setVisibility(View.VISIBLE);
            functionViewGroup.setVisibility(View.VISIBLE);
            lineIamgeView.setVisibility(View.VISIBLE);
            posButton.setBackgroundResource(R.drawable.alertdialog_single_selector);
        }

        if (!showPosBtn && showNegBtn && !showList) {
            negButton.setVisibility(View.VISIBLE);
            functionViewGroup.setVisibility(View.VISIBLE);
            lineIamgeView.setVisibility(View.VISIBLE);
            negButton.setBackgroundResource(R.drawable.alertdialog_single_selector);
        }

        if (showSelsetPanel) {
            posButton.setVisibility(View.GONE);
            negButton.setVisibility(View.GONE);
            functionViewGroup.setVisibility(View.GONE);
            selectpanelViewGroup.setVisibility(View.VISIBLE);
            leftpanelViewGroup.setVisibility(View.VISIBLE);
            rightpanelViewGroup.setVisibility(View.VISIBLE);
        }

        if (showList) {
            posButton.setVisibility(View.GONE);
            negButton.setVisibility(View.GONE);
            functionViewGroup.setVisibility(View.GONE);
            listViewGroup.setVisibility(View.VISIBLE);
            setListItems();
        }

        if (showCountDown) {
            msgTextView.setVisibility(View.VISIBLE);
        }

        if (showCanclebtn) {
            cancleButton.setVisibility(View.VISIBLE);
        }

    }

    public void show() {
        setLayout();
        dialog.show();
    }

    public void dismiss() {
        dialog.dismiss();
    }

}
