package kku.freestyledev.game;

import kku.freestyledev.ikids.R;
import kku.freestyledev.sounds.GameSound;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;

public class DescGame extends Activity {

	Dialog dialog;
	Intent in;
	ImageButton btnSkip;
	ImageView imgBack;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.desc_game);

		in = new Intent(DescGame.this, GameBoard.class);

		dialog = new Dialog(DescGame.this);
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialog.setContentView(R.layout.desc_game);
		dialog.setCancelable(false);
		imgBack = (ImageView) dialog.findViewById(R.id.imgDesc);
		imgBack.setImageResource(R.drawable.bgcount);

		btnSkip = (ImageButton) dialog.findViewById(R.id.btnSkip_to_game);
		btnSkip.setImageResource(R.drawable.forward);
		btnSkip.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				GameSound.play(getApplicationContext());
				// คืนหน่อยความจำให้กับระบบ
				if (dialog != null && dialog.isShowing()) {
					startActivity(in);
					overridePendingTransition(android.R.anim.fade_in,
							android.R.anim.fade_out);
					DescGame.this.finish();
				} else {
					dialog.cancel();
				}

			}
		});
		// debug dialog

		dialog.show();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		GameSound.stop(getApplicationContext());
	}

}
