package se.kth.roberto.boardgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by guancio on 08/11/2017.
 */

public class BoardView extends View {
    private final GestureDetector mDetector;
    private final GameController game;

    class mListener extends GestureDetector.SimpleOnGestureListener {
        public boolean onDown(MotionEvent e) {
            return true;
        }
    }

    public BoardView(Context context) {
        super(context);
        mDetector = new GestureDetector(this.getContext(), new mListener());
        game = new GameController();
    }

    public void onDraw(Canvas canvas) {
        int height = getHeight();
        int width = getWidth();

        Paint blackPaint = new Paint();
        Paint whitePaint = new Paint();
        Paint redPaint = new Paint();
        whitePaint.setARGB(255, 255, 255, 255);
        blackPaint.setARGB(255, 0, 0, 0);
        redPaint.setARGB(255, 255, 0, 0);

        int recW = width / 8;
        int recH = height / 8;
        Paint paint = whitePaint;
        for (int j=0; j<8; j++) {
            for (int i=0; i<8; i++) {
                RectF shape = new RectF(                        i*recW,
                        j*recH,
                        (i+1)*recW,
                        (j+1)*recH
                );

                if (j ==0 && i == game.gameInstance.playerPositionX)
                    canvas.drawRect(shape, redPaint);
                else if ((i + j) % 2 == 0)
                    canvas.drawRect(shape, blackPaint);
                else
                    canvas.drawRect(shape, whitePaint);
/*
                canvas.drawRect(shape, paint);
                if (paint == whitePaint)
                    paint = blackPaint;
                else
                    paint = whitePaint;
                    */
            }
            /*
            if (paint == whitePaint)
                paint = blackPaint;
            else
                paint = whitePaint;
                */
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        boolean result = mDetector.onTouchEvent(event);
        if (!result) {
            if (event.getAction() == MotionEvent.ACTION_UP) {
                if (event.getX() < this.getWidth() / 2)
                    this.game.goLeft();
                else
                    this.game.Right();

                this.invalidate();

                result = true;
            }
        }
        return result;
    }
}
