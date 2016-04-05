package com.test.myapplication.multipleCustomLayout;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.test.myapplication.R;
import com.test.myapplication.model.SimpleImageName;

import java.util.ArrayList;

/**
 * Created by bon on 16/03/29.
 */
public class MultipleCustomLayoutAdapter extends BaseAdapter {

    private ArrayList<SimpleImageName> simpleNames;
    private LayoutInflater inflater;
    private Context context;

    public MultipleCustomLayoutAdapter(@NonNull Context context) {
        this.context = context;
        this.simpleNames = new ArrayList<>();
        this.inflater = LayoutInflater.from(context);
    }

    public void setItem(ArrayList<SimpleImageName> list) {
        simpleNames.clear();
        simpleNames.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return simpleNames.size();
    }

    @Override
    public Object getItem(int position) {
        return simpleNames.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {

        SimpleImageName data = simpleNames.get(position);

        if (position % 2 == 0) {
            convertView = inflater.inflate(R.layout.list_item_image_text, null);
        } else {
            convertView = inflater.inflate(R.layout.list_item_image_text2, null);
        }

        final TextView textView = (TextView) convertView.findViewById(R.id.text);
        textView.setText(data.getName());

        ImageView imageView = (ImageView) convertView.findViewById(R.id.image);

        String url = data.getImage();

        Glide.with(context)
                .load(url)
                .centerCrop()
                .into(imageView);

        // 리스트 아이템을 터치 했을 때 이벤트 발생
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 터치 시 해당 아이템 이름 출력
                Toast.makeText(parent.getContext(), textView.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }

}
