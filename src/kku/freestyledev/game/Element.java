package kku.freestyledev.game;

import java.util.Random;

import kku.freestyledev.ikids.R;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

public class Element {
	private float mX;
	private float mY;
	private int mSpeedX;
	private int mSpeedY;
	private Bitmap mBitmap;
	private int gtype;

	public float getmX() {
		return mX;
	}

	public void setmX(float mX) {
		this.mX = mX;
	}

	public float getmY() {
		return mY;
	}

	public void setmY(float mY) {
		this.mY = mY;
	}

	public int getGtype() {
		return gtype;
	}

	public int getWidth() {
		return mBitmap.getWidth();
	}

	public int getHeight() {
		return mBitmap.getHeight();
	}

	public Element(Resources res, int x, int y) {
		Random rand = new Random();
		int r = (rand.nextInt(1));
		gtype = r;
		if (r == 0)
			mBitmap = BitmapFactory.decodeResource(res, R.drawable.bath);
		// else if (r == 1)
		// mBitmap = BitmapFactory.decodeResource(res, R.drawable.bottle);
		// else
		// mBitmap = BitmapFactory.decodeResource(res, R.drawable.can);

		mX = x - mBitmap.getWidth() / 2;
		mY = y - mBitmap.getHeight() / 2;
		mSpeedX = rand.nextInt(7) - 3;
		mSpeedY = rand.nextInt(7) - 3;
	}

	public void doDraw(Canvas canvas) {
		canvas.drawBitmap(mBitmap, mX, mY, null);
	}

	public void animate(long elapsedTime) {
		mX += mSpeedX * (elapsedTime / 20f);
		mY += mSpeedY * (elapsedTime / 20f);
		checkBorders();
	}

	private void checkBorders() {
		if (mX <= 0) {
			mSpeedX = -mSpeedX;
			mX = 0;
		} else if (mX + mBitmap.getWidth() >= Panel.mWidth) {
			mSpeedX = -mSpeedX;
			mX = Panel.mWidth - mBitmap.getWidth();
		}
		if (mY <= 0) {
			mY = 0;
			mSpeedY = -mSpeedY;
		}
		if (mY + mBitmap.getHeight() >= Panel.mHeight) {
			mSpeedY = -mSpeedY;
			mY = Panel.mHeight - mBitmap.getHeight();
		}
	}
}
