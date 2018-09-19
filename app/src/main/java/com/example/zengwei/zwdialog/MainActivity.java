package com.example.zengwei.zwdialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.zwdialogs.DetermineListener;
import com.example.zwdialogs.SelectListener;

public class MainActivity extends AppCompatActivity {
    private Button abc1,abc2,abc3,abc4,abc5,abc6,abc7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        abc1=findViewById(R.id.abc1);
        abc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new ZwDialogUtil().a(MainActivity.this);
            }
        });
        abc2=findViewById(R.id.abc2);
        abc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new ZwDialogUtil().b(MainActivity.this);
            }
        });
        abc3=findViewById(R.id.abc3);
        abc3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new ZwDialogUtil().c(MainActivity.this);
            }
        });
        abc4=findViewById(R.id.abc4);
        abc4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new ZwDialogUtil().d(MainActivity.this);
            }
        });
        abc5=findViewById(R.id.abc5);
        abc5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new ZwDialogUtil().e(MainActivity.this);
            }
        });
        abc6=findViewById(R.id.abc6);
        abc6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new ZwDialogUtil().f(MainActivity.this);
            }
        });
        abc7=findViewById(R.id.abc7);
        abc7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // new ZwDialogUtil().g(MainActivity.this);
//                new com.example.zwdialogs.ZwDialogUtil().determine(MainActivity.this, "提醒", "真香警告！", new DetermineListener() {
//                    @Override
//                    public void ok() {
//                        Toast.makeText(MainActivity.this, "确定", Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void no() {
//                        Toast.makeText(MainActivity.this, "取消", Toast.LENGTH_SHORT).show();
//                    }
//                });
//                String[] strings={"123","123"};
//                new com.example.zwdialogs.ZwDialogUtil().select(MainActivity.this, strings, new SelectListener() {
//                    @Override
//                    public void itemClick(int position) {
//                        Toast.makeText(MainActivity.this, position+"", Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void no() {
//                        Toast.makeText(MainActivity.this, "取消", Toast.LENGTH_SHORT).show();
//                    }
//                });
                new com.example.zwdialogs.ZwDialogUtil().littie(MainActivity.this,2,"#ccff0000");
            }
        });
    }

}
