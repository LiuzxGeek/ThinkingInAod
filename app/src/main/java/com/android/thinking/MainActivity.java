package com.android.thinking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.thinking.library.annotation.BindView;
import com.android.thinking.library.utils.AnnotationUtils;

public class MainActivity extends AppCompatActivity {

    @BindView(id = R.id.tv_hello)
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnnotationUtils.initBindView(this);
        if (mTextView != null)
            mTextView.setText("ijk");
    }
}
