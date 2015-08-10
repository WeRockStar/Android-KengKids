package kku.freestyledev.splash;

import kku.freestyledev.ikids.MainMenu;
import kku.freestyledev.ikids.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends Activity {

	Intent in;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);

		in = new Intent(Splash.this, MainMenu.class);

		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				startActivity(in);
				overridePendingTransition(android.R.anim.fade_in,
						android.R.anim.fade_out);
				Splash.this.finish();
			}
		}, 3000);
	}
}
