package com.cnblogs.android;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.KeyEvent;
/**
 * 基类，大部分Activity继承自此类
 * @author walkingp
 * @date:2011-11
 *
 */
public class BaseActivity extends Activity {
	/**
	 * 横竖屏
	 */
	@Override
	protected void onResume() {
		super.onResume();
		if (!SettingActivity.getIsAutoHorizontal(this))
			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//如果用户没有启用自动横竖屏，则用户竖屏显示
		else
			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_USER);//否则根据用户的设定来显示屏幕的横竖
	}
	protected void onPause() {
		super.onPause();
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	/**
	 * 按下键盘上返回按钮
	 */
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode==KeyEvent.KEYCODE_SEARCH){//搜索
			Intent intent = new Intent(BaseActivity.this,SearchActivity.class);
			intent.putExtra("isShowQuitHints", false);
			startActivity(intent);
			return true;
		}else {		
			return super.onKeyDown(keyCode, event);
		}
	}
}
