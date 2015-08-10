package kku.freestyledev.ikids;

import kku.freestyledev.game.DescGame;
import kku.freestyledev.game.SplashGame;
import kku.freestyledev.sounds.GameSound;
import kku.freestyledev.storylist.ListChapter;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainMenu extends Activity implements OnClickListener {

	ImageView imgKids;
	ImageView imgCould;
	ImageButton btnLearn, btnAbout, btnGame;
	Intent in, inAbout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);

		RelativeLayout layout = (RelativeLayout) findViewById(R.id.container);

		imgKids = (ImageView) findViewById(R.id.imgSuperKids);
		imgCould = (ImageView) findViewById(R.id.imgCould);
		btnLearn = (ImageButton) findViewById(R.id.imgBtnLearn);
		btnAbout = (ImageButton) findViewById(R.id.imgBtnAbout);
		btnGame = (ImageButton) findViewById(R.id.imgBtnGame);

		// Animation
		Animation ani = new TranslateAnimation(Animation.RELATIVE_TO_PARENT,
				0f, Animation.RELATIVE_TO_PARENT, 0.23f,
				Animation.RELATIVE_TO_PARENT, 0f, Animation.RELATIVE_TO_PARENT,
				0f);
		// Animation
		Animation ani2 = new TranslateAnimation(Animation.RELATIVE_TO_PARENT,
				0.3f, Animation.RELATIVE_TO_PARENT, -0.17f,
				Animation.RELATIVE_TO_PARENT, 0f, Animation.RELATIVE_TO_PARENT,
				0f);

		// Animation Position
		ani.initialize(imgKids.getWidth(), imgKids.getHeight(),
				layout.getWidth(), layout.getHeight());

		ani2.initialize(imgCould.getWidth(), imgCould.getHeight(),
				layout.getWidth(), layout.getHeight());

		ani.setDuration(6000); // 6 วิ
		ani.setFillAfter(true);
		ani.setRepeatCount(15);
		imgKids.startAnimation(ani);

		ani2.setDuration(7000); // 7 วิ
		ani2.setFillAfter(true);
		ani2.setRepeatCount(15);
		imgCould.startAnimation(ani2);

		ani.setInterpolator(new LinearInterpolator());
		ani2.setInterpolator(new LinearInterpolator());

		btnLearn.setOnClickListener(this);
		btnAbout.setOnClickListener(this);
		btnGame.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.imgBtnLearn:
			GameSound.play(this);
			in = new Intent(MainMenu.this, ListChapter.class);
			startActivity(in);
			overridePendingTransition(android.R.anim.fade_in,
					android.R.anim.fade_out);
			break;

		case R.id.imgBtnGame:
			GameSound.play(this);
			in = new Intent(MainMenu.this, DescGame.class);
			startActivity(in);
			overridePendingTransition(android.R.anim.fade_in,
					android.R.anim.fade_out);
			break;

		case R.id.imgBtnAbout:
			GameSound.play(this);
			inAbout = new Intent(MainMenu.this, AboutDev.class);
			startActivity(inAbout);
			overridePendingTransition(android.R.anim.fade_in,
					android.R.anim.fade_out);
			break;

		}

	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
}
