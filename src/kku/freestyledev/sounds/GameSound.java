package kku.freestyledev.sounds;

import kku.freestyledev.ikids.R;
import android.content.Context;
import android.media.MediaPlayer;

public class GameSound {
	private static MediaPlayer mPlayer = null;

	public static void play(Context context) {
		stop(context);

		try {// ดักข้อมผิดพลาด

			mPlayer = MediaPlayer.create(context, R.raw.clash);
			mPlayer.start();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// หยุดเล่นเพลง
		public static void stop(Context context) {
			if (mPlayer != null) {
				mPlayer.stop();
				mPlayer.release();
				mPlayer = null;
			}
		}
}
