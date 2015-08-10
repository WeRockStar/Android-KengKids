package kku.freestyledev.ikids;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.TextView;

public class AboutDev extends Activity {

	TextView txtTitle, txtApp, txtUn, txtFact, txtDep, txtV, txtKal, txtTuk;
	Typeface tf;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.aboutdev);

		// Font
		tf = Typeface.createFromAsset(getAssets(), "ZoodHardSell.ttf");

		txtTitle = (TextView) findViewById(R.id.txtTitleDev);
		txtApp = (TextView) findViewById(R.id.txtAppDev);
		txtUn = (TextView) findViewById(R.id.txtUniversity);
		txtFact = (TextView) findViewById(R.id.txtFact);
		txtDep = (TextView) findViewById(R.id.txtDep);
		txtV = (TextView)findViewById(R.id.txtV);
		txtKal = (TextView)findViewById(R.id.txtKal);
		txtTuk = (TextView)findViewById(R.id.txtTuk);

		// set font
		txtTitle.setTypeface(tf);
		txtApp.setTypeface(tf);
		txtUn.setTypeface(tf);
		txtFact.setTypeface(tf);
		txtDep.setTypeface(tf);
		txtV.setTypeface(tf);
		txtKal.setTypeface(tf);
		txtTuk.setTypeface(tf);
	}
}
