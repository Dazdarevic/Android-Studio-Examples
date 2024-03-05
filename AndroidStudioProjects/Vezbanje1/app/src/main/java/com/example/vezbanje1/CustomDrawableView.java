package com.example.vezbanje1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class CustomDrawableView extends View {

    public CustomDrawableView(Context context) {
        super(context);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //primer2
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);

        // make the entire canvas white
        paint.setColor(Color.WHITE);
        canvas.drawPaint(paint);

        // draw blue circle with anti aliasing turned off
        paint.setAntiAlias(false);
        paint.setColor(Color.BLUE);
        canvas.drawCircle(20, 20, 15, paint);

        paint.setAntiAlias(false);
        paint.setColor(Color.RED);
        canvas.drawCircle(100, 100, 50, paint);

        paint.setAntiAlias(false);
        paint.setColor(Color.YELLOW);
        canvas.drawRect(100, 40,70, 30, paint);

        canvas.rotate(-90);

        paint.setColor(Color.BLUE);
        canvas.drawText("BELKISA je rotirana za 90 stepeni", 40, 240, paint);

        canvas.rotate(+90);

        paint.setColor(Color.BLUE);
        canvas.drawText("Belkisa je rotirana nazad za 90 stepeni.", 40, 340, paint);
    }
}
