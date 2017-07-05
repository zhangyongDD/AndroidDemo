package com.alertlsodialogdemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.alertlsodialogdemo.widget.AlertIosDialog;

import com.alertlsodialogdemo.R;
import com.alertlsodialogdemo.widget.AlertIosDialog.ListItemsColor;

import static com.alertlsodialogdemo.widget.AlertIosDialog.*;


public class SettingActivity extends Activity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        findViewById(R.id.activity_setting_textview_updata).setOnClickListener(this);
        findViewById(R.id.activity_setting_textview_getmsg).setOnClickListener(this);
        findViewById(R.id.activity_setting_textview_loginout).setOnClickListener(this);
        findViewById(R.id.activity_setting_textview_select_panel).setOnClickListener(this);
        findViewById(R.id.activity_setting_textview_list).setOnClickListener(this);
        findViewById(R.id.activity_setting_textview_countdown).setOnClickListener(this);
        findViewById(R.id.activity_setting_textview_towbtn).setOnClickListener(this);
        findViewById(R.id.activity_setting_textview_bottom).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_setting_textview_updata:
                new AlertIosDialog(this).builder(R.style.AlertDialogStyle).setTitle("温馨提示").setMsg("发现新版本，建议立即更新使用").setPositiveButton("立即更新", new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "正在下载更新…", Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("下次再说", new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                }).show();
                break;
            case R.id.activity_setting_textview_getmsg:
                new AlertIosDialog(this).builder(R.style.AlertDialogStyle).setTitle("是否同步消息？").setPositiveButton("确定", new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "正在同步消息…", Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("取消", new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                }).show();
                break;
            case R.id.activity_setting_textview_loginout:
                new AlertIosDialog(this).builder(R.style.AlertDialogStyle).setMsg("是否退出登录？").setPositiveButton("确定", new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "退出登录", Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("取消", new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                }).show();
                break;
            case R.id.activity_setting_textview_select_panel:
                new AlertIosDialog(this).builder(R.style.AlertDialogStyle).setAlertDialogSize(1).setSelsctPanel(R.mipmap.ic_launcher, R.mipmap.ic_launcher, "左面板", "右面板").setLeftPanelOnClick(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "左面板", Toast.LENGTH_SHORT).show();
                    }
                }).setRightPanelOnClick(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "右面板", Toast.LENGTH_SHORT).show();
                    }
                }).show();
                break;
            case R.id.activity_setting_textview_list:
                //这里的setAlertDialogSize(0.95)，不要设置为1否知因外面的布局导致弹出的AlertDialogde 右边出错没有了圆角的背景，原因估计跟andoird画图有些关系吧，具体不明。
                new AlertIosDialog(this).builder(R.style.ActionListDialogStyle).setAlertDialogSize(0.95).setTitle("选择操作").setCancleOnTouchOutside(false).addListItems("条目一", ListItemsColor.Blue, new OnListItemsClickListener() {
                    @Override
                    public void onClick(int which) {
                        Toast.makeText(getApplicationContext(), "item" + which, Toast.LENGTH_SHORT).show();
                    }
                }).addListItems("条目二", ListItemsColor.Blue, new OnListItemsClickListener() {
                    @Override
                    public void onClick(int which) {
                        Toast.makeText(getApplicationContext(), "item" + which, Toast.LENGTH_SHORT).show();
                    }
                }).addListItems("条目三", ListItemsColor.Blue, new OnListItemsClickListener() {
                    @Override
                    public void onClick(int which) {
                        Toast.makeText(getApplicationContext(), "item" + which, Toast.LENGTH_SHORT).show();
                    }
                }).addListItems("条目四", ListItemsColor.Blue, new OnListItemsClickListener() {
                    @Override
                    public void onClick(int which) {
                        Toast.makeText(getApplicationContext(), "item" + which, Toast.LENGTH_SHORT).show();
                    }
                }).addListItems("条目五", ListItemsColor.Blue, new OnListItemsClickListener() {
                    @Override
                    public void onClick(int which) {
                        Toast.makeText(getApplicationContext(), "item" + which, Toast.LENGTH_SHORT).show();
                    }
                }).addListItems("条目六", ListItemsColor.Blue, new OnListItemsClickListener() {
                    @Override
                    public void onClick(int which) {
                        Toast.makeText(getApplicationContext(), "item" + which, Toast.LENGTH_SHORT).show();
                    }
                }).addListItems("条目七", ListItemsColor.Blue, new OnListItemsClickListener() {
                    @Override
                    public void onClick(int which) {
                        Toast.makeText(getApplicationContext(), "item" + which, Toast.LENGTH_SHORT).show();
                    }
                }).addListItems("条目八", ListItemsColor.Blue, new OnListItemsClickListener() {
                    @Override
                    public void onClick(int which) {
                        Toast.makeText(getApplicationContext(), "item" + which, Toast.LENGTH_SHORT).show();
                    }
                }).addListItems("条目九", ListItemsColor.Blue, new OnListItemsClickListener() {
                    @Override
                    public void onClick(int which) {
                        Toast.makeText(getApplicationContext(), "item" + which, Toast.LENGTH_SHORT).show();
                    }
                }).addListItems("条目十", ListItemsColor.Blue, new OnListItemsClickListener() {
                    @Override
                    public void onClick(int which) {
                        Toast.makeText(getApplicationContext(), "item" + which, Toast.LENGTH_SHORT).show();
                    }
                }).setCanaleBtnClickListener("取消", new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                }).show();
                break;

            case R.id.activity_setting_textview_towbtn:
                new AlertIosDialog(this).builder(R.style.AlertDialogStyle).setAlertDialogSize(0.5).addListItems("复制", ListItemsColor.Blue, new OnListItemsClickListener() {
                    @Override
                    public void onClick(int which) {
                        Toast.makeText(getApplicationContext(), "复制" + which, Toast.LENGTH_SHORT).show();
                    }
                }).addListItems("删除", ListItemsColor.Blue, new OnListItemsClickListener() {
                    @Override
                    public void onClick(int which) {
                        Toast.makeText(getApplicationContext(), "删除" + which, Toast.LENGTH_SHORT).show();
                    }
                }).show();
                break;
            case R.id.activity_setting_textview_countdown:
                new AlertIosDialog(this).builder(R.style.AlertDialogStyle).setAlertDialogSize(0.5).setTitle("倒数面板").setCountDown(5, "秒后自动跳转页面", new OnTimeAlertViewClickListener() {
                    @Override
                    public void confirm() {
                        Toast.makeText(getApplicationContext(), "删除成功", Toast.LENGTH_SHORT).show();
                    }
                }).setPositiveButton("手动跳转", new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "跳转成功！", Toast.LENGTH_SHORT).show();
                    }
                }).setCancleOnTouchOutside(false).show();
                break;
            case R.id.activity_setting_textview_bottom:
                new AlertIosDialog(this).builder(R.style.ActionListDialogStyle).setAlertDialogSize(0.95).setCancleOnTouchOutside(false).addListItems("条目一", ListItemsColor.Blue, new OnListItemsClickListener() {
                    @Override
                    public void onClick(int which) {
                        Toast.makeText(getApplicationContext(), "item" + which, Toast.LENGTH_SHORT).show();
                    }
                }).addListItems("条目二", ListItemsColor.Blue, new OnListItemsClickListener() {
                    @Override
                    public void onClick(int which) {
                        Toast.makeText(getApplicationContext(), "item" + which, Toast.LENGTH_SHORT).show();
                    }
                }).setCanaleBtnClickListener("取消", new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                }).show();
                break;

        }

    }
}
