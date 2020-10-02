package com.example.savefiletext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Button dataAcak,save,load;
    TextView textView;
    ListView listData;

    ArrayList arrayData = new ArrayList();

    ArrayList<String> arrayList;
    String[] ListFile = new String[] {  };

    private static int index_FileText = 1;
    private static final String FILE_NAME = "dataSignal"+index_FileText+".txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataAcak = (Button) findViewById(R.id.dataAcak);
        save = (Button) findViewById(R.id.save);
        load = (Button) findViewById(R.id.load);
        textView = (TextView) findViewById(R.id.textView);
        listData = (ListView) findViewById(R.id.listData);

        arrayList = new ArrayList<String>(Arrays.asList(ListFile));

        dataAcak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = 0;
                for (int i=0; i<10;i++){
                    x = i;
                    textView.setText(String.valueOf(x));
                    arrayData.add(x);
                }

            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dataText;
                FileOutputStream fos = null;

//                int idx = 1;
//                String filename = "DataSignal_Subjek_.txt";

                for (int i=0;i<arrayData.size();i++){
                    try {
                        dataText = String.valueOf(arrayData.get(i));
                        fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
                        fos.write(dataText.getBytes());

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        if (fos != null){
                            try {
                                fos.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                Toast.makeText(MainActivity.this, "Saved to " + getFilesDir() + "/" + FILE_NAME, Toast.LENGTH_LONG).show();
            }
        });



    }
}