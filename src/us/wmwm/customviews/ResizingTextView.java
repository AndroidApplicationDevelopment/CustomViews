package us.wmwm.customviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class ResizingTextView extends View {

	String txt;
	
	Paint paint;
	

	public ResizingTextView(Context context, AttributeSet attrs) {
		this(context, attrs,0);
	}
	
	
	
	public ResizingTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		
		final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ResizingTextView, defStyle, 0);
		
		txt = a.getString(R.styleable.ResizingTextView_text);
		
		a.recycle();
		Log.d("ResizingTextView", txt);
		
		paint = new Paint();
		
		paint.setColor(Color.BLACK);
		
	}



	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		paint.setTextSize(14);
		paint.setStyle(Style.FILL_AND_STROKE);
		Log.d("onDraw", "drawing text " + getMeasuredWidth() + " " + getMeasuredHeight());
		
		paint.setColor(Color.WHITE);
		
		int width = getMeasuredWidth();
		int height = getMeasuredHeight();
		
		canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), paint);
		
		paint.setColor(Color.BLACK);
		paint.setStyle(Style.STROKE);
		canvas.drawText(txt, 15, 15, paint);
		
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		
//		final int widthMode = MeasureSpec.getMode(widthMeasureSpec);
//        final int heightMode = MeasureSpec.getMode(heightMeasureSpec);
//        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
//        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        
        float width = paint.measureText(txt);      
        
        Log.d("onMeasure", width+"");
        
        //setMeasuredDimension(getMeasuredWidth(), );
		
	}
	
	

}
