package com.mike.menu.alarm;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mike.commonlib.json.JsonService;
import com.mike.commonlib.logger.Log;
import com.mike.commonlib.utils.ToastUtil;
import com.mike.menu.R;

public class AlarmBuyActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int OVERLAY_PERMISSION_REQ_CODE = 2;
    private Context mContext = AlarmBuyActivity.this;
    Log log = Log.Factory.getInstance().setTag(getClass().getSimpleName());
    JsonService service = JsonService.Factory.getSingletonImpl();

    private Button startService;
    private Button stopService;
    private EditText time;

    public static int TIME; //记录时间间隔

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_titlebar);
        startService = (Button) findViewById(R.id.start_serice);
        stopService = (Button) findViewById(R.id.stop_serice);
        time = (EditText) findViewById(R.id.time);
        startService.setOnClickListener(this);
        stopService.setOnClickListener(this);
        log.d(new Activity());
        if (Build.VERSION.SDK_INT >= 23) {
            //没有悬浮窗权限m,去开启悬浮窗权限
            try {
                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
                startActivityForResult(intent, OVERLAY_PERMISSION_REQ_CODE);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.start_serice:
                Intent startIntent = new Intent(this, AlarmBuyService.class);
                TIME = Integer.parseInt(time.getText().toString().trim());
                //通过Intent将时间间隔传递给Service
                startIntent.putExtra("Time", TIME);
                ToastUtil.showToast(this, "开始提醒");
                startService(startIntent);
                break;
            case R.id.stop_serice:
                Intent stopIntent = new Intent(this, AlarmBuyService.class);
                ToastUtil.showToast(this, "结束提醒");
                stopService(stopIntent);
                break;
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == OVERLAY_PERMISSION_REQ_CODE) {
            if (Build.VERSION.SDK_INT >= 23) {
                if (!Settings.canDrawOverlays(this)) {
                    Toast.makeText(this, "权限授予失败，无法开启悬浮窗", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "权限授予成功！", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

}
