package kong.qingwei.demo.kqwcheckviewdemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by kongqw on 2015/10/23.
 */
public class CheckView extends View {
    Context mContext;
    int[] CheckNum = null;
    Paint mTempPaint = new Paint();
    private final int mPointNum;
    private final int mLineNum;
    private final int mTextLength;
    private final float mTextSize;
    private final int mTextColor;
    private final int mBgColor;

    // ��֤��
    public CheckView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        mTempPaint.setAntiAlias(true);
        mTempPaint.setTextSize(Config.TEXT_SIZE);
        mTempPaint.setStrokeWidth(3);


        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CheckView);
        // ��ȡ�����ĸ���
        mPointNum = a.getInteger(R.styleable.CheckView_point_num, 100);
        // ��ȡ����ߵ�����
        mLineNum = a.getInteger(R.styleable.CheckView_line_num, 10);
        // ��ȡ��֤�볤��
        mTextLength = a.getInteger(R.styleable.CheckView_text_length, 4);
        // ��ȡ��֤�������С
        mTextSize = a.getDimension(R.styleable.CheckView_text_size, 30);
        // ��ȡ��֤��������ɫ
        mTextColor = a.getColor(R.styleable.CheckView_text_color, 0XFFFFFFFF);
        // ��ȡ������ɫ
        mBgColor = a.getColor(R.styleable.CheckView_bg_color, 0XFFFFFFFF);


        // ��ȡ��֤�����ͣ�������/����ĸ/��ϣ�
        Log.d("CheckView", "point_num = " + mPointNum);
        Log.d("CheckView", "line_num = " + mLineNum);
        Log.d("CheckView", "text_length = " + mTextLength);
        Log.d("CheckView", "text_color = " + mTextColor);
        Log.d("CheckView", "text_size = " + mTextSize);
        Log.d("CheckView", "bg_color = " + mBgColor);

        a.recycle();
    }


    public void onDraw(Canvas canvas) {

        getCheckNum();

        canvas.drawColor(mBgColor);
        final int height = getHeight();
        // ���CheckView�ؼ��ĸ߶�
        final int width = getWidth();
        // ���CheckView�ؼ��Ŀ��
        int dx = width / mTextLength / 2;
        for (int i = 0; i < mTextLength; i++) {
            // ������֤�ؼ��ϵ��ı�
            canvas.drawText("" + CheckNum[i], dx, getPositon(height), mTempPaint);
            dx += width / (mTextLength + 1);
        }
        int[] line;
        for (int i = 0; i < Config.LINE_NUM; i++) {
            // ����
            line = CheckUtil.getLine(height, width);
            canvas.drawLine(line[0], line[1], line[2], line[3], mTempPaint);
        }
        // ����СԲ��
        int[] point;
        for (int i = 0; i < Config.POINT_NUM; i++) {
            // ����
            point = CheckUtil.getPoint(height, width);
            canvas.drawCircle(point[0], point[1], 1, mTempPaint);
        }
    }

    public void invaliChenkNum() {
        invalidate();
    }

    /**
     * �����������
     *
     * @return
     */
    public int[] getCheckNum() {
        int[] tempCheckNum = new int[mTextLength];
        for (int i = 0; i < mTextLength; i++) {
            tempCheckNum[i] = (int) (Math.random() * 10);
        }
        CheckNum = tempCheckNum;
        return tempCheckNum;
    }


    /**
     * ������֤��Ļ���y��λ��
     *
     * @param height ����CheckView�ĸ߶�ֵ
     * @return
     */
    public int getPositon(int height) {
        int tempPositoin = (int) (Math.random() * height);
        if (tempPositoin < 20) {
            tempPositoin += 20;
        }
        return tempPositoin;
    }

}
