package kku.freestyledev.sounds;

import kku.freestyledev.ikids.R;
import android.content.Context;
import android.media.MediaPlayer;

public class GameSound {
	private static MediaPlayer mPlayer = null;

	public static void play(Context context) {
		stop(context);

		try {// �ѡ�����Դ��Ҵ

			mPlayer = MediaPlayer.create(context, R.raw.clash);
			mPlayer.start();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// ��ش����ŧ
		public static void stop(Context context) {
			if (mPlayer != null) {
				mPlayer.stop();
				mPlayer.release();
				mPlayer = null;
			}
		}
}
