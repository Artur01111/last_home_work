package com.example.last_home_work.scrol1;

import com.example.last_home_work.R;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.last_home_work.Container1;
import com.example.last_home_work.databinding.ItemProductBinding;

import java.util.ArrayList;

public class SKROL1 extends RecyclerView.Adapter<SKROL1.ScrolViewHolder> {
    private ArrayList<Container1> container;

    public SKROL1(ArrayList<Container1> container) {
        this.container = container;
    }

    @NonNull
    @Override
    public ScrolViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ScrolViewHolder(ItemProductBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ScrolViewHolder holder, int position) {
        holder.bind(container.get(position));
    }

    @Override
    public int getItemCount() {
        return container.size();
    }

    class ScrolViewHolder extends RecyclerView.ViewHolder {
        public ItemProductBinding viewBinding;

        public ScrolViewHolder(@NonNull ItemProductBinding viewBinding) {
            super(viewBinding.getRoot());
            this.viewBinding = viewBinding;

            itemView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            scaleView(v, 1.0f, 1.1f);
                            changeColors(true);
                            return true;
                        case MotionEvent.ACTION_UP:
                        case MotionEvent.ACTION_CANCEL:
                            scaleView(v, 1.1f, 1.0f);
                            changeColors(false);
                            return true;
                    }
                    return false;
                }
            });
        }

        public void bind(Container1 container1) {
            viewBinding.itemText.setText(container1.getItemText());
            viewBinding.itemPrice.setText(container1.getItemPrice());
            Glide.with(itemView.getContext()).load(container1.getItemView()).into(viewBinding.itemView);
            Glide.with(itemView.getContext()).load(container1.getStar1()).into(viewBinding.star1);
            Glide.with(itemView.getContext()).load(container1.getStar2()).into(viewBinding.star2);
            Glide.with(itemView.getContext()).load(container1.getStar3()).into(viewBinding.star3);
            Glide.with(itemView.getContext()).load(container1.getStar4()).into(viewBinding.star4);
            Glide.with(itemView.getContext()).load(container1.getStar5()).into(viewBinding.star5);
        }

        private void scaleView(View v, float startScale, float endScale) {
            ObjectAnimator scaleX = ObjectAnimator.ofFloat(v, "scaleX", startScale, endScale);
            ObjectAnimator scaleY = ObjectAnimator.ofFloat(v, "scaleY", startScale, endScale);
            scaleX.setDuration(200);
            scaleY.setDuration(200);
            scaleX.start();
            scaleY.start();
        }

        private void changeColors(boolean isSelected) {
            if (isSelected) {
                viewBinding.itemText.setTextColor(Color.WHITE);
                viewBinding.itemPrice.setTextColor(Color.WHITE);
                viewBinding.borderView.setBackgroundResource(R.drawable.border_selected);
            } else {
                viewBinding.itemText.setTextColor(Color.GRAY);
                viewBinding.itemPrice.setTextColor(Color.GRAY);
                viewBinding.borderView.setBackgroundResource(R.drawable.border);
            }
        }
    }
}
