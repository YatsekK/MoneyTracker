package com.example.yatsek.moneytracker;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemViewHolder> {

    private List<Item> data = new ArrayList<>();

    public ItemsAdapter() {
        createData();
    }

    @NonNull
    @Override
    public ItemsAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_record, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsAdapter.ItemViewHolder holder, int position) {
        Item item = data.get(position);
        holder.applyData(item);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    private void createData() {
        data.add(new Item("Молоко", 35));
        data.add(new Item("Жизнь", 1));
        data.add(new Item("Курсы", 50));
        data.add(new Item("Хлеб", 26));
        data.add(new Item("Тот самый ужин который я оплатил за всех потому что платил картой", 600000));
        data.add(new Item("", 0));
        data.add(new Item("Тот самый ужин", 604));
        data.add(new Item("ракета Falcon Heavy", 1));
        data.add(new Item("Лего тысячелетний сокол", 1000000));
        data.add(new Item("Монитор", 100));
        data.add(new Item("MacBook Pro", 100));
        data.add(new Item("Шоколадка", 100));
        data.add(new Item("Шкаф", 100));
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;
        private final TextView price;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            price = itemView.findViewById(R.id.price);
        }

        public void applyData(Item item) {
            title.setText(item.getTitle());
            price.setText(String.valueOf(item.getPrice()));
        }
    }
}
