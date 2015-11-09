package com.example.tkueasysamplecode.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tkueasysamplecode.R;
import com.example.tkueasysamplecode.beans.MyDataResult;

import java.util.ArrayList;
import java.util.List;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by Xavier on 2015/11/9.
 */
public class LandscapeListAdapter extends BaseAdapter {
	private final List<MyDataResult.ResultItem> list;
	private Context context;
	private final LayoutInflater layoutInflater;

	public LandscapeListAdapter(Context context) {
		super();
		this.list = new ArrayList<>();
		this.context = context;
		this.layoutInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return (this.list == null) ? 0 : this.list.size();
	}

	@Override
	public MyDataResult.ResultItem getItem(int position) {
		return this.list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = this.layoutInflater.inflate(R.layout.list_item_landscape, null);
		}

		final MyDataResult.ResultItem resultItem = this.getItem(position);

		ImageView landscapeImageView = (ImageView) convertView.findViewById(R.id.imgv_landscape);
		TextView parkNameText = (TextView) convertView.findViewById(R.id.text_park_name);
		TextView landscapeNameText = (TextView) convertView.findViewById(R.id.text_landscape_name);
		TextView openTimeText = (TextView) convertView.findViewById(R.id.text_open_time);

		Picasso.with(convertView.getContext()).load(resultItem.getImage()).placeholder(R.drawable.ic_loading).into(landscapeImageView);

		parkNameText.setText(this.context.getString(R.string.custom_text_park_name, resultItem.getParkName()));
		landscapeNameText.setText(this.context.getString(R.string.custom_text_landscape_name, resultItem.getName()));
		openTimeText.setText(this.context.getString(R.string.custom_text_open_time, resultItem.getOpenTime()));

		convertView.setTag(resultItem);

		return convertView;
	}

	public void clear() {
		this.list.clear();
	}

	public boolean addAll(List<MyDataResult.ResultItem> data) {
		return this.list.addAll(data);
	}
}
