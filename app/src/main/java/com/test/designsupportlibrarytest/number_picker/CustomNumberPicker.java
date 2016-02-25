package com.test.designsupportlibrarytest.number_picker;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.support.v7.app.AlertDialog;
import android.util.AttributeSet;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.test.designsupportlibrarytest.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CustomNumberPicker extends TextView {

    private String[] figures = new String[2];

    @Bind(R.id.whole_number)
    NumberPicker wholeNumberView;

    @Bind(R.id.decimal_number)
    NumberPicker decimalNumberView;

    @Bind(R.id.unit)
    TextView unitView;

    // constructor
    public CustomNumberPicker(Context context) {
        this(context, null);
    }

    public CustomNumberPicker(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomNumberPicker(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomNumberPicker, defStyleAttr, 0);
        // Dialog のタイトル
        final String pickerTitle = typedArray.getString(R.styleable.CustomNumberPicker_num_picker_title);
        // NumberPicker の MaxValue
        final int maxValue = typedArray.getInteger(R.styleable.CustomNumberPicker_max_value, 0);
        // NumberPicker の MinValue
        final int minValue = typedArray.getInteger(R.styleable.CustomNumberPicker_min_value, 0);
        // NumberPicker の default(=Value)
        final int value = typedArray.getInteger(R.styleable.CustomNumberPicker_value, 0);
        // 単位
        final String unit = typedArray.getString(R.styleable.CustomNumberPicker_unit);
        typedArray.recycle();

        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                showNumberPicker(pickerTitle, value, maxValue, minValue, unit);
//                showNumberPicker();
            }
        });
    }

    private void showNumberPicker() {
        final AlertDialog dialog = new AlertDialog.Builder(getContext())
                .setView(R.layout.view_number_picker)
                .setTitle("hello")
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        figures[0] = String.valueOf(wholeNumberView.getValue());
                        figures[1] = String.valueOf(decimalNumberView.getValue());

                        String string = figures[0] + "." + figures[1];
                        Float fig = Float.parseFloat(string);

                        setText(String.valueOf(fig));
                    }
                })
                .setNegativeButton(android.R.string.cancel, null)
                .show();

        // 単位セット
        unitView = ButterKnife.findById(dialog, R.id.unit);
        unitView.setText("単位");

        // 定数の NumberPicker 範囲セット
        wholeNumberView = ButterKnife.findById(dialog, R.id.whole_number);
        wholeNumberView.setMaxValue(100);
        wholeNumberView.setMinValue(10);
        wholeNumberView.setValue(50);

        // 小数の NumberPicker 範囲セット
        decimalNumberView = ButterKnife.findById(dialog, R.id.decimal_number);
        decimalNumberView.setMaxValue(9); // 小数の部分は 0~9 までに固定
        decimalNumberView.setMinValue(0);
        decimalNumberView.setValue(0);
    }

    private void showNumberPicker(String pickerTitle, int value, int maxValue, int minValue, String unit) {
        final AlertDialog dialog = new AlertDialog.Builder(getContext())
                .setView(R.layout.view_number_picker)
                .setTitle(pickerTitle)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        figures[0] = String.valueOf(wholeNumberView.getValue());
                        figures[1] = String.valueOf(decimalNumberView.getValue());

                        String string = figures[0] + "." + figures[1];
                        Float fig = Float.parseFloat(string);

                        setText(String.valueOf(fig));
                    }
                })
                .setNegativeButton(android.R.string.cancel, null)
                .show();

        // 単位セット
        unitView = ButterKnife.findById(dialog, R.id.unit);
        unitView.setText(unit);

        // 定数の NumberPicker 範囲セット
        wholeNumberView = ButterKnife.findById(dialog, R.id.whole_number);
        wholeNumberView.setMaxValue(maxValue);
        wholeNumberView.setMinValue(minValue);
        wholeNumberView.setValue(value);

        // 小数の NumberPicker 範囲セット
        decimalNumberView = ButterKnife.findById(dialog, R.id.decimal_number);
        decimalNumberView.setMaxValue(9); // 小数の部分は 0~9 までに固定
        decimalNumberView.setMinValue(0);
        decimalNumberView.setValue(0);

        // 二度開いた時入力されている値をとってくる
        float number = Float.parseFloat(getText().toString());
        int wholeNum = (int) number;
        int decimalNum = (int) ((number - wholeNum) * 10);
        wholeNumberView.setValue(wholeNum);
        decimalNumberView.setValue(decimalNum);
    }

}
