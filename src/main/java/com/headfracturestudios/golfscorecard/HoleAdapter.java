package com.headfracturestudios.golfscorecard;

import android.content.Context;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;


public class HoleAdapter extends BaseAdapter {

    private Context mContext;
    private Hole[] mHoles;

    public HoleAdapter(Context context, Hole[] holes){
        mContext = context;
        mHoles = holes;
    }

    @Override
    public int getCount() {
        return mHoles.length;
    }

    @Override
    public Object getItem(int position) {
        return mHoles[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        final ViewHolder viewholder;

        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.score_list_item, null);
            viewholder = new ViewHolder();
            viewholder.holeNumber = (TextView) convertView.findViewById(R.id.holeNumberTextView);
            viewholder.holeScore = (TextView) convertView.findViewById(R.id.scoreTextView);
            viewholder.addButton = (Button) convertView.findViewById(R.id.addButton);
            viewholder.subButton = (Button) convertView.findViewById(R.id.subtractButton);



            convertView.setTag(viewholder);
        } else {
            viewholder = (ViewHolder) convertView.getTag();

        }

        Hole hole = mHoles[position];

        viewholder.holeNumber.setText(hole.getHoleString(hole.getHoleNumber()));
        viewholder.holeScore.setText(hole.getScore()+ "");
        viewholder.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mHoles[position].setScore(mHoles[position].addScore());
                viewholder.holeScore.setText(mHoles[position]+"");

            }
        });

        viewholder.subButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHoles[position].setScore(mHoles[position].subtractScore());
                viewholder.holeScore.setText(mHoles[position]+"");
                if (mHoles[position].getScore()==-1){
                    mHoles[position].setScore(0);
                    viewholder.holeScore.setText(0+"");
                }

            }
        });


        return convertView;
    }

    private static class ViewHolder {
        TextView holeNumber;
        TextView holeScore;
        Button subButton;
        Button addButton;

        }
}
