package com.labpro.game.ember;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MenuActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
	}
	public void handleButton() {
		Intent i = new Intent("android.intent.action.SESUATU");
		this.startActivity(i);
		this.finish();
	}
}
