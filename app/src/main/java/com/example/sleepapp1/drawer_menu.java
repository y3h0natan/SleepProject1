package com.example.sleepapp1;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

public class drawer_menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_drawer_menu);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    public class DrawerAdapter extends RecyclerView.Adapter<DrawerAdapter.ViewHolder> {
        private final Context context;
        private final String[] items;
        private final DrawerItemClickListener listener;

        public DrawerAdapter(Context context, String[] items, DrawerItemClickListener listener) {
            this.context = context;
            this.items = items;
            this.listener = listener;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false);
            return new ViewHolder(view);
        }

        @NonNull

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.textView.setText(items[position]);
            holder.itemView.setOnClickListener(v -> listener.onDrawerItemClick(position));
        }

        @Override
        public int getItemCount() {
            return items.length;
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {
            TextView textView;

            public ViewHolder(View itemView) {
                super(itemView);
                textView = itemView.findViewById(android.R.id.text1);
            }
        }

        public interface DrawerItemClickListener {
            void onDrawerItemClick(int position);
        }
    }

}