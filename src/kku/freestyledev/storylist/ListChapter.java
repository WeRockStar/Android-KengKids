package kku.freestyledev.storylist;

import java.util.ArrayList;
import java.util.List;

import kku.freestyledev.ikids.R;
import kku.freestyledev.learn.StoryOne;
import kku.freestyledev.learn.StoryTwo;
import kku.freestyledev.sounds.GameSound;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListChapter extends Activity implements OnItemClickListener {

	Typeface tf;
	TextView txtTitle, txtApp;
	Intent in;

	public static final String[] titles = new String[] { "��Сѹ���Ե���?",
			"���Դ�ʹ�������Сѹ���", "������ǧ�¢ͧ���������",
			"˹�ҷ��ͧ���Էѡ��", "�Էѡ�������ʹ���", "���ҧ������蹤�",
			"�Ե��Ҿ�ͧ��餹", "������ʹ���", "����ѡ���ä" };

	public static final String[] descriptions = new String[] {
			"�����Ӥѭ�ͧ��Сѹ", "�ش���Դ�ʹ������",
			"�����ѡ�������˭�ͧ���������", "��ѧ��ͧ�Ҿ�����Ѻ˹�ҷ��",
			"����ͧ������ʹ��¢ͧ���ӻ�Сѹ",
			"������蹤���ͤ�������׹�ͧ��ͺ����",
			"�Ե��Ҿ��й��㨢ͧ����ѧ��", "��ʹ�������͹", "�ѡ�ҵ���ҡ��" };

	public static final Integer[] images = { R.drawable.chapter_one,
			R.drawable.chapter_two, R.drawable.chapter_three,
			R.drawable.chapter_four, R.drawable.chapter_five,
			R.drawable.chapter_six, R.drawable.chapter_seven,
			R.drawable.chapter_eigth, R.drawable.chapter_nine };

	ListView listView;
	List<RowChapter> rowItems;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listchapter);

		// font
		tf = Typeface.createFromAsset(getAssets(), "ZoodHardSell.ttf");

		// TextView
		txtTitle = (TextView) findViewById(R.id.txtTitle);
		txtApp = (TextView) findViewById(R.id.txtApp);

		// setFont
		txtTitle.setTypeface(tf);
		txtApp.setTypeface(tf);

		rowItems = new ArrayList<RowChapter>();
		for (int i = 0; i < titles.length; i++) {
			RowChapter item = new RowChapter(images[i], titles[i],
					descriptions[i]);
			rowItems.add(item);
		}

		listView = (ListView) findViewById(R.id.listChapter);
		CustomChapter adapter = new CustomChapter(this, rowItems);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {

		// Toast toast = Toast.makeText(getApplicationContext(), "Item "
		// + (position + 1) + ": " + rowItems.get(position),
		// Toast.LENGTH_SHORT);
		// toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0, 0);
		// toast.show();

		GameSound.play(this);
		int p = position + 1;
		if (p == 1) {
			in = new Intent(ListChapter.this, StoryOne.class);
			startActivity(in);
			overridePendingTransition(android.R.anim.slide_in_left,
					android.R.anim.slide_out_right);
		} 
		if (p == 2) {
			in = new Intent(ListChapter.this, StoryTwo.class);
			startActivity(in);
			overridePendingTransition(android.R.anim.fade_in,
					android.R.anim.fade_out);
		}
	}
}
