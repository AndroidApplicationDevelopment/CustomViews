package us.wmwm.customviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Button;

public class MyButton extends Button {

	String txt;
	
	Paint paint;
	
	Rect textBounds = new Rect();
	

	public MyButton(Context context, AttributeSet attrs) {
		this(context, attrs,0);
	}
	
	
	
	public MyButton(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);	
		
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {		
		if(paint==null) {
			paint = new Paint();
			textBounds = new Rect();
		}
		final int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        final int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
              
        
        float lastSize = 0.5f;
        paint.setTextSize(lastSize);        
        while(true) {        	        	        	        
        	paint.getTextBounds(getText().toString(), 0, getText().toString().length(), textBounds);
        	if(textBounds.width()>widthSize) {
        		break;
        	}
        	if(textBounds.height()>heightSize) {
        		break;
        	}
        	lastSize*=1.1f;
        	paint.setTextSize(lastSize);
        	Log.d("onMeasure", textBounds.width() + ", " + textBounds.height());
        }        
        lastSize/=1.1f;
        
		paint.setTextSize(lastSize);
		
		setTextSize(lastSize);		
		
		Log.d("onMeasure", widthSize + ", " + heightSize);
        
        Log.d("onMeasure", textBounds.width() + ", " + textBounds.height());      
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}
	
	

}
