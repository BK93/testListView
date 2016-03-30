package com.test.myapplication.simpleImageTextListView;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.test.myapplication.R;
import com.test.myapplication.model.SimpleImageName;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by bon on 16/03/29.
 */
public class ImageTextListViewActivity extends AppCompatActivity {

    @NonNull
    public static Intent createIntent(@NonNull Context context) {
        return new Intent(context, ImageTextListViewActivity.class);
    }

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list);

        setTitle("single custom item layout");

        listView = (ListView) findViewById(R.id.list_view);

        try {
            loadFile();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void loadFile() throws JSONException {

        final AssetManager manager = getResources().getAssets();

        try {
            AssetManager.AssetInputStream assetInputStream = (AssetManager.AssetInputStream) manager.open("food_image.json");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(assetInputStream));

            StringBuilder stringBuilder = new StringBuilder();

            // json파일의 내용이 용량이 클경우 Stirng 의 허용점인 4096 byte 를 넘어가면 오류발생
            int bufferSize = 1024 * 1024;

            // char 로 버프 싸이즈 만큼 담기위해 선언
            char readBuf[] = new char[bufferSize];
            int resultSize = 0;

            // 파일의 전체 내용 읽어오기
            while ((resultSize = bufferedReader.read(readBuf)) != -1) {
                if (resultSize == bufferSize) {
                    stringBuilder.append(readBuf);
                } else {
                    for (int i = 0; i < resultSize; i++) {
                        stringBuilder.append(readBuf[i]);
                    }
                }
            }

            // 새로운 문자열을 만들어서 내부 버퍼의 내용을 복사하고 반환한대
            String jString = stringBuilder.toString();

            // JSONObject 얻어오기
            JSONObject obj = new JSONObject(jString);

            JSONArray array = new JSONArray();
            if (obj.has("test")) {
                array = obj.getJSONArray("test");
            }

            ArrayList<SimpleImageName> list = new ArrayList<>();
            for (int i = 0; i < array.length(); i++) { //24
                SimpleImageName simpleName = new SimpleImageName();
                // array has set of key = name.
                simpleName.setJSONObject(array.getJSONObject(i));
                list.add(simpleName);
            }

            ImageTextListViewAdapter adapter = new ImageTextListViewAdapter(this);
            adapter.setItem(list);
            listView.setAdapter(adapter);

        } catch (IOException e) {
            Log.w("execption", "파일이 없나봐용", e);
            e.printStackTrace();
        }
    }

}


