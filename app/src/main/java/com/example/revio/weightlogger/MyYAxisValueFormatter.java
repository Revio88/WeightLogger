package com.example.revio.weightlogger;

import com.github.mikephil.charting.formatter.YAxisValueFormatter;
import com.github.mikephil.charting.components.YAxis;

import java.text.DecimalFormat;

/**
 * Created by revio on 08/11/15.
 */
public class MyYAxisValueFormatter implements YAxisValueFormatter {

    private DecimalFormat mFormat;

    public MyYAxisValueFormatter() {
        mFormat = new DecimalFormat("###,###,###,##0.0");
    }

    @Override
    public String getFormattedValue(float value, YAxis yAxis) {
        return mFormat.format(value) + " $";
    }

}
