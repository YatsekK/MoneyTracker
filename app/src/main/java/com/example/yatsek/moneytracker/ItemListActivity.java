package com.example.yatsek.moneytracker;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ItemListActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<Record> mData = new ArrayList<>();
    private ItemListAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items_list);

        mRecyclerView = findViewById(R.id.list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new ItemListAdapter();
        createData();
        mRecyclerView.setAdapter(mAdapter);
    }

    private void createData() {
        mData.add(new Record("Молоко", 35));
        mData.add(new Record("Жизнь", 1));
        mData.add(new Record("Курсы", 50));
        mData.add(new Record("Хлеб", 26));
        mData.add(new Record("Тот самый ужин который я оплатил за всех потому что платил картой", 600000));
        mData.add(new Record("", 0));
        mData.add(new Record("Тот самый ужин", 604));
        mData.add(new Record("ракета Falcon Heavy", 1));
        mData.add(new Record("Лего тысячелетний сокол", 1000000));
        mData.add(new Record("Монитор", 100));
        mData.add(new Record("MacBook Pro", 100));
        mData.add(new Record("Шоколадка", 100));
        mData.add(new Record("Шкаф", 100));
    }

    private class ItemListAdapter extends RecyclerView.Adapter<RecordViewHolder> {
        @NonNull
        @Override
        public RecordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_record, parent, false);
            return new RecordViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecordViewHolder holder, int position) {
            Record record = mData.get(position);
            holder.applyData(record);
        }

        @Override
        public int getItemCount() {
            return mData.size();
        }
    }

    private class RecordViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;
        private final TextView price;

        public RecordViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            price = itemView.findViewById(R.id.price);
        }

        public void applyData(Record record) {
            title.setText(record.getTitle());
            price.setText(String.valueOf(record.getPrice()));
        }
    }
}
