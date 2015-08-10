package kku.freestyledev.game;

import kku.freestyledev.ikids.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;

public class SplashGame extends Activity {

	Intent in;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_game);

		in = new Intent(SplashGame.this, GameBoard.class);

		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				in = new Intent(SplashGame.this, GameBoard.class);
				startActivity(in);
				overridePendingTransition(android.R.anim.fade_in,
						android.R.anim.fade_out);

			}
		}, 2000);
	}

}
