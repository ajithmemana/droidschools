package com.droidschools.customprogressbar;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class MainActivity extends Activity {
	Dialog dialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Context context = this;
		dialog = new Dialog(context, android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		// Set a custom view for the Dialog
		dialog.setContentView(R.layout.custom_progress_bar);
	}
	public void triggerLoadingBar(View v) {
		dialog.show();

	}
}
