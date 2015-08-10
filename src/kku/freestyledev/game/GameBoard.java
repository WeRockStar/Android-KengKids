package kku.freestyledev.game;

import kku.freestyledev.ikids.R;
import android.app.Activity;
import android.os.Bundle;

public class GameBoard extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new Panel(this));
	}
}
