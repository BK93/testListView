package com.test.myapplication.simpleImageTextListView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.test.myapplication.R;
import com.test.myapplication.model.SimpleImageName;

import java.util.ArrayList;

/**
 * Created by bon on 16/03/29.
 */
public class ImageTextListViewAdapter extends BaseAdapter {

    private ArrayList<SimpleImageName> simpleNames;
    private LayoutInflater inflater;
    private Context context;

    public ImageTextListViewAdapter(@NonNull Context context) {
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
    public View getView(int position, View convertView, ViewGroup parent) {
        SimpleImageName data = simpleNames.get(position);
        convertView = inflater.inflate(R.layout.list_item_image_text, null);

        TextView textView = (TextView) convertView.findViewById(R.id.text);
        textView.setText(data.getName());

        ImageView imageView = (ImageView) convertView.findViewById(R.id.image);

        String url = data.getImage();

        Picasso.with(context)
                .load(url)
                .resize(50, 50)
                .centerCrop()
                .into(imageView);

        return convertView;
    }

}
