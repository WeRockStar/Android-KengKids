package kku.freestyledev.game;

import java.util.ArrayList;
import java.util.Random;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class Panel extends SurfaceView implements SurfaceHolder.Callback {

	public static float mWidth;
	public static float mHeight;
	private ViewThread mThread;
	private ArrayList<Element> mElements = new ArrayList<Element>();
	private int mElementNumber = 0;
	private Paint mPaint = new Paint();
	private int mGarbagType = 0;
	private int score = 0;

	public Panel(Context context) {
		super(context);
		getHolder().addCallback(this);
		mThread = new ViewThread(this);
		mPaint.setColor(Color.WHITE);
	}

	public void addElements() {
		if (mElementNumber < 10) {
			mElements.add(new Element(getResources(), (int) (mWidth / 2), 10));
			mElementNumber = mElements.size();
		}
	}

	public void doDraw(long elapsed, Canvas canvas) {
		canvas.drawColor(Color.BLACK);
		addElements();
		synchronized (mElements) {

			for (Element element : mElements) {
				element.doDraw(canvas);
			}
		}
//		canvas.drawText("FPS: " + Math.round(1000f / elapsed) + " Elements: "
//				+ mElementNumber, 10, 10, mPaint);
//		canvas.drawText("Score : " + score, 10, 30, mPaint);
		String gtxt = "";
		if (mGarbagType == 0)
			gtxt = "paper";
		else if (mGarbagType == 1)
			gtxt = "bottle";
		else
			gtxt = "can";
//		canvas.drawText("Touch : -> " + gtxt + " <-", 10, 40, mPaint);

		// Log.e("Touch : " + gtxt, "Touch : " + gtxt);
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		if (!mThread.isAlive()) {
			mThread = new ViewThread(this);
			mThread.setRunning(true);
			mThread.start();
		}
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		mWidth = width;
		mHeight = height;
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		if (mThread.isAlive()) {
			mThread.setRunning(false);
		}
	}

	public boolean onTouchEvent(MotionEvent event) {
		int tx = (int) event.getX();
		int ty = (int) event.getY();
		int i = 0;
		for (Element element : mElements) {
			if ((element.getmX() < tx && tx < element.getmX()
					+ element.getWidth())
					&& (element.getmY() < ty && ty < element.getmY()
							+ element.getHeight())) {

				if (mGarbagType == element.getGtype()) {
					score += 5;

				}

				String str = "";

				if (element.getGtype() == 0) {
					str = "Paper";
				} else if (element.getGtype() == 1) {
					str = "Water";
				} else if (element.getGtype() == 2) {
					str = "Coak";
				}

				Log.e("DustmanGame", "Touch on : " + str + " , Score : 5");

				mElements.remove(i);
				mElementNumber = mElements.size();

				mGarbagType = randomGarbage();

				break;
			}
			i++;
		}
		return super.onTouchEvent(event);
	}

	public void animate(long elapsedTime) {
		synchronized (mElements) {
			for (Element element : mElements) {
				element.animate(elapsedTime);
			}
		}
	}

	public int randomGarbage() {
		Random rand = new Random();
		int r = rand.nextInt(3);
		return r;
	}

}
